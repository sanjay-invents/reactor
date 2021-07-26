package com.shoryukane.section04;

import com.shoryukane.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lecture06OnError {

    public static void main(String[] args) {

        Flux.range(1, 10)
                .log()
                .map(i -> 10 / (5 - i))
//                .onErrorReturn(-1)
//                .onErrorResume(e -> fallback())
                .onErrorContinue((error, object) -> {

                })
                .subscribe(Util.subscriber());

    }

    private static Mono<Integer> fallback() {
        return Mono.fromSupplier(() -> Util.faker().random().nextInt(100, 200));
    }

}
