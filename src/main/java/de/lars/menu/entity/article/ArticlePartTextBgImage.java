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
@Entity(name = "ArticlePartTextBgImage")
@Table(name = "article_part_text_bg_image")
public class ArticlePartTextBgImage extends ArticlePart {

    @Column(name = "text", columnDefinition = "TEXT")
    private String text;

    @Column(name = "filename_extern", length = 512)
    private String filenameExtern;

    @Column(name = "filename_intern", length = 512)
    private String filenameIntern;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFilenameExtern() {
        return filenameExtern;
    }

    public void setFilenameExtern(String filenameExtern) {
        this.filenameExtern = filenameExtern;
    }

    public String getFilenameIntern() {
        return filenameIntern;
    }

    public void setFilenameIntern(String filenameIntern) {
        this.filenameIntern = filenameIntern;
    }
}
