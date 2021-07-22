package com.shoryukane.section03;

import com.shoryukane.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture05FluxGenerate {

    public static void main(String[] args) {

        Flux.generate(synchronousSink -> {
            System.out.println("Emitting");
            synchronousSink.next(Util.faker().country().name());
//            synchronousSink.complete();
            synchronousSink.error(new RuntimeException("oops"));
        })
                .take(2)
                .subscribeWith(Util.subscriber());

    }

}
