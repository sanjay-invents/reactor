package com.shoryukane.section01.assignment;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    private static final Path PATH = Paths.get("src/main/resources/assignment/section01");

    public static Mono<String> read(String fileName) {
        return Mono.fromSupplier(() -> readFile(fileName));
    }

    public static Mono<Void> write(String fileName, String content) {
        return Mono.fromRunnable(() -> writeFile(fileName, content));
    }

    public static Mono<Void> delete(String fileName) {
        return Mono.fromRunnable(() -> deleteFile(fileName));
    }

    private static String readFile(String fileName) {
        try {
            byte[] ba = Files.readAllBytes(PATH.resolve(fileName));
            return new String(ba);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeFile(String fileName, String content) {
        try {
            Files.write(PATH.resolve(fileName), content.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void deleteFile(String fileName) {
        try {
            Files.delete(PATH.resolve(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
