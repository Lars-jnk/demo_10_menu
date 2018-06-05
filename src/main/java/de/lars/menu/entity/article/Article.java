/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.entity.article;

import de.lars.menu.enums.ArticleStatus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author syrinx
 */
@Entity
@Table(name = "article")
public class Article implements Serializable {

    public static int HEADLINE_MIN_LEN = 5;
    public static int HEADLINE_MAX_LEN = 128;

    public static int PATH_MIN_LEN = 5;
    public static int PATH_MAX_LEN = 64;
    public static String PATH_PATTERN = "^[a-z0-9]{1,}(-[a-z0-9]{1,})*$";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Size(max = 64)
    @Column(name = "path")
    private String path;

    @Size(max = 128)
    @Column(name = "headline")
    private String headline;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ArticleStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    private Date created;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "article_id")
    @OrderBy("position ASC")
    private List<ArticlePart> parts = new ArrayList<>();

    public Article() {
    }

    public Article(String path, String headline) {
        this.path = path;
        this.headline = headline;
        this.status = ArticleStatus.NOT_RELEASED;
        this.created = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public ArticleStatus getStatus() {
        return status;
    }

    public void setStatus(ArticleStatus status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<ArticlePart> getParts() {
        return parts;
    }

    public void addPart(ArticlePart part) {
        this.parts.add(part);
    }

    public void setParts(List<ArticlePart> parts) {
        this.parts = parts;
    }

}
