/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.elements.background.image;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.formlayout.FormLayout;
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

    private String strFilenameIntern;
    private String strFilenameExtern;
    private String strMimeType;
    private String alternativeText;
    private int width;
    private int height;
    private long sizeInByte;

    private ScrollableVerticalLayout panel;

    private VerticalLayout commonLayout;
    private TextField titelIntern;
    private TextArea notice;
    private Upload upload;

    private FormLayout imageLayout;
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
        setHeight("100vh");
        addButtonLayout();

        panel = new ScrollableVerticalLayout();
        panel.add(createCommonFieldLayout());

        add(panel);
    }

    public BackgroundElementImage getBackgroundImage() {
        BackgroundElementImage bgImage = new BackgroundElementImage();
        bgImage.setFilenameExtern(strFilenameExtern);
        bgImage.setFilenameIntern(strFilenameIntern);
        bgImage.setMimeType(strMimeType);
        bgImage.setSizeInByte(1234);
        bgImage.setWidth(3000);
        bgImage.setHeight(2000);

        bgImage.setAltervativeText("alt Text");

        bgImage.setInternTitle("Titel");
        bgImage.setNotice("Notiz");

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

        commonLayout = new VerticalLayout(titelIntern, notice, upload);
        commonLayout.addClassName("be-content-layout");
        return commonLayout;
    }

    private void cacheFile(SucceededEvent event, FileData fileData) {
        strFilenameExtern = fileData.getFileName();
        strMimeType = fileData.getMimeType();
        sizeInByte = event.getContentLength();

        try {
            strFilenameIntern = fileCacheService.cacheFile(fileData.getOutputBuffer(), strFilenameExtern.substring(strFilenameExtern.lastIndexOf(".") + 1));
            setImageWithInfos("cache/" + strFilenameIntern);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BackgroundElementImageModificationView.class.getName()).log(Level.SEVERE, null, ex);
            add(new Label(ex.getMessage()));
        }
    }

    private void setImageWithInfos(String filename) {
        setImage(filename);
    }

    public void setImage(String filenameGenerated) {
        if (image != null) {
            remove(image);
        }
        image = new Image(filenameGenerated, "Oje, da ist wohl ein Fehler aufgetreten.");
        image.setWidth("100%");
        panel.add(image);
    }
}
