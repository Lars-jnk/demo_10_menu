/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.elements.background.image;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.SucceededEvent;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.FileData;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import de.lars.menu.component.layout.PlainVerticalLayout;
import de.lars.menu.component.layout.ScrollableVerticalLayout;
import de.lars.menu.dto.ImageDto;
import de.lars.menu.entity.element.background.BackgroundElementImage;
import de.lars.menu.entity.facade.BackgroundElementImageFacade;
import de.lars.menu.service.FileCacheService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author Lars
 */
@StyleSheet("styles/backend/content.css")
public abstract class BackgroundElementImageModificationView extends VerticalLayout {

    private ScrollableVerticalLayout panel;

    private VerticalLayout contentLayout;
    private TextField titleIntern;
    private TextArea notice;
    private Upload upload;

    private PlainVerticalLayout imagePropertyLayout;
    private TextField alternativeText;
    private TextField filenameOriginal;
    private TextField mimeType;
    private TextField filenameGenerated;
    private TextField imageWidth;
    private TextField imageHeight;
    private TextField imageSizeInByte;
    private Image image;

    private ImageDto imageDto;

    @Inject
    private FileCacheService fileCacheService;

    @Inject
    protected BackgroundElementImageFacade facade;

    public BackgroundElementImageModificationView() {
        setPadding(false);
        setHeight("100vh");
        addButtonLayout();

        panel = new ScrollableVerticalLayout();

        MemoryBuffer fileBuffer = new MemoryBuffer();
        upload = new Upload(fileBuffer);
        upload.addClassName("be-content-upload");
        upload.addSucceededListener(event -> {
            cacheFile(event, fileBuffer.getFileData());
        });
        panel.add(upload);
        add(panel);
    }

    public BackgroundElementImage fillEntity(BackgroundElementImage backgroundImage) throws IllegalAccessException {
        if (image == null || imagePropertyLayout == null) {
            throw new IllegalAccessException("Upload an image before calling this function.");
        }
        backgroundImage.setInternTitle(titleIntern.getValue());
        backgroundImage.setNotice(notice.getValue());
        backgroundImage.setAltervativeText(alternativeText.getValue());
        backgroundImage.setFilenameExtern(filenameOriginal.getValue());
        backgroundImage.setFilenameIntern(filenameGenerated.getValue());
        backgroundImage.setMimeType(mimeType.getValue());
        backgroundImage.setSizeInByte(imageDto.sizeInByte);
        backgroundImage.setWidth(imageDto.width);
        backgroundImage.setHeight(imageDto.height);

        return backgroundImage;
    }

    private void addButtonLayout() {
        HorizontalLayout layoutBtn = new HorizontalLayout();
        layoutBtn.addClassName("be-content-layout");
        addButtons(layoutBtn);
        add(layoutBtn);
    }

    public abstract void addButtons(HorizontalLayout layout);

    private void cacheFile(SucceededEvent event, FileData fileData) {
        try {
            imageDto = fileCacheService.cacheFile(fileData, event.getContentLength());
            setImageWithInfos(imageDto);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BackgroundElementImageModificationView.class.getName()).log(Level.SEVERE, null, ex);
            add(new Label(ex.getMessage()));
        } catch (IOException ex) {
            Logger.getLogger(BackgroundElementImageModificationView.class.getName()).log(Level.SEVERE, null, ex);
            add(new Label(ex.getMessage()));
        }
    }

    protected void setImageWithInfos(ImageDto imageDto) {
        if (contentLayout != null) {
            panel.remove(contentLayout);
        }

        titleIntern = new TextField("Titel (intern)", imageDto.titleIntern, "Titel");
        titleIntern.setWidth("100%");

        notice = new TextArea("Notiz (intern)", imageDto.notice, "Notiz");
        notice.setWidth("100%");

        image = createImage(imageDto.directory + "/" + imageDto.filenameGenerated);

        imagePropertyLayout = createImagePropertyLayout(imageDto);

        contentLayout = new VerticalLayout(titleIntern, notice, image, imagePropertyLayout);
        contentLayout.setSpacing(false);
        panel.add(contentLayout);
    }

    private PlainVerticalLayout createImagePropertyLayout(ImageDto imageDto) {
        PlainVerticalLayout imagePropertyLayout = new PlainVerticalLayout();

        alternativeText = createTextField("Alternativtext", imageDto.alternativeText, false);
        HorizontalLayout layout = new HorizontalLayout(alternativeText);
        layout.setWidth("100%");
        layout.expand(alternativeText);
        imagePropertyLayout.add(layout);

        filenameOriginal = createTextField("Dateiname (original)", imageDto.filenameOriginal, true);
        mimeType = createTextField("Mime Type", imageDto.mimeType, true);
        layout = new HorizontalLayout(filenameOriginal, mimeType);
        layout.setWidth("100%");
        layout.expand(filenameOriginal);
        imagePropertyLayout.add(layout);

        filenameGenerated = createTextField("Dateiname (generiert)", imageDto.filenameGenerated, true);
        layout = new HorizontalLayout(filenameGenerated);
        layout.setWidth("100%");
        layout.expand(filenameGenerated);
        imagePropertyLayout.add(layout);

        imageWidth = createTextField("Breite", Integer.toString(imageDto.width), true);
        imageWidth.setSuffixComponent(new Span("px"));
        imageHeight = createTextField("Höhe", Integer.toString(imageDto.height), true);
        imageHeight.setSuffixComponent(new Span("px"));
        imageSizeInByte = createTextField("Dateigröße", Long.toString(imageDto.sizeInByte), true);
        imageSizeInByte.setSuffixComponent(new Span("Byte"));
        layout = new HorizontalLayout(imageWidth, imageHeight, imageSizeInByte);
        layout.setWidth("100%");
        layout.expand(imageWidth, imageHeight, imageSizeInByte);
        imagePropertyLayout.add(layout);

        return imagePropertyLayout;
    }

    private Image createImage(String filenameGenerated) {
        Image image = new Image(filenameGenerated, "Oje, da ist wohl ein Fehler aufgetreten.");
        image.setWidth("100%");
        return image;
    }

    private TextField createTextField(String label, String value, boolean enabled) {
        TextField textField = new TextField(label);
        textField.setValue(value);
        textField.setReadOnly(enabled);
        return textField;
    }
}
