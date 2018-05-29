/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.components.backend.menu;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 *
 * @author syrinx
 */
public class MenuGroup extends VerticalLayout {

    private MenuGroupLinks groupLinks;
    private MenuGroupHeader header;

    public MenuGroup(String title) {
        setClassName("be-menu-group");
        setPadding(false);
        setSpacing(false);
        setMargin(false);

        header = new MenuGroupHeader(title, this);
        add(header);

        groupLinks = new MenuGroupLinks();
        add(groupLinks);
    }

    public void addLink(String title, Class<? extends Component> aClass) {
        groupLinks.add(new MenuGroupLink(title, aClass));
        header.addText(title);
    }

    public void hideLinks(boolean b) {
        groupLinks.hideLinks(b);
    }
}
