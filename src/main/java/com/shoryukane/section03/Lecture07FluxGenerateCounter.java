package com.shoryukane.section03;

import com.shoryukane.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.Locale;

public class Lecture07FluxGenerateCounter {

    public static void main(String[] args) {

        Flux.generate(
                () -> 1,
                (counter, sink) -> {
                    String country = Util.faker().country().name();
                    sink.next(country);
                    if (counter >= 100 || country.toLowerCase(Locale.ROOT).equals("canada")) {
                        sink.complete();
                    }

                    return counter + 1;
                }
        )
                .take(4)
                .subscribe(Util.subscriber());

    }

}
