package de.lars.menu.view.backend;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import de.lars.menu.view.backend.article.ArticleListView;
import de.lars.menu.view.backend.demo.Form2View;
import de.lars.menu.view.backend.demo.FormView;
import de.lars.menu.view.backend.demo.HelloView;
import de.lars.menu.view.backend.demo.HomeView;
import de.lars.menu.view.backend.demo.MyComboBoxView;
import de.lars.menu.view.backend.demo.MyDropDownView;
import de.lars.menu.view.backend.demo.MyTabView;
import de.lars.menu.view.backend.demo.PanelView;
import de.lars.menu.view.backend.demo.ServiceView;
import de.lars.menu.view.backend.demo.TabView;
import de.lars.menu.view.backend.elements.background.BackgroundElementListView;
import de.lars.menu.view.backend.menu.Menu;
import de.lars.menu.view.backend.menu.MenuGroup;
import de.lars.menu.view.backend.polymer.helloworld.HelloWorldView;
import de.lars.menu.view.backend.startpage.content.StartpageContentListView;

/**
 * The main view contains a button and a template element.
 */
@Route(BackendView.ROUTE)
@PageTitle("Backend")
public class BackendView extends HorizontalLayout implements RouterLayout {

    public static final String ROUTE = "backend";
    public static final String PROJECT_NAME = "demo_10_menu";

    public BackendView() {
        setSpacing(false);
        setWidth("100%");
        setClassName("be-view");

        Menu menu = new Menu("Backend");

        MenuGroup groupStartpage = new MenuGroup("Startseite");
        groupStartpage.addLink("Content", StartpageContentListView.class);
        menu.add(groupStartpage);

        MenuGroup groupElements = new MenuGroup("Elemente");
        groupElements.addLink("Hintergründe", BackgroundElementListView.class);
        menu.add(groupElements);

        MenuGroup groupBtn = new MenuGroup("Demo");
        groupBtn.addLink("Article", ArticleListView.class);
        groupBtn.addLink("Hello", HelloView.class);
        groupBtn.addLink("Ein Test", HomeView.class);
        groupBtn.addLink("ServiceView", ServiceView.class);
        groupBtn.addLink("Tabs", TabView.class);
        groupBtn.addLink("My Tabs", MyTabView.class);
        groupBtn.addLink("My Combobox", MyComboBoxView.class);
        groupBtn.addLink("My Dropdown", MyDropDownView.class);
        groupBtn.addLink("Panel Test", PanelView.class);
        menu.add(groupBtn);

        MenuGroup groupPolymer = new MenuGroup("Polymer");
        groupPolymer.addLink("Hallo Welt", HelloWorldView.class);
        menu.add(groupPolymer);

        MenuGroup groupBtn2 = new MenuGroup("Zweites");
        groupBtn2.addLink("Form", FormView.class);
        groupBtn2.addLink("Form2", Form2View.class);
        groupBtn2.addLink("MenuLink", HomeView.class);
        groupBtn2.addLink("Infos", ServiceView.class);
        menu.add(groupBtn2);

        add(menu);
    }
}
