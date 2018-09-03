/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.training.exercise;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import de.lars.menu.entity.facade.ExerciseFacade;
import de.lars.menu.entity.training.Exercise;
import de.lars.menu.view.backend.BackendView;
import de.lars.menu.view.backend.article.ArticleEditView;
import de.lars.menu.view.backend.article.ArticleShowView;
import java.text.SimpleDateFormat;
import javax.inject.Inject;

/**
 *
 * @author Lars
 */
@Route(value = ExerciseListView.ROUTE, layout = BackendView.class)
public class ExerciseListView extends VerticalLayout implements BeforeEnterObserver {

    public static final String ROUTE = BackendView.ROUTE + "/exercise";

    @Inject
    private ExerciseFacade facade;

    @Inject
    private ExerciseCreateDialog createDialog;

    private Grid<Exercise> grid;

    public ExerciseListView() {
        grid = new Grid<>();
        grid.addColumn(Exercise::getName).setHeader("Name");
        grid.addColumn(exercise -> new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(exercise.getCreated())).setHeader("Created");
        grid.addColumn(exercise -> new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(exercise.getUpdated())).setHeader("updated");
        grid.addComponentColumn(article -> new HorizontalLayout(
                new RouterLink("show", ArticleShowView.class, article.getId()),
                new RouterLink("edit", ArticleEditView.class, article.getId()))
        );
        grid.setSizeFull();

        add(new Button("erstellen", e -> {
            createDialog.open();
            createDialog.addOpenedChangeListener(e1 -> {
                if (createDialog.isOpened() == false) {
                    updateExercises();
                }
            });
        }));
        add(grid);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent bee) {
        updateExercises();
    }

    private void updateExercises() {
        grid.setItems(facade.findAll());
    }

    private void closeDialog() {
        if (createDialog.isCreated()) {
            facade.create(createDialog.getExercise());
            updateExercises();
        }
        createDialog.close();
    }
}
