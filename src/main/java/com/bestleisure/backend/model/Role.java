package com.bestleisure.backend.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "id", updatable = false)
    @SequenceGenerator(name = "role_sequence", sequenceName = "roles_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_sequence")
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private Collection<User> users;

    public Role() {
    }

    public Role(Long id, String name, Collection<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public Long getId() {
        return id;
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

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
