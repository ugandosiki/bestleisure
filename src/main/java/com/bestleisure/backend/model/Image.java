package com.bestleisure.backend.model;

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

    @JsonManagedReference
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private Post post_id;

    @JsonManagedReference
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "banner_id")
    private Banner banner_id;

    public Image() {
    }

    public Image(String path) {
        this.path = path;
    }

    public Image(String path, Post post_id) {
        this.path = path;
        this.post_id = post_id;
    }

    public Image(String path, Banner banner_id) {
        this.path = path;
        this.banner_id = banner_id;
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

    public Post getPost_id() {
        return this.post_id;
    }

    public void setPost_id(Post post_id) {
        this.post_id = post_id;
    }

    public Banner getBanner_id() {
        return this.banner_id;
    }

    public void setBanner_id(Banner banner_id) {
        this.banner_id = banner_id;
    }
}
