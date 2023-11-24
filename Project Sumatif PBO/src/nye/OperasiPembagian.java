package nye;

public class OperasiPembagian extends OperasiBilangan {
    public OperasiPembagian() {
        this.namaOperasi = "Pembagian";
    }

    protected void set_C() {
        if (b != 0) {
            this.c = a / b;
        } else {
            System.out.println("Error: Pembagian dengan 0 tidak diperbolehkan");
        }
    }
}
