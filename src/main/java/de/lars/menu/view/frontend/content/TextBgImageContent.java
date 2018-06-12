/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.frontend.content;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 *
 * @author syrinx
 */
public class TextBgImageContent extends VerticalLayout {

    private final Label lblHeadline;
    private final Label lblText;

    public TextBgImageContent(String imageUrl) {
        getStyle().set("background-image", "url(" + imageUrl + ")");
        setClassName("fe-main-image-background");

        lblHeadline = new Label("hallo");
        lblHeadline.setClassName("fe-main-image-headline");
        add(lblHeadline);

        lblText = new Label("das ist längerer text");
        lblText.setClassName("fe-main-image-text");
        add(lblText);
    }

    public void setHeadline(String headline) {
        lblHeadline.setText(headline);
    }

    public void setText(String text) {
        lblText.setText(text);
    }
}
