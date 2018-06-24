/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;

/**
 *
 * @author syrinx
 */
@Route("session")
@PageTitle("Session")
public class SessionView extends VerticalLayout implements RouterLayout, BeforeEnterObserver {

    private Label lblSessionId;
    private Label lblCsrfToken;

    public SessionView() {
        setWidth("100%");
        setSpacing(false);

        lblSessionId = new Label("");
        add(lblSessionId);
        lblCsrfToken = new Label("");
        add(lblCsrfToken);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent bee) {
//        lblSessionId.setText(" Session-ID: " + bee.getSession().getSession().getId());
        //      lblCsrfToken.setText(" CSRF: " + bee.getSession().getCsrfToken());
    }
}
