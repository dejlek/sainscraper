package com.sainsburys.sainscraper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.*;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author dejan
 */
public class Sainscraper {
    private URL url;
    private Connection con;
    
    public Sainscraper(URL argUrl) {
        url = argUrl;
    }
    
    public ProductInfo getProductInfo(String argUrl) {
        String title = "";
        float size = 0.0f;
        float unitPrice = 0.0f;
        String description = "";
        
        try {
            Document doc = Jsoup.connect(argUrl).get();
            Element el = doc.select("div.productTitleDescriptionContainer").first();
            if (el == null) {
                return null;
            } else {
                // Let's get the product title
                Element titleElement = el.getElementsByTag("h1").first();
                title = titleElement.text();
                
                // size of the web-page
                size = doc.toString().length();
                
                // let's get price per unit
            }
            el = doc.select("p.pricePerUnit").first();
            if (el == null) {
                return null;
            } else {
                String ptxt = el.text();
                ptxt = ptxt.replace("/unit", "");
                ptxt = ptxt.replace("£", "");
                float ppunit = Float.parseFloat(ptxt);
                unitPrice = ppunit;
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
