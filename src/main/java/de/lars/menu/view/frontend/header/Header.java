/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.frontend.header;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

/**
 *
 * @author syrinx
 */
public class Header extends HorizontalLayout {

    public Header() {
        setClassName("fe-header");

        HeaderButton btn = new HeaderButton("test");
        btn.addClickListener(e -> {
            Notification.show("hallo :D", 0, Notification.Position.TOP_START);
        });
        add(btn);

        btn = new HeaderButton("Backend");
        btn.addClickListener(e -> {
            getUI().ifPresent(ui -> ui.navigate("backend"));
        });
        add(btn);
    }
}
