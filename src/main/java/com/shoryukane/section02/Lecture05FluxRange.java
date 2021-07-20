package com.shoryukane.section02;

import com.shoryukane.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture05FluxRange {

    public static void main(String[] args) {

        Flux.range(3, 10)
                .log()
                .map(i -> Util.faker().name().fullName())
                .log()
                .subscribe(
                        Util.onNext()
                );

    }

}
