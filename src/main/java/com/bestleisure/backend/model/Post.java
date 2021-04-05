package com.bestleisure.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @SequenceGenerator(name = "post_sequence", sequenceName = "posts_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_sequence")
    private Long id;

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @JsonManagedReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id")
    private Category category;

    @JsonManagedReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "type_id")
    private Type type;

    @JsonManagedReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonManagedReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "subcategory_id")
    private SubCategory subCategory;

    @JsonManagedReference
    @OneToMany(mappedBy = "post")
    private List<Banner> banners = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "post")
    private List<Image> images = new ArrayList<>();

    @Column(name = "address", unique = true, nullable = false)
    private String address;

    @JsonManagedReference
    @ManyToMany(mappedBy = "likedPosts")
    Set<User> userLikes = new HashSet<>();

    public Post() {
    }

    public Post(Long id, String title, String description, Category category, SubCategory subCategory, User user, String address) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.subCategory = subCategory;
        this.user = user;
        this.address = address;
    }

    public Set<User> getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(User user) {
        this.userLikes.add(user);
    }

    public List<Banner> getBanners() {
        return banners;
    }

    public void setBanners(List<Banner> banners) {
        this.banners = banners;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user_id) {
        this.user = user_id;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}

