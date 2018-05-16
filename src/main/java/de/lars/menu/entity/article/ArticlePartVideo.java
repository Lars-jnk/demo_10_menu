/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.entity.article;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author syrinx
 */
@Entity(name = "ArticlePartVideo")
@Table(name = "article_part_video")
public class ArticlePartVideo extends ArticlePart {

    @Column(name = "title", length = 1024)
    private String title;

    @Column(name = "title_show", length = 1024)
    private String titleShow;

    @Column(name = "length")
    private int length;
}
