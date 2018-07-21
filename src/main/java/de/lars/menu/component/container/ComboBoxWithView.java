/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.component.container;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Tobias
 */
public class ComboBoxWithView extends VerticalLayout {

    private Map<String, Component> nameToView;
    private List<String> names;
    private Div views;
    private Set<Component> viewShown;
    private ComboBox<String> comboBox;

    public ComboBoxWithView(String label) {
        setSpacing(false);
        setMargin(false);
        setPadding(false);
        setWidth("100%");

        nameToView = new HashMap<>();
        comboBox = new ComboBox<>(label);
        names = new ArrayList<>();
        views = new Div();
        views.setWidth("100%");

        comboBox.setItems("keiner", "Bild", "Video", "Farbe");
        comboBox.setValue("keiner");

        comboBox.addValueChangeListener(event -> {
            if (event.getSource().isEmpty()) {
                viewShown.forEach(page -> page.setVisible(false));
                viewShown.clear();
            } else {
                viewShown.forEach(page -> page.setVisible(false));
                viewShown.clear();
                Component selectedPage = nameToView.get(event.getValue());
                selectedPage.setVisible(true);
                viewShown.add(selectedPage);
            }
        });

        super.add(comboBox);
        super.add(views);
    }

    public void add(String name, Component view) {
        if (nameToView.isEmpty()) {
            view.setVisible(true);
            viewShown = Stream.of(view).collect(Collectors.toSet());
        } else {
            view.setVisible(false);
        }
        nameToView.put(name, view);
        names.add(name);
        views.add(view);
        comboBox.setItems(names);
    }

    @Override
    public void add(Component... components) {
        throw new IllegalArgumentException("use add(String, Component component)");
    }
}
