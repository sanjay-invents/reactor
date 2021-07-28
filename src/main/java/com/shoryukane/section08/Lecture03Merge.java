package com.shoryukane.section08;

import com.shoryukane.courseutil.Util;
import com.shoryukane.section08.helper.AmericanAirlines;
import com.shoryukane.section08.helper.Emirates;
import com.shoryukane.section08.helper.Qatar;
import reactor.core.publisher.Flux;

public class Lecture03Merge {

    public static void main(String[] args) {

        Flux<String> merge = Flux.merge(
                Qatar.getFlights(),
                Emirates.getFlights(),
                AmericanAirlines.getFlights()
        );

        merge.subscribe(Util.subscriber());

        Util.sleepSeconds(10);

    }

}
