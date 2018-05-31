/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author reuss
 */
@ApplicationScoped
public class PathGenerationService {

    private static final String pathRegEx = "^[a-z0-9]+(-[a-z0-9]+)*$";

    public String generateFromHeadline(String headline) {
        headline = headline.replace(' ', '-');
        headline = headline.toLowerCase();
        headline = headline.replace("ü", "ue");
        headline = headline.replace("ö", "oe");
        headline = headline.replace("ä", "ae");

        if (isValidPath(headline)) {
            return headline;
        } else {
            throw new IllegalArgumentException("No valid path.");
        }
    }

    private boolean isValidPath(String path) {
        Pattern p = Pattern.compile(pathRegEx);
        Matcher m = p.matcher(path);
        return m.matches();
    }
}
