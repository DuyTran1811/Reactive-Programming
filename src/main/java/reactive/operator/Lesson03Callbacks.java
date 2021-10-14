package reactive.operator;

import reactive.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lesson03Callbacks {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    for (int i = 0; i < 5; i++) {
                        fluxSink.next(i);
                    }
                    fluxSink.complete();
//                    fluxSink.error(new RuntimeException("oops"));
                    System.out.println("--Completed ");
                })
                .doOnComplete(() -> System.out.println("doOnCompleted"))
                .doFirst(() -> System.out.println("doFirst "))
                .doOnNext(o -> System.out.println("doONext: " + o))
                .doOnSubscribe(s -> System.out.println("doOnSubscribe " + s))
                .doOnRequest(l -> System.out.println("doOnRequest: " + l))
                .doOnError(err -> System.out.println("error: " + err))
                .doOnTerminate(() -> System.out.println("doOnTerminal"))
                .doOnCancel(() -> System.out.println("doOnCancel"))
                .doFinally(signal -> System.out.println("doFinally: " + signal))
                .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard: " + o))
                .take(3)
                .subscribe(Util.subscriber());
    }
}
