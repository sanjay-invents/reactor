package com.shoryukane.section01;

import java.util.stream.Stream;

public class Lecture01Stream {

    public static void main(String[] args) {

        Stream<Integer> integerStream = Stream.of(1)
                .map(integer -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return integer * 2;
                });
//        System.out.println(integerStream);

        integerStream.forEach(System.out::println);
    }


}
