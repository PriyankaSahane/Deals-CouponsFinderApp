package security.proxy;

import java.io.IOException;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import security.pojo.Admission;
import security.pojo.Course;
import security.pojo.Deals;

@FeignClient(value = "deals-service", url = "http://localhost:8003")
public interface DealsProxy {
	
	@PostMapping(value = "/Deals/addDeals",produces = "application/json")
	public ResponseEntity<Deals> addDeals(@RequestBody @Validated Deals dObj,@RequestHeader("Authorization") String authorization);

	
	@GetMapping(value = "/Deals/getAllDeals", produces = "application/json")
	public ResponseEntity<List<Deals>> getAllDeals(@RequestHeader("Authorization") String authorization);
	
	@GetMapping(value = "/Deals/getByTitle/{title}", produces = "application/json")
	public ResponseEntity<List<Deals>> getByTitle(@RequestHeader("Authorization") String authorization);

	@PutMapping(value="/Deals/updateDeals/{deals_Id}/{title}/{min_prize}/{max_prize}",produces = "application/json")
	public ResponseEntity<Deals> updateDeals(@PathVariable String deals_id,@PathVariable String title,@PathVariable int min_prize,@PathVariable int max_prize,@RequestHeader("Authorization") String authorization);
	
	@DeleteMapping(value="/Deals/deactivateDeals/{deals_id}/{title}",produces = "application/json")
	public ResponseEntity<Deals> deactivateDeals(@PathVariable String deals_id,@PathVariable String title, @RequestHeader("Authorization") String authorization);
	
}
