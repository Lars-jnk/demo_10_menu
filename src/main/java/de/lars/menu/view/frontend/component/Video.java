/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.frontend.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;

/**
 *
 * @author Tobias
 */
@Tag("video")
public class Video extends Component implements HasStyle {

    public Video() {
        Source source = new Source();

        setClassName("fe-video");

        getElement().setAttribute("poster", "img/videoframe.jpg");
        getElement().setAttribute("loop", true);
        getElement().setAttribute("muted", true);
        getElement().setAttribute("autoplay", true);
        getElement().appendChild(source.getElement());
    }
}
