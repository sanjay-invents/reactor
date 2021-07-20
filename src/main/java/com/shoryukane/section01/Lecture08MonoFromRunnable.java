package com.shoryukane.section01;

import com.shoryukane.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lecture08MonoFromRunnable {

    public static void main(String[] args) {

//        Runnable runnable = () -> System.out.println("");

        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        () -> {
                            System.out.println("Process is done. Sending email...");
                        }
                );

    }

    private static Runnable timeConsumingProcess() {
        return () -> {
            Util.sleepSeconds(3);
            System.out.println("Operation completed");
        };
    }

}
