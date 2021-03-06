/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.article;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import de.lars.menu.entity.article.Article;
import de.lars.menu.entity.facade.ArticleFacade;
import de.lars.menu.service.PathGenerationService;
import de.lars.menu.view.backend.article.component.button.BigButton;
import de.lars.menu.view.backend.article.component.button.BigButtonList;
import de.lars.menu.view.backend.article.component.button.RoundedButton;
import de.lars.menu.view.backend.article.component.part.ArticlePartEditLayout;
import de.lars.menu.view.backend.article.component.part.ArticlePartEditListLayout;
import de.lars.menu.view.backend.article.component.part.layout.ArticlePartTextBgImageEditLayout;
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

    protected TextField tfHeadline;
    protected TextField tfPath;

    protected ArticlePartEditListLayout articlePartListLayout;
    private BigButtonList btnList;
    private FormLayout header;

    @Inject
    protected ArticleFacade facade;

    @Inject
    private PathGenerationService pathGenService;

    public ArticleModificationView() {
        setWidth("700px");
        setClassName("be-article-mod-border");
        setSpacing(false);

        header = new FormLayout();
        header.setClassName("be-article-header");

        tfHeadline = new TextField();
        tfHeadline.setWidth("100%");
        tfHeadline.setPlaceholder("Überschrift");
        tfHeadline.setMinLength(Article.HEADLINE_MIN_LEN);
        tfHeadline.setMaxLength(Article.HEADLINE_MAX_LEN);
        tfHeadline.setErrorMessage("Hallo ddd");
        header.addFormItem(tfHeadline, new Label("Überschrift"));

        tfPath = new TextField();
        tfPath.setPlaceholder("Pfad");
        tfPath.setMinLength(Article.PATH_MIN_LEN);
        tfPath.setMaxLength(Article.PATH_MAX_LEN);
        tfPath.setPattern(Article.PATH_PATTERN);
        tfPath.setErrorMessage("Min ddd");

        RoundedButton btnPath = new RoundedButton("generieren");
        btnPath.addClickListener(e -> {
            tfPath.setValue(pathGenService.generateFromHeadline(tfHeadline.getValue()));
        });

        HorizontalLayout layoutPath = new HorizontalLayout(tfPath, btnPath);
        layoutPath.setWidth("100%");
        layoutPath.expand(tfPath);
        Label lblPath = new Label("Pfad");
        lblPath.addClassName("be-article-header-path-lbl");
        header.addFormItem(layoutPath, lblPath);

        header.setResponsiveSteps(new ResponsiveStep("0", 1));
    }

    protected void addForms() {
        add(header);
        articlePartListLayout = new ArticlePartEditListLayout();
        add(articlePartListLayout);
    }

    protected boolean isValid() {
        return !tfHeadline.isInvalid() && !tfPath.isInvalid();
    }

    public void addPlusBtn() {
        btnList = new BigButtonList();

        addBtn2BtnList("Text", ArticlePartTextEditLayout.class);
        addBtn2BtnList("Text mit Hintergrundbild", ArticlePartTextBgImageEditLayout.class);

        add(btnList);
    }

    private void addBtn2BtnList(String title, Class<? extends ArticlePartEditLayout> aClass) {
        BigButton btn = new BigButton(title);
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
