package com.shoryukane.section11;

import com.shoryukane.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class Lecture01SinkOne {

    public static void main(String[] args) {

        // mono can emit 1 value or empty or error
        Sinks.One<Object> sink = Sinks.one();

        Mono<Object> mono = sink.asMono();

        mono.subscribe(Util.subscriber("sam"));
        mono.subscribe(Util.subscriber("mike"));

//        sink.tryEmitValue("Hi");
//        sink.tryEmitEmpty();
//        sink.tryEmitError(new RuntimeException("Oops"));

//        sink.emitValue("hi", (signalType, emitResult) -> {
//            System.out.println(signalType.name());
//            System.out.println(emitResult.name());
//            return false;
//        });
//
//        sink.emitValue("hello", (signalType, emitResult) -> {
//            System.out.println(signalType.name());
//            System.out.println(emitResult.name());
//            return false;
//        });
        sink.tryEmitValue("Hello");

    }


}
