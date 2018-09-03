/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.entity.facade;

import de.lars.menu.entity.training.Exercise;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Lars
 */
@Stateless
public class ExerciseFacade extends AbstractFacade<Exercise> {

    @PersistenceContext(unitName = "de.lars.menu_demo_10_menu_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExerciseFacade() {
        super(Exercise.class);
    }

}
