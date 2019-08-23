package com.example.handi.cross.model.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by handi.imsi on 21/08/2019.
 */

public class ResponseItemBlog {


    @SerializedName("article_title")
    private String articleTitle;

    @SerializedName("article_image")
    private String articleImage;

    @SerializedName("link")
    private String linkblog;


    public void setArticleTitle(String articleTitle){
        this.articleTitle = articleTitle;
    }

    public String getArticleTitle(){
        return articleTitle;
    }

    public void setArticleImage(String articleImage){
        this.articleImage = articleImage;
    }

    public String getArticleImage(){
        return articleImage;
    }

    public void setLinkblog(String linkblog){
        this.linkblog = linkblog;
    }

    public String getLinkblog(){
        return linkblog;
    }


}

