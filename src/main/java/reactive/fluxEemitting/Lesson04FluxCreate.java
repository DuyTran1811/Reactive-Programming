package reactive.fluxEemitting;

import reactive.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lesson04FluxCreate {
    public static void main(String[] args) {
        // Only one instance of Fluxsink
        Flux.create(fluxSink -> {
                    String country;
                    int count  = 0;
                    do {
                        country = Util.faker().country().name();
                        System.out.println("emitting : " + country);
                        fluxSink.next(country);
                        count ++;
                    } while (!country.equalsIgnoreCase("canada")
                            && !fluxSink.isCancelled() && count < 10);
                    fluxSink.complete();
                })
//                .take(3)
                .subscribe(Util.subscriber());
    }
}
