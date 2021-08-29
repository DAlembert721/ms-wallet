package com.everis.mswallet.query.handler;

import com.everis.mswallet.query.dto.TransactionDto;
import com.everis.mswallet.query.dto.WalletDto;
import com.everis.mswallet.query.projections.service.TransactionQueryService;
import com.everis.mswallet.shared.response.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class TransactionQueryHandler {
    @Autowired
    private TransactionQueryService transactionQueryService;


    public Mono<ServerResponse> getAllTransactions(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(transactionQueryService.findAll(), TransactionDto.class);
    }

    public Mono<ServerResponse> getTransactionById(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        return transactionQueryService.findById(id)
                .flatMap(transactionDto ->
                        ServerResponse.status(HttpStatus.FOUND)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(transactionDto))
                .switchIfEmpty(ErrorResponse.buildBadResponse("The transaction with id".concat(id).concat("don't exist"), HttpStatus.NOT_FOUND))
                .onErrorResume(t -> ErrorResponse.buildBadResponse(t.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
    }

    public Mono<ServerResponse> getAllTransactionsByWalletId(ServerRequest serverRequest) {
        String walletId = serverRequest.pathVariable("walletId");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(transactionQueryService.findAllTransactionsByWalletId(walletId), WalletDto.class);
    }
}
