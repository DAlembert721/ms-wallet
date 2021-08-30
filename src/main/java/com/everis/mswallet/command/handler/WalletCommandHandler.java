package com.everis.mswallet.command.handler;

import com.everis.mswallet.command.domain.service.WalletCommandService;
import com.everis.mswallet.command.dto.CreateWallet;
import com.everis.mswallet.shared.response.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class WalletCommandHandler {
    @Autowired
    private WalletCommandService walletCommandService;

    public Mono<ServerResponse> createWallet(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(CreateWallet.class)
                .flatMap(createWallet -> walletCommandService.createWallet(createWallet))
                .flatMap(walletCreated -> ServerResponse.status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(walletCreated))
                .switchIfEmpty(ErrorResponse.buildBadResponse("Error on create", HttpStatus.BAD_REQUEST))
                .onErrorResume(throwable -> ErrorResponse.buildBadResponse(throwable.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));

    }
}
