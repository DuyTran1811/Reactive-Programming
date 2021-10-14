package reactive.operator;

import reactive.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lesson09SwitchIfEmpty {
    public static void main(String[] args) {
        getOrderNumbers()
                .filter(i -> i > 10)
                .switchIfEmpty(fallback())
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1, 11);
    }
    private static Flux<Integer> fallback() {
        return Flux.range(20, 5);
    }

}
