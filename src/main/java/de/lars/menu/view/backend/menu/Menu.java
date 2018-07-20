/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.menu;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import de.lars.menu.view.backend.article.ArticleListView;
import de.lars.menu.view.backend.demo.Form2View;
import de.lars.menu.view.backend.demo.FormView;
import de.lars.menu.view.backend.demo.HomeView;
import de.lars.menu.view.backend.demo.ServiceView;

/**
 *
 * @author reuss
 */
@StyleSheet("styles/backend/menu-styles.css")
public class Menu extends VerticalLayout {

    public Menu(String headline) {
        setPadding(false);
        setSizeUndefined();
        setClassName("be-menu");

        super.add(new MenuHeadline(headline));
    }

    @Override
    public void add(Component... components) {
        throw new IllegalArgumentException("use add(MenuGroup menuGroup);");
    }

    public void add(MenuGroup menuGroup) {
        super.add(menuGroup);
    }
}
