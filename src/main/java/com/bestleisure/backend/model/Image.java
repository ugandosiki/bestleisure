package com.bestleisure.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "images")
public class Image {
    @Id
    @Column(name = "id", updatable = false)
    @SequenceGenerator(name = "image_sequence", sequenceName = "images_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_sequence")
    private Long id;

    @Column(name = "path", unique = true)
    private String path;

    @JsonBackReference
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private Post post;

    @JsonManagedReference
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "banner")
    private Banner banner;

    public Image() {
    }

    public Image(String path) {
        this.path = path;
    }

    public Image(String path, Post post) {
        this.path = path;
        this.post = post;
    }

    public Image(String path, Banner banner) {
        this.path = path;
        this.banner = banner;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Post getPost() {
        return this.post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Banner getBanner() {
        return this.banner;
    }

    public void setBanner(Banner banner) {
        this.banner = banner;
    }
}
