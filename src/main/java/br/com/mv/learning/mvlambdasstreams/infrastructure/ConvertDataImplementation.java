package br.com.mv.learning.mvlambdasstreams.infrastructure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertDataImplementation implements IConvertData {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> classType) throws JsonProcessingException {
        T t = mapper.readValue(json, classType);
        return t;
    }
}
