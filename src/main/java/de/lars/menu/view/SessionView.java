/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import de.lars.menu.service.SessionService;
import javax.inject.Inject;

/**
 *
 * @author syrinx
 */
@Route("session")
@PageTitle("Session")
public class SessionView extends VerticalLayout implements RouterLayout, BeforeEnterObserver {

    private HorizontalLayout layoutLogin;
    private TextField tfUser;
    private Button btnLogin;

    private HorizontalLayout layoutLogout;
    private Label lblUser;
    private Button btnLogout;

    @Inject
    private SessionService sessionService;

    public SessionView() {
        setWidth("100%");
        setSpacing(false);

        tfUser = new TextField();
        btnLogin = new Button("Login");
        btnLogin.addClickListener(e -> {
            sessionService.login(tfUser.getValue());
            refresh();
        });
        layoutLogin = new HorizontalLayout(tfUser, btnLogin);

        lblUser = new Label();
        btnLogout = new Button("Logout");
        btnLogout.addClickListener(e -> {
            sessionService.logout();
            getUI().get().getSession().close();
            refresh();
        });
        layoutLogout = new HorizontalLayout(lblUser, btnLogout);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent bee) {
        refresh();
    }

    private void refresh() {
        removeAll();
        if (sessionService.isLoggedIn()) {
            lblUser.setText("User: " + sessionService.getSession().user);
            add(layoutLogout);
        } else {
            tfUser.setValue("");
            add(layoutLogin);
        }
    }
}
