/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.elements.background.image;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import de.lars.menu.entity.facade.BackgroundElementFacade;
import de.lars.menu.view.backend.BackendView;
import de.lars.menu.view.backend.elements.background.BackgroundElementListView;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author Tobias
 */
@Route(value = BackgroundElementImageCreateView.ROUTE, layout = BackendView.class)
public class BackgroundElementImageCreateView extends BackgroundElementImageModificationView {

    public static final String ROUTE = BackgroundElementListView.ROUTE + "/image/create";

    @Inject
    private BackgroundElementFacade facade;

    public BackgroundElementImageCreateView() {
    }

    @Override
    public void addButtons(HorizontalLayout layout) {
        layout.add(new Button("erstellen", e -> {
            try {
                facade.create(getBackgroundImage());
            } catch (IllegalAccessException ex) {
                Notification.show("so aber nicht!", 10, Notification.Position.MIDDLE);
                Logger.getLogger(BackgroundElementImageCreateView.class.getName()).log(Level.SEVERE, null, ex);
            }
            Notification.show("gespeichert");
        }));

        layout.add(new Button("zur Liste", e -> {
            getUI().ifPresent(ui -> ui.navigate("backend/background"));
        }));
    }
}
