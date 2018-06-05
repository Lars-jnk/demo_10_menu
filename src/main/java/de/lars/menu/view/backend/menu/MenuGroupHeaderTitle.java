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
public class MenuGroupHeaderTitle extends Label {

    public static String ID = "be_menu_group_btn_title";
    public static String CLASS_NAME = ID.replace("_", "-");

    public MenuGroupHeaderTitle(String title) {
        super(title);
        setId(ID + "_" + title);
        setClassName(CLASS_NAME);
    }
}
