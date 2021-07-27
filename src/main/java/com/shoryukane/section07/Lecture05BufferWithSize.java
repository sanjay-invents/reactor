package com.shoryukane.section07;

import com.shoryukane.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lecture05BufferWithSize {

    public static void main(String[] args) {

        System.setProperty("reactor.bufferSize.small", "16");

        Flux.create(fluxSink -> {
            for (int i = 1; i < 201 && !fluxSink.isCancelled(); i++) {
                fluxSink.next(i);
                System.out.println("Pushed : " + i);
                Util.sleepMilliSeconds(1);
            }
            fluxSink.complete();
        })
                .onBackpressureBuffer(50, o -> System.out.println("Dropped : " + o))
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> {
                    Util.sleepMilliSeconds(10);
                })
                .subscribe(Util.subscriber());

        Util.sleepSeconds(10);

    }

}
