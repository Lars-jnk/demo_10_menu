package de.lars.menu.entity.article;

import de.lars.menu.entity.article.Article;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-15T21:22:03")
@StaticMetamodel(ArticlePart.class)
public abstract class ArticlePart_ { 

    public static volatile SingularAttribute<ArticlePart, Long> id;
    public static volatile SingularAttribute<ArticlePart, Integer> position;
    public static volatile SingularAttribute<ArticlePart, Article> article;

}