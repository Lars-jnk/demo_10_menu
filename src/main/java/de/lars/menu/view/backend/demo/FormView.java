/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.demo;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import de.lars.menu.view.backend.BackendView;

/**
 *
 * @author syrinx
 */
@Route(value = "backend/form", layout = BackendView.class)
public class FormView extends FormLayout {

    public FormView() {
        TextField titleField = new TextField();
        titleField.setLabel("Title");
        titleField.setPlaceholder("Sir");
        TextField firstNameField = new TextField();
        firstNameField.setLabel("First name");
        firstNameField.setPlaceholder("John");
        TextField lastNameField = new TextField();
        lastNameField.setLabel("Last name");
        lastNameField.setPlaceholder("Doe");

        add(titleField, firstNameField, lastNameField);

        setResponsiveSteps(
                new ResponsiveStep("0", 1),
                new ResponsiveStep("21em", 2),
                new ResponsiveStep("22em", 3));
    }
}
