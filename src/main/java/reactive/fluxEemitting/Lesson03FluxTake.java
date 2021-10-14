package reactive.fluxEemitting;

import reactive.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lesson03FluxTake {
    public static void main(String[] args) {
        Flux.range(1,10)
                .log()
                .take(3)
                .subscribe(Util.subscriber());
    }
}
