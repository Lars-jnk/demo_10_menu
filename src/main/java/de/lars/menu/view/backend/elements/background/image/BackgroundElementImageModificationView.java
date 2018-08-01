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
import de.lars.menu.component.layout.ScrollableVerticalLayout;
import de.lars.menu.dto.ImageDto;
import de.lars.menu.entity.element.background.BackgroundElementImage;
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
    private TextField titelIntern;
    private TextArea notice;
    private Upload upload;

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
            ImageDto imageDto = fileCacheService.cacheFile(fileData, event.getContentLength());
            //String filenameGenerated = fileCacheService.cacheFile(fileData.getOutputBuffer(), filenameOriginal.substring(filenameOriginal.lastIndexOf(".") + 1));
            //BufferedImage imgBuffer = ImageIO.read(new File("cache/" + filenameGenerated));
            //setImageWithInfos("cache/", filenameGenerated, filenameOriginal, fileData.getMimeType(), imgBuffer.getWidth(), imgBuffer.getHeight(), event.getContentLength());
            setImageWithInfos(imageDto);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BackgroundElementImageModificationView.class.getName()).log(Level.SEVERE, null, ex);
            add(new Label(ex.getMessage()));
        } catch (IOException ex) {
            Logger.getLogger(BackgroundElementImageModificationView.class.getName()).log(Level.SEVERE, null, ex);
            add(new Label(ex.getMessage()));
        }
    }

    //private void setImageWithInfos(String fileDir, String filenameIntern, String filenameExtern, String mimeType, int width, int height, long sizeInByte) {
    private void setImageWithInfos(ImageDto imageDto) {
        setImage(imageDto.directory + "/" + imageDto.filenameGenerated);
        imagePropertyLayout = new VerticalLayout();
        imagePropertyLayout.setMargin(false);
        imagePropertyLayout.setSpacing(false);
        imagePropertyLayout.setPadding(false);
        imagePropertyLayout.setWidth("100%");
        contentLayout.add(imagePropertyLayout);

        filenameOriginal = createTextField("Dateiname (original)", imageDto.filenameOriginal, true);
        mimeType = createTextField("Mime Type", imageDto.mimeType, true);
        HorizontalLayout layout = new HorizontalLayout(filenameOriginal, mimeType);
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
        layout.expand(imageWidth);
        layout.expand(imageHeight);
        layout.expand(imageSizeInByte);
        imagePropertyLayout.add(layout);
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
