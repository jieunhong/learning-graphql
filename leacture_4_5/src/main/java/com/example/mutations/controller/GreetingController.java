package com.example.mutations.controller;

import com.example.mutations.entity.Greeting;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Controller
public class GreetingController {


    @QueryMapping
    Greeting greeting(){
        return new Greeting("Hello");
    }

    @SubscriptionMapping
    Flux<Greeting> greetings(){
        return Flux
                .fromStream(Stream.generate(() -> new Greeting("Hello "+ Instant.now())))
                .delayElements(Duration.ofSeconds(1))
                .take(10);
    }
}
