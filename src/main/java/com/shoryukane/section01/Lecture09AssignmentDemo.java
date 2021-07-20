package com.shoryukane.section01;

import com.shoryukane.courseutil.Util;
import com.shoryukane.section01.assignment.FileService;

public class Lecture09AssignmentDemo {

    public static void main(String[] args) {

        FileService.read("file03.txt")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        FileService.delete("file03.txt")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

//        FileService.write("file03.txt", "This is file3.")
//                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

    }

}
