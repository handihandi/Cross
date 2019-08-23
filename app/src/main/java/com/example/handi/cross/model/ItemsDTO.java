package com.example.handi.cross.model;


import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class ItemsDTO implements Serializable {

	@SerializedName("product_name")
	private String productName;

	@SerializedName("product_image")
	private String productImage;

	@SerializedName("link")
	private String link;



	@SerializedName("article_title")
	private String articleTitle;

	@SerializedName("article_image")
	private String articleImage;

	//@SerializedName("link")
//	private String linkblog;


	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getProductName(){
		return productName;
	}

	public void setProductImage(String productImage){
		this.productImage = productImage;
	}

	public String getProductImage(){
		return productImage;
	}

	public void setLink(String link){
		this.link = link;
	}

	public String getLink(){
		return link;
	}



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

	//public void setLinkblog(String linkblog){
	//	this.linkblog = linkblog;
	//}

	//public String getLinkblog(){
	//	return linkblog;
	//}


	@Override
 	public String toString(){
		return 
			"ItemsDTO{" + 
			"product_name = '" + productName + '\'' + 
			",product_image = '" + productImage + '\'' + 
			",link = '" + link + '\'' +
			"}";
		}
}