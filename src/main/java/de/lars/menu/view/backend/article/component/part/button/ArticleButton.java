/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.article.component.part.button;

import com.vaadin.flow.component.HasClickListeners;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 *
 * @author syrinx
 */
public class ArticleButton extends VerticalLayout implements HasSize, HasClickListeners<VerticalLayout> {

    public ArticleButton() {
        setClassName("be-article-btn");
        setAlignItems(FlexComponent.Alignment.CENTER);
        setSpacing(false);
    }

    public ArticleButton(String text) {
        this();
        Label lbl = new Label(text);
        lbl.addClassName("be-article-btn-lbl");
        add(lbl);
    }

}
