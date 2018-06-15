/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.article.component.part.layout;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextArea;
import de.lars.menu.entity.article.ArticlePart;
import de.lars.menu.entity.article.ArticlePartTextBgImage;
import de.lars.menu.view.backend.article.component.part.ArticlePartEditLayout;

/**
 *
 * @author syrinx
 */
public class ArticlePartTextBgImageEditLayout extends ArticlePartEditLayout {

    private ArticlePartTextBgImage entityTextBgImage;

    private TextArea text = null;
    private Tab tabText = null;
    private Tab tabImage = null;

    public ArticlePartTextBgImageEditLayout() {
        super();

        text = new TextArea("Text");
        text.setWidth("100%");
        text.setHeight("200px");
    }

    @Override
    protected void initContentRetracted() {
        lblHeader.setText(text.getValue());
        contentLayout.removeAll();
    }

    @Override
    protected void initContentFull() {
        lblHeader.setText("");
        contentLayout.add(new Tabs(getTextTab(), buildImageTab()));
    }

    private Tab getTextTab() {
        if (tabText != null) {
            return tabText;
        }
        tabText = buildTextTab();
        return tabText;
    }

    private Tab buildTextTab() {
        tabText = new Tab("Text");
        //tabText.add(text);
        VerticalLayout layout = new VerticalLayout();
        layout.add(new Label("tester juhu"));
        //tabText.add(layout);
        return tabText;
    }

    private Tab buildImageTab() {
        tabImage = new Tab("Image");
        return tabImage;
    }

    @Override
    protected ArticlePart getEntity() {
        if (entityTextBgImage == null) {
            entityTextBgImage = new ArticlePartTextBgImage();
        }
        entityTextBgImage.setText(text.getValue());
        return entityTextBgImage;
    }

    @Override
    protected void setEntity(ArticlePart entity) {
        if (entity instanceof ArticlePartTextBgImage) {
            entityTextBgImage = (ArticlePartTextBgImage) entity;
            text.setValue(entityTextBgImage.getText());
        } else {
            throw new IllegalArgumentException(ArticlePartTextBgImage.class.getName() + " expected; instead " + entity.getClass().getName());
        }
    }
}
