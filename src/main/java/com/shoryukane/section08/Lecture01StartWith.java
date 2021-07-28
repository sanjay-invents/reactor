package com.shoryukane.section08;

import com.shoryukane.courseutil.Util;
import com.shoryukane.section08.helper.NameGenerator;

public class Lecture01StartWith {

    public static void main(String[] args) {

        NameGenerator generator = new NameGenerator();
        generator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("sam"));

        generator.generateNames()
                .take(2)
                .subscribe(Util.subscriber("mike"));

        generator.generateNames()
                .take(3)
                .subscribe(Util.subscriber("jake"));

        generator.generateNames()
                .filter(n -> n.startsWith("A"))
                .take(2)
                .subscribe(Util.subscriber("marshal"));

        generator.generateNames()
                .take(5)
                .subscribe(Util.subscriber("toby"));

    }

}
