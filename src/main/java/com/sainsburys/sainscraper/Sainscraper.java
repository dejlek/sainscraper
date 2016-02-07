package com.sainsburys.sainscraper;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.*;
import org.jsoup.*;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author dejan
 */
public class Sainscraper {
    private URL url;
    
    public Sainscraper(URL argUrl) {
        url = argUrl;
    }
    
    public ProductInfo getProductInfo(String argUrl) {
        String title = "";
        float size = 0.0f;
        float unitPrice = 0.0f;
        String description = "";
        
        Connection con = Jsoup.connect(url.toString());
        try {
            Element el = con.get().select("div.productTitleDescriptionContainer").first();
            if (el == null) {
                return null;
            } else {
                Element titleElement = el.getElementsByTag("h1").first();
                title = titleElement.toString();
                
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Sainscraper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ProductInfo(title, size, unitPrice, description);
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
