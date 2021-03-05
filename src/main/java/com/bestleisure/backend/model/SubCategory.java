package com.bestleisure.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
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

    @JsonManagedReference
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category_id;

    @JsonBackReference
    @OneToMany(mappedBy = "subCategory_id")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Post> posts;

    public SubCategory() {
    }

    public SubCategory(Long id, String name, Category category_id) {
        this.id = id;
        this.name = name;
        this.category_id = category_id;
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

    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }
}
