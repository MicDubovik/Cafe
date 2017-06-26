package by.coffeeroom.security.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Table for keep Roles.
 */
@Entity
@Table(name = "user_roles")
public class Role implements Serializable{
    /**
     * id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_role_id;
    /**
     * Role.
     */
    private String role ;
    /**
     * User.
     */
    @ManyToOne
    @JoinColumn(name = "username",referencedColumnName = "username")
    private User user;

    /**
     * Constructor.
     */
    public Role() {

    }

    /**
     * Constructor.
     * @param role
     * @param user
     */
    public Role(String role, User user) {
        this.role = role;
        this.user = user;
    }

    /**
     * Constructor.
     * @param role
     */
    public Role(String role) {
        this.role = role;
    }

    /**
     * Get user.
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     * Set user.
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Get user_role_id.
     * @return
     */
    public Long getUser_role_id() {
        return user_role_id;
    }
    /**
     * Set user_role_id.
     * @return
     */
    public void setUser_role_id(Long user_role_id) {
        this.user_role_id = user_role_id;
    }

    /**
     * Get role.
     * @return
     */
    public String getRole() {
        return role;
    }

    /**
     * Set role.
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }
}
