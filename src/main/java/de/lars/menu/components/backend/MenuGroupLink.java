/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.components.backend;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.router.RouterLink;

/**
 *
 * @author syrinx
 */
public class MenuGroupLink extends RouterLink {

    public MenuGroupLink(String title, Class<? extends Component> aClass) {
        super(title, aClass);
        setClassName("be-menu-link");
    }
}
