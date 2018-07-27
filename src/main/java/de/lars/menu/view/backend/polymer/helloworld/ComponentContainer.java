/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.polymer.helloworld;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.templatemodel.TemplateModel;

/**
 *
 * @author Tobias
 */
@Tag("component-container")
@HtmlImport("/frontend/src/ComponentContainer.html")
public class ComponentContainer extends PolymerTemplate<TemplateModel> {

    public ComponentContainer() {
        Element label = ElementFactory.createLabel("Main layout header");
        Element button = ElementFactory.createButton("Click me");

        getElement().appendChild(label, button);
    }
}
