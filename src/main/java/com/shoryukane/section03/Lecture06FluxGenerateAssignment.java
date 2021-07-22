package com.shoryukane.section03;

import com.shoryukane.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.Locale;

public class Lecture06FluxGenerateAssignment {

    public static void main(String[] args) {

        // Canada exit
        // max = 10
        // subscriber cancels then exit

        Flux.generate(synchronousSink -> {
            String country = Util.faker().country().name();
            System.out.println("Emitting : " + country);
            synchronousSink.next(country);
            if (country.toLowerCase(Locale.ROOT).equals("canada")) {
                synchronousSink.complete();
            }
        })
                .subscribe(Util.subscriber());

    }

}
