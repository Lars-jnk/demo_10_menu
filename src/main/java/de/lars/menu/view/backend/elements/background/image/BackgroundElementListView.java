/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.elements.background.image;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import de.lars.menu.entity.element.background.BackgroundElement;
import de.lars.menu.entity.element.background.BackgroundElementImage;
import de.lars.menu.entity.facade.BackgroundElementFacade;
import de.lars.menu.view.backend.BackendView;
import de.lars.menu.view.backend.elements.background.image.BackgroundElementImageCreateView;
import de.lars.menu.view.backend.elements.background.image.BackgroundElementImageEditView;
import javax.inject.Inject;

/**
 *
 * @author Tobias
 */
@Route(value = BackgroundElementListView.ROUTE, layout = BackendView.class)
public class BackgroundElementListView extends VerticalLayout implements BeforeEnterObserver {

    public static final String ROUTE = BackendView.ROUTE + "/background";

    @Inject
    private BackgroundElementFacade facade;

    private Grid<BackgroundElement> grid;

    public BackgroundElementListView() {
        grid = new Grid<>();
        grid.addColumn(BackgroundElement::getInternTitle).setHeader("Titel");
        grid.addColumn(background -> pickType(background)).setHeader("Typ");
        grid.addComponentColumn(background -> new HorizontalLayout(
                //new RouterLink("show", Back.class, article.getId()),
                new RouterLink("edit", BackgroundElementImageEditView.class, background.getId()))
        ).setHeader("Aktion");
        grid.setSizeFull();

        add(new RouterLink("create image", BackgroundElementImageCreateView.class));
        add(grid);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent bee) {
        grid.setItems(facade.findAll());
    }

    private String pickType(BackgroundElement background) {
        if (background instanceof BackgroundElementImage) {
            return "Bild";
        } else {
            return "unbekannt";
        }
    }
}
