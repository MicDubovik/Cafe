package by.coffeeroom.security.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Table for keep users.
 */
@Entity
@Table(name = "users")
public class User implements Serializable{
    /**
     * User id-name.
     */
    @Id
    @Column(unique = true)
    @Size(min = 3)
    private String username;
    /**
     * Password.
     */
    @Size(min = 6)
    private String password;
    /**
     * Email.
     */
    @Email(message = "Invalid email.Please try again.")
    @Size(min = 7)
    private String email;
    /**
     * Field for disabled users.
     */
    private boolean enabled;
    /**
     * List orders.
     */
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Order> orders;
    /**
     * List roles.
     */
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private Set<Role> roleSet;

    /**
     * Constructor.
     */
    public User() {
    }

    /**
     * Constructor.
     * @param username
     * @param password
     * @param email
     * @param enabled
     */
    public User(String username, String password, String email , boolean enabled) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
        this.orders = new ArrayList<>();
    }

    /**
     * Get username.
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set username.
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get password
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * set password.
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get roles
     * @return
     */
    public Set<Role> getRoleSet() {
        return roleSet;
    }

    /**
     * Set roles
     * @param roleSet
     */
    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    /**
     * Get email.
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set email.
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get enabled.
     * @return
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Set enable.
     * @param enabled
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * get list orders.
     * @return
     */
    public List<Order> getOrders() {
        return orders;
    }

    /**
     * set list orders.
     * @param orders
     */
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
