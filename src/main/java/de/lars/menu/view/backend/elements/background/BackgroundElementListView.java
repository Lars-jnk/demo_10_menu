/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.elements.background;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import de.lars.menu.view.backend.BackendView;

/**
 *
 * @author Tobias
 */
@Route(value = BackgroundElementListView.ROUTE, layout = BackendView.class)
public class BackgroundElementListView extends VerticalLayout {

    public static final String ROUTE = BackendView.ROUTE + "/background";

    public BackgroundElementListView() {
        RouterLink btnCreate = new RouterLink("create", BackgroundElementCreateView.class);
        add(btnCreate);
    }
}
