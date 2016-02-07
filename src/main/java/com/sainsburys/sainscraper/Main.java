package com.sainsburys.sainscraper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

/**
 * A class which contains the entry point.
 * @author dejan
 */
public class Main {
    public static final void main(String[] args) {
        System.out.println(Arrays.toString(args));
        String urlStr = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html";
        if (args.length == 1) {
            // If user gives URL as an argument to the application, we use it.
            urlStr = args[0];
        }
        URL url;
        try {
            url = new URL(urlStr);
            System.out.println(url);
        } catch (MalformedURLException ex) {
            System.out.println("The given web-address '" + urlStr + "' is not valid. Exiting....");
        }
    }
}
