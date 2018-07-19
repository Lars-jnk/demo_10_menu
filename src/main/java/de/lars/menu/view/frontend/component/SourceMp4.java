/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.frontend.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;

/**
 *
 * @author Tobias
 */
@Tag("source")
public class SourceMp4 extends Component {

    private static final String REGEX_MP4 = ".*\\.mp4$";

    public SourceMp4(String src) {
        if (src.matches(REGEX_MP4) == false) {
            throw new IllegalArgumentException("only mp4 videos");
        }

        getElement().setAttribute("src", src);
        getElement().setAttribute("type", "video/mp4");
    }
}
