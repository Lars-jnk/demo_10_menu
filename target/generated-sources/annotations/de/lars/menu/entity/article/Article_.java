package de.lars.menu.entity.article;

import de.lars.menu.entity.article.ArticlePart;
import de.lars.menu.enums.ArticleStatus;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-15T21:22:03")
@StaticMetamodel(Article.class)
public class Article_ { 

    public static volatile SingularAttribute<Article, String> path;
    public static volatile SingularAttribute<Article, Date> created;
    public static volatile ListAttribute<Article, ArticlePart> parts;
    public static volatile SingularAttribute<Article, Long> id;
    public static volatile SingularAttribute<Article, String> headline;
    public static volatile SingularAttribute<Article, ArticleStatus> status;

}