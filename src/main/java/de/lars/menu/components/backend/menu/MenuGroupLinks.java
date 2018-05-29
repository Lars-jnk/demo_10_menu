/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.components.backend.menu;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 *
 * @author reuss
 */
public class MenuGroupLinks extends VerticalLayout {

    public MenuGroupLinks() {
        setClassName("be-menu-group-links");
        setMargin(false);
        setPadding(false);
        setSpacing(false);

        hideLinks(true);
    }

    public void hideLinks(boolean hide) {
        setClassName("be-menu-group-links-hide", hide);
    }
}
