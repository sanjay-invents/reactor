package com.shoryukane.section04;

import com.shoryukane.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lecture08DefaultIfEmpty {

    public static void main(String[] args) {

        getOrderNumbers()
                .filter(i -> i > 10)
                .defaultIfEmpty(-100)
                .subscribe(Util.subscriber());

    }

    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1, 10);
    }

}
