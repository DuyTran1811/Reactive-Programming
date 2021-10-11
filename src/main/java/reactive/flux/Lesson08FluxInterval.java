package reactive.flux;

import reactive.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lesson08FluxInterval {
    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1))
                .subscribe(Util.onNext());
        Util.sleepSeconds(5);
    }
}
