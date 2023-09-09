package bg.distilery.models.user;

import bg.distilery.models.order.ShippingDetails;
import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    @ManyToMany
    private Set<UserRole> roles;

    @OneToMany
    private Set<ShippingDetails> shippingDetails;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    public Set<ShippingDetails> getShippingDetails() {
        return shippingDetails;
    }

    public void setShippingDetails(Set<ShippingDetails> shippingDetails) {
        this.shippingDetails = shippingDetails;
    }
}
