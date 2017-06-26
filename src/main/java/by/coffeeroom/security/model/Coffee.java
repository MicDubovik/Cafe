package by.coffeeroom.security.model;

import org.hibernate.annotations.NotFound;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Entity
@Table
public class Coffee implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name_en;
    private String name_ru;
    private boolean isExist;

    private double cost;

    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "order_id")
    private Order order;

    @Transient
    @Min(value = 0)
    private int count;

    @Transient
    private boolean selected;

    @Transient
    private String name;

    public Coffee() {

    }

    public Coffee(boolean isExist, double cost, String name) {
        this.isExist = isExist;
        this.cost = cost;
        this.name = name;
    }

    public Coffee(String name_en, String name_ru, boolean isExist, double cost) {
        this.name_en = name_en;
        this.name_ru = name_ru;
        this.isExist = isExist;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public String getName_ru() {
        return name_ru;
    }

    public void setName_ru(String name_ru) {
        this.name_ru = name_ru;
    }

    public boolean isExist() {
        return isExist;
    }

    public void setExist(boolean exist) {
        isExist = exist;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
