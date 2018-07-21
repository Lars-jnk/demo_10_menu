/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.startpage.content;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import de.lars.menu.component.edit.TextEditView;
import de.lars.menu.component.edit.background.BackgroundEditView;
import de.lars.menu.component.tabs.ContentTabs;
import de.lars.menu.entity.facade.ArticleFacade;
import javax.inject.Inject;

/**
 *
 * @author Tobias
 */
public abstract class StartpageContentModificationView extends VerticalLayout {

    private TextEditView textEditView;

    private BackgroundEditView backgroundEditView;

    @Inject
    protected ArticleFacade facade;

    public StartpageContentModificationView() {
        HorizontalLayout layoutBtn = new HorizontalLayout();
        addButtons(layoutBtn);
        add(layoutBtn);

        ContentTabs contentTabs = new ContentTabs();
        textEditView = new TextEditView();
        contentTabs.add("Text", textEditView);

        backgroundEditView = new BackgroundEditView();
        contentTabs.add("Hintergrund", backgroundEditView);

        add(contentTabs);
    }

    protected abstract void addButtons(HorizontalLayout layout);
}
