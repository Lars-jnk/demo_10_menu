/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.training.exercise;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import de.lars.menu.entity.training.Exercise;

/**
 *
 * @author Lars
 */
public abstract class ExerciseModifitationDialog extends Dialog {

    private boolean saved = false;
    protected Exercise exercise = null;
    protected TextField tfName;
    protected TextArea tfDescription;

    public ExerciseModifitationDialog(Exercise exercise) {
        tfName = new TextField("", "Name eintragen ...");
        tfName.setAutofocus(true);
        tfDescription = new TextArea("", "Beschreibung eintragen ...");

        setEntity(exercise);

        FormLayout layout = new FormLayout();
        tfName.setWidth("100%");
        layout.addFormItem(tfName, "Name");

        tfDescription.setWidth("100%");
        layout.addFormItem(tfDescription, "Beschreibung");

        layout.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1));

        Button confirmButton = new Button("Confirm", event -> {
            exercise.setName(tfName.getValue());
            exercise.setDescription(tfDescription.getValue());
            saved = true;
            close();
        });
        Button cancelButton = new Button("Cancel", event -> {
            close();
        });

        Span span = new Span();
        HorizontalLayout btns = new HorizontalLayout(span, confirmButton, cancelButton);
        btns.setWidth("100%");
        btns.expand(span);

        add(new VerticalLayout(layout, btns));
    }

    public boolean isSaved() {
        return saved;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public Exercise getEntity() {
        return exercise;
    }

    public void setEntity(Exercise exercise) {
        this.exercise = exercise;
        if (exercise.getName() != null) {
            tfName.setValue(exercise.getName());
        }
        if (exercise.getDescription() != null) {
            tfDescription.setValue(exercise.getDescription());
        }
    }
}
