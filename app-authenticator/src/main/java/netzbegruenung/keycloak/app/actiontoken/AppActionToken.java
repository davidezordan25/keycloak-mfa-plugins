package netzbegruenung.keycloak.app.actiontoken;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.keycloak.authentication.actiontoken.DefaultActionToken;

public class AppActionToken extends DefaultActionToken {

	public static final String TOKEN_TYPE = "app-action-token";

	private static final String JSON_FIELD_ORIGINAL_AUTHENTICATION_SESSION_ID = "oasid";

	@JsonProperty(value = JSON_FIELD_ORIGINAL_AUTHENTICATION_SESSION_ID)
	private String originalAuthenticationSessionId;

	public AppActionToken(String userId, int absoluteExpirationInSecs, String compoundAuthenticationSessionId, String clientId) {
		super(userId, TOKEN_TYPE, absoluteExpirationInSecs, null);
		this.issuer = clientId;
		this.originalAuthenticationSessionId = compoundAuthenticationSessionId;
	}

	private AppActionToken() {
		// Required to deserialize from JWT
		super();
	}

	public String getOriginalCompoundAuthenticationSessionId() {
		return originalAuthenticationSessionId;
	}

	public void setOriginalCompoundAuthenticationSessionId(String originalCompoundAuthenticationSessionId) {
		this.originalAuthenticationSessionId = originalCompoundAuthenticationSessionId;
	}
}
