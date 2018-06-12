/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.frontend.header;

import com.vaadin.flow.component.HasClickListeners;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 *
 * @author syrinx
 */
public class HeaderButton extends VerticalLayout implements HasSize, HasClickListeners<VerticalLayout> {

    public HeaderButton() {
        setClassName("fe-header-btn");
        setAlignItems(FlexComponent.Alignment.CENTER);
        setSpacing(false);
    }

    public HeaderButton(String text) {
        this();
        Label lbl = new Label(text);
        lbl.addClassName("fe-header-btn-txt");
        add(lbl);
    }
}
