package reactive.flux;

import reactive.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lesson01FluxIntro {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.just(1, 2, 3, 4,"A",
                Util.faker().name().fullName());
        flux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete());
    }
}
