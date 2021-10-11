package reactive.flux;

import reactive.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lesson09FluxFromMono {
    public static void main(String[] args) {
//        Mono<String> mono = Mono.just("a");
//        Flux<String> flux = Flux.from(mono);
//        flux.subscribe(Util.onNext());

        Flux.range(1, 10)
                .filter(i -> i > 3)
                .next().subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete());
    }

    private static void soSomething(Flux<String> flux) {

    }
}
