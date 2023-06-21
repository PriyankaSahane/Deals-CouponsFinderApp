package security.pojo;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
//import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Document(collection = "Deals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Deals implements Serializable{
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    @Id
	String deals_id;  
	String title;
	String deal_category;
	String link;
	String icon_link;
	String view_deal;
	String img;
	int min_prize;
	int max_prize;
	
}
