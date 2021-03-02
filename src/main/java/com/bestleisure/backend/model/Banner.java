package com.bestleisure.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "banners")
public class Banner {
    @Id
    @Column(name = "id", updatable = false)
    @SequenceGenerator(name = "banner_sequence", sequenceName = "banners_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "banner_sequence")
    private Long id;

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @Column(name = "description", unique = true)
    private String description;

    @Column(name = "img_url", unique = true, nullable = false)
    private String imgUrl;

    @JsonManagedReference
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private Post post;

    public Banner(Long id, String title, String description, String imgUrl, Post post) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imgUrl = imgUrl;
        this.post = post;
    }

    public Banner() {
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
