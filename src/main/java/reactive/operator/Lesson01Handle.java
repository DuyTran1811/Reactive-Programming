package reactive.operator;

import reactive.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lesson01Handle {
    public static void main(String[] args) {
        Flux.range(1, 20)
                .handle((integer, synchronousSink) -> {
                    if (integer == 7)
                        synchronousSink.complete();
                    else
                        synchronousSink.next(integer);
//                    if (integer % 2 == 0)
//                        synchronousSink.next(integer);
//                    else
//                        synchronousSink.next(integer + "a");
                }).subscribe(Util.subscriber());
    }
}
