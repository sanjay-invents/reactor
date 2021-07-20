package com.shoryukane.section02;

import com.shoryukane.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture01FluxIntro {

    public static void main(String[] args) {

//        Flux<Integer> flux = Flux.just(1, 2, 3, 4);

//        Flux<Integer> flux = Flux.empty();

        Flux<Object> flux = Flux.just(1, 2, 3, "a", Util.faker().name().fullName());

        flux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

    }

}
