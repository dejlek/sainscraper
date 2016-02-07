package com.sainsburys.sainscraper;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.*;
import org.jsoup.*;

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
        JSONObject json = new JSONObject();
        JSONArray results = new JSONArray();
        json.put("results", results);
        json.put("total", 0.0f);
        
        Connection con = Jsoup.connect(url.toString());
        int size;
        try {
            size = con.get().toString().length();
            System.out.println(size);
        } catch (IOException ex) {
            Logger.getLogger(Sainscraper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(json.toJSONString());
        return json.toJSONString();
    }
    
    // ::::: Accessors ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL argUrl) {
        url = argUrl;
    }
}
