package reactive.threading;

import reactive.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lesson03SubscribeOnMultiple {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
                    printThreadName("create");
                    for (int i = 0; i < 4; i++) {
                        fluxSink.next(i);
                        Util.sleepSeconds(2000);
                    }
                    fluxSink.complete();
                })
                .doOnNext(i -> printThreadName("Next" + i));
        flux
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(v -> printThreadName("sub" + v));
        flux
                .subscribeOn(Schedulers.parallel())
                .subscribe(v -> printThreadName("sub" + v));
        Util.sleepSeconds(20000);
   }

    private static void printThreadName(String smg) {
        System.out.println(smg + "\t\t: Thread: " + Thread.currentThread().getName());
    }
}
