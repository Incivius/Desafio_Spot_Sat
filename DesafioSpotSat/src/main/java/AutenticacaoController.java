package main.java;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class AutenticacaoController {
	@PostMapping("/v1/auth")
	public ResponseEntity<?> authenticate(@RequestBody ObjectNode request) {
	    if (!request.has("email") || !request.has("password")) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	            .body(createResponse("Formato da requisição inválido!"));
	    }

	    String email = request.get("email").asText();
	    String password = request.get("password").asText();

	    if ("admin@exemplo.com.br".equals(email) && "abcd1234".equals(password)) {
	        return ResponseEntity.ok().body(createResponse("Autenticado com sucesso!"));
	    } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	            .body(createResponse("Falha ao autenticar!"));
	    }
	}
	private ObjectNode createResponse(String message) {
	    ObjectMapper mapper = new ObjectMapper();
	    ObjectNode response = mapper.createObjectNode();
	    response.put("message", message);
	    return response;
	}
}