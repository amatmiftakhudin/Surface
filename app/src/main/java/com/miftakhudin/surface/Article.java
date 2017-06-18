package com.miftakhudin.surface;

/**
 * Created by miftakhudin on 6/11/17.
 */

public class Article {
    private String article_title;
    private String article_description;


    public Article(String article_title, String article_description) {
        this.article_title = article_title;
        this.article_description = article_description;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_description() {
        return article_description;
    }

    public void setArticle_description(String article_description) {
        this.article_description = article_description;
    }
}
