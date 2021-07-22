package com.shoryukane.section03;

import com.shoryukane.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture04FluxCreateIssueFix {

    public static void main(String[] args) {

        // Only one instance of fluxsink
        Flux.create(fluxSink -> {
                    String country;
                    do {
                        country = Util.faker().country().name();
                        System.out.println("Emitting : " + country);
                        fluxSink.next(country);
                    } while (!country.toLowerCase().equals("nepal") && !fluxSink.isCancelled());
                    fluxSink.complete();
                }
        )
                .take(3)
                .subscribeWith(Util.subscriber());
    }

}
