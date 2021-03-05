package com.bestleisure.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@JsonIgnoreProperties
@Entity
@Table(name = "images")
public class Image {
    @Id
    @Column(name = "id", updatable = false)
    @SequenceGenerator(name = "image_sequence", sequenceName = "images_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_sequence")
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "path", unique = true)
    private String path;

    @JsonManagedReference
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private Post post_id;

    @JsonManagedReference
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "banner_id")
    private Banner banner_id;

    public Image() {
    }

    public Image(Long id, String path, Post post_id, Banner banner_id, String name) {
        this.id = id;
        this.path = path;
        this.post_id = post_id;
        this.banner_id = banner_id;
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(final String path) {
        this.path = path;
    }

    public Post getPost_id() {
        return this.post_id;
    }

    public void setPost_id(final Post post_id) {
        this.post_id = post_id;
    }

    public Banner getBanner_id() {
        return this.banner_id;
    }

    public void setBanner_id(final Banner banner_id) {
        this.banner_id = banner_id;
    }
}
