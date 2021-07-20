package com.shoryukane.section01;

import com.shoryukane.courseutil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lecture05MonoFromSupplier {

    public static void main(String[] args) {

        // Use just only when you have data already
        // Mono<String> mono = Mono.just(getName());

        Supplier<String> stringSupplier = () -> getName();
        Mono<String> mono = Mono.fromSupplier(stringSupplier);

        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

        Callable<String> stringCallable = () -> getName();
        Mono.fromCallable(stringCallable)
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

    }

    private static String getName() {
        System.out.println("Generating name...");
        return Util.faker().name().fullName();
    }

}
