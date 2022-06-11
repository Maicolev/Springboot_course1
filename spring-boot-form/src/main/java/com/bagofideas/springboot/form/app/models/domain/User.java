package com.bagofideas.springboot.form.app.models.domain;

import com.bagofideas.springboot.form.app.validation.RegexIdentificator;
import com.bagofideas.springboot.form.app.validation.Required;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;


public class User
{
    //@Pattern(regexp = "[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")
    @RegexIdentificator
    private String id;

    // @NotEmpty(message = "The name cannot be empty")
    private String name;

    //@NotEmpty
    @Required
    private String lastName;

    @NotBlank
    @Size(min=3, max=8)
    private String userName;

    @NotEmpty
    private String password;

    @Required
    @Email
    private String email;

    @NotNull
    @Min(5)
    @Max(5000)
    private Integer account;

    @NotNull
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    private Date birthday;

    @NotNull
    private Country country;

    @NotEmpty
    private List<Role> roles;

    private Boolean enable;

    @NotEmpty
    private String gender;

    private String secretValue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAccount() { return account;}

    public void setAccount(Integer account) {this.account = account; }

    public Date getBirthday() { return birthday; }

    public void setBirthday(Date birthday) {this.birthday = birthday;}

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSecretValue() {
        return secretValue;
    }

    public void setSecretValue(String secretValue) {
        this.secretValue = secretValue;
    }
}
