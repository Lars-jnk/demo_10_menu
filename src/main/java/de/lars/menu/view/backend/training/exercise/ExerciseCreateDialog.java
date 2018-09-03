/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.training.exercise;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.wcs.vaadin.flow.cdi.UIScoped;
import de.lars.menu.entity.facade.ExerciseFacade;
import de.lars.menu.entity.training.Exercise;
import javax.inject.Inject;

/**
 *
 * @author Lars
 */
@UIScoped
public class ExerciseCreateDialog extends Dialog {

    @Inject
    private ExerciseFacade facade;

    private boolean created = false;
    private Exercise exercise = null;

    public ExerciseCreateDialog() {
        TextField tfName = new TextField("Name", "Name eintragen ...");
        TextArea tfDescription = new TextArea("Beschreibung", "Beschreibung eintragen ...");

        Button confirmButton = new Button("Confirm", event -> {
            exercise = new Exercise();
            exercise.setName(tfName.getValue());
            exercise.setDescription(tfDescription.getValue());
            created = true;
            facade.create(exercise);
            close();
        });
        Button cancelButton = new Button("Cancel", event -> {
            close();
        });

        add(new VerticalLayout(tfName, tfDescription, new HorizontalLayout(confirmButton, cancelButton)));
        setHeight("400");
        setWidth("500");
    }

    public boolean isCreated() {
        return created;
    }

    public Exercise getExercise() {
        return exercise;
    }

}
