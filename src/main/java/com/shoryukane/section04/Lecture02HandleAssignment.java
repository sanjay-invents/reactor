package com.shoryukane.section04;

import com.shoryukane.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.Locale;

public class Lecture02HandleAssignment {

    public static void main(String[] args) {

        Flux.generate(synchronousSink -> synchronousSink.next(Util.faker().country().name()))
                .map(Object::toString)
                .handle((s, synchronousSink) -> {
                    synchronousSink.next(s);
                    if (s.toLowerCase(Locale.ROOT).equals("canada")) {
                        synchronousSink.complete();
                    }
                })
                .subscribe(Util.subscriber());

    }

}
