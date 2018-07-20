/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.startpage.content.component;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.tabs.Tab;

/**
 *
 * @author Tobias
 */
public class TextTab extends Tab {

    public TextTab() {
        super("Text");

        add(new Label("dfgsdfgsdfgsdf"));
    }
}
