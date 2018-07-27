/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.demo;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.lars.menu.component.container.ComboBoxWithView;
import de.lars.menu.view.backend.BackendView;

/**
 *
 * @author Tobias
 */
@Route(value = "backend/mycombobox", layout = BackendView.class)
@PageTitle("My-Combobox-Demo")
public class MyComboBoxView extends VerticalLayout {

    public MyComboBoxView() {
        ComboBoxWithView comboBoxWithView = new ComboBoxWithView("Type:");

        Div page1 = new Div();
        page1.setText("Page#1");
        comboBoxWithView.add("Eins", page1);

        Div page2 = new Div();
        page2.setText("Page#2");
        comboBoxWithView.add("Zwei", page2);

        Div page3 = new Div();
        page3.setText("Page#3");
        comboBoxWithView.add("Drei", page3);

        add(comboBoxWithView);
    }
}
