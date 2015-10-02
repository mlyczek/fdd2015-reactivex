package pl.mlyczek.fdd2015.transformers;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 * Transforms response into JSON representation.
 */
public class JsonTransformer implements ResponseTransformer {

    private Gson gson;

    public JsonTransformer(Gson gson) {
        this.gson = gson;
    }

    @Override
    public String render(Object model) throws Exception {
        return gson.toJson(model);
    }
}
