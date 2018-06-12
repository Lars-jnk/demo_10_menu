/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.frontend.header;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 *
 * @author syrinx
 */
public class Header extends VerticalLayout {

    public Header() {
        add(new Label("juhu"));
        setClassName("fe-header");
    }
}
