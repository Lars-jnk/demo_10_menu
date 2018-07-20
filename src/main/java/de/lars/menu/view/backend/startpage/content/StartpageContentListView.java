/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templatespublic class StartpageListView extends VerticalLayout {

 * and open the template in the editor.
 */
package de.lars.menu.view.backend.startpage.content;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import de.lars.menu.view.backend.BackendView;

/**
 *
 * @author Tobias
 */
@Route(value = StartpageContentListView.ROUTE, layout = BackendView.class)
public class StartpageContentListView extends VerticalLayout {

    public static final String ROUTE = BackendView.ROUTE + "/startpagecontent";

    public StartpageContentListView() {
        add(new RouterLink("create", StartpageContentCreateView.class));

    }
}
