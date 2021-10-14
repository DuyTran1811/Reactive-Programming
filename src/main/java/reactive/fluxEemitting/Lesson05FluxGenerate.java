package reactive.fluxEemitting;

import reactive.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lesson05FluxGenerate {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
                    System.out.println("emitting");
                    synchronousSink.next(Util.faker().country().name());
                    synchronousSink.error(new RuntimeException("oops"));
                })
                .take(3)
                .subscribe(Util.subscriber());
    }
}
