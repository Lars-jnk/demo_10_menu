/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.article;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;
import de.lars.menu.entity.article.Article;
import de.lars.menu.entity.facade.ArticleFacade;
import de.lars.menu.view.backend.BackendView;
import java.text.SimpleDateFormat;
import javax.inject.Inject;

/**
 *
 * @author syrinx
 */
@Route(value = "article", layout = BackendView.class)
public class ArticleListView extends VerticalLayout implements BeforeEnterObserver {

    @Inject
    private ArticleFacade facade;

    private Grid<Article> grid;

    public ArticleListView() {
        setSizeFull();

        grid = new Grid<>();
        grid.addColumn(Article::getHeadline).setHeader("Überschrift");
        grid.addColumn(article -> new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(article.getCreated())).setHeader("Created");
        grid.addColumn(Article::getStatus).setHeader("Status");
        grid.addComponentColumn(article -> new HorizontalLayout(
                new RouterLink("show", ArticleShowView.class, article.getId()),
                new RouterLink("edit", ArticleEditView.class, article.getId()))
        );
        grid.setSizeFull();

        add(new RouterLink("Create", ArticleCreateView.class));
        add(grid);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent bee) {
        grid.setItems(facade.findAll());
    }
}
