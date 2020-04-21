import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;
public class Main {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("course.json"));
            JSONObject jsonobject = (JSONObject) obj;
            String name = (String) jsonobject.get("Name");
            String course = (String) jsonobject.get("Course");
            JSONArray subjects = (JSONArray) jsonobject.get("Subjects");
            System.out.println("Name: " + name);
            System.out.println("Course: " + course);
            System.out.println("Subjects: ");
            Iterator iterator = subjects.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}