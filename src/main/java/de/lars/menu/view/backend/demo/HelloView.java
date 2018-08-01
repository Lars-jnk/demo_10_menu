/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.lars.menu.view.backend.BackendView;

/**
 *
 * @author Lars
 */
@Route(value = "backend/hello", layout = BackendView.class)
@PageTitle("Hello")
public class HelloView extends VerticalLayout {

    public HelloView() {
        VerticalLayout vlMain = new VerticalLayout();
        // two components:
        TextField name = new TextField("Name");
        name.setWidth("200px");

        Button greet = new Button("Greet");

        // add them to "this" layout (a VerticalLayout)
        vlMain.add(name, greet);

        // add logic through event listeners
        greet.addClickListener(event
                -> add(new Span("Hello, " + name.getValue())));

        add(vlMain);

    }

}
