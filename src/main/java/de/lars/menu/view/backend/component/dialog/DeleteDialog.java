/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.component.dialog;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import de.lars.menu.component.layout.PlainVerticalLayout;

/**
 *
 * @author Lars
 */
public abstract class DeleteDialog extends Dialog {

    private PlainVerticalLayout content;
    private boolean deleted = false;

    public DeleteDialog() {
        content = new PlainVerticalLayout();

        Button confirmButton = new Button("Ja", event -> {
            deleted = true;
            close();
        });
        Button cancelButton = new Button("Nein", event -> {
            close();
        });
        add(new VerticalLayout(content, new HorizontalLayout(confirmButton, cancelButton)));
    }

    protected void setContent(FormLayout layout) {
        content.add(layout);
    }

    public boolean isDeleted() {
        return deleted;
    }
}
