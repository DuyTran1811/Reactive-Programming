package reactive.threading;

import reactive.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lesson06Parallel {
    public static void main(String[] args) {

        Flux.range(1, 10)
                .parallel(2)
                .runOn(Schedulers.boundedElastic())
                .doOnNext(i -> printThreadName("next" + i))
                .sequential()
                .subscribe(v -> printThreadName("sub" + v));

        Util.sleepSeconds(10000);
    }

    private static void printThreadName(String smg) {
        System.out.println(smg + "\t\t: Thread: " + Thread.currentThread().getName());
    }

}
