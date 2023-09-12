package bg.distilery.models.user.dto;


import bg.distilery.validation.MatchingFields;
import bg.distilery.validation.UniqueUsername;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@MatchingFields(first = "password", second = "repeatPassword")
public class RegisterDto {
    @NotBlank
    @UniqueUsername
    private String username;

    @NotBlank
    @Length(min = 8, max = 32)
    private String password;

    private String repeatPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
