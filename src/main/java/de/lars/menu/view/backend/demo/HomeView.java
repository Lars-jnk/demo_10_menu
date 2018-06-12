/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.demo;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import de.lars.menu.view.backend.BackendView;

/**
 *
 * @author syrinx
 */
@Route(value = "backend/home", layout = BackendView.class)
public class HomeView extends VerticalLayout {

    public HomeView() {
        add(new Label("home view"));
    }
}
