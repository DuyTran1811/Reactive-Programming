package reactive.fluxEemitting;

import reactive.courseutil.Util;
import reactive.fluxEemitting.helper.NameProducer;
import reactor.core.publisher.Flux;

public class Lesson02FluxCreateRefactoring {
    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();
        Flux.create(nameProducer).subscribe(Util.subscriber());
        Runnable readable = nameProducer::produce;
        for (int i = 0; i < 10; i++) {
            new Thread(readable).start();
        }
        Util.sleepSeconds(3);
    }
}
