package com.shoryukane.section12;

import com.shoryukane.courseutil.Util;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

import java.util.Locale;

public class Lecture01Context {

    public static void main(String[] args) {
        getWelcomeMessage()
//                .contextWrite(Context.of("users", "jake"))
                .contextWrite(context -> context.put("user", context.get("user").toString().toUpperCase(Locale.ROOT)))
                .contextWrite(Context.of("user", "sam"))
                .subscribe(Util.subscriber());
    }

    private static Mono<String> getWelcomeMessage() {
        return Mono.deferContextual(contextView -> {
            if(contextView.hasKey("user")) {
                return Mono.just("Welcome " + contextView.get("user"));
            } else {
                return Mono.error(new RuntimeException("Unauthenticated"));
            }
        });
    }

}
