/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.article.component.part.button;

import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcons;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 *
 * @author syrinx
 */
public class ArticlePartToolButtonList extends VerticalLayout implements HasSize {

    private boolean stateHidden = true;
    private VerticalLayout createButtons;
    private ArticlePartToolButton addBtn;

    public ArticlePartToolButtonList() {
        setClassName("be-article-mod-btns");

        addBtn = new ArticlePartToolButton();
        addBtn.addClickListener(e -> changeState());
        add(addBtn);

        createButtons = new VerticalLayout();
        createButtons.setClassName("be-article-mod-create-btns");
        hideCreateButtons();

        add(createButtons);
    }

    public void addArticlePart(ArticlePartToolButton btn) {
        createButtons.add(btn);
    }

    private void changeStyle() {
        createButtons.setClassName("be-article-mod-create-btns-hide", stateHidden);
        if (stateHidden) {
            addBtn.setIcon(VaadinIcons.PLUS.create());
        } else {
            addBtn.setIcon(VaadinIcons.MINUS.create());
        }
    }

    public void hideCreateButtons() {
        stateHidden = true;
        changeStyle();
    }

    private void changeState() {
        stateHidden = !stateHidden;
        changeStyle();
    }
}
