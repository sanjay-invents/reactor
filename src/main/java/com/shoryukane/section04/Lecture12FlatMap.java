package com.shoryukane.section04;

import com.shoryukane.courseutil.Util;
import com.shoryukane.section04.helper.OrderService;
import com.shoryukane.section04.helper.UserService;

public class Lecture12FlatMap {

    public static void main(String[] args) {

        UserService.getUsers()
                .flatMap(user ->
                    OrderService.getOrders(user.getUserId())
                )
//                .filter(purchaseOrder -> purchaseOrder.getItem() > 10)
                .subscribe(Util.subscriber());
        Util.sleepSeconds(60);

    }

}
