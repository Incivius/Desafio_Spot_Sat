import org.springframework.data.annotation.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class AuthRequest {
    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;
}