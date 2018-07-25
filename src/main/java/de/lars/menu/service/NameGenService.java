/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.service;

import java.util.Random;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Tobias
 */
@ApplicationScoped
public class NameGenService {

    private final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String generate(String suffix) {
        return generate(suffix, 64);
    }

    public String generate(String suffix, int len) {
        String retVal = new String();
        Random random = new Random();

        for (int i = 0; i < len; ++i) {
            retVal += CHARS.charAt(random.nextInt(CHARS.length()));
        }
        retVal += "." + suffix;
        return retVal;
    }
}
