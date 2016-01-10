package api.rest;

import api.bean.Message;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.TemplateViewRoute;

import static api.response.JsonTransformer.fromJson;


public class AddNewMessage implements Route {
    @Override
    public Object handle(Request request, Response response) throws Exception {
        String body = request.body();
        Message newMessage = fromJson(body, Message.class);
        newMessage.setId(1000);
        return newMessage;
    }
}
