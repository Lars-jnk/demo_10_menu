/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.service;

import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author syrinx
 */
@ApplicationScoped
public class Service {

    public String get(String value) {
        return "Hallo " + value;
    }
}
