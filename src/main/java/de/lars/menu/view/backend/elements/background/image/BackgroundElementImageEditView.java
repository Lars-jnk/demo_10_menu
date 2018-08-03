/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.elements.background.image;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import de.lars.menu.dto.ImageDto;
import de.lars.menu.entity.element.background.BackgroundElementImage;
import de.lars.menu.view.backend.BackendView;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lars
 */
@Route(value = BackgroundElementImageEditView.ROUTE, layout = BackendView.class)
public class BackgroundElementImageEditView extends BackgroundElementImageModificationView implements HasUrlParameter<Long> {

    public static final String ROUTE = BackgroundElementListView.ROUTE + "/image/edit";

    private BackgroundElementImage backgroundImage;

    @Override
    public void addButtons(HorizontalLayout layout) {
        layout.add(new Button("speichern", e -> {
            try {
                if (backgroundImage != null) {
                    facade.edit(fillEntity(backgroundImage));
                }
            } catch (IllegalAccessException ex) {
                Notification.show("so aber nicht!", 10, Notification.Position.MIDDLE);
                Logger.getLogger(BackgroundElementImageCreateView.class.getName()).log(Level.SEVERE, null, ex);
            }
            Notification.show("gespeichert", 10, Notification.Position.MIDDLE);
            getUI().ifPresent(ui -> ui.navigate("backend/background"));
        }));

        layout.add(new Button("zur Liste", e -> {
            getUI().ifPresent(ui -> ui.navigate("backend/background"));
        }));
    }

    @Override
    public void setParameter(BeforeEvent event, Long id) {
        backgroundImage = facade.find(id);

        ImageDto imageDto = new ImageDto();
        imageDto.titleIntern = backgroundImage.getInternTitle();
        imageDto.notice = backgroundImage.getNotice();
        imageDto.alternativeText = backgroundImage.getAltervativeText();
        imageDto.directory = "cache";
        imageDto.filenameGenerated = backgroundImage.getFilenameIntern();
        imageDto.filenameOriginal = backgroundImage.getFilenameExtern();
        imageDto.mimeType = backgroundImage.getMimeType();
        imageDto.width = backgroundImage.getWidth();
        imageDto.height = backgroundImage.getHeight();
        imageDto.sizeInByte = backgroundImage.getSizeInByte();

        setImageWithInfos(imageDto);
    }
}
