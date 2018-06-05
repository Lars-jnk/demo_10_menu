/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.menu;

import com.vaadin.flow.component.html.Label;

/**
 *
 * @author syrinx
 */
public class MenuHeadline extends Label {

    public MenuHeadline(String title) {
        super(title);
        setClassName("be-menu-headline");
    }
}
