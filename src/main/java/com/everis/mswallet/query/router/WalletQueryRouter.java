package com.everis.mswallet.query.router;

import com.everis.mswallet.query.handler.WalletQueryHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class WalletQueryRouter {
    @Bean
    public RouterFunction<ServerResponse> walletQueryRoutes(WalletQueryHandler handler) {
        return route(GET("/wallets"), handler::getAllWallets)
                .andRoute(GET("/wallets/{id}"), handler::getWalletById)
                .andRoute(GET("/wallets/{walletNumber}"), handler::getWalletByWalletNumber);
    }
}
