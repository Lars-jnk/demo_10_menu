/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.training.exercise;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.GeneratedVaadinDialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import de.lars.menu.entity.facade.ExerciseFacade;
import de.lars.menu.entity.training.Exercise;
import de.lars.menu.view.backend.BackendView;
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

    private Grid<Exercise> grid;
    private ExerciseCreateDialog createDialog;
    private ExerciseEditDialog editDialog;
    private ExerciseDeleteDialog deleteDialog;

    public ExerciseListView() {
        grid = new Grid<>();
        grid.addColumn(Exercise::getName).setHeader("Name");
        grid.addColumn(exercise -> new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(exercise.getCreated())).setHeader("Created");
        grid.addColumn(exercise -> new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(exercise.getUpdated())).setHeader("updated");
        grid.addComponentColumn(exercise -> new HorizontalLayout(
                new Button("edit", e -> {
                    editDialog = new ExerciseEditDialog(exercise, this::handleOpenChangeEdit);
                }),
                new Button("löschen", e -> {
                    deleteDialog = new ExerciseDeleteDialog(exercise, this::handleOpenChangeDelete);
                })
        ));
        grid.setSizeFull();

        add(new Button("erstellen", e -> {
            createDialog = new ExerciseCreateDialog(this::handleOpenChangeCreate);
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

    private void handleOpenChangeCreate(GeneratedVaadinDialog.OpenedChangeEvent e) {
        if (createDialog.isOpened() == false && createDialog.isSaved()) {
            facade.create(createDialog.getEntity());
            updateExercises();
        }
    }

    private void handleOpenChangeEdit(GeneratedVaadinDialog.OpenedChangeEvent e) {
        if (editDialog.isOpened() == false && editDialog.isSaved()) {
            facade.edit(editDialog.getEntity());
            updateExercises();
        }
    }

    private void handleOpenChangeDelete(GeneratedVaadinDialog.OpenedChangeEvent e) {
        if (deleteDialog.isOpened() == false && deleteDialog.isDeleted()) {
            facade.remove(deleteDialog.getEntity());
            updateExercises();
        }
    }

}
