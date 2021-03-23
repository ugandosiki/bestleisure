package com.bestleisure.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "categories")

public class Category {
    @Id
    @Column(name = "id", updatable = false)
    @SequenceGenerator(name = "category_sequence", sequenceName = "categories_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "category")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<SubCategory> subCategories = new HashSet<>();

    @JsonBackReference
    @OneToMany(mappedBy = "category")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Post> posts;

    public Category() {
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public Set<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(Set<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
