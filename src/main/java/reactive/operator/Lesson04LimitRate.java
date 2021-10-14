package reactive.operator;

import reactive.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lesson04LimitRate {
    public static void main(String[] args) {
        Flux.range(1, 1000)
                .log()
                .limitRate(100, 99)
                .subscribe(Util.subscriber());
    }
}
