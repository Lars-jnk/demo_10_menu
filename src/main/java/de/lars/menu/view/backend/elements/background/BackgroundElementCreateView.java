/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.elements.background;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import de.lars.menu.view.backend.BackendView;

/**
 *
 * @author Tobias
 */
@Route(value = BackgroundElementCreateView.ROUTE, layout = BackendView.class)
public class BackgroundElementCreateView extends VerticalLayout {

    public static final String ROUTE = BackgroundElementListView.ROUTE + "/create";

}
