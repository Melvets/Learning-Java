import java.io.*;

public class pengolahan_string {
    public static void main(String[] args) throws Exception {

        // 4. Buatlah sebuah program dengan menggunakan method reserve() yang menghasilkan output AYARAKGNALAP.
        System.out.println("4. Buatlah sebuah program dengan menggunakan method reserve() yang menghasilkan output AYARAKGNALAP.");

        StringBuffer a = new StringBuffer("AYARAKGNALAP");
        System.out.println("String awal: " + a);

        a.reverse();
        System.out.println("String setelah reverse: " + a + "\n");


        // 5. Hitunglah panjang karakter string pada kalimat "HEMAT PANGKAL KAYA" dengan menggunakan method length().
        System.out.println("5. Hitunglah panjang karakter string pada kalimat \"HEMAT PANGKAL KAYA\" dengan menggunakan method length().");

        StringBuffer b = new StringBuffer("HEMAT PANGKAL KAYA");
        int hitung = b.length();
        System.out.println("Panjang karakter: " + hitung + "\n");


        // 10. Buatlah sebuah kode program dengan menggunakan method replace() yang menghasilkan output BALIKHUTAN.
        System.out.println("10. Buatlah sebuah kode program dengan menggunakan method replace() yang menghasilkan output BALIKHUTAN.");

        StringBuffer c = new StringBuffer("BALIK");
        System.out.println("String awal: " + c);

        c.replace(5, 10, "HUTAN");
        System.out.println("String setelah: " + c);
    }
}
