package od.pnit.module;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private int id;

    @NonNull
    @Size(min = 5, max = 40)
    private String order_address;

    @NonNull
    @Size(min = 2, max = 40)
    private String customer_firstname;

    @NonNull
    @Size(min = 5, max = 35)
    private String customer_lastname;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Item> items;

    public Order(int id, @NonNull @Size(min = 5, max = 40) String order_address, @NonNull @Size(min = 2, max = 40) String customer_firstname, @NonNull @Size(min = 5, max = 35) String customer_lastname, List<Item> items) {
        this.id = id;
        this.order_address = order_address;
        this.customer_firstname = customer_firstname;
        this.customer_lastname = customer_lastname;
        this.items = items;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getOrder_address() {
        return order_address;
    }

    public void setOrder_address(@NonNull String order_address) {
        this.order_address = order_address;
    }

    @NonNull
    public String getCustomer_firstname() {
        return customer_firstname;
    }

    public void setCustomer_firstname(@NonNull String customer_firstname) {
        this.customer_firstname = customer_firstname;
    }

    @NonNull
    public String getCustomer_lastname() {
        return customer_lastname;
    }

    public void setCustomer_lastname(@NonNull String customer_lastname) {
        this.customer_lastname = customer_lastname;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
