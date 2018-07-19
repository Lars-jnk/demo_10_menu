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
@Tag("video")
public class Video extends Component {

    public Video(String src, boolean autoplay, boolean loop, boolean muted) {
        SourceMp4 source = new SourceMp4(src);

        getElement().setAttribute("autoplay", autoplay);
        getElement().setAttribute("loop", loop);
        getElement().setAttribute("muted", muted);
        getElement().appendChild(source.getElement());
    }
}
