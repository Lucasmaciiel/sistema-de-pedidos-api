package com.lmg.cursomc.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class EmailDTO implements Serializable {

    private static final long serialVersionUID = -8467358322134202391L;

    @NotEmpty(message= "Preenchimento obrigatório")
    @Email(message="Email inválido")
    private String email;

    public EmailDTO(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
