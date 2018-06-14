/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.servlet;

import com.vaadin.flow.server.ServiceException;
import com.vaadin.flow.server.SessionDestroyEvent;
import com.vaadin.flow.server.SessionDestroyListener;
import com.vaadin.flow.server.SessionInitEvent;
import com.vaadin.flow.server.SessionInitListener;
import com.vaadin.flow.server.VaadinServletConfiguration;
import com.wcs.vaadin.flow.cdi.server.CdiVaadinServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author reuss
 */
@WebServlet(urlPatterns = "/*", name = "UIServlet", asyncSupported = true)
@VaadinServletConfiguration(productionMode = false, heartbeatInterval = 20)
public class MyServlet extends CdiVaadinServlet
        implements SessionInitListener, SessionDestroyListener {

    @Override
    protected void servletInitialized() throws ServletException {
        super.servletInitialized();
        getService().addSessionInitListener(this);
        getService().addSessionDestroyListener(this);

        System.out.println("init()");
    }

    @Override
    public void sessionInit(SessionInitEvent event)
            throws ServiceException {

        System.out.println("session init() "
                + " Session-ID: " + event.getSession().getSession().getId()
                + " CSRF: " + event.getSession().getCsrfToken()
        );
    }

    @Override
    public void sessionDestroy(SessionDestroyEvent event) {
        System.out.println("session destroy()");
    }
}
