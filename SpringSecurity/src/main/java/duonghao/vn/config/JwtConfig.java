package duonghao.vn.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.jwt")
public class JwtConfig {
    private String secret;
    private int expirationMs;

    // Getters/Setters
    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public int getExpirationMs() {
        return expirationMs;
    }

    public void setExpirationMs(int expirationMs) {
        this.expirationMs = expirationMs;
    }

	public JwtConfig(String secret, int expirationMs) {
		super();
		this.secret = secret;
		this.expirationMs = expirationMs;
	}

	public JwtConfig() {
		super();
	}
    
}