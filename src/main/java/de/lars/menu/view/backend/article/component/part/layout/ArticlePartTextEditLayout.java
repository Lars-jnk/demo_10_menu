/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.article.component.part.layout;

import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import de.lars.menu.entity.article.ArticlePart;
import de.lars.menu.entity.article.ArticlePartText;
import de.lars.menu.view.backend.article.component.part.ArticlePartEditLayout;

/**
 *
 * @author syrinx
 */
public class ArticlePartTextEditLayout extends ArticlePartEditLayout {

    private ArticlePartText entityText;

    private TextField headline = null;
    private TextArea text = null;

    public ArticlePartTextEditLayout() {
        super();

        headline = new TextField("Überschrift");
        headline.setWidth("100%");
        text = new TextArea("Text");
        text.setWidth("100%");
        text.setHeight("200px");
    }

    @Override
    protected void initContentRetracted() {
        lblHeader.setText(headline.getValue() + " - " + text.getValue());
        contentLayout.removeAll();
    }

    @Override
    protected void initContentFull() {
        lblHeader.setText("");
        contentLayout.add(headline, text);
    }

    @Override
    protected ArticlePart getEntity() {
        if (entityText == null) {
            entityText = new ArticlePartText();
        }
        entityText.setHeadline(headline.getValue());
        entityText.setText(text.getValue());
        return entityText;
    }

    @Override
    protected void setEntity(ArticlePart entity) {
        if (entity instanceof ArticlePartText) {
            entityText = (ArticlePartText) entity;
            headline.setValue(entityText.getHeadline());
            text.setValue(entityText.getText());
        } else {
            throw new IllegalArgumentException(ArticlePartText.class.getName() + " expected; instead " + entity.getClass().getName());
        }
    }
}
