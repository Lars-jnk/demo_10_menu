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
    protected VerticalLayout contentLayout;
    private ToolbarButton btnRetractOrFull;
    protected Label lblHeader;
    private boolean retracted;

    public ArticlePartEditLayout() {
        setClassName("be-article-part-mod-border");
        setWidth("100%");
        this.retracted = true;

        contentLayout = new VerticalLayout();
        contentLayout.setClassName("be-article-part-content");
        contentLayout.setWidth("100%");
        contentLayout.setSpacing(false);

        addToolbar();
        add(contentLayout);
    }

    protected abstract void initContentRetracted();

    protected abstract void initContentFull();

    protected abstract ArticlePart getEntity();

    protected abstract void setEntity(ArticlePart entity);

    public void setArticlePartListLayout(ArticlePartEditListLayout listLayout) {
        this.listLayout = listLayout;
    }

    public void showRetracted() {
        this.retracted = true;
        initContentRetracted();
        btnRetractOrFull.removeAll();
        btnRetractOrFull.add(VaadinIcons.PLUS_CIRCLE_O.create());
    }

    public void showFull() {
        this.retracted = false;
        initContentFull();
        btnRetractOrFull.removeAll();
        btnRetractOrFull.add(VaadinIcons.MINUS_CIRCLE_O.create());
    }

    private void addToolbar() {
        HorizontalLayout layoutToolbar = new HorizontalLayout();
        layoutToolbar.setClassName("be-article-part-toolbar");
        layoutToolbar.setWidth("100%");

        lblHeader = new Label();
        lblHeader.addClassName("be-article-part-lbl-header");
        lblHeader.setWidth("100%");
        layoutToolbar.add(lblHeader);
        add(layoutToolbar);

        HorizontalLayout layoutTools = new HorizontalLayout();
        layoutTools.setSpacing(false);
        layoutTools.setClassName("be-article-part-toolbar-tools");
        layoutTools.add(createRetractOrFullBtn());
        layoutTools.add(createDownBtn());
        layoutTools.add(createUpBtn());
        layoutTools.add(createRemoveBtn());

        layoutToolbar.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        layoutToolbar.add(layoutTools);
    }

    private ToolbarButton createRetractOrFullBtn() {
        btnRetractOrFull = new ToolbarButton(VaadinIcons.PLUS_CIRCLE_O.create());
        //btnRetractOrFull.setIcon(VaadinIcons.PLUS_CIRCLE_O.create());
        btnRetractOrFull.addClickListener(e -> {
            if (retracted) {
                showFull();
            } else {
                showRetracted();
            }
        });
        return btnRetractOrFull;
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
