/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.article;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import de.lars.menu.entity.article.Article;
import de.lars.menu.entity.facade.ArticleFacade;
import de.lars.menu.view.backend.article.component.part.ArticlePartEditLayout;
import de.lars.menu.view.backend.article.component.part.button.ArticlePartToolButton;
import de.lars.menu.view.backend.article.component.part.button.ArticlePartToolButtonList;
import de.lars.menu.view.backend.article.component.part.ArticlePartListLayout;
import de.lars.menu.view.backend.article.component.part.layout.ArticlePartLinksEditLayout;
import de.lars.menu.view.backend.article.component.part.layout.ArticlePartTextEditLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author syrinx
 */
@StyleSheet("styles/backend/article/article-styles.css")
public abstract class ArticleModificationView extends VerticalLayout {

    @Inject
    protected ArticleFacade facade;

    protected TextField tfHeadline;
    protected TextField tfPath;

    private FormLayout forms;
    protected ArticlePartListLayout articlePartListLayout;
    private ArticlePartToolButtonList btnList;

    public ArticleModificationView() {
        setWidth("700px");
        setClassName("be-article-mod-border");
        setSpacing(false);

        forms = new FormLayout();

        tfHeadline = new TextField();
        tfHeadline.setPlaceholder("Überschrift");
        tfHeadline.setMinLength(Article.HEADLINE_MIN_LEN);
        tfHeadline.setMaxLength(Article.HEADLINE_MAX_LEN);
        forms.addFormItem(tfHeadline, "Überschrift");

        tfPath = new TextField();
        tfPath.setPlaceholder("Pfad");
        tfPath.setMinLength(Article.PATH_MIN_LEN);
        tfPath.setMaxLength(Article.PATH_MAX_LEN);
        tfPath.setPattern(Article.PATH_PATTERN);
        forms.addFormItem(tfPath, "Pfad");

        forms.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1));
    }

    protected void addForms() {
        add(forms);
        articlePartListLayout = new ArticlePartListLayout();
        add(articlePartListLayout);
    }

    protected boolean isValid() {
        return !tfHeadline.isInvalid();
    }

    public void addPlusBtn() {
        btnList = new ArticlePartToolButtonList();

        addBtn2BtnList("Text", ArticlePartTextEditLayout.class);
        addBtn2BtnList("Links", ArticlePartLinksEditLayout.class);

        add(btnList);
    }

    private void addBtn2BtnList(String title, Class<? extends ArticlePartEditLayout> aClass) {
        ArticlePartToolButton btn = new ArticlePartToolButton(title);
        btn.addClickListener(e -> {
            try {
                articlePartListLayout.addPart(aClass.newInstance());
            } catch (InstantiationException ex) {
                Logger.getLogger(ArticleModificationView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ArticleModificationView.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnList.hideCreateButtons();
        });
        btnList.addArticlePart(btn);
    }
}
