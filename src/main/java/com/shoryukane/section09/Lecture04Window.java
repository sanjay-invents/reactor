package com.shoryukane.section09;

import com.shoryukane.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class Lecture04Window {

    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {

        eventStream()
//                .window(5)
                .window(Duration.ofSeconds(2))
                .flatMap(stringFlux -> saveEvents(stringFlux))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);

    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(800))
                .map(i -> "Event " + i);
    }

    private static Mono<Integer> saveEvents(Flux<String> flux) {
        return flux
                .doOnNext(e -> System.out.println("Saving " + e))
                .doOnComplete(() -> {
                    System.out.println("Saved this batch");
                    System.out.println("----------------");
                })
                .then(Mono.just(atomicInteger.getAndIncrement()));
    }

}
