package reactive.secstion1;

import reactor.core.publisher.Mono;

public class Lesson2MonoJust {
    public static void main(String[] args) {
        // Publisher
        Mono<Integer> mono = Mono.just(1);
        System.out.println(mono);
        mono.subscribe(i -> System.out.println("Received: " + i));
    }
}
