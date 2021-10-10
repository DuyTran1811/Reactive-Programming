package reactive.secstion1;

import reactive.courseutil.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lesson6SupplierRefactoring {
    public static void main(String[] args) {
        getName();
        String name = getName()
                .subscribeOn(Schedulers.boundedElastic()).block();
        getName();
        System.out.println(name);
        Util.sleepSeconds(4);
    }

    private static Mono<String> getName() {
        System.out.println("Entered get Name method");
        return Mono.fromSupplier(() -> {
            System.out.println("Generating Name ...");
            Util.sleepSeconds(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }


}
