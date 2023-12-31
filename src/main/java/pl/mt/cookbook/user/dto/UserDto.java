package pl.mt.cookbook.user.dto;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import pl.mt.cookbook.ProperPassword;

import java.util.Date;
import java.util.Set;

public class UserDto {
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
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
    private boolean newsletter;
    private Set<String> roles;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isNewsletter() {
        return newsletter;
    }

    public void setNewsletter(boolean newsletter) {
        this.newsletter = newsletter;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
