package com.redhat.labs;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;

public class MainVerticle extends AbstractVerticle {

    @Override
    public void start() {
        Router router = Router.router(vertx);

        router.route().handler(StaticHandler.create("webroot"));

        HttpServer server = vertx.createHttpServer(
                new HttpServerOptions()
                        .setPort(config().getInteger("http.port", 8080))
                        .setHost(config().getString("http.host", "localhost")));
        server.requestHandler(router::accept).listen();
    }
}
