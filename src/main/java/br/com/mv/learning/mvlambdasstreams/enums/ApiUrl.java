package br.com.mv.learning.mvlambdasstreams.enums;

public enum ApiUrl {


    OMDB_API("http://www.omdbapi.com/?apikey=bb1a407d&t=");

    private String url;
    ApiUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
