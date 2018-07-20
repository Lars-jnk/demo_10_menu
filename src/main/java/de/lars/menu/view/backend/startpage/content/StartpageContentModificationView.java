/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.startpage.content;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tabs;
import de.lars.menu.entity.facade.ArticleFacade;
import de.lars.menu.view.backend.startpage.content.component.BackgroundTab;
import de.lars.menu.view.backend.startpage.content.component.TextTab;
import javax.inject.Inject;

/**
 *
 * @author Tobias
 */
public abstract class StartpageContentModificationView extends VerticalLayout {

    @Inject
    protected ArticleFacade facade;

    public StartpageContentModificationView() {
        setWidth("700px");
        setSpacing(false);

        HorizontalLayout layoutBtn = new HorizontalLayout();
        addButtons(layoutBtn);
        add(layoutBtn);

        Tabs tabs = new Tabs();
        tabs.setWidth("700px");
        TextTab textTab = new TextTab();
        tabs.add(textTab);

        BackgroundTab backgroundTab = new BackgroundTab();
        tabs.add(backgroundTab);

        add(tabs);

    }

    protected abstract void addButtons(HorizontalLayout layout);
}
