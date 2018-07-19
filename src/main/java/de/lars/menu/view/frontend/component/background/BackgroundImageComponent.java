/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.frontend.component.background;

import com.vaadin.flow.component.html.Image;

/**
 *
 * @author Tobias
 */
public class BackgroundImageComponent extends Image {

    public BackgroundImageComponent(String src, String alt) {
        super(src, alt);
        setClassName("fullview");
    }
}
