package api.rest;

import api.bean.Message;
import spark.Request;
import spark.Response;
import spark.Route;

public class Hello implements Route {

    public Hello(){}

    @Override
    public Object handle(Request request, Response response) throws Exception {
        String name = request.params(":name");
        Message helloMessage = new Message();
        helloMessage.setId(1);
        helloMessage.setName("Hello :: " + name);
        helloMessage.setDescription("Nice to meet you all");
        return helloMessage;
    }
}
