package reactive.operator;

import reactive.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lesson07TimeOut {
    public static void main(String[] args) {
       getOrderNumbers().timeout(Duration.ofSeconds(2), fallback())
               .subscribe(Util.subscriber());
       Util.sleepSeconds(6000);
    }
    private static Flux<Integer>getOrderNumbers(){
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1));
    }
    private static Flux<Integer>fallback(){
        return Flux.range(100,10)
                .delayElements(Duration.ofMillis(200));
    }
}
