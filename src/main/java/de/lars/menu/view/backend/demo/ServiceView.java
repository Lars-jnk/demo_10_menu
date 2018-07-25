/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.lars.menu.service.NameGenService;
import de.lars.menu.service.Service;
import de.lars.menu.service.SessionService;
import de.lars.menu.view.backend.BackendView;
import javax.inject.Inject;

/**
 *
 * @author syrinx
 */
@Route(value = "backend/service", layout = BackendView.class)
@PageTitle("DemoService")
public class ServiceView extends VerticalLayout implements BeforeEnterObserver {

    public static String ID_LABEL = "demo_label";
    public static String ID_TEXTFIELD = "demo_textfield";
    public static String ID_BUTTON = "demo_button";

    @Inject
    private Service service;

    @Inject
    private NameGenService nameGenService;

    @Inject
    private SessionService sessionService;

    public ServiceView() {
        Label label = new Label("empty");
        label.setId(ID_LABEL);
        TextField tf = new TextField("Text eingeben");
        //tf.setValue("tester");
        tf.setId(ID_TEXTFIELD);
        Button button = new Button("Click me",
                event -> label.setText(service.get(tf.getValue())));
        button.setId(ID_BUTTON);

        add(tf, button, label);

        TextField suffix = new TextField("Suffix");
        Label generatedName = new Label();
        Button gen = new Button("Gen Name",
                event -> generatedName.setText(nameGenService.generate(suffix.getValue()))
        );
        add(suffix, gen, generatedName);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent bee) {
        sessionService.hello();
    }
}
