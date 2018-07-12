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
public class Source extends Component {

    public Source() {
        getElement().setAttribute("src", "video/video1.mp4");
        getElement().setAttribute("type", "video/mp4");
    }
}
