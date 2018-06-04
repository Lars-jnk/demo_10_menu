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
import de.lars.menu.view.backend.article.component.part.button.ArticleButton;
import javax.inject.Inject;

/**
 *
 * @author syrinx
 */
@Route(value = "article/edit", layout = BackendView.class)
public class ArticleEditView extends ArticleModificationView implements HasUrlParameter<Long> {

    @Inject
    private ArticleDeleteDialog deleteDialog;

    private Article article;
    private ArticleButton btnToShow;

    public ArticleEditView() {
        HorizontalLayout buttons = new HorizontalLayout();
        buttons.addClassName("be-article-buttons");
        buttons.setWidth("100%");

        ArticleButton btnCreate = new ArticleButton("speichern");
        btnCreate.addClickListener(e -> {
            if (this.isValid()) {
                article.setHeadline(tfHeadline.getValue());
                article.setPath(tfPath.getValue());
                article.setParts(articlePartListLayout.getParts());
                facade.edit(article);
                btnCreate.getUI().ifPresent(ui -> ui.navigate("article"));
            }
        });

        ArticleButton btnDelete = new ArticleButton("löschen");
        btnDelete.addClickListener(e -> {
            deleteDialog.setArticle(article);
            deleteDialog.open();
        });

        btnToShow = new ArticleButton("anzeigen");

        ArticleButton btnToList = new ArticleButton("zur Liste");
        btnToList.addClickListener(e -> {
            btnToList.getUI().ifPresent(ui -> ui.navigate("article"));
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
            btnToShow.getUI().ifPresent(ui -> ui.navigate("article/show/" + articleId));
        });
    }
}
