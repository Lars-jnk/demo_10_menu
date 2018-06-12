/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.frontend;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import de.lars.menu.view.frontend.content.TextBgImageContent;
import de.lars.menu.view.frontend.header.Header;
import de.lars.menu.view.frontend.header.HeaderBox;

/**
 *
 * @author syrinx
 */
@Route("")
@PageTitle("Baltrum")
@StyleSheet("styles/frontend/main-styles.css")
public class FrontendView extends VerticalLayout implements RouterLayout {

    public FrontendView() {
        setWidth("100%");
        setSpacing(false);
        setClassName("fe-main");

        HeaderBox headerBox = new HeaderBox();
        Header header = new Header();
        headerBox.add(header);
        add(headerBox);

        TextBgImageContent mainContent = new TextBgImageContent("http://localhost:8080/demo_10_menu_git/image?name=img.jpg");
        add(mainContent);

        VerticalLayout layout = new VerticalLayout();
        layout.setClassName("fe-main-content");
        layout.add(new Label("asdf"));
        layout.add(new TextField("adfgagg"));
        add(layout);

        mainContent = new TextBgImageContent("http://localhost:8080/demo_10_menu_git/image?name=P1070112.JPG");
        add(mainContent);
    }
}
