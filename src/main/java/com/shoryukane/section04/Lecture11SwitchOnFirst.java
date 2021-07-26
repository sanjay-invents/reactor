package com.shoryukane.section04;

import com.shoryukane.courseutil.Util;
import com.shoryukane.section04.helper.Person;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class Lecture11SwitchOnFirst {

    public static void main(String[] args) {

        getPerson()
                .switchOnFirst((signal, personFlux) -> {
                    System.out.println("Inside switch on first");
                    return signal.isOnNext() && signal.get().getAge() > 10 ? personFlux : applyFilterMap().apply(personFlux);
                })
                .subscribe(Util.subscriber());

    }

    public static Flux<Person> getPerson() {
        return Flux.range(1, 10)
                .map(i -> new Person());
    }

    public static Function<Flux<Person>, Flux<Person>> applyFilterMap() {
        return personFlux -> personFlux
                .filter(person -> person.getAge() > 10)
                .doOnNext(person -> person.setName(person.getName().toUpperCase()))
                .doOnDiscard(Person.class, person -> System.out.println("Not allowing : " + person));
    }

}
