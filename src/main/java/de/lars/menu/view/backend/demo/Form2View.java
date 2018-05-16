/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.demo;

import de.lars.menu.view.backend.BackendView;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

/**
 *
 * @author syrinx
 */
@Route(value = "form2", layout = BackendView.class)
public class Form2View extends FormLayout {

    public Form2View() {
        TextField firstName = new TextField();
        firstName.setPlaceholder("John");
        addFormItem(firstName, "First name");

        TextField lastName = new TextField();
        lastName.setPlaceholder("Doe");
        addFormItem(lastName, "Last name");

        setResponsiveSteps(new ResponsiveStep("0", 1));
    }
}
