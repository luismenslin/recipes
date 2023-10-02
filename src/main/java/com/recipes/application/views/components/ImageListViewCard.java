package com.recipes.application.views.components;

import com.recipes.application.data.model.Recipe.Recipe;
import com.recipes.application.views.recipe.RecipeView;
import com.vaadin.flow.component.UI;
import com.recipes.application.data.repository.recipe.RecipeJdbcRepository;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility.Position;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.Background;
import com.vaadin.flow.theme.lumo.LumoUtility.BorderRadius;
import com.vaadin.flow.theme.lumo.LumoUtility.Display;
import com.vaadin.flow.theme.lumo.LumoUtility.FlexDirection;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.FontWeight;
import com.vaadin.flow.theme.lumo.LumoUtility.JustifyContent;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.Overflow;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import com.vaadin.flow.theme.lumo.LumoUtility.Width;
import org.vaadin.lineawesome.LineAwesomeIcon;

import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicReference;

public class ImageListViewCard extends ListItem {

    private final RecipeJdbcRepository repository = new RecipeJdbcRepository();

    public ImageListViewCard(String text, String url, String description, Long itemId) throws SQLException {
        getStyle().set("cursor", "pointer");

        addClassNames(Background.CONTRAST_5, Display.FLEX, FlexDirection.COLUMN, AlignItems.START, Padding.MEDIUM,
                BorderRadius.LARGE, Position.RELATIVE);

        Div div = new Div();
        div.addClassNames(Background.CONTRAST, Display.FLEX, AlignItems.CENTER, JustifyContent.CENTER,
                Margin.Bottom.MEDIUM, Overflow.HIDDEN, BorderRadius.MEDIUM, Width.FULL);
        div.setHeight("160px");

        Image image = new Image();
        image.setWidth("100%");
        image.setSrc(url);
        image.setAlt(text);

        div.add(image);

        Span header = new Span();
        header.addClassNames(FontSize.XLARGE, FontWeight.SEMIBOLD);
        header.setText(text);

        Paragraph descriptionView = new Paragraph(description);
        descriptionView.addClassName(Margin.Vertical.MEDIUM);

        Component favButton = createFavoriteButton(itemId);
        favButton.removeFromParent();

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(div, header, descriptionView);
        verticalLayout.addClickListener(event -> {
            UI.getCurrent().navigate(RecipeView.class, itemId);
        });

        add(verticalLayout, favButton);
    }

    private Component createFavoriteButton(Long itemId) throws SQLException {
        Recipe recipe = repository.findById(itemId);

        Div favoriteButtonDiv = new Div();
        favoriteButtonDiv.getStyle().set("bottom", "10px");
        favoriteButtonDiv.getStyle().set("right", "10px");
        favoriteButtonDiv.getStyle().set("position", "absolute");

        Component heartEmpty = LineAwesomeIcon.HEART.create();
        Component heartSolid = LineAwesomeIcon.HEART_SOLID.create();
        AtomicReference<Component> actualHeart = new AtomicReference<>(recipe.getFavorite() ? heartSolid : heartEmpty);
        favoriteButtonDiv.add(actualHeart.get());

        favoriteButtonDiv.addClickListener(event -> {
            try {
                if (actualHeart.get() == heartEmpty) {
                    favoriteButtonDiv.replace(heartEmpty, heartSolid);
                    actualHeart.set(heartSolid);
                } else {
                    favoriteButtonDiv.replace(heartSolid, heartEmpty);
                    actualHeart.set(heartEmpty);
                }

                recipe.setFavorite(!recipe.getFavorite());
                repository.update(recipe);
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao favoritar receita " + e);
            }
        });

        return favoriteButtonDiv;
    }
}
