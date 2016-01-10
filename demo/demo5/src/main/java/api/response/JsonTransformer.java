package api.response;

import com.google.gson.Gson;
import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer {

    private Gson gson = new Gson();

    @Override
    public String render(Object model) {
        return gson.toJson(model);
    }

    public static <T extends Object> T  fromJson(String json, Class<T> classe) {
        return new Gson().fromJson(json, classe);
    }

}
