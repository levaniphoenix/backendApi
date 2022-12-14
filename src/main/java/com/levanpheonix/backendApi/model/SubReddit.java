package com.levanpheonix.backendApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class SubReddit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition="TEXT")
    private String Description;

    private Date createdAt;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id")
    private User subRedditOwner;

    @JsonIgnore
    @OneToMany(mappedBy = "subReddit", cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private List<Post> posts;

    public SubReddit(String name, String description, Date createdAt, User subRedditOwner) {
        this.name = name;
        Description = description;
        this.createdAt = createdAt;
        this.subRedditOwner = subRedditOwner;
    }
    public SubReddit(){}

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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public User getSubRedditOwner() {
        return subRedditOwner;
    }

    public void setSubRedditOwner(User subRedditOwner) {
        this.subRedditOwner = subRedditOwner;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
