/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.article.component.part;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcons;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import de.lars.menu.entity.article.ArticlePart;
import de.lars.menu.view.backend.article.component.button.ToolbarButton;

/**
 *
 * @author syrinx
 */
public abstract class ArticlePartEditLayout extends VerticalLayout {

    private ArticlePartEditListLayout listLayout;

    public ArticlePartEditLayout() {
        setClassName("be-article-part-mod-border");
        setWidth("100%");

        addToolbar();

        VerticalLayout layout = new VerticalLayout();
        layout.setClassName("be-article-part-content");
        layout.setWidth("100%");
        layout.setSpacing(false);
        initContent(layout);
        add(layout);
    }

    protected abstract void initContent(VerticalLayout layout);

    protected abstract ArticlePart getEntity();

    protected abstract void setEntity(ArticlePart entity);

    public void setArticlePartListLayout(ArticlePartEditListLayout listLayout) {
        this.listLayout = listLayout;
    }

    private void addToolbar() {
        HorizontalLayout layoutToolbar = new HorizontalLayout();
        layoutToolbar.setClassName("be-article-part-toolbar");
        layoutToolbar.setWidth("100%");

        Label label = new Label("Neu");
        layoutToolbar.add(label);
        add(layoutToolbar);

        HorizontalLayout layoutTools = new HorizontalLayout();
        layoutTools.setSpacing(false);
        layoutTools.setClassName("be-article-part-toolbar-tools");
        layoutTools.add(createDownBtn());
        layoutTools.add(createUpBtn());
        layoutTools.add(createRemoveBtn());

        layoutToolbar.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        layoutToolbar.add(layoutTools);
    }

    private ToolbarButton createDownBtn() {
        ToolbarButton btn = new ToolbarButton(VaadinIcons.ARROW_DOWN.create());
        btn.addClickListener(e -> listLayout.moveViewDown(this));
        return btn;
    }

    private ToolbarButton createUpBtn() {
        ToolbarButton btn = new ToolbarButton(VaadinIcons.ARROW_UP.create());
        btn.addClickListener(e -> listLayout.moveViewUp(this));
        return btn;
    }

    private ToolbarButton createRemoveBtn() {
        ToolbarButton btn = new ToolbarButton(VaadinIcons.CLOSE.create());
        btn.addClickListener(e -> listLayout.removeView(this));
        return btn;
    }
}
