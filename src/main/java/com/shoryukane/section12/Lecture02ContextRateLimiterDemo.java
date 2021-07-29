package com.shoryukane.section12;

import com.shoryukane.courseutil.Util;
import com.shoryukane.section12.helper.BookService;
import com.shoryukane.section12.helper.UserService;
import reactor.util.context.Context;

public class Lecture02ContextRateLimiterDemo {

    public static void main(String[] args) {

        BookService.getBook()
                .repeat(3)
                .contextWrite(UserService.userCategoryContext())
                .contextWrite(Context.of("user", "mike"))
                .subscribe(Util.subscriber());

    }

}
