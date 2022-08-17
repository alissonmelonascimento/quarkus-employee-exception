package org.acme.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Employee {

    @NotNull(message = "Informe o nome")
    public String name;

    @NotNull(message = "Informe o salário")
    public Double salary;

    @NotNull(message = "Informe o email")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",message = "Formato de email inválido" )
    public String email;
    
}
