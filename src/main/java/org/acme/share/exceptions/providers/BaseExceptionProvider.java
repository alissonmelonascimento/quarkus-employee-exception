package org.acme.share.exceptions.providers;

import java.time.OffsetDateTime;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.acme.share.exceptions.Problem;

@Provider
public class BaseExceptionProvider implements ExceptionMapper<Exception>{

    @Override
    public Response toResponse(Exception e) {
        Problem problem   = new Problem();
        problem.detail    = e.getLocalizedMessage();
        problem.status    = 500;
        problem.timestamp = OffsetDateTime.now();
        problem.title     = "Erro interno no sistema";

        return Response.status(Status.INTERNAL_SERVER_ERROR).entity(problem).type(MediaType.APPLICATION_JSON).build();
    }
    
}
