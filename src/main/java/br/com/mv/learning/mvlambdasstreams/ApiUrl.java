package br.com.mv.learning.mvlambdasstreams;

public enum ApiUrl {

    OMDB_API("http://www.omdbapi.com/?apikey=bb1a407d&t=Lucifer");

    private String url;
    ApiUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
