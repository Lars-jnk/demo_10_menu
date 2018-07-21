/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.component.tabs;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Tobias
 */
@StyleSheet("styles/components/tabs.css")
public class ContentTabs extends VerticalLayout {

    private Map<Tab, Component> tabsToPages;
    private Tabs tabs;
    private Div pages;
    private Set<Component> pagesShown;

    public ContentTabs() {
        setSpacing(false);
        setMargin(false);
        setPadding(false);
        setWidth("100%");
        setClassName("component-tabs");

        tabsToPages = new HashMap<>();
        tabs = new Tabs();
        tabs.setWidth("100%");
        pages = new Div();
        pages.setWidth("100%");

        tabs.addSelectedChangeListener(event -> {
            pagesShown.forEach(page -> page.setVisible(false));
            pagesShown.clear();
            Component selectedPage = tabsToPages.get(tabs.getSelectedTab());
            selectedPage.setVisible(true);
            pagesShown.add(selectedPage);
        });

        super.add(tabs);
        super.add(pages);
    }

    public void add(String name, Component page) {
        if (tabsToPages.isEmpty()) {
            page.setVisible(true);
            pagesShown = Stream.of(page).collect(Collectors.toSet());
        } else {
            page.setVisible(false);
        }
        Tab tab = new Tab(name);
        tabsToPages.put(tab, page);
        tabs.add(tab);
        pages.add(page);
    }

    @Override
    public void add(Component... components) {
        throw new IllegalArgumentException("use add(String name, Component component)");
    }
}
