package com.shoryukane.section04;

import com.shoryukane.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture04LimitRate {

    public static void main(String[] args) {

        Flux.range(1, 1000)
                .log()
                .limitRate(100, 0)
                .subscribe(Util.subscriber());

    }

}
