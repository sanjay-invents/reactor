package com.shoryukane.section02;

import com.shoryukane.courseutil.Util;
import com.shoryukane.section02.helper.NameGenerator;

import java.util.List;

public class Lecture07FluxVsList {

    public static void main(String[] args) {

//        List<String> names = NameGenerator.getNames(5);
//        System.out.println(names);
            NameGenerator.getNames(5)
                    .subscribe(Util.onNext());
    }

}
