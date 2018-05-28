/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.article.component.part.layout;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
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

    private TextField headline;
    private TextArea text;

    @Override
    protected void initContent(VerticalLayout layout) {

        headline = new TextField("Überschrift");
        headline.setWidth("100%");
        text = new TextArea("Text");
        text.setWidth("100%");
        text.setHeight("200px");

        add(headline, text);
    }

    @Override
    protected ArticlePart getEntity() {
        ArticlePartText entity = new ArticlePartText();
        entity.setHeadline(headline.getValue());
        entity.setText(text.getValue());
        return entity;
    }

    @Override
    protected void setEntity(ArticlePart entity) {
        if (entity instanceof ArticlePartText) {
            ArticlePartText entityText = (ArticlePartText) entity;
            headline.setValue(entityText.getHeadline());
            text.setValue(entityText.getText());
        } else {
            throw new IllegalArgumentException(ArticlePartText.class.getName() + " expected; instead " + entity.getClass().getName());
        }
    }
}
