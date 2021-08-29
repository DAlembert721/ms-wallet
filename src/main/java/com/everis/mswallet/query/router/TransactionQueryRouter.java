package com.everis.mswallet.query.router;

import com.everis.mswallet.query.handler.TransactionQueryHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class TransactionQueryRouter {
    @Bean
    public RouterFunction<ServerResponse> transactionRoutes(TransactionQueryHandler handler) {
        return route(GET("/wallets/transactions/"), handler::getAllTransactions)
                .andRoute(GET("/wallets/transactions/{id}"), handler::getTransactionById)
                .andRoute(GET("/wallets/{walletId}/transactions}"), handler::getAllTransactionsByWalletId);
    }
}
