package reactive.threading;

import reactive.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

public class Lesson07FluxInterval {
    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1000))
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(Util.subscriber());

        Util.sleepSeconds(20000);
    }
}
