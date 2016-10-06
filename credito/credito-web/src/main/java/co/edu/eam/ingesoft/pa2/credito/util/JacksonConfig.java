package co.edu.eam.ingesoft.pa2.credito.util;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;

@Provider
public class JacksonConfig implements ContextResolver<ObjectMapper> {
private final ObjectMapper objectMapper;

public JacksonConfig() throws Exception {

    objectMapper = new ObjectMapper()
                .disable( SerializationFeature.WRITE_DATES_AS_TIMESTAMPS )
                .disable( SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS )
                .setSerializationInclusion( JsonInclude.Include.NON_NULL )
                .registerModule( new JSR310Module() );

}

@Override
public ObjectMapper getContext( Class<?> arg0 ) {
    return objectMapper;
} }