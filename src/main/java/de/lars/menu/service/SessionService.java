/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.service;

import com.vaadin.flow.server.VaadinSession;
import de.lars.menu.entity.Session;
import de.lars.menu.entity.facade.SessionFacade;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author syrinx
 */
@SessionScoped
public class SessionService implements Serializable {

    @Inject
    private SessionFacade facade;

    private Session session = null;

    public SessionService() {
        System.out.println(new Date() + "  -  SessionService()");
    }

    @PostConstruct
    public void init() {
        System.out.println(new Date() + "  -  SessionService init()");
    }

    @PreDestroy
    public void destroy() {
        System.out.println(new Date() + "  -  SessionService destroy()");
        destroySession();
    }

    public void createSession(VaadinSession vaadinSession) {
        session = new Session();
        session.setSessionId(vaadinSession.getSession().getId());
        session.setCsrfToken(vaadinSession.getCsrfToken());

        facade.create(session);
    }

    public boolean isLoggedIn() {
        if (session != null) {
            return session.user != null;
        }
        return false;
    }

    public void destroySession() {
        if (session != null) {
            session.destroySession();
            facade.edit(session);
        }
    }

    public void login(String value) {
        if (session != null) {
            session.user = value;
            facade.edit(session);
            System.out.println("login done");
        }
    }

    public void logout() {
        if (session != null) {
            session.loggedout = true;
            facade.edit(session);
            session.user = null;
            System.out.println("logout done");
        }
    }

    public Session getSession() {
        return session;
    }

    public void hello() {
        System.out.println("Hallo");
    }
}
