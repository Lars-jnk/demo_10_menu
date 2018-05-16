/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.entity.article;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author syrinx
 */
@Entity
@Table(name = "article_part_linklist")
public class ArticlePartLinklist extends ArticlePart {

    @Size(max = 256)
    @Column(name = "headline")
    private String headline;

    @Column(name = "text", columnDefinition = "TEXT")
    private String text;
}
