/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.lars.menu.view.frontend;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import de.lars.menu.service.SessionService;
import de.lars.menu.view.frontend.component.Text;
import de.lars.menu.view.frontend.component.Video;
import de.lars.menu.view.frontend.component.background.BackgroundImageComponent;
import de.lars.menu.view.frontend.component.background.BackgroundVideoComponent;
import de.lars.menu.view.frontend.content.ContentContainerFullView;
import de.lars.menu.view.frontend.content.TextBgImageContent;
import de.lars.menu.view.frontend.content.TextBgVideoContent;
import de.lars.menu.view.frontend.header.Header;
import de.lars.menu.view.frontend.header.HeaderBox;
import javax.inject.Inject;

/**
 *
 * @author syrinx
 */
@Route("")
@PageTitle("Baltrum")
@StyleSheet("styles/frontend/main-styles.css")
@StyleSheet("styles/frontend/content.css")
@StyleSheet("styles/common.css")
public class FrontendView extends VerticalLayout implements RouterLayout {

    @Inject
    private SessionService sessionService;

    public FrontendView() {
        setWidth("100%");
        setSpacing(false);
        setClassName("fe-main");

        HeaderBox headerBox = new HeaderBox();
        Header header = new Header();
        headerBox.add(header);
        add(headerBox);

        BackgroundImageComponent image = new BackgroundImageComponent("images/img.jpg", "Da klappte was nicht. :O");
        ContentContainerFullView ccfv = new ContentContainerFullView();
        ccfv.setBackground(image);
        Text text = new Text();
        ccfv.add(text);
        add(ccfv);

        BackgroundVideoComponent video = new BackgroundVideoComponent("video/video1.mp4");
        text = new Text();
        ccfv = new ContentContainerFullView();
        ccfv.setBackground(video);
        ccfv.add(text);
        add(ccfv);

        image = new BackgroundImageComponent("images/P1070112.JPG", "Da klappte was nicht. :O");
        VerticalLayout textContent = new VerticalLayout();
        textContent.setClassName("fe-main-image-text-content");
        Label lblHeadline = new Label("hallo");
        lblHeadline.setClassName("fe-main-image-headline");
        textContent.add(lblHeadline);
        Label lblText = new Label("das ist längerer text");
        lblText.setClassName("fe-main-image-text");
        textContent.add(lblText);

        ccfv = new ContentContainerFullView();
        ccfv.setBackground(image);
        ccfv.add(textContent);
        add(ccfv);

        VerticalLayout layout = new VerticalLayout();
        layout.setClassName("fe-main-content");
        layout.add(new Label("asdf"));
        layout.add(new TextField("adfgagg"));
        add(layout);

        TextBgImageContent mainContent = new TextBgImageContent("http://localhost:8080/demo_10_menu/image?name=img.jpg");
        add(mainContent);
    }
}
