package reactive.mono;

import reactive.courseutil.Util;
import reactive.mono.assignment.FileService;

public class Lesson9AssignmentDemo {
    public static void main(String[] args) {
        FileService.read("file01.txt.txt").subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete());
        FileService.write("file02.txt", "This is file 02").subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete());
        FileService.delete("file02.txt").subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
