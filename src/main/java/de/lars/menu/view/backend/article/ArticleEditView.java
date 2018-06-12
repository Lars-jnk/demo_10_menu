/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.article;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import de.lars.menu.entity.article.Article;
import de.lars.menu.view.backend.BackendView;
import de.lars.menu.view.backend.article.component.ArticleDeleteDialog;
import de.lars.menu.view.backend.article.component.button.RoundedButton;
import javax.inject.Inject;

/**
 *
 * @author syrinx
 */
@Route(value = "backend/article/edit", layout = BackendView.class)
public class ArticleEditView extends ArticleModificationView implements HasUrlParameter<Long> {

    @Inject
    private ArticleDeleteDialog deleteDialog;

    private Article article;
    private RoundedButton btnToShow;

    public ArticleEditView() {
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.addClassName("be-article-buttons");

        RoundedButton btnCreate = new RoundedButton("speichern");
        btnCreate.addClickListener(e -> {
            if (this.isValid()) {
                article.setHeadline(tfHeadline.getValue());
                article.setPath(tfPath.getValue());
                article.setParts(articlePartListLayout.getParts());
                facade.edit(article);
                btnCreate.getUI().ifPresent(ui -> ui.navigate("backend/article"));
            }
        });

        RoundedButton btnDelete = new RoundedButton("löschen");
        btnDelete.addClickListener(e -> {
            deleteDialog.setArticle(article);
            deleteDialog.open();
        });

        btnToShow = new RoundedButton("anzeigen");

        RoundedButton btnToList = new RoundedButton("zur Liste");
        btnToList.addClickListener(e -> {
            btnToList.getUI().ifPresent(ui -> ui.navigate("backend/article"));
        });
        buttons.add(btnCreate, btnDelete, btnToShow, btnToList);

        add(buttons);
        addForms();
        addPlusBtn();
    }

    @Override
    public void setParameter(BeforeEvent event, Long articleId) {
        article = facade.find(articleId);
        tfHeadline.setValue(article.getHeadline());
        tfPath.setValue(article.getPath());
        articlePartListLayout.setParts(article.getParts());

        btnToShow.addClickListener(e -> {
            btnToShow.getUI().ifPresent(ui -> ui.navigate("backend/article/show/" + articleId));
        });
    }
}
