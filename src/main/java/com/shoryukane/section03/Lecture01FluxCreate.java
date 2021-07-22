package com.shoryukane.section03;

import com.shoryukane.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.Locale;

public class Lecture01FluxCreate {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
//            fluxSink.next(1);
//            fluxSink.next(2);
//            fluxSink.complete();
//            for (int i = 0; i < 10; i++) {
//                fluxSink.next(Util.faker().country().name());
//            }
//            fluxSink.complete();
            String country;
            do {
                country = Util.faker().country().name();
                fluxSink.next(country);
            } while (!country.toLowerCase().equals("nepal"));
            fluxSink.complete();
        })
                .subscribeWith(Util.subscriber());

    }

}
