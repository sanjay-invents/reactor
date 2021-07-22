package com.shoryukane.section03;

import com.shoryukane.courseutil.Util;
import com.shoryukane.section03.assignment.FileReaderService;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Lecture09FileReaderServiceAssignment {

    public static void main(String[] args) {

        FileReaderService fileReaderService = new FileReaderService();

        Path path = Paths.get("src/main/resources/assignment/section03/file01.txt");

        fileReaderService.read(path)
                .map(s -> {
                    Integer integer = Util.faker().random().nextInt(0, 10);
                    if (integer > 8) {
                        throw new RuntimeException("Ooops");
                    }
                    return s;
                })
                .take(20)
                .subscribe(Util.subscriber());

    }

}
