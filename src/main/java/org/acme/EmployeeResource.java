package org.acme;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.acme.domain.Employee;
import org.acme.domain.EmployeeUC;

@Path("/employee")
public class EmployeeResource {

    @Inject
    EmployeeUC employeeService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(@Valid Employee employee) throws Exception{
        this.employeeService.save(employee);
    }
}