/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.training.exercise;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.dialog.Dialog;
import de.lars.menu.entity.training.Exercise;

/**
 *
 * @author Lars
 */
public class ExerciseCreateDialog extends ExerciseModifitationDialog {

    public ExerciseCreateDialog(ComponentEventListener<OpenedChangeEvent<Dialog>> listener) {
        super(new Exercise());

        open();
        addOpenedChangeListener(listener);
    }
}
