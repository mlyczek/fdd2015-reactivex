package pl.mlyczek.fdd2015.converters;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.ResponseBody;
import retrofit.Converter;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public class StringConverterFactory extends Converter.Factory {
    @Override
    public Converter<ResponseBody, ?> fromResponseBody(Type type, Annotation[] annotations) {
        return new Converter<ResponseBody, String>() {
            @Override public String convert(ResponseBody value) throws IOException {
                return value.string();
            }
        };
    }

    @Override public Converter<?, RequestBody> toRequestBody(Type type, Annotation[] annotations) {
        return new Converter<String, RequestBody>() {
            @Override public RequestBody convert(String value) throws IOException {
                return RequestBody.create(MediaType.parse("text/plain"), value);
            }
        };
    }
}
