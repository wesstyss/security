package web.model;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;


@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {
    @Id
    private Long id;

    @Column(name="name")
    private String name;

    public Long getId() {
        return id;
    }

    public Role() {
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
