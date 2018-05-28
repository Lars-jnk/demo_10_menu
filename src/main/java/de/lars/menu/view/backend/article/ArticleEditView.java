/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.article;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import de.lars.menu.entity.article.Article;
import de.lars.menu.view.backend.BackendView;
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
    private Button btnToShow;

    public ArticleEditView() {
        HorizontalLayout buttons = new HorizontalLayout();

        Button btnCreate = new Button("save");
        btnCreate.addClickListener(e -> {
            if (this.isValid()) {
                article.setHeadline(tfHeadline.getValue());
                article.setPath(tfPath.getValue());
                article.setParts(articlePartListLayout.getParts());
                facade.edit(article);
                btnCreate.getUI().ifPresent(ui -> ui.navigate("article"));
            }
        });

        Button btnDelete = new Button("delete");
        btnDelete.addClickListener(e -> {
            deleteDialog.setArticle(article);
            deleteDialog.open();
        });

        btnToShow = new Button("show");

        Button btnToList = new Button("to List");
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
