package com.recipes.application.views;

import com.recipes.application.views.about.AboutView;
import com.recipes.application.views.recipe.RecipeFormView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

public class MainLayout extends AppLayout {

    public static class MenuItemInfo extends ListItem {

        public MenuItemInfo(String menuTitle, Component icon, Class<? extends Component> view) {
            RouterLink link = new RouterLink();
            link.addClassNames(LumoUtility.Display.FLEX, LumoUtility.Gap.XSMALL, LumoUtility.Height.MEDIUM, LumoUtility.AlignItems.CENTER, LumoUtility.Padding.Horizontal.SMALL,
                    LumoUtility.TextColor.BODY);
            link.setRoute(view);

            Span text = new Span(menuTitle);
            text.addClassNames(LumoUtility.FontWeight.MEDIUM, LumoUtility.FontSize.MEDIUM, LumoUtility.Whitespace.NOWRAP);

            if (icon != null) link.add(icon);

            link.add(text);
            add(link);
        }
    }

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addToNavbar(createHeaderContent());
    }

    private Component createHeaderContent() {
        Header header = new Header();
        header.addClassNames(LumoUtility.BoxSizing.BORDER, LumoUtility.Display.FLEX, LumoUtility.FlexDirection.ROW, LumoUtility.Width.FULL);

        Div layout = new Div();
        layout.addClassNames(LumoUtility.Display.FLEX, LumoUtility.AlignItems.CENTER, LumoUtility.Padding.Horizontal.LARGE);

        Image logo = new Image("images/recipes-logo.png", "Logo da Recipes");
        logo.addClassNames(LumoUtility.Padding.MEDIUM, LumoUtility.Height.XLARGE);
        layout.add(logo);

        Nav nav = new Nav();
        nav.addClassNames(LumoUtility.Display.FLEX, LumoUtility.Overflow.AUTO, LumoUtility.Padding.Horizontal.MEDIUM, LumoUtility.Padding.Vertical.XSMALL);

        UnorderedList list = new UnorderedList();
        list.addClassNames(LumoUtility.Display.FLEX, LumoUtility.Gap.SMALL, LumoUtility.ListStyleType.NONE, LumoUtility.Margin.NONE, LumoUtility.Padding.NONE);
        nav.add(list);
        layout.add(nav);

        for (MenuItemInfo menuItem : createMenuItems()) list.add(menuItem);

        header.add(layout);
        return header;
    }

    private MenuItemInfo[] createMenuItems() {
        return new MenuItemInfo[] {
            new MenuItemInfo("Recipe Form", LineAwesomeIcon.BOOK_OPEN_SOLID.create(), RecipeFormView.class),
            new MenuItemInfo("About", LineAwesomeIcon.FILE.create(), AboutView.class)
        };
    }
}
