/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.article.component.button;

import com.vaadin.flow.component.HasClickListeners;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 *
 * @author syrinx
 */
public class BigButton extends VerticalLayout implements HasSize, HasClickListeners<VerticalLayout> {

    public BigButton() {
        setClassName("be-article-mod-btn");
        setAlignItems(Alignment.CENTER);
        setSpacing(false);
    }

    public BigButton(String text) {
        this();
        add(new Label(text));
    }

    public BigButton(Icon icon) {
        this();
        setIcon(icon);
    }

    public void setIcon(Icon icon) {
        removeAll();
        add(icon);
    }
}
