/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.demo;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.lars.menu.view.backend.BackendView;
import de.lars.menu.view.component.tabs.ContentTabs;

/**
 *
 * @author Tobias
 */
@Route(value = "backend/mytabs", layout = BackendView.class)
@PageTitle("My-Tab-Demo")
public class MyTabView extends VerticalLayout {

    public MyTabView() {
        ContentTabs tabs = new ContentTabs();

        Div page1 = new Div();
        page1.setText("Page#1");
        tabs.add("My Tab 1", page1);

        Div page2 = new Div();
        page2.setText("Page#2");
        tabs.add("My Tab 2", page2);

        Div page3 = new Div();
        page3.setText("Page#3");
        tabs.add("My Tab 3", page3);

        add(tabs);
    }
}
