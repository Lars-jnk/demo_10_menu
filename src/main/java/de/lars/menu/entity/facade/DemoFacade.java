/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.entity.facade;

import de.lars.menu.entity.demo.Demo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author syrinx
 */
@Stateless
public class DemoFacade extends AbstractFacade<Demo> {

    @PersistenceContext(unitName = "de.lars.menu_demo_10_menu_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DemoFacade() {
        super(Demo.class);
    }
    
}
