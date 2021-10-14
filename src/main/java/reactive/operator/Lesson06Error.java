package reactive.operator;

import reactive.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lesson06Error {
    public static void main(String[] args) {
        Flux.range(1,10)
                .log()
                .map(integer -> 10 / (5 - integer))
//                .onErrorReturn(-1)
//                .onErrorResume(e -> fallback())
                .onErrorContinue((error ,obj) -> {

                })
                .subscribe(Util.subscriber());
    }
    private static Mono<Integer> fallback() {
        return Mono.fromSupplier(() -> Util.faker().random().nextInt(100, 200));
    }
}
