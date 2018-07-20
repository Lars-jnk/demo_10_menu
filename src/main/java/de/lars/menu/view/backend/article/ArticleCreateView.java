/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.article;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import de.lars.menu.entity.article.Article;
import de.lars.menu.view.backend.BackendView;

/**
 *
 * @author syrinx
 */
@Route(value = ArticleCreateView.ROUTE, layout = BackendView.class)
public class ArticleCreateView extends ArticleModificationView {

    public static final String ROUTE = ArticleListView.ROUTE + "/create";

    public ArticleCreateView() {
        HorizontalLayout buttons = new HorizontalLayout();

        Button btnCreate = new Button("create");
        btnCreate.addClickListener(e -> {
            if (this.isValid()) {
                facade.create(new Article(tfPath.getValue(), tfHeadline.getValue()));
                btnCreate.getUI().ifPresent(ui -> ui.navigate("backend/article"));
            }
        });

        Button btnToList = new Button("to List");
        btnToList.addClickListener(e -> {
            btnToList.getUI().ifPresent(ui -> ui.navigate("backend/article"));
        });
        buttons.add(btnCreate, btnToList);

        add(buttons);
        addForms();
        addPlusBtn();
    }
}
