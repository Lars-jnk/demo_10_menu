/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.backend.startpage.content.component;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.upload.Receiver;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.FileData;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 *
 * @author Tobias
 */
public class BackgroundTab extends Tab {

    private final static String PATH = "c:\\Users\\Tobias\\Desktop\\vaadin\\demo_10_menu\\target\\demo_10_menu_git-1.0-SNAPSHOT\\";

    private String backgroundFilename;
    private String backgroundFilenameTmpAbs;
    private String backgroundMimeType;

    public BackgroundTab() {
        MemoryBuffer fileBuffer = new MemoryBuffer();
        Upload upload = new Upload(fileBuffer);
        add(upload);

        upload.addSucceededListener(event -> {
            FileData f = fileBuffer.getFileData();
            backgroundFilename = f.getFileName();
            backgroundMimeType = f.getMimeType();
            backgroundFilenameTmpAbs = PATH + "\\cache\\" + backgroundFilename;
            try {
                Receiver receiver = upload.getReceiver();
                ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) f.getOutputBuffer();

                OutputStream outputStream = new FileOutputStream(backgroundFilenameTmpAbs);
                byteArrayOutputStream.writeTo(outputStream);
                outputStream.close();

                Image image = new Image("cache/" + backgroundFilename, "nichts...");
                image.setWidth("600px");
                add(image);
            } catch (Exception e) {
                add(new Label("Oje! - " + e.getMessage()));
                System.err.println(e.getMessage() + " : ");
            }
            /*
            Component component = createComponent(event.getMIMEType(),
                    event.getFileName(),
                    upload.getInputStream(event.getFileName()));
            showOutput(event.getFileName(), component, output);
             */
        });
    }
}
