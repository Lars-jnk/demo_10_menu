/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.article.component.part.layout;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import de.lars.menu.entity.article.ArticlePart;
import de.lars.menu.entity.article.ArticlePartLinklist;
import de.lars.menu.view.backend.article.component.part.ArticlePartEditLayout;

/**
 *
 * @author syrinx
 */
public class ArticlePartLinksEditLayout extends ArticlePartEditLayout {

    @Override
    protected void initContent(VerticalLayout layout) {
        layout.add(new Label("test"), new TextField());
    }

    @Override
    protected ArticlePart getEntity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void setEntity(ArticlePart entity) {
        if (entity instanceof ArticlePartLinklist) {
            ArticlePartLinklist entityLinks = (ArticlePartLinklist) entity;
        } else {
            throw new IllegalArgumentException(ArticlePartLinklist.class.getName() + " expected; instead " + entity.getClass().getName());
        }
    }
}
