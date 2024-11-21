package sg.edu.nus.issq.vttp_day13_lecture.model;

import java.util.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Person {

    // @NotNull(message="id must be auto generated")
    private String id;

    @NotEmpty(message = "first name is required")
    @Size(min = 3, max = 20, message = "first name must be between 3 to 60 characters")
    private String firstName;

    @NotEmpty(message = "last name is required")
    @Size(min = 3, max = 20, message = "last name must be between 3 to 60 characters")
    private String lastName;

    @Min(value = 3000, message = "Minimum salary starts from 3000")
    @Max(value = 15000, message = "Maximum salary cannot exceed 15000")
    private Integer salary;

    @Email(message = "Email entered is not a valid email")
    @NotBlank(message = "Email is compulsory")
    private String email;

    @Past(message = "How can you be born in the present and/or now?")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    // Use regular expression validation
    // minimum 11111111-99999999
    // Starts with 8 or 9, follow by 7 digits.
    // only accepts digits 0-9 for the next 7 digits
    // preset is 8/9 must start with that
    @Pattern(regexp = "(8|9)[0-9]{7}", message = "Phone number starting with 8 or 9, followed by 7 digits.")
    private String telephone;

    // fraction means whole number, no decimals, integer means 6 digits long
    @Digits(fraction = 0, integer = 6, message = "Postal code must be 6 digits")
    @Min(value = 111111) // Postal codes start from 111111
    @Max(value = 999999) // Postal codes max is 999999
    private Integer postalCode;

    // Getters Setters Contrustors toString
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Person() {
    }

    public Person(String firstName, String lastName, Integer salary, String email, Date dateOfBirth, String telephone, Integer postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.email = email;
        this.dateOfBirth = dateOfBirth;

        // Randomly generated ID, just for this exmaple
        // Actual use case, custom format generator
        this.id = UUID.randomUUID().toString();

        this.telephone = telephone;
        this.postalCode = postalCode;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

}
