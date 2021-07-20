package com.shoryukane.section01;

import com.shoryukane.courseutil.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lecture06SupplierRefactoring {

    public static void main(String[] args) {

        getName();
        String name = getName()
                .subscribeOn(Schedulers.boundedElastic())
//                .subscribe(Util.onNext());
                .block();
        System.out.println(name);
        getName();
        Util.sleepSeconds(4);
    }

    private static Mono<String> getName() {
        System.out.println("Entered getName method");
        return Mono.fromSupplier(() -> {
            System.out.println("Generating name...");
            Util.sleepSeconds(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }

}
