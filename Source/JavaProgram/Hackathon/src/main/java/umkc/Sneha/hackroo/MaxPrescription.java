package umkc.Sneha.hackroo;
//import com.sun.org.apache.xpath.internal.operations.String;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MaxPrescription {

        public static void main(String[] args) {

            JSONParser parser = new JSONParser();
            
            try {

                Object obj = new JSONParser().parse(new FileReader("/Users/snehamishra/Desktop/hackaroo/AK.json"));

                //JSONObject jo = (JSONObject) obj;
                //array.add(obj);

                //JSONObject jsonObject = (JSONObject) obj;
                //System.out.println(obj);

               // String name = (String) jo.get("number_of_prescriptions");
                //System.out.println(name);

               // long age = (Long) jo.get("product_fda_list_name");
               // System.out.println(age);

                // loop array
                JSONArray ja = (JSONArray) obj;


                HashMap<String, Integer> maxNumber = new HashMap<String, Integer>();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < ja.size(); i++)

                {
                    JSONObject first = (JSONObject)ja.get(i);
                    //String shipper = (String) first.get("number_of_prescriptions");
                    String nop = (String) first.get("number_of_prescriptions");
                    sb.append(nop);
                    String pn = (String)first.get("product_fda_list_name");
                    System.out.println( sb.toString() + "," + " "  + pn);

                    if(nop == null){
                        sb.setLength(0);
                        // ignore null values, do nothing
                    }else{
                        int nopInt = Integer.parseInt(sb.toString());
                        maxNumber.put(pn, nopInt);
                        sb.setLength(0);
                    }


                }
                // Checking for the max values
                Map.Entry<String, Integer> maxEntry = null;
                for(Map.Entry<String, Integer> entry : maxNumber.entrySet()){
                    if(maxEntry == null || entry.getValue().compareTo(maxEntry.getValue())>0){
                        maxEntry = entry;
                    }
                }
                System.out.println("max value is - "+maxEntry.getValue() +" for medicine - "+maxEntry.getKey());

                //wrinting to txt file




                //JSONArray msg = (JSONArray) ja.get(0);


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }

    }

