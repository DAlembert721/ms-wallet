package com.everis.mswallet.command.router;

import com.everis.mswallet.command.handler.WalletCommandHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class WalletCommandRouter {
    @Bean
    public RouterFunction<ServerResponse> walletRouter(WalletCommandHandler walletCommandHandler) {
        return route(POST("/wallets"), walletCommandHandler::createWallet);
    }
}
