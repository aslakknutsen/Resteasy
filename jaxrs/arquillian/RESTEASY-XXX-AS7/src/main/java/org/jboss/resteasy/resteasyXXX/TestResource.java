package org.jboss.resteasy.resteasyXXX;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * 
 * @author <a href="aslak@redhat.com">Aslak Knutsen</a>
 *
 */
@Path("/")
public class TestResource
{
   @GET
   @Path("test")
   @Produces({"application/vnd.test+xml", "application/vnd.test+xml;type=test"})
   public Response test()
   {
      return Response.ok(new TestRep("x y z")).build();
   }

}
