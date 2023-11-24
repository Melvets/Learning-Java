package nye;

public class OperasiPengurangan extends OperasiBilangan {
    public OperasiPengurangan() {
        this.namaOperasi = "Pengurangan";
    }

    protected void set_C() {
        this.c = a - b;
    }
}
