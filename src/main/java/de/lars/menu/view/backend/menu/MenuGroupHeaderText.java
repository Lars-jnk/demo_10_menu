/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.menu;

import com.vaadin.flow.component.html.Label;

/**
 *
 * @author reuss
 */
public class MenuGroupHeaderText extends Label {

    public MenuGroupHeaderText() {
        setClassName("be-menu-group-btn-text");
    }

    public void addText(String text) {
        if ("".equals(getText())) {
            setText(text);
        } else {
            setText(getText() + ", " + text);
        }
    }

    public void hideText(boolean b) {
        setClassName("be-menu-group-btn-text-hide", b);
    }
}
