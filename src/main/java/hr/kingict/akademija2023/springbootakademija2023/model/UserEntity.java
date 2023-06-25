package hr.kingict.akademija2023.springbootakademija2023.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "korisnici")
public class UserEntity extends BasicEntity {

    @Column(name = "korisnicko_ime")
    private String username;

    @Column(name = "lozinka")
    private String password;

    @Column(name = "rola")
    private String role;

    @Column(name = "aktivan")
    private Boolean active;



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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
