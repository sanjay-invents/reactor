package com.shoryukane.section04;

import com.shoryukane.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lecture03DoCallbacks {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            System.out.println("Inside create");
            for (int i = 0; i < 5; i++) {
                fluxSink.next(i);
            }
//            fluxSink.complete();
            fluxSink.error(new RuntimeException("Oops"));
            System.out.println("--completed");
        })
                .doOnComplete(() -> System.out.println("doOnComplete"))
                .doFirst(() -> System.out.println("doFirst 1"))
                .doOnNext(o -> System.out.println("doOnNext : " + o))
                .doOnSubscribe(subscription -> System.out.println("doOnSubscribe 1 : " + subscription))
                .doOnRequest(value -> System.out.println("doOnRequest : " + value))
                .doFirst(() -> System.out.println("doFirst 2"))
                .doOnError(throwable -> System.out.println("doOnError : " + throwable.getMessage()))
                .doOnTerminate(() -> System.out.println("doOnTerminate"))
                .doOnCancel(() -> System.out.println("doOnCancel"))
                .doOnSubscribe(subscription -> System.out.println("doOnSubscribe 2 : " + subscription))
                .doFinally(signalType -> System.out.println("doFinally 1 : " + signalType))
                .doFirst(() -> System.out.println("doFirst 3"))
                .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard : " + o))
                .take(2)
                .doFinally(signalType -> System.out.println("doFinally 2 : " + signalType))
                .subscribe(Util.subscriber());

    }

}
