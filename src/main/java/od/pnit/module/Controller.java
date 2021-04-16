package od.pnit.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class Controller {

    private OrderService service;

    @Autowired
    public Controller(OrderService service) {
        this.service = service;
    }

    @PostMapping("/order/item")
    public ResponseEntity<String> addItem(@RequestBody Item item, @RequestParam(value = "order_id") int order_id) {
        boolean status = service.addItem(item, order_id);

        if (status) return ResponseEntity.ok("item added!");
        else return ResponseEntity.badRequest().build();
    }

    @PutMapping("/order/item")
    public ResponseEntity<String> replaceItem(@RequestBody Item item, @RequestParam(value = "item_id") int item_id, @RequestParam(value = "order_id") int order_id) {
        boolean status = service.replaceItem(item, item_id, order_id);

        if (status) return ResponseEntity.ok("replaced");
        else return ResponseEntity.badRequest().build();
    }

    @PostMapping("/order")
    public void addOrder(@RequestBody Order order) {
        service.addOrder(order);
    }

    @DeleteMapping("/order/{id}")
    public  void deleteOrder(@PathVariable(value = "id") int id) {
        service.deleteOrder(id);
    }

    @PutMapping("/order")
    public ResponseEntity<String> replaceCustomerLastName(@RequestParam(value = "customer_lastname") String lastName, @RequestParam(value = "order_id") int order_id) {
        boolean status = service.replaceCustomerLastName(lastName, order_id);

        if (status) return ResponseEntity.ok("replaced");
        else return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/order/item")
    public ResponseEntity<String> deleteItemFromOrder(@RequestParam(value = "order_id") int order_id, @RequestParam(value = "item_id") int item_id) {
        boolean status = service.deleteItemFromOrder(order_id, item_id);

        if (status) return ResponseEntity.ok("replaced");
        else return ResponseEntity.badRequest().build();
    }
}
