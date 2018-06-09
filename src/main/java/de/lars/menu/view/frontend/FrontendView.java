/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.frontend;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;

/**
 *
 * @author syrinx
 */
@Route("front")
@PageTitle("Baltrum")
@StyleSheet("styles/frontend/main-styles.css")
public class FrontendView extends VerticalLayout implements RouterLayout {

    public FrontendView() {
        setWidth("100%");
        setSpacing(false);
        setClassName("fe-main");

        //this.getParent().get().getElement().setAttribute("width", "100%");
        Div image = new Div();
        image.getStyle().set("background-image", "url(http://localhost:8080/demo_10_menu_git/image?name=img.jpg)");
        image.setClassName("fe-main-image");
        add(image);

        VerticalLayout layout = new VerticalLayout();
        layout.setClassName("fe-main-content");
        layout.add(new Label("asdf"));
        layout.add(new TextField("adfgagg"));
        add(layout);

        image = new Div();
        image.getStyle().set("background-image", "url(http://localhost:8080/demo_10_menu_git/image?name=P1070112.JPG)");
        image.setClassName("fe-main-image");
        add(image);

    }
}
