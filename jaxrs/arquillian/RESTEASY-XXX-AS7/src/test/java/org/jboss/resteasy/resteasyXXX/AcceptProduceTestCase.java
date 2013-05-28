package org.jboss.resteasy.resteasyXXX;

import static org.junit.Assert.assertEquals;

import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * 
 * @author <a href="aslak@redhat.com">Aslak Knutsen</a>
 * 
 */
@RunWith(Arquillian.class)
public class AcceptProduceTestCase
{
   @Deployment(testable = false)
   public static WebArchive createTestArchive()
   {
      WebArchive war = ShrinkWrap.create(WebArchive.class, "RESTEASY-XXX.war")
            .addClasses(TestApplication.class, TestResource.class, TestRep.class)
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

      return war;
   }

   @ArquillianResource
   private URL base;
   
   @Test
   public void shouldbeAbleToProduceAcceptMediaType() throws Exception
   {
	  callService("application/vnd.test+xml");
   }

   @Test
   public void shouldbeAbleToProduceAcceptMediaTypeWithParameter() throws Exception
   {
	  callService("application/vnd.test+xml;type=test");
   }

   private void callService(String acceptMediaType) throws Exception {
      ClientRequest request = new ClientRequest(new URL(base, "rest/test").toExternalForm());
      request.accept(acceptMediaType);
	      
      ClientResponse<String> response = request.get(String.class);
      assertEquals(200, response.getStatus());
      assertEquals(acceptMediaType, response.getMediaType().toString());
   }
}
