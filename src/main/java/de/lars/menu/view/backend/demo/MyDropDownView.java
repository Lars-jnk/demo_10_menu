/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.demo;

import com.github.appreciated.dropdown.IronDropdownWrapper;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.lars.menu.component.container.ComboBoxWithView;
import de.lars.menu.component.dropdown.DropdownMenu;
import de.lars.menu.view.backend.BackendView;

/**
 *
 * @author Tobias
 */
@Route(value = "backend/mydropdown", layout = BackendView.class)
@PageTitle("My-DropDown-Demo")
@StyleSheet("styles/components/dropdown.css")
public class MyDropDownView extends VerticalLayout {

    public MyDropDownView() {
        add(new Label("Drop Down"));

        add(createCombobox());

        DropdownMenu ddm = new DropdownMenu("Neu");
        add(ddm);

        add(createDropdown());
    }

    private IronDropdownWrapper createDropdown() {
        VerticalLayout dropedLayout = new VerticalLayout();
        dropedLayout.addClassName("component-dropdown-droped-btns");
        dropedLayout.setPadding(false);
        dropedLayout.setSpacing(false);

        Button btn = new Button("eins", e -> Notification.show("btn eins"));
        btn.setClassName("component-dropdown-droped-btn");
        dropedLayout.add(btn);

        btn = new Button("zwei", e -> Notification.show("btn zwei"));
        btn.setClassName("component-dropdown-droped-btn");
        dropedLayout.add(btn);

        IronDropdownWrapper ironDropdown = new IronDropdownWrapper(new Button("open"), dropedLayout);
        ironDropdown.getContentWrapper().getStyle() // to style the dropdown wrapper
                .set("border-radius", "3px")
                .set("margin", "2px")
                .set("box-shadow", "0px 2px 6px #ccc");
        return ironDropdown;
    }

    private ComboBoxWithView createCombobox() {
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

        return comboBoxWithView;
    }
}
