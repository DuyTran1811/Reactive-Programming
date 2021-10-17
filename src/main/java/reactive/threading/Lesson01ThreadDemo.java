package reactive.threading;

import reactive.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lesson01ThreadDemo {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
                    printThreadName("create: ");
                    fluxSink.next(1);
                })
                .doOnNext(i -> printThreadName("Next: " + i));
        Runnable runnable = () -> flux.subscribe(v -> printThreadName("sub: " + v));
        for (int i = 0; i < 2; i++) {
            new Thread(runnable).start();
        }
        Util.sleepSeconds(5);
    }

    private static void printThreadName(String smg) {
        System.out.println(smg + "\t\t: Thread: " + Thread.currentThread().getName());
    }
}
