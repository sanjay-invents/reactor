package com.shoryukane.section02;

import com.shoryukane.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lecture09FluxFromMono {

    public static void main(String[] args) {
        //Mono To Flux
//        Mono<String> mono = Mono.just("a");
//
//        Flux<String> flux = Flux.from(mono);
//
//        flux.subscribe(Util.onNext());

        // Flux To Mono
        Flux.range(1, 10)
                .next()
                .filter(i -> i > 3)
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

    }

    private static void doSomething(Flux<String> flux) {

    }

}
