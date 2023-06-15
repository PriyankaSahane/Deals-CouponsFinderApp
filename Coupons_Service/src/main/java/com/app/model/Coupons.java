package com.app.model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
//import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "Coupon")
public class Coupons {
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    @Id
	int coupon_id;
    
	String title;
   
	String coupon_category;
    
	String link;
    
	String icon_link;
   
	String view_details;
    
    public Coupons() {
    	
    }
    
    public Coupons(int coupon_id, @NotBlank @Size(max = 100) String title,
			@NotBlank @Size(max = 100) String coupon_category, @NotBlank @Size(max = 100) String link,
			@NotBlank @Size(max = 100) String icon_link, @NotBlank @Size(max = 100) String view_details) {
		super();
		this.coupon_id = coupon_id;
		this.title = title;
		this.coupon_category = coupon_category;
		this.link = link;
		this.icon_link = icon_link;
		this.view_details = view_details;
	}
	public int getCoupon_id() {
		return coupon_id;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getView_details() {
		return view_details;
	}

	public void setView_details(String view_details) {
		this.view_details = view_details;
	}

	public void setCoupon_id(int l) {
		this.coupon_id = l;
	}
	public String getCoupon_category() {
		return coupon_category;
	}
	public void setCoupon_category(String coupon_category) {
		this.coupon_category = coupon_category;
	}
	public String getIcon_link() {
		return icon_link;
	}
	public void setIcon_link(String icon_link) {
		this.icon_link = icon_link;
	}
	@Override
	public String toString() {
		return "Deals [coupon_id=" + coupon_id + ", title=" + title + ", coupon_category=" + coupon_category + ", link="
				+ link + ", icon_link=" + icon_link + ", view_details=" + view_details + "]";
	}
}
