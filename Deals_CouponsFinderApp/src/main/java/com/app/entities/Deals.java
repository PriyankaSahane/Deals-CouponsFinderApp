package com.app.entities;
import lombok.Setter;
import lombok.Getter;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("Deals")
public class Deals {
  @Id
  private String deal_id;
  private String merchant_id;
  private String merchant_name;
  private String title;
  private String image_url;
  private String category;
  private String prize;
  private String discount;
  private Date start_date;
  private Date end_date;
 
}
