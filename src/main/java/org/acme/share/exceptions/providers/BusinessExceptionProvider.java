package org.acme.share.exceptions.providers;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.acme.share.exceptions.BusinessException;
import org.acme.share.exceptions.Problem;

@Provider
public class BusinessExceptionProvider implements ExceptionMapper<BusinessException>{

    @Override
    public Response toResponse(BusinessException e) {
        Problem problem = new Problem(e);
        return Response.status(422).entity(problem).type(MediaType.APPLICATION_JSON).build();
    }
    
}
