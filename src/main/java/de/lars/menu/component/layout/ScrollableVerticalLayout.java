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
public class ScrollableVerticalLayout extends VerticalLayout {

    private VerticalLayout innerLayout;

    public ScrollableVerticalLayout() {
        setPadding(false);
        setMargin(false);
        setSpacing(false);
        getStyle().set("overflow-y", "auto");
        getStyle().set("margin-top", "0px");

        innerLayout = new VerticalLayout();
        innerLayout.setPadding(false);
        innerLayout.setMargin(false);
        innerLayout.setSpacing(false);
        innerLayout.getStyle().set("display", "block");

        super.add(innerLayout);
    }

    @Override
    public void add(Component... components) {
        innerLayout.add(components);
    }

    @Override
    public void remove(Component... components) {
        innerLayout.remove(components);
    }
}
