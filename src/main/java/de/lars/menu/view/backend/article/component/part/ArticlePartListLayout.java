/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.article.component.part;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import de.lars.menu.entity.article.ArticlePart;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author syrinx
 */
public class ArticlePartListLayout extends VerticalLayout {

    private List<ArticlePartEditLayout> parts;

    public ArticlePartListLayout() {
        setClassName("be-article-list-mod-border");
        parts = new ArrayList<ArticlePartEditLayout>();
    }

    public void addPart(ArticlePartEditLayout articlePartEditLayout) {
        articlePartEditLayout.setArticlePartListLayout(this);
        parts.add(articlePartEditLayout);
        add(articlePartEditLayout);
    }

    public void moveViewDown(ArticlePartEditLayout articlePartEditLayout) {
        int idx = indexOf(articlePartEditLayout);
        if (idx < getComponentCount() - 1) {
            replace(articlePartEditLayout, getComponentAt(idx + 1));
        }
    }

    public void moveViewUp(ArticlePartEditLayout articlePartEditLayout) {
        int idx = indexOf(articlePartEditLayout);
        if (idx > 0) {
            replace(articlePartEditLayout, getComponentAt(idx - 1));
        }
    }

    public void removeView(ArticlePartEditLayout articlePartEditLayout) {
        remove(articlePartEditLayout);
    }

    public List<ArticlePart> getParts() {
        List<ArticlePart> partList = new ArrayList<ArticlePart>();
        for (ArticlePartEditLayout layout : parts) {
            partList.add(layout.getEntity());
        }
        return partList;
    }
}
