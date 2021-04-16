package od.pnit.module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    private OrderRepository order_repo;
    private ItemRepository item_repo;

    @Autowired
    public void setOrder_repo(OrderRepository order_repo) {
        this.order_repo = order_repo;
    }

    @Autowired
    public void setItem_repo(ItemRepository item_repo) {
        this.item_repo = item_repo;
    }

    public boolean addItem(Item item, int order_id) {
        if (!order_repo.existsById(order_id)) return false;

        Order order = order_repo.getOne(order_id);
        item.setOrder(order);
        item_repo.save(item);

        return true;

    }

    public void addOrder(Order order) {
        order_repo.saveAndFlush(order);
    }

    public void deleteOrder(int id) {
        order_repo.deleteById(id);
    }

    public boolean replaceItem(Item item, int item_id, int order_id) {
        // replace
        return true;
    }

    public boolean replaceCustomerLastName(String lastName, int order_id) {
        if (!order_repo.existsById(order_id)) return false;

        Order order = order_repo.getOne(order_id);
        order.setCustomer_lastname(lastName);
        order_repo.saveAndFlush(order);

        return true;
    }

    public boolean deleteItemFromOrder(int order_id, int item_id) {
        if (!order_repo.existsById(order_id) || !item_repo.existsById(item_id)) return false;

        Order order = order_repo.getOne(order_id);
        order.getItems().remove(item_repo.getOne(item_id));
        order_repo.saveAndFlush(order);

        return true;
    }
}
