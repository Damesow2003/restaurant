package com.api.restaurant.modele;




import jakarta.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

@Table(name="commentaire_diner")
@DynamicUpdate
@Entity
public class CommentDiner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="diner_id")
    private int dinerId;
    private String commentaire;
    @Column(name="created_date")
    private String createdDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDinerId() {
        return dinerId;
    }

    public void setDinerId(int dinerId) {
        this.dinerId = dinerId;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
