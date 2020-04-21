import java.io.FileNotFoundException ;
import java.io.FileReader;
import java.io.IOException ;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class test {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("bai3.json"));
            JSONObject jsonobject = (JSONObject) obj;
            String name = (String) jsonobject.get("header");
            JSONArray item = (JSONArray) jsonobject.get("item");
            System.out.println(name);
            System.out.println("item: ");
            Iterator iterator = item.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
