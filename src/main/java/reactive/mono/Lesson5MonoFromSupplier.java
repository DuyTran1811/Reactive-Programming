package reactive.mono;

import reactive.courseutil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lesson5MonoFromSupplier {
    private static String getName() {
        System.out.println("Generating name ... ");
        return Util.faker().name().fullName();
    }

    public static void main(String[] args) {
        Supplier<String> stringSupplier = () ->getName();
        // use just only when you have data already
//        Mono<String> mono = Mono.just(getName());
        Mono<String> mono = Mono.fromSupplier(() -> getName());
        mono.subscribe(
                Util.onNext()
        );
        Callable<String> stringCallable =() -> getName();
        Mono.fromCallable(stringCallable)
                .subscribe(
                        Util.onNext()
                );
    }
}
