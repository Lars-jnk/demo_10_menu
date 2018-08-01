/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.elements.background.image;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.SucceededEvent;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.FileData;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import de.lars.menu.component.layout.ScrollableVerticalLayout;
import de.lars.menu.entity.element.background.BackgroundElementImage;
import de.lars.menu.service.FileCacheService;
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
    private TextField titelIntern;
    private TextArea notice;
    private Upload upload;

    //private FormLayout imagePropertyLayout;
    private VerticalLayout imagePropertyLayout;
    private TextField filenameOriginal;
    private TextField mimeType;
    private TextField filenameGenerated;
    private TextField imageWidth;
    private TextField imageHeight;
    private TextField imageSizeInByte;
    private Image image;

    @Inject
    private FileCacheService fileCacheService;

    public BackgroundElementImageModificationView() {
        setPadding(false);
        setHeight("100vh");
        addButtonLayout();

        panel = new ScrollableVerticalLayout();
        panel.add(createCommonFieldLayout());

        add(panel);
    }

    public BackgroundElementImage getBackgroundImage() throws IllegalAccessException {
        if (imagePropertyLayout == null) {
            throw new IllegalAccessException("create FormLayout and Fields before calling this function.");
        }
        BackgroundElementImage bgImage = new BackgroundElementImage();
        bgImage.setFilenameExtern(filenameOriginal.getValue());
        bgImage.setFilenameIntern(filenameGenerated.getValue());
        bgImage.setMimeType(mimeType.getValue());
        bgImage.setSizeInByte(1234);
        bgImage.setWidth(3000);
        bgImage.setHeight(2000);

        bgImage.setAltervativeText("alt Text");

        bgImage.setInternTitle(titelIntern.getValue());
        bgImage.setNotice(notice.getValue());

        return bgImage;
    }

    private void addButtonLayout() {
        HorizontalLayout layoutBtn = new HorizontalLayout();
        layoutBtn.addClassName("be-content-layout");
        addButtons(layoutBtn);
        add(layoutBtn);
    }

    public abstract void addButtons(HorizontalLayout layout);

    private VerticalLayout createCommonFieldLayout() {
        titelIntern = new TextField("Titel (intern)", "Titel");
        titelIntern.setWidth("100%");

        notice = new TextArea("Notiz (intern)", "Notiz");
        notice.setWidth("100%");

        MemoryBuffer fileBuffer = new MemoryBuffer();
        upload = new Upload(fileBuffer);
        upload.addSucceededListener(event -> {
            cacheFile(event, fileBuffer.getFileData());
        });

        contentLayout = new VerticalLayout(titelIntern, notice, upload);
        return contentLayout;
    }

    private void cacheFile(SucceededEvent event, FileData fileData) {
        String filenameOriginal = fileData.getFileName();
        try {
            String filenameGenerated = fileCacheService.cacheFile(fileData.getOutputBuffer(), filenameOriginal.substring(filenameOriginal.lastIndexOf(".") + 1));
            setImageWithInfos("cache/", filenameGenerated, filenameOriginal, fileData.getMimeType(), event.getContentLength());
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BackgroundElementImageModificationView.class.getName()).log(Level.SEVERE, null, ex);
            add(new Label(ex.getMessage()));
        }
    }

    private void setImageWithInfos(String fileDir, String filenameIntern, String filenameExtern, String mimeType, long sizeInByte) {
        setImage(fileDir + filenameIntern);
        imagePropertyLayout = new VerticalLayout();
        imagePropertyLayout.setMargin(false);
        imagePropertyLayout.setSpacing(false);
        imagePropertyLayout.setPadding(false);
        imagePropertyLayout.setWidth("100%");
        contentLayout.add(imagePropertyLayout);

        this.filenameOriginal = createTextField("Dateiname (original)", filenameExtern, true);
        this.mimeType = createTextField("Mime Type", mimeType, true);
        HorizontalLayout layout = new HorizontalLayout(this.filenameOriginal, this.mimeType);
        layout.setWidth("100%");
        layout.expand(this.filenameOriginal);
        imagePropertyLayout.add(layout);

        this.filenameGenerated = createTextField("Dateiname (generiert)", filenameIntern, true);
        layout = new HorizontalLayout(this.filenameGenerated);
        layout.setWidth("100%");
        layout.expand(this.filenameGenerated);
        imagePropertyLayout.add(layout);

        this.imageSizeInByte = createTextField("Dateigröße", Long.toString(sizeInByte), true);
        imagePropertyLayout.add(new HorizontalLayout(this.imageSizeInByte));

        /*
        this.filenameOriginal = new TextField();
        this.filenameOriginal.setValue(filenameExtern);
        this.filenameOriginal.setReadOnly(true);
        this.filenameOriginal.setWidth("70%");
        FormItem item = imagePropertyLayout.addFormItem(this.filenameOriginal, "Dateiname (original)");

        this.mimeType = new TextField();
        this.mimeType.setValue(mimeType);
        this.mimeType.setReadOnly(true);
        this.mimeType.setWidth("30%");
        imagePropertyLayout.addFormItem(this.mimeType, "Mime Type");

        this.filenameGenerated = new TextField();
        this.filenameGenerated.setValue(filenameIntern);
        this.filenameGenerated.setReadOnly(true);
        imagePropertyLayout.addFormItem(this.filenameGenerated, "Dateiname (generiert)");

        this.imageSizeInByte = new TextField();
        this.imageSizeInByte.setValue(Long.toString(sizeInByte));
        this.imageSizeInByte.setReadOnly(true);
        imagePropertyLayout.addFormItem(this.imageSizeInByte, "Dateigröße");
         */
    }

    public void setImage(String filenameGenerated) {
        if (image != null) {
            remove(image);
        }
        image = new Image(filenameGenerated, "Oje, da ist wohl ein Fehler aufgetreten.");
        image.setWidth("100%");
        contentLayout.add(image);
    }

    private TextField createTextField(String label, String value, boolean enabled) {
        TextField textField = new TextField(label);
        textField.setValue(value);
        textField.setReadOnly(enabled);
        return textField;
    }
}
