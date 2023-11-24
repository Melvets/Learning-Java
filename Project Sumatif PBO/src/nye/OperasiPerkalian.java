package nye;

public class OperasiPerkalian extends OperasiBilangan {
    public OperasiPerkalian() {
        this.namaOperasi = "Perkalian";
    }

    protected void set_C() {
        this.c = a * b;
    }
}
