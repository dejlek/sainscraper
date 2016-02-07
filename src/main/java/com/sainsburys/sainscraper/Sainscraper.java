package com.sainsburys.sainscraper;

import java.net.URL;

/**
 *
 * @author dejan
 */
public class Sainscraper {
    private URL url;
    
    public Sainscraper(URL argUrl) {
        url = argUrl;
    }
    
    public String scrape() {
        String ret = "{}"; // empty JSON
        return ret;
    }
    
    // ::::: Accessors ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL argUrl) {
        url = argUrl;
    }
}
