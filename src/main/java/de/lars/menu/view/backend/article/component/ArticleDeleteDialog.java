/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.article.component;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.wcs.vaadin.flow.cdi.UIScoped;
import de.lars.menu.entity.article.Article;
import de.lars.menu.entity.facade.ArticleFacade;
import javax.inject.Inject;

/**
 *
 * @author syrinx
 */
@UIScoped
public class ArticleDeleteDialog extends Dialog {

    @Inject
    private ArticleFacade facade;

    private Article article;
    private Label messageLabel;

    public ArticleDeleteDialog() {
        setCloseOnEsc(false);
        setCloseOnOutsideClick(false);

        messageLabel = new Label();

        Button confirmButton = new Button("Confirm", event -> {
            facade.remove(article);
            close();
            getUI().ifPresent(ui -> ui.navigate("backend/article"));
        });
        Button cancelButton = new Button("Cancel", event -> {
            close();
        });
        HorizontalLayout buttons = new HorizontalLayout(confirmButton, cancelButton);
        VerticalLayout layout = new VerticalLayout(messageLabel, buttons);
        add(layout);
    }

    public void setArticle(Article article) {
        this.article = article;
        messageLabel.setText("Wollen Sie den Article \"" + article.getHeadline() + "\" wirklich löschen?");
    }
}
