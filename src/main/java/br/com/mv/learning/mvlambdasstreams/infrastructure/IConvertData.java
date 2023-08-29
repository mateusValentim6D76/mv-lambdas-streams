package br.com.mv.learning.mvlambdasstreams.infrastructure;

public interface IConvertData {

     <T> T getData(String json , Class<T> classType);
}
