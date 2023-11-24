import java.util.LinkedList;

public class program_linkedlist {
    public static void main(String[] args) {
        LinkedList<String> A = new LinkedList<String> ();
        String [] nama = {"David", "Alfa", "Benny"};

        // tambah data diambil dari array nama

        for(int nList = 0; nList<nama.length; nList++) {
            A.add(nama[nList]);
        }

        // tampil data

        System.out.println("Data Asli : ");
        for(int nList = 0; nList < nama.length; nList++) {
            System.out.println("Indeks " + nList + " : " + A.get(nList));
        }

        System.out.println("\nTambah data di Index ke-2 : " );
        A.add (3, "Danni");
        for(int nList= 0; nList < nama.length; nList++) {
            System.out.println("Indeks " + nList + " : " + A.get(nList));
        }

        System.out.println("\nDelete data di Index ke-2 : ");
        A.remove(2);
        for(int nList= 0; nList < nama.length; nList++) {
            System.out.println("Indeks " + nList + " : " + A.get (nList));
        }

        System.out.println("\nTambah data di Awal list : ");
        A.addFirst("Marcelo");
        for(int nList= 0; nList < nama.length; nList++) {
            System.out.println("Indeks " + nList + " : " + A.get (nList));
        }

        System.out.println("\nTambah data di Akhir list : ");
        A.addLast("Ferdi");
        for(int nList= 0; nList < nama.length; nList++) {
            System.out.println("Indeks " + nList +" : " + A.get (nList));
        }

        System.out.println("\nTambah data di Akhir list : ");
        A.remove(4);
        for(int nList= 0; nList < nama.length; nList++) {
            System.out.println("Indeks " + nList + " : " + A.get (nList));
        }

    }
}
