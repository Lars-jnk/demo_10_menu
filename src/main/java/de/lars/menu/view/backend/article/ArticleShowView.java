/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.article;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import de.lars.menu.entity.article.Article;
import de.lars.menu.entity.facade.ArticleFacade;
import de.lars.menu.view.backend.BackendView;
import javax.inject.Inject;

/**
 *
 * @author syrinx
 */
@Route(value = "article/show", layout = BackendView.class)
public class ArticleShowView extends VerticalLayout implements HasUrlParameter<Long> {

    @Inject
    private ArticleFacade facade;

    private TextField tfHeadline;
    private TextField tfPath;
    private Button btnEdit;

    public ArticleShowView() {

        HorizontalLayout buttons = new HorizontalLayout();

        Button btnToList = new Button("to List");
        btnToList.addClickListener(e -> {
            btnToList.getUI().ifPresent(ui -> ui.navigate("article"));
        });

        btnEdit = new Button("Edit");

        buttons.add(btnToList, btnEdit);

        add(buttons);

        FormLayout forms = new FormLayout();

        tfHeadline = new TextField();
        tfHeadline.setEnabled(false);
        forms.addFormItem(tfHeadline, "Überschrift");

        tfPath = new TextField();
        tfPath.setEnabled(false);
        forms.addFormItem(tfPath, "Pfad");

        forms.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1));

        add(forms);
    }

    @Override
    public void setParameter(BeforeEvent event, Long articleId) {
        Article article = facade.find(articleId);
        tfHeadline.setValue(article.getHeadline());
        tfPath.setValue(article.getPath());

        btnEdit.addClickListener(e -> {
            btnEdit.getUI().ifPresent(ui -> ui.navigate("article/edit/" + articleId));
        });
    }
}
