/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.lars.menu.entity.demo.Demo;
import de.lars.menu.entity.facade.DemoFacade;
import de.lars.menu.view.backend.BackendView;
import javax.inject.Inject;

/**
 *
 * @author Lars
 */
@Route(value = "backend/demo", layout = BackendView.class)
@PageTitle("Demo Entity")
public class DemoEntityView extends VerticalLayout {

    @Inject
    private DemoFacade demoFacade;

    private TextField demoCol;
    private TextField demoCol1;
    private Button btn;

    public DemoEntityView() {
        demoCol = new TextField("DemoCol", "Text...");
        demoCol1 = new TextField("DemoCol 1", "Text...");
        btn = new Button("Speichern", e -> demoFacade.create(new Demo(demoCol.getValue(), demoCol1.getValue())));

        add(demoCol, demoCol1, btn);
    }
}
