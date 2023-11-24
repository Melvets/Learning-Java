package nye;

public class OperasiPenjumlahan extends OperasiBilangan {
    public OperasiPenjumlahan() {
        this.namaOperasi = "Penjumlahan";
    }

    protected void set_C() {
        this.c = a + b;
    }
}
