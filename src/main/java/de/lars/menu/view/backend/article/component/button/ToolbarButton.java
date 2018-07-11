/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.article.component.button;

import com.vaadin.flow.component.ClickNotifier;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 *
 * @author syrinx
 */
public class ToolbarButton extends VerticalLayout implements HasSize, ClickNotifier<VerticalLayout> {

    public ToolbarButton(Component component) {
        add(component);
        setClassName("be-article-part-toolbar-btn");
    }
}
