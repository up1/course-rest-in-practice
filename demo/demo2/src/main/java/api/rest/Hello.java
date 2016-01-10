package api.rest;

import api.bean.Message;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
public class Hello {

    @GET
    @Path("/hello/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message sayHi(@PathParam("name") String name) {
        Message helloMessage = new Message();
        helloMessage.setId(1);
        helloMessage.setName("Hello :: " + name);
        helloMessage.setDescription("Nice to meet you all");

        return helloMessage;
    }

}
