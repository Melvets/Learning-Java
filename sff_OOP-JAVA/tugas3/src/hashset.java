import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class hashset {
    public static void main(String[ ] args) {
        HashMap<String, String> map= new HashMap<String, String> ();
        map.put("rumah", "Tipe 45");
        map.put("mobil", "BMW");
        map.put("bunga", "Mawar");
        System.out.println("Sebelum diubah ");
        
        Iterator<String> ite = map.keySet( ).iterator( );
        while(ite.hasNext ( ));{
            System.out.println(map.get(ite.next( )));
        }

        System.out.println("Setelah diubah ");
        map.put("mobil", "Ferrari");
        for(String key : map.keySet( ) ) {
            System.out.println(map.get(key));
        }
    }
}
