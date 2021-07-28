package com.shoryukane.section09;

import com.shoryukane.courseutil.Util;
import com.shoryukane.section09.helper.BookOrder;
import com.shoryukane.section09.helper.RevenueReport;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Lecture03Assignment {

    public static void main(String[] args) {

        Set<String> allowedCategories = new HashSet<>();
        allowedCategories.add("Science fiction");
        allowedCategories.add("Fantasy");
        allowedCategories.add("Suspense/Thriller");

        bookStream()
                .filter(bookOrder -> allowedCategories.contains(bookOrder.getCategory()))
                .buffer(Duration.ofSeconds(5))
                .map(list -> revenueCalculator(list))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);

    }

    private static Flux<BookOrder> bookStream() {
        return Flux.interval(Duration.ofMillis(200))
                .map(i -> new BookOrder());
    }

    private static RevenueReport revenueCalculator(List<BookOrder> bookOrderList) {
        Map<String, Double> map = bookOrderList.stream()
                .collect(Collectors.groupingBy(
                        BookOrder::getCategory,
                        Collectors.summingDouble(BookOrder::getPrice)
                ));

        return new RevenueReport(map);
    }

}
