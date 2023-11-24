import java.util.ArrayList;

public class program_arraylist {
    public static void main(String[] args) throws Exception {
        
        ArrayList<Human> list1 = new ArrayList<Human> ( ) ;
        for(int i = 0; i < 10; i++) {
            list1.add(new Human("Human " + i));
        }

        for(int i = 0; i < list1.size( ); i++) {
            System.out.println(list1.get(i).name);
        }
    }
}

class Human {
    public String name;
    public Human(String name) {
        this.name = name;
    }
}