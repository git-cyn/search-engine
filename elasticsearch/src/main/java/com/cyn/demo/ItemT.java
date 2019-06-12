package com.cyn.demo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Document(indexName = "item",type = "docs", shards = 1, replicas = 0)
public class ItemT implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
	 * @Description: @Id注解必须是springframework包下的
	 * org.springframework.data.annotation.Id						
	 */
    @Id
    private Long id;
    
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title; //标题
    
    @Field(type = FieldType.Keyword)
    private String category;// 分类
    
    @Field(type = FieldType.Keyword)
    private String brand; // 品牌
    
    @Field(type = FieldType.Double)
    private Double price; // 价格
    
    @Field(index = false, type = FieldType.Keyword)
    private String images; // 图片地址

    public ItemT() {
    }

    public ItemT(Long id, String title, String category, String brand, Double price, String images) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.images = images;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
