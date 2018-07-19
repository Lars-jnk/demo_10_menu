/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.frontend.content;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 *
 * @author Tobias
 */
public class ContentContainerFullView extends VerticalLayout {

    private Component background = null;

    public ContentContainerFullView() {
        setClassName("fullview");
    }

    public void setBackground(Component component) {
        if (background != null) {
            remove(background);
        }
        background = component;
        add(background);
    }
}
