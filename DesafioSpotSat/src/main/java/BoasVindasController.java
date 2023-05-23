package main.java;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.json.JSONObject;

@RestController
@RequestMapping("/v1")
public class BoasVindasController {
	 @GetMapping("/")
	 public ResponseEntity<?> getWelcomeMessage() {
	    JSONObject response = new JSONObject();
	    response.put("message", "Bem vindo a API GeoPoly!");
	    return ResponseEntity.ok(response.toString());
		 }
}