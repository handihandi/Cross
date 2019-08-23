package com.example.handi.cross.model.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by handi.imsi on 21/08/2019.
 */

public class ResponseItems  implements Serializable {

    @SerializedName("product_name")
    private String productName;

    @SerializedName("product_image")
    private String productImage;

    @SerializedName("link")
    private String linkproduct;


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

    public void setLinkProduct(String linkproduct){
        this.linkproduct = linkproduct;
    }

    public String getLinkProduct(){
        return linkproduct;
    }


}
