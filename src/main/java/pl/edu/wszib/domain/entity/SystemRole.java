package pl.edu.wszib.domain.entity;

import pl.edu.wszib.enums.Role;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class SystemRole {

    @Id
    @Enumerated(EnumType.STRING)
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
