package de.lars.menu.view.backend;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import de.lars.menu.view.backend.article.ArticleListView;
import de.lars.menu.view.backend.demo.Form2View;
import de.lars.menu.view.backend.demo.FormView;
import de.lars.menu.view.backend.demo.HomeView;
import de.lars.menu.view.backend.demo.MyComboBoxView;
import de.lars.menu.view.backend.demo.MyTabView;
import de.lars.menu.view.backend.demo.ServiceView;
import de.lars.menu.view.backend.demo.TabView;
import de.lars.menu.view.backend.menu.Menu;
import de.lars.menu.view.backend.menu.MenuGroup;
import de.lars.menu.view.backend.startpage.content.StartpageContentListView;

/**
 * The main view contains a button and a template element.
 */
@Route(BackendView.ROUTE)
@PageTitle("Backend")
public class BackendView extends HorizontalLayout implements RouterLayout {

    public static final String ROUTE = "backend";

    public BackendView() {
        setWidth("100%");
        setClassName("be-content");

        Menu menu = new Menu("Backend");

        MenuGroup groupStartpage = new MenuGroup("Startseite");
        groupStartpage.addLink("Content", StartpageContentListView.class);
        menu.add(groupStartpage);

        MenuGroup groupBtn = new MenuGroup("Demo");
        groupBtn.addLink("Article", ArticleListView.class);
        groupBtn.addLink("Ein Test", HomeView.class);
        groupBtn.addLink("ServiceView", ServiceView.class);
        groupBtn.addLink("der neue Service", ServiceView.class);
        groupBtn.addLink("Wichtig!", HomeView.class);
        groupBtn.addLink("Tabs", TabView.class);
        groupBtn.addLink("My Tabs", MyTabView.class);
        groupBtn.addLink("My Combobox", MyComboBoxView.class);
        menu.add(groupBtn);

        MenuGroup groupBtn2 = new MenuGroup("Zweites");
        groupBtn2.addLink("Form", FormView.class);
        groupBtn2.addLink("Form2", Form2View.class);
        groupBtn2.addLink("MenuLink", HomeView.class);
        groupBtn2.addLink("Infos", ServiceView.class);
        menu.add(groupBtn2);

        add(menu);
    }
}
