package reactive.flux;

import reactive.courseutil.Util;
import reactive.flux.helper.NameGenerator;

import java.util.List;

public class Lesson07FluxVsList {
    public static void main(String[] args) {
//        List<String> names = NameGenerator.getNames(5);
//        System.out.println(names);

        NameGenerator.getNames(5).subscribe(Util.onNext());
    }
}
