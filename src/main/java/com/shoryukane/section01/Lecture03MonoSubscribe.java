package com.shoryukane.section01;

import com.shoryukane.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lecture03MonoSubscribe {

    public static void main(String[] args) {

        // Publisher
        Mono<Integer> mono = Mono.just("ball")
                .map(String::length)
                .map(l -> l / 2);

        // 1
        // mono.subscribe();

        // 2
//        mono.subscribe(
//                item -> System.out.println(item),
//                err -> System.out.println("Error message : " + err.getMessage()),
//                () -> System.out.println("Completed")
//        );

        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

    }

}
