/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author barbara.johnson
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

import java.io.IOException;

public class Helper {

    public static int addTwo(int a, int b) {
        return a + b;
    }
    
    
    public static double monthlyPayment(double amt, double yearlyInterestRate,
            int numberOfYears)
    {
        return 0.0;
    }
    
    public static boolean isPositive(int n) {
        return n > 0;
    }
    
    public static int largest(int a, int b) {
        if (a > b) return a;
        return b;
    }

    public static Dictionary<String, Double> webScraper() {
        String s = "success";
        String url = "http://www.x-rates.com/table/?from=USD&amount=1";
        Dictionary<String, Double> dict = new Hashtable<>();
        try {
            Document doc = Jsoup.connect(url).get();
            Elements rows = doc.select("table.ratesTable > tbody > tr");
            for (Element row : rows) {
                Elements tds = row.select("td");
                String currency = tds.get(0).text();
                Double rate1 = Double.valueOf(tds.get(1).text());
                Double rate2 = Double.valueOf(tds.get(2).text());
                System.out.printf("Currency: %s, rate1: %s, rate2: %s%n", 
                        currency, rate1, rate2);
                // add it to the dictionary
            }          
        } catch (IOException ex) {
            s = "fail";
        }   
        System.out.printf("%s",s);
        return dict;
    }
}
