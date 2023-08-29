package br.com.mv.learning.mvlambdasstreams.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertDataImplementation implements IConvertData {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> classType) {
        return null;
    }
}
