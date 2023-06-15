package com.app.model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
//import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "Deals")
public class Deals {
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    @Id
	int deal_id;  
	String title;
	String deal_category;
	String link;
	String icon_link;
	String view_deal;
	String img;
	
	
	public Deals() {
		
	}
	
	
	public int getDeal_id() {
		return deal_id;
	}
	public void setDeal_id(int deal_id) {
		this.deal_id = deal_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDeal_category() {
		return deal_category;
	}
	public void setDeal_category(String deal_category) {
		this.deal_category = deal_category;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getIcon_link() {
		return icon_link;
	}
	public void setIcon_link(String icon_link) {
		this.icon_link = icon_link;
	}
	public String getView_deal() {
		return view_deal;
	}
	public void setView_deal(String view_deal) {
		this.view_deal = view_deal;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}


	@Override
	public String toString() {
		return "Deals [deal_id=" + deal_id + ", title=" + title + ", deal_category=" + deal_category + ", link=" + link
				+ ", icon_link=" + icon_link + ", view_deal=" + view_deal + ", img=" + img + "]";
	}
    
	
	
}
