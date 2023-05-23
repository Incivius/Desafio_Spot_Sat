import javax.ws.rs.Path;
import org.json.JSONObject;


@Path("/v1")
public class APIController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getResponse() {
        JSONObject response = new JSONObject();
        response.put("message", "Mensagem padrão");
        
        return response.toString();
    }
}