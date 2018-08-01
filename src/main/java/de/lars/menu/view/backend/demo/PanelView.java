/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.demo;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.lars.menu.view.backend.BackendView;

/**
 *
 * @author Lars
 */
@Route(value = "backend/panel", layout = BackendView.class)
@PageTitle("My-Panel-Test")
public class PanelView extends VerticalLayout {

    public PanelView() {
        VerticalLayout panel = new VerticalLayout();
        panel.getStyle().set("overflow", "auto");
        panel.getStyle().set("border", "1px solid");
        panel.setWidth("300px");
        panel.setHeight("200px");
        add(panel);

        VerticalLayout layout = new VerticalLayout();
        layout.getStyle().set("display", "block");
        layout.setSizeUndefined();
        layout.add(new TextField("eins"));
        layout.add(new TextField("zwei"));
        layout.add(new TextField("drei"));

        panel.add(layout);
    }
}
