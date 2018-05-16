package de.lars.menu.view.backend;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import de.lars.menu.components.backend.Menu;

/**
 * The main view contains a button and a template element.
 */
@Route("")
@PageTitle("Backend")
public class BackendView extends HorizontalLayout implements RouterLayout {

    public BackendView() {        
        setWidth("100%");
        setClassName("be-content");
        
        add(new Menu());
    }
}
