package org.acme.share.exceptions.providers;

import java.util.Iterator;

import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.acme.share.exceptions.Problem;
import org.acme.share.exceptions.ProblemObject;

@Provider
public class ConstraintViolationExceptionProvider implements ExceptionMapper<ConstraintViolationException>{

    @Override
    public Response toResponse(ConstraintViolationException e) {
        Problem problem = new Problem(e);

        e.getConstraintViolations().forEach( (c) -> {
            problem.messages
                    .add(new ProblemObject(lastFieldName(c.getPropertyPath().iterator()), e.getLocalizedMessage()));
        } );

        return Response.status(Status.BAD_REQUEST).entity(problem).type(MediaType.APPLICATION_JSON).build();
    }

    String lastFieldName(Iterator<Path.Node> nodes){
        Path.Node last = null;
        while(nodes.hasNext()){
            last = nodes.next();
        }

        return last.getName();
    }
    
}
