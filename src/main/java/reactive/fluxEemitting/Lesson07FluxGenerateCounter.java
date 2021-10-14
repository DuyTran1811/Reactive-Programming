package reactive.fluxEemitting;

import reactive.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lesson07FluxGenerateCounter {
    public static void main(String[] args) {
        Flux.generate(
                () -> 1,
                (count, sink) -> {
                    String country = Util.faker().country().name();
                    sink.next(country);
                    if (count >= 10 || country.equalsIgnoreCase("canada"))
                        sink.complete();
                    return count + 1;
                }
        )
                .take(4)
                .subscribe(Util.subscriber());
    }
}
