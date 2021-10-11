package reactive.flux;

import reactive.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lesson03FluxFromArrayOfList {
    public static void main(String[] args) {
//        List<String> list = Arrays.asList("a", "b", "c");
//        Flux.fromIterable(list).subscribe(Util.onNext());
        Integer[] arr = {1, 2, 3, 4, 5};
        Flux.fromArray(arr).subscribe(Util.onNext());
    }
}
