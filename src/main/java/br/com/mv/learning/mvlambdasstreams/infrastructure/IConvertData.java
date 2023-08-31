package br.com.mv.learning.mvlambdasstreams.infrastructure;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IConvertData {

     <T> T getData(String json , Class<T> classType) throws JsonProcessingException;
}
