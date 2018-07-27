/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.component.container;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Tobias
 */
public class ComboBoxReplaceView extends VerticalLayout {

    private Map<String, Component> nameToView;
    private List<String> names;
    private ComboBox<String> comboBox;

    public ComboBoxReplaceView(String label) {
        setSpacing(false);
        setMargin(false);
        setPadding(false);
        setWidth("100%");

        nameToView = new HashMap<>();
        comboBox = new ComboBox<>(label);
        names = new ArrayList<>();

        comboBox.addValueChangeListener(event -> {
            if (event.getSource().isEmpty() == false) {
                Component selectedPage = nameToView.get(event.getValue());
                remove(comboBox);
                super.add(selectedPage);
            }
        });

        super.add(comboBox);
    }

    public void add(String name, Component view) {
        nameToView.put(name, view);
        names.add(name);
        comboBox.setItems(names);
    }

    @Override
    public void add(Component... components) {
        throw new IllegalArgumentException("use add(String, Component component)");
    }
}
