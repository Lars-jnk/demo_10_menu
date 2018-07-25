/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.startpage.content;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import de.lars.menu.view.backend.BackendView;

/**
 *
 * @author Tobias
 */
@Route(value = StartpageContentCreateView.ROUTE, layout = BackendView.class)
public class StartpageContentCreateView extends StartpageContentModificationView {

    public static final String ROUTE = StartpageContentListView.ROUTE + "/create";

    public StartpageContentCreateView() {
    }

    @Override
    protected void addButtons(HorizontalLayout layout) {
        Button btnCreate = new Button("create");
        btnCreate.addClickListener(e -> {
        });

        Button btnToList = new Button("to List");
        btnToList.addClickListener(e -> {
            btnToList.getUI().ifPresent(ui -> ui.navigate("backend/startpagecontent"));
        });

        layout.add(btnCreate, btnToList);
    }
}
