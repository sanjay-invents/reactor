package com.shoryukane.section03;

import com.shoryukane.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture03FluxTake {

    public static void main(String[] args) {

        Flux.range(1, 10)
                .log()
                .take(3)
                .log()
                .subscribe(Util.subscriber());

    }

}
