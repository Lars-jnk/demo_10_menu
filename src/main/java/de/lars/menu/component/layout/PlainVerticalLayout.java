/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.component.layout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 *
 * @author Lars
 */
public class PlainVerticalLayout extends VerticalLayout {

    public PlainVerticalLayout() {
        super();
        setMargin(false);
        setSpacing(false);
        setPadding(false);
    }

    public PlainVerticalLayout(Component[] children) {
        this();
        add(children);
    }
}
