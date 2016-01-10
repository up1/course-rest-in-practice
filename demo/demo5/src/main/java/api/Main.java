package api;


import api.exception.NotFoundException;
import api.response.JsonTransformer;
import api.rest.Hello;
import com.google.gson.Gson;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {

        port(8080);

        Gson gson = new Gson();
        get("/hello/:name", new Hello(), gson::toJson);
        get("/hello2/:name", new Hello(), new JsonTransformer());

        exception(NotFoundException.class, (e, request, response) -> {
            response.status(404);
            response.body("Resource not found");
        });

    }
}
