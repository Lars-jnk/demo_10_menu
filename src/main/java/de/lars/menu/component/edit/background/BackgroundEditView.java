/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.component.edit.background;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import de.lars.menu.component.container.ComboBoxWithView;

/**
 *
 * @author Tobias
 */
public class BackgroundEditView extends VerticalLayout {

    private ComboBoxWithView comboBoxWithView;

    public BackgroundEditView() {
        comboBoxWithView = new ComboBoxWithView("Type:");
        BackgroundImageEditView b = new BackgroundImageEditView();
        b.setImage("100_3183.JPG");
        comboBoxWithView.add("Bild", b);

        add(comboBoxWithView);
    }
}
