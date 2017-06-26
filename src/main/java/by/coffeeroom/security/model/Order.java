package by.coffeeroom.security.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Table for keep orders.
 */
@Entity
@Table(name = "orders")
public class Order implements Serializable{
    /**
     * id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;
    /**
     * Address
     */
    @Size(min = 10)
    private String address;
    /**
     * Order price.
     */
    private int fullPrice;
    /**
     * Order date.
     */
    @Temporal(TemporalType.DATE)
    private Date date;
    /**
     * List ordered product.
     */
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Coffee> coffeeList;
    /**
     * User .
     */
    @ManyToOne
    @JoinColumn(name = "username",referencedColumnName = "username")
    private User user;

    /**
     * Constructor.
     */
    public Order() {
    }

    /**
     * Constructor.
     * @param address
     * @param fullPrice
     * @param coffeeList
     * @param user
     */
    public Order(String address, int fullPrice,List<Coffee> coffeeList ,User user) {
        this.address = address;
        this.fullPrice = fullPrice;
        this.coffeeList = coffeeList;
        this.user = user;
        this.date = new Date();
    }

    /**
     * Get address.
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set address.
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get order price.
     * @return
     */
    public int getFullPrice() {
        return fullPrice;
    }

    /**
     * Set order price.
     * @param fullPrice
     */
    public void setFullPrice(int fullPrice) {
        this.fullPrice = fullPrice;
    }

    /**
     * Get list product.
     * @return
     */
    public List<Coffee> getCoffeeList() {
        return coffeeList;
    }

    /**
     * Set list product.
     * @param coffeeList
     */
    public void setCoffeeList(List<Coffee> coffeeList) {
        this.coffeeList = coffeeList;
    }

    /**
     * Get order id.
     * @return
     */
    public Long getOrder_id() {
        return order_id;
    }

    /**
     * Set order id.
     * @param order_id
     */
    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    /**
     * get user.
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     * set user.
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * get date.
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     * set date.
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }
}

