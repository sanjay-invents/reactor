package com.shoryukane.section09;

import com.shoryukane.courseutil.Util;
import com.shoryukane.section09.assignment.OrderProcessor;
import com.shoryukane.section09.assignment.OrderService;
import com.shoryukane.section09.assignment.PurchaseOrder;
import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class Lecture06Assignment {

    public static void main(String[] args) {

        Map<String, Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>>> map = new HashMap<>();
        map.put("Kids", OrderProcessor.kidsProcessing());
        map.put("Automotive", OrderProcessor.automotiveProcessing());

        Set<String> set = map.keySet();

        OrderService.orderStream()
                .filter(p -> set.contains(p.getCategory()))
                .groupBy(PurchaseOrder::getCategory)
                .flatMap(groupedFlux -> map.get(groupedFlux.key()).apply(groupedFlux))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

}
