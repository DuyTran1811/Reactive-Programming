package reactive.mono;

import reactive.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lesson3MonoSubscribe {
    public static void main(String[] args) {
        // Publisher
        Mono<Integer> mono = Mono.just("Hellosss")
                .map(String::length)
                .map(l -> l);
        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
