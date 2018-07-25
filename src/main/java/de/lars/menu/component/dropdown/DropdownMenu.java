/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.component.dropdown;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

/**
 *
 * @author Tobias
 */
@StyleSheet("styles/components/dropdown.css")
public class DropdownMenu extends HorizontalLayout {

    public DropdownMenu(String title) {
        setClassName("component-dropdown");

        Label lblTitle = new Label(title);
        lblTitle.setClassName("component-dropdown-title");
        add(lblTitle);

        Icon icon = new Icon(VaadinIcon.ANGLE_DOWN);
        icon = new Icon(VaadinIcon.CHEVRON_DOWN_SMALL);
        add(icon);
    }
}
