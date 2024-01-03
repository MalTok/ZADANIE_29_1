package pl.mt.cookbook.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import pl.mt.cookbook.ProperPassword;

public class UserAddDto {
    @NotBlank
    @Size(min = 2, max = 255)
    @Email(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$") // RFC 5322
    private String email;
    @NotBlank
    @Size(min = 8, max = 255, message = "Hasło musi mieć minimalną długość {min} znaków")
//    alternatywnie: @Pattern(regexp = "^(?=.*[a-ząćęłńóśźż])(?=.*[A-ZĄĆĘŁŃÓŚŹŻ])(?=.*[0-9])(?=.*[@#$%^&+=!]).*$",
//            message = "Hasło musi zawierać min. 1 małą i 1 dużą literę, 1 znak specjalny, 1 cyfrę")
    @ProperPassword
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
