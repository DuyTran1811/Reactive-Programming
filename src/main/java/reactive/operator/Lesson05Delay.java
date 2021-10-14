package reactive.operator;

import reactive.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lesson05Delay {
    public static void main(String[] args) {
        Flux.range(1, 100)
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(Util.subscriber());
        Util.sleepSeconds(600000000);
    }
}
