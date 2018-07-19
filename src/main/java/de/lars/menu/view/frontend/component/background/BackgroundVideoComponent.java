/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.frontend.component.background;

import com.vaadin.flow.component.HasStyle;
import de.lars.menu.view.frontend.component.Video;

/**
 *
 * @author Tobias
 */
public class BackgroundVideoComponent extends Video implements HasStyle {

    public BackgroundVideoComponent(String src) {
        super(src, true, true, true);

        addClassName("fullview");
        addClassName("fe-content-bg-video");
    }
}
