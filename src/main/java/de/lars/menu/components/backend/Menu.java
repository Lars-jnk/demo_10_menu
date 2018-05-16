/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.components.backend;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import de.lars.menu.view.backend.demo.Form2View;
import de.lars.menu.view.backend.demo.FormView;
import de.lars.menu.view.backend.demo.HomeView;
import de.lars.menu.view.backend.demo.ServiceView;
import de.lars.menu.view.backend.article.ArticleListView;

/**
 *
 * @author reuss
 */
@StyleSheet("styles/backend/menu-styles.css")
public class Menu extends VerticalLayout {

    public Menu() {
        setPadding(false);
        setClassName("be-menu");

        add(new MenuHeadline("Backend"));

        MenuGroup groupBtn = new MenuGroup("Demo");
        groupBtn.addLink("Article", ArticleListView.class);
        groupBtn.addLink("Ein Test", HomeView.class);
        groupBtn.addLink("ServiceView", ServiceView.class);
        groupBtn.addLink("der neue Service", ServiceView.class);
        groupBtn.addLink("Wichtig!", HomeView.class);
        add(groupBtn);

        MenuGroup groupBtn2 = new MenuGroup("Zweites");
        groupBtn2.addLink("Form", FormView.class);
        groupBtn2.addLink("Form2", Form2View.class);
        groupBtn2.addLink("MenuLink", HomeView.class);
        groupBtn2.addLink("Infos", ServiceView.class);
        add(groupBtn2);
    }
}
