import java.util.HashMap;
import java.util.Map;

public class tmp_ {
    public static void main(String[] args) {
        Map<Integer, String> myMap = new HashMap<>();
        myMap.put(1, "1");
        myMap.put(2, "2");
        myMap.put(3, "3");

        for(Map.Entry<Integer, String> entry : myMap.entrySet()) {
            Integer key = entry.getKey();
            String val = entry.getValue();
        }

        for(Integer key : myMap.keySet()) {
            System.out.println(key);
        }

    }


}
