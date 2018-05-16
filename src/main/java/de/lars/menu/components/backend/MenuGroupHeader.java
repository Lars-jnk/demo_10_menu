/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.components.backend;

import com.vaadin.flow.component.HasClickListeners;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 *
 * @author syrinx
 */
public class MenuGroupHeader extends VerticalLayout implements HasSize, HasClickListeners<VerticalLayout> {

    private boolean open = false;
    private MenuGroupHeaderText lblText;

    public MenuGroupHeader(String title, MenuGroup menuGroup) {
        setClassName("be-menu-group-btn");
        setSpacing(false);

        add(new MenuGroupHeaderTitle(title));
        lblText = new MenuGroupHeaderText();
        add(lblText);

        addClickListener(e -> {
            if (open) {
                lblText.hideText(false);
                changeBackgroundColor(false);
                menuGroup.hideLinks(true);
                open = false;
            } else {
                lblText.hideText(true);
                changeBackgroundColor(true);
                menuGroup.hideLinks(false);
                open = true;
            }
        });
    }

    public void addText(String title) {
        lblText.addText(title);
    }

    private void changeBackgroundColor(boolean b) {
        setClassName("be-menu-group-btn-color", b);
    }
}
