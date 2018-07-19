/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.frontend.component;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 *
 * @author Tobias
 */
public class Text extends VerticalLayout {

    public Text() {
        setClassName("fe-text-bg-video-content");

        add(new Label("Hallo, hier bin ich!!!!"));
    }
}
