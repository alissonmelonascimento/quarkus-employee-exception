package org.acme.applications;

import javax.enterprise.context.ApplicationScoped;

import org.acme.domain.Employee;
import org.acme.domain.EmployeeUC;
import org.acme.share.exceptions.BusinessException;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class EmployeeUCImpl implements EmployeeUC{

    @ConfigProperty(name = "salary-max")
    Double salaryMax;

    @Override
    public void save(Employee employee) throws Exception{
        if(employee.salary > this.salaryMax){
            throw new BusinessException("Salário muito alto");
        }

        //TODO persist
    }
    
}
