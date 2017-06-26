package by.coffeeroom.security.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Table.Keep configuration data.
 */
@Entity
@Table
public class Configuration implements Serializable{
    /**
     * Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * Quantity for each free cups.
     */
    private int nCups;
    /**
     * Cost for free delivery.
     */
    private int xFreeDelivery;
    /**
     * Cost delivery.
     */
    private int mCostDelivery;

    /**
     * Constructor
     */
    public Configuration() {
    }

    /**
     * Constructor.
     * @param nCups
     * @param xFreeDelivery
     * @param mCostDelivery
     */
    public Configuration(int nCups, int xFreeDelivery, int mCostDelivery) {
        this.nCups = nCups;
        this.xFreeDelivery = xFreeDelivery;
        this.mCostDelivery = mCostDelivery;
    }

    /**
     * Get Id.
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set id
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get nCups.
     * @return
     */
    public int getnCups() {
        return nCups;
    }

    /**
     * Set nCups.
     * @param nCups
     */
    public void setnCups(int nCups) {
        this.nCups = nCups;
    }

    /**
     * Get value for free delivery.
     * @return
     */
    public int getxFreeDelivery() {
        return xFreeDelivery;
    }

    /**
     * Set value for free delivery.
     * @param xFreeDelivery
     */
    public void setxFreeDelivery(int xFreeDelivery) {
        this.xFreeDelivery = xFreeDelivery;
    }

    /**
     * Get cost delivery.
     * @return
     */
    public int getmCostDelivery() {
        return mCostDelivery;
    }

    /**
     * Set cost delivery.
     * @param mCostDelivery
     */
    public void setmCostDelivery(int mCostDelivery) {
        this.mCostDelivery = mCostDelivery;
    }
}
