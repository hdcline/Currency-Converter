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
        
        /*System.out.println("running...");
		Document document;
		try {
			//Get Document object after parsing the html from given url.
			document = Jsoup.connect("http://www.zillow.com/denver-co/").get();

			String title = document.title(); //Get title
			System.out.println("  Title: " + title); //Print title.
                        
                        Elements price = document.select(".list-card-price:contains($)");
                
                        for (int i = 0; i < price.size(); i++){
                            System.out.println(price.get(i).text());
                        }

		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
        System.out.println(usdToEuro(5));
    }
    
    public static double usdToEuro (double amount) throws IOException{
        Document document;
        
        //Get Document object after parsing the html from given url.
        document = Jsoup.connect("https://www.google.com/search?ei=UCE7XvC_OMSttQbc9YGwBQ&q=currency+conversions&oq=currency+conversions&gs_l=psy-ab.3..0i131j0l6j0i10j0l2.45306.54628..54749...0.7..0.109.1513.19j1......0....1..gws-wiz.......0i71j0i67j0i131i67j0i273j0i273i70i258.PcSDKkNO4bo&ved=0ahUKEwjwp_SInLvnAhXEVs0KHdx6AFYQ4dUDCAs&uact=5").get();

        System.out.println("Connected");

        //Creates a list named rate. Selects elements with the "data-value" attribute.
        Elements rate = document.select("[data-value]");

        //Variable storing the value of the "data-value" attribute.
        //Originally stored as a string in the list, so it had to be converted to a double.
        double conversionRate = Double.parseDouble(rate.first().attr("data-value"));

        double conversion = amount * conversionRate;
        
        return Math.round(conversion * 100.00) / 100.00;
    }
    
}
