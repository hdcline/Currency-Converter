/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currencyconverter;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.text.DecimalFormat;
import java.util.Scanner;
/**
 *
 * @author hunter
 */
public class CurrencyConverter {
    static DecimalFormat df = new DecimalFormat("0.00");
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //First comment. Testing git commit.
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the currency you would like to convert from (Euro, Japanese Yen, British Pound, "
                + "Canadian Dollar, Swiss franc, Australian Dollar, Mexican peso): ");
        String fromCurrency = scanner.nextLine();
        
        System.out.print("Enter the currency you would like to convert to (Euro, Japanese Yen, British Pound, "
                + "Canadian Dollar, Swiss franc, Australian Dollar, Mexican peso): ");
        String toCurrency = scanner.nextLine();
        
        System.out.print("Enter the amount to be converted: ");
        double amount = scanner.nextDouble();
        
        //Formats the amount so that it always shows 2 decimals.
        String strAmount = String.format("%.02f", amount);
	
        //Checks to see if the user is converting from usd.
        if ("usd".equals(fromCurrency.toLowerCase())){
            //Checks to see if the user is converting to euro.
            if ("euro".equals(toCurrency.toLowerCase())){
                //Formats the conversion to always show 2 decimals.
                String strConversion = String.format("%.02f", usdToOther(toCurrency, amount));
                System.out.println(strAmount + " USD = " + strConversion + " Euro");
            }
            
            else if ("japanese yen".equals(toCurrency.toLowerCase())){
                String strConversion = String.format("%.02f", usdToOther(toCurrency, amount));
                System.out.println(strAmount + " USD = " + strConversion + " Japanese Yen");
            }
            
            else if ("british pound".equals(toCurrency.toLowerCase())){
                String strConversion = String.format("%.02f", usdToOther(toCurrency, amount));
                System.out.println(strAmount + " USD = " + strConversion + " British Pound");
            }
            
            else if ("canadian dollar".equals(toCurrency.toLowerCase())){
                String strConversion = String.format("%.02f", usdToOther(toCurrency, amount));
                System.out.println(strAmount + " USD = " + strConversion + " Canadian Dollar");
            }
            
            else if ("canadian dollar".equals(toCurrency.toLowerCase())){
                String strConversion = String.format("%.02f", usdToOther(toCurrency, amount));
                System.out.println(strAmount + " USD = " + strConversion + " Swiss franc");
            }
            
            else if ("australian dollar".equals(toCurrency.toLowerCase())){
                String strConversion = String.format("%.02f", usdToOther(toCurrency, amount));
                System.out.println(strAmount + " USD = " + strConversion + " Australian Dollar");
            }
            
            else if ("mexican peso".equals(toCurrency.toLowerCase())){
                String strConversion = String.format("%.02f", usdToOther(toCurrency, amount));
                System.out.println(strAmount + " USD = " + strConversion + " Mexican peso");
            }
        }
    }
    
    public static double usdToOther (String currency, double amount) throws IOException{
        Document document;
        
        if ("euro".equals(currency.toLowerCase())){
            //Get Document object after parsing the html from given url.
            document = Jsoup.connect("https://www.google.com/search?ei=UCE7XvC_OMSttQbc9YGwBQ&q=currency+conversions&oq=currency+conversions&gs_l=psy-ab.3..0i131j0l6j0i10j0l2.45306.54628..54749...0.7..0.109.1513.19j1......0....1..gws-wiz.......0i71j0i67j0i131i67j0i273j0i273i70i258.PcSDKkNO4bo&ved=0ahUKEwjwp_SInLvnAhXEVs0KHdx6AFYQ4dUDCAs&uact=5").get();

            //System.out.println("Connected");

            //Creates a list named rate. Selects elements with the "data-value" attribute.
            Elements rate = document.select("[data-value]");

            //Variable storing the value of the "data-value" attribute.
            //Originally stored as a string in the list, so it had to be converted to a double.
            double conversionRate = Double.parseDouble(rate.first().attr("data-value"));

            double conversion = amount * conversionRate;

            return Math.round(conversion * 100.00) / 100.00;
        }
        
        else if ("japanese yen".equals(currency.toLowerCase())){
            document = Jsoup.connect("https://www.google.com/search?ei=tVI7Xpn0JY-DtQa1hbPwDA&q=usd+to+japanese+yen&oq=usd+to+japa&gs_l=psy-ab.3.0.0l10.77559070.77561651..77563772...0.4..0.109.916.10j1......0....1..gws-wiz.......0i71j0i67j0i131j0i67i70i258j0i131i67j0i273j0i10.DgJiUajmXZE").get();
            //Creates a list named rate. Selects elements with the "data-value" attribute.
            Elements rate = document.select("[data-value]");
            
            //Variable storing the value of the "data-value" attribute.
            //Originally stored as a string in the list, so it had to be converted to a double.
            double conversionRate = Double.parseDouble(rate.first().attr("data-value"));
            
            double conversion = amount * conversionRate;
            
            return Math.round(conversion * 100.00) / 100.00;
            
        }
        
        else if ("british pound".equals(currency.toLowerCase())){
            document = Jsoup.connect("https://www.google.com/search?ei=44I8Xv3HEoS3tAay3YXwCA&q=usd+to+british+pound&oq=usd+to+british+pound&gs_l=psy-ab.3..0i70i258j0l9.247154.250338..252754...0.2..0.194.1091.12j1......0....1..gws-wiz.......0i71j0i131j0i10.wI31i_nUkxM&ved=0ahUKEwi9xcOh7b3nAhWEG80KHbJuAY4Q4dUDCAs&uact=5").get();
            
            //Creates a list named rate. Selects elements with the "data-value" attribute.
            Elements rate = document.select("[data-value]");
            
            //Variable storing the value of the "data-value" attribute.
            //Originally stored as a string in the list, so it had to be converted to a double.
            double conversionRate = Double.parseDouble(rate.first().attr("data-value"));
            
            double conversion = amount * conversionRate;
            
            return Math.round(conversion * 100.00) / 100.00;
        }
        
        else if ("canadian dollar".equals(currency.toLowerCase())){
            document = Jsoup.connect("https://www.google.com/search?ei=4IM8XtvLMcuztAbJ_ZQo&q=usd+to+canadian+dollar&oq=usd+to+canadian+dollar&gs_l=psy-ab.3..0i70i258j0l9.410795.414050..414275...0.2..0.144.1205.14j1......0....1..gws-wiz.......0i71j0i67j0i131j0i10j0i131i70i258.t-bKIyD5I-M&ved=0ahUKEwjbu7Sa7r3nAhXLGc0KHck-BQUQ4dUDCAs&uact=5").get();
            
            //Creates a list named rate. Selects elements with the "data-value" attribute.
            Elements rate = document.select("[data-value]");
            
            //Variable storing the value of the "data-value" attribute.
            //Originally stored as a string in the list, so it had to be converted to a double.
            double conversionRate = Double.parseDouble(rate.first().attr("data-value"));
            
            double conversion = amount * conversionRate;
            
            return Math.round(conversion * 100.00) / 100.00;
        }
        
        else if ("swiss franc".equals(currency.toLowerCase())){
            document = Jsoup.connect("https://www.google.com/search?ei=f4U8XrSFO47PtQai4bqICQ&q=usd+to+swiss+franc&oq=usd+to+swiss+franc&gs_l=psy-ab.3..0i70i258j0l6j0i22i30l3.115979.117340..117718...0.2..0.102.910.10j1......0....1..gws-wiz.......0i71j0i273j0i131i273j0i131j0i273i70i258.VBuynx0ZsQI&ved=0ahUKEwj0wK_g773nAhWOZ80KHaKwDpEQ4dUDCAs&uact=5").get();
            
            //Creates a list named rate. Selects elements with the "data-value" attribute.
            Elements rate = document.select("[data-value]");
            
            //Variable storing the value of the "data-value" attribute.
            //Originally stored as a string in the list, so it had to be converted to a double.
            double conversionRate = Double.parseDouble(rate.first().attr("data-value"));
            
            double conversion = amount * conversionRate;
            
            return Math.round(conversion * 100.00) / 100.00;
        }
        
        else if ("australian dollar".equals(currency.toLowerCase())){
            document = Jsoup.connect("https://www.google.com/search?ei=9oU8XpSjI8u7tAbdmp-YDQ&q=usd+to+australian+dollar&oq=usd+to+australian+dollar&gs_l=psy-ab.3..0i70i258j0l9.106281.109424..109618...0.2..0.92.1270.17......0....1..gws-wiz.......0i71j0i67j0i131j0i10i70i258.V_ruxcMPV-c&ved=0ahUKEwiU9vaY8L3nAhXLHc0KHV3NB9MQ4dUDCAs&uact=5").get();
            
            //Creates a list named rate. Selects elements with the "data-value" attribute.
            Elements rate = document.select("[data-value]");
            
            //Variable storing the value of the "data-value" attribute.
            //Originally stored as a string in the list, so it had to be converted to a double.
            double conversionRate = Double.parseDouble(rate.first().attr("data-value"));
            
            double conversion = amount * conversionRate;
            
            return Math.round(conversion * 100.00) / 100.00;
        }
        
        else if ("mexican peso".equals(currency.toLowerCase())){
            document = Jsoup.connect("https://www.google.com/search?ei=ZIY8XsjkPIW2tAaezZqQDA&q=usd+to+mexican+peso&oq=usd+to+mexican+peso&gs_l=psy-ab.3..0i70i258j0l9.161205.162748..162990...0.2..2.187.1019.10j2......0....1..gws-wiz.......0i71.RsNMdju0bAw&ved=0ahUKEwjIpsrN8L3nAhUFG80KHZ6mBsIQ4dUDCAs&uact=5").get();
            
            //Creates a list named rate. Selects elements with the "data-value" attribute.
            Elements rate = document.select("[data-value]");
            
            //Variable storing the value of the "data-value" attribute.
            //Originally stored as a string in the list, so it had to be converted to a double.
            double conversionRate = Double.parseDouble(rate.first().attr("data-value"));
            
            double conversion = amount * conversionRate;
            
            return Math.round(conversion * 100.00) / 100.00;
        }
        
        else {
            return 0.0;
        }
        
    }
    
}
