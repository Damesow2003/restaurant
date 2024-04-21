package com.api.restaurant.modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Table(name="diner")
@Entity
public class Diner{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Integer id;
    private String titre;
    private String description;
    @Column(name="image_url")
    private String imageUrl;
    private int score;
    private String position;
    @Column(name="created_date")
    private Date createdDate;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name="diner_id")
    private List<CommentDiner> comments = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<CommentDiner> getComments() {
        return comments;
    }

    public void setComments(List<CommentDiner> comments) {
        this.comments = comments;
    }
}
