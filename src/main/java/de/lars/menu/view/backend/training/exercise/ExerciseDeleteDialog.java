/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.training.exercise;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import de.lars.menu.entity.training.Exercise;
import de.lars.menu.view.backend.component.dialog.DeleteDialog;

/**
 *
 * @author Lars
 */
public class ExerciseDeleteDialog extends DeleteDialog {

    private Exercise exercise;

    public ExerciseDeleteDialog(Exercise exercise, ComponentEventListener<OpenedChangeEvent<Dialog>> listener) {
        super();
        this.exercise = exercise;

        FormLayout layout = new FormLayout();

        TextField tfName = new TextField();
        tfName.setValue(exercise.getName());
        tfName.setEnabled(false);
        tfName.setWidth("100%");
        layout.addFormItem(tfName, "Name");

        TextArea tfDescription = new TextArea();
        tfDescription.setValue(exercise.getDescription());
        tfDescription.setEnabled(false);
        tfDescription.setWidth("100%");
        layout.addFormItem(tfDescription, "Beschreibung");

        layout.setResponsiveSteps(new ResponsiveStep("0", 1));

        setContent(layout);

        open();
        addOpenedChangeListener(listener);
    }

    public Exercise getEntity() {
        return exercise;
    }
}
