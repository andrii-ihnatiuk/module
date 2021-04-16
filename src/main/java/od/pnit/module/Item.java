package od.pnit.module;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue
    private int id;

    @NonNull
    @Size(min = 2, max = 25)
    private String item_name;

    @Min(0)
    @Max(100000)
    private float item_price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    @JsonIgnore
    private Order order;


    public Item(int id, @NonNull @Size(min = 2, max = 25) String item_name, @Min(0) @Max(100000) float item_price, Order order) {
        this.id = id;
        this.item_name = item_name;
        this.item_price = item_price;
        this.order = order;
    }

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(@NonNull String item_name) {
        this.item_name = item_name;
    }

    public float getItem_price() {
        return item_price;
    }

    public void setItem_price(float item_price) {
        this.item_price = item_price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
