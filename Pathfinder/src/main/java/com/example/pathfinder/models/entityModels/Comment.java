package com.example.pathfinder.models.entityModels;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean approved;
    private LocalDateTime created;

    @Column(columnDefinition = "TEXT")
    private String textContent;

    @ManyToOne
    private User author;

    @ManyToOne
    private Route route;

    public Long getId() {
        return id;
    }

    public Comment setId(Long id) {
        this.id = id;
        return this;
    }

    public boolean isApproved() {
        return approved;
    }

    public Comment setApproved(boolean approved) {
        this.approved = approved;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public Comment setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public String getTextContent() {
        return textContent;
    }

    public Comment setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Comment setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Route getRoute() {
        return route;
    }

    public Comment setRoute(Route route) {
        this.route = route;
        return this;
    }
}
