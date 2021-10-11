package reactive.mono;

import reactive.courseutil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lesson7FromFuture {
    public static void main(String[] args) {
        Mono.fromFuture(getName()).subscribe(
                Util.onNext()
        );
        Util.sleepSeconds(100);
    }
    private static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(() -> Util.faker().name().fullName());
    }
}
