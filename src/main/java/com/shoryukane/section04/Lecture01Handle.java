package com.shoryukane.section04;

import com.shoryukane.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture01Handle {

    public static void main(String[] args) {

        // handle = filter + map
//        Flux.range(1, 20)
//                .handle((integer, synchronousSink) -> {
//                    if (integer % 2 == 0)
//                        synchronousSink.next(integer);
//                    else
//                        synchronousSink.next(integer + "a");
//                })
//                .subscribe(Util.subscriber());
        Flux.range(1, 20)
                .handle((integer, synchronousSink) -> {
                    if (integer == 7)
                        synchronousSink.complete();
                    else
                        synchronousSink.next(integer);
                })
                .subscribe(Util.subscriber());

    }

}
