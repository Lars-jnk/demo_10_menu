/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.service;

import com.vaadin.flow.component.upload.receivers.FileData;
import de.lars.menu.dto.ImageDto;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;

/**
 *
 * @author Lars
 */
@SessionScoped
public class FileCacheService implements Serializable {

    private final static String PATH_1 = "c:\\_dev\\_fugy\\_source\\demo_10_menu\\target\\demo_10_menu_git-1.0-SNAPSHOT\\";
    private final static String PATH_2 = "c:\\_dev\\_fugy\\_source\\demo_10_menu\\src\\main\\webapp\\";
    private final static String DIR_CACHE = "cache";
    //private final static List<String>  = {"cache", "images", "videos"};

    @Inject
    private NameGenService nameGenService;

    public ImageDto cacheFile(FileData fileData, long contentLength) throws IllegalAccessException, IOException {
        String suffix = fileData.getFileName().substring(fileData.getFileName().lastIndexOf(".") + 1);
        String filenameGenerated = cacheFile(fileData.getOutputBuffer(), suffix);

        BufferedImage imgBuffer = ImageIO.read(new File(PATH_1 + DIR_CACHE + "\\" + filenameGenerated));

        ImageDto imageDto = new ImageDto();
        imageDto.directory = DIR_CACHE;
        imageDto.filenameGenerated = filenameGenerated;
        imageDto.filenameOriginal = fileData.getFileName();
        imageDto.mimeType = fileData.getMimeType();
        imageDto.width = imgBuffer.getWidth();
        imageDto.height = imgBuffer.getHeight();
        imageDto.sizeInByte = contentLength;

        return imageDto;
    }

    private String cacheFile(OutputStream outputBuffer, String suffix) throws IllegalAccessException {
        createDir(PATH_1 + DIR_CACHE);
        createDir(PATH_2 + DIR_CACHE);

        String filenameIntern = nameGenService.generate(suffix);

        saveFileInCache(outputBuffer, PATH_1 + DIR_CACHE + "\\" + filenameIntern);
        saveFileInCache(outputBuffer, PATH_2 + DIR_CACHE + "\\" + filenameIntern);

        return filenameIntern;
    }

    private void createDir(String dir) {
        File path = new File(dir);
        if (path.exists() == false) {
            path.mkdir();
        }
    }

    private void saveFileInCache(OutputStream outputBuffer, String filenameAbs) throws IllegalAccessException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) outputBuffer;
            OutputStream outputStream = new FileOutputStream(filenameAbs);
            byteArrayOutputStream.writeTo(outputStream);
            outputStream.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            throw new IllegalAccessException("Oje - " + filenameAbs);
        }
    }
}
