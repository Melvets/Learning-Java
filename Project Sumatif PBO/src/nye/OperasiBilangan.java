package nye;

public class OperasiBilangan {
    protected double a, b, c;
    protected String namaOperasi;

    protected void set_A(double a) {
        this.a = a;
    }

    protected void set_B(double b) {
        this.b = b;
    }

    protected void set_C() {
        this.c = 0;
    }

    protected void get_A() {
        System.out.println("Nilai A: " + a);
    }

    protected void get_B() {
        System.out.println("Nilai B: " + b);
    }

    protected void get_C() {
        System.out.println("Nilai C: " + c);
    }

    protected void tampil() {
        System.out.println("Hasil Operasi " + namaOperasi + ": " + c);
    }
}