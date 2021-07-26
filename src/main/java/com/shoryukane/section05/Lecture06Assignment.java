package com.shoryukane.section05;

import com.shoryukane.courseutil.Util;
import com.shoryukane.section05.assignment.InventoryService;
import com.shoryukane.section05.assignment.OrderService;
import com.shoryukane.section05.assignment.RevenueService;

public class Lecture06Assignment {

    public static void main(String[] args) {

        OrderService orderService = new OrderService();
        RevenueService revenueService =  new RevenueService();
        InventoryService inventoryService = new InventoryService();

        orderService.orderStream()
                .subscribe(revenueService.subscribeOrderStream());
        orderService.orderStream()
                .subscribe(inventoryService.subscribeOrderStream());

        inventoryService.inventoryStream()
                .subscribe(Util.subscriber("inventory"));

        revenueService.revenueStream()
                .subscribe(Util.subscriber("revenue"));

        Util.sleepSeconds(60);

    }

}
