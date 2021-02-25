package com.bestleisure.backend.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "subcategories")
public class SubCategory {
    @Id
    @Column(name = "id", updatable = false)
    @SequenceGenerator(name = "subcategory_sequence", sequenceName = "subcategories_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subcategory_sequence")
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "subCategory", fetch = FetchType.EAGER)
    @OrderColumn
    private List<Post> posts;

    public SubCategory() {
    }

    public SubCategory(Long id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
