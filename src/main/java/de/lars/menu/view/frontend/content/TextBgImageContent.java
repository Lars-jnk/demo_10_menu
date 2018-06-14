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

    private final VerticalLayout textContent;
    private final Label lblHeadline;
    private final Label lblText;

    public TextBgImageContent(String imageUrl) {
        getStyle().set("background-image", "url(" + imageUrl + ")");
        setClassName("fe-main-image-background");

        textContent = new VerticalLayout();
        textContent.setClassName("fe-main-image-text-content");

        lblHeadline = new Label("hallo");
        lblHeadline.setClassName("fe-main-image-headline");
        textContent.add(lblHeadline);

        lblText = new Label("das ist längerer text");
        lblText.setClassName("fe-main-image-text");
        textContent.add(lblText);

        add(textContent);
    }

    public void setHeadline(String headline) {
        lblHeadline.setText(headline);
    }

    public void setText(String text) {
        lblText.setText(text);
    }
}
