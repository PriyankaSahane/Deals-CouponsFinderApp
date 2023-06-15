package com.app.entities;
import lombok.Setter;
import lombok.Getter;

//import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("Merchant")
public class Merchant {
	@Id
	 private String merchant_id;
	 private String name;
	 private String email;
	 private String phone_number;
	// private String address;
	 //private Date created_at;
	// private Date updated_at;
}
