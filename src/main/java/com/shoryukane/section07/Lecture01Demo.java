package com.shoryukane.section07;

import com.shoryukane.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lecture01Demo {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            for (int i = 1; i < 501; i++) {
                fluxSink.next(i);
                System.out.println("Pushed : " + i);
            }
            fluxSink.complete();
        })
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> {
                    Util.sleepMilliSeconds(10);
                })
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);

    }

}
