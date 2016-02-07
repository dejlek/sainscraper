package com.sainsburys.sainscraper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dejan
 */
public class SainscraperTest {
    Sainscraper sscraper;
    
    public SainscraperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        URL url;
        try {
            url = new URL("http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html");
            sscraper = new Sainscraper(url);
        } catch (MalformedURLException ex) {
            Logger.getLogger(SainscraperTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @After
    public void tearDown() {
        sscraper = null;
    }

    @Test
    public void testSomeMethod() {
        String json = sscraper.scrape();
        assertTrue(!json.isEmpty());
    }
    
}
