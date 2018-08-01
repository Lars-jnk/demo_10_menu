/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author Lars
 */
@SessionScoped
public class FileCacheService implements Serializable {

    private final static String PATH_1 = "c:\\_dev\\_fugy\\_source\\demo_10_menu\\target\\demo_10_menu_git-1.0-SNAPSHOT\\";
    private final static String PATH_2 = "c:\\_dev\\_fugy\\_source\\demo_10_menu\\src\\main\\webapp\\";
    //private final static List<String>  = {"cache", "images", "videos"};

    @Inject
    private NameGenService nameGenService;

    public String cacheFile(OutputStream outputBuffer, String suffix) throws IllegalAccessException {
        createDir(PATH_1 + "cache");
        createDir(PATH_2 + "cache");

        String filenameIntern = nameGenService.generate(suffix);

        saveFileInCache(outputBuffer, PATH_1 + "cache\\" + filenameIntern);
        saveFileInCache(outputBuffer, PATH_2 + "cache\\" + filenameIntern);

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
