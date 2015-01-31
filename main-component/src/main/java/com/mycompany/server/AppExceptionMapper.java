package com.mycompany.server;

import javax.ws.rs.core.Response;

/**
 * @author <a href="mailto:androideper@gmail.com"> Android Developer</a>
 *         Date: 11/9/2014 - 12:21 AM
 */
public class AppExceptionMapper implements javax.ws.rs.ext.ExceptionMapper {
    @Override
    public Response toResponse(Throwable throwable) {
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
