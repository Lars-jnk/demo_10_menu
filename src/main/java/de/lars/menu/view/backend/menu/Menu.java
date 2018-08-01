/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.menu;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.StyleSheet;
import de.lars.menu.component.layout.ScrollableVerticalLayout;

/**
 *
 * @author reuss
 */
@StyleSheet("styles/backend/menu-styles.css")
public class Menu extends ScrollableVerticalLayout {

    public Menu(String headline) {
        setPadding(false);
        setSpacing(false);
        setSizeUndefined();
        setClassName("be-menu");

        MenuHeadlineLayout headlineLayout = new MenuHeadlineLayout();
        headlineLayout.add(new MenuHeadline(headline));

        super.add(headlineLayout);
    }

    @Override
    public void add(Component... components) {
        throw new IllegalArgumentException("use add(MenuGroup menuGroup);");
    }

    public void add(MenuGroup menuGroup) {
        super.add(menuGroup);
    }
}
