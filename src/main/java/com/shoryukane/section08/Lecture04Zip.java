package com.shoryukane.section08;

import com.shoryukane.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture04Zip {

    public static void main(String[] args) {

        Flux.zip(getBody(), getEngine(), getTires())
//                .doOnNext(tuple3 -> tuple3.getT3())
                .subscribe(Util.subscriber());

    }

    private static Flux<String> getBody() {
        return Flux.range(1, 5)
                .map(i -> "Body");
    }

    private static Flux<String> getEngine() {
        return Flux.range(1, 2)
                .map(i -> "Engine");
    }

    private static Flux<String> getTires() {
        return Flux.range(1, 6)
                .map(i -> "Tires");
    }

}
