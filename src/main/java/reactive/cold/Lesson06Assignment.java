package reactive.cold;

import reactive.cold.assignment.InventoryService;
import reactive.cold.assignment.OrderService;
import reactive.cold.assignment.RevenueService;
import reactive.courseutil.Util;

public class Lesson06Assignment {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        RevenueService revenueService = new RevenueService();
        InventoryService inventoryService = new InventoryService();

        // revenue and inv - observe order stream
        orderService.orderStream().subscribe(revenueService.subscribeOrderStream());
        orderService.orderStream().subscribe(inventoryService.subscribeOrderStream());

        inventoryService.revenueStream()
                .subscribe(Util.subscriber("inventory"));

        inventoryService.revenueStream()
                .subscribe(Util.subscriber("revenue"));
        Util.sleepSeconds(20000);
    }
}
