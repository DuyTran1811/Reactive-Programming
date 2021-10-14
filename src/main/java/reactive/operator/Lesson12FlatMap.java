package reactive.operator;

import reactive.courseutil.Util;
import reactive.operator.helper.OrderService;
import reactive.operator.helper.UserService;

public class Lesson12FlatMap {
    public static void main(String[] args) {
        UserService.getUsers()
                .flatMap(user -> OrderService.getOrders(user.getUserId()))
                .subscribe(Util.subscriber());
    }
}
