package app.quantun.langchanin.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.util.Map;

/**
 * DTO for {@link com.google.firebase.auth.UserRecord}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRecordDto implements Serializable {

    private String uid;
    private String email;
    private String phoneNumber;
    private boolean emailVerified;
    private String displayName;
    private String photoUrl;
    private boolean disabled;


    private  Map<String,Object>  customClaims;
}
