/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.entity.element.background;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Tobias
 */
@Entity
@Table(name = "element_background_image")
public class BackgroundElementImage extends BackgroundElement {

    public static final String DIR = "images";

    @Column(name = "filename_intern", length = 512)
    private String filenameIntern;

    @Column(name = "filename_extern", length = 512)
    private String filenameExtern;

    @Column(name = "mime_type", length = 64)
    private String mimeType;

    @Column(name = "width")
    private int width;

    @Column(name = "height")
    private int height;

    @Column(name = "altervative_text", length = 512)
    private String altervativeText;

    public String getFilenameIntern() {
        return filenameIntern;
    }

    public void setFilenameIntern(String filenameIntern) {
        this.filenameIntern = filenameIntern;
    }

    public String getFilenameExtern() {
        return filenameExtern;
    }

    public void setFilenameExtern(String filenameExtern) {
        this.filenameExtern = filenameExtern;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getAltervativeText() {
        return altervativeText;
    }

    public void setAltervativeText(String altervativeText) {
        this.altervativeText = altervativeText;
    }

}
