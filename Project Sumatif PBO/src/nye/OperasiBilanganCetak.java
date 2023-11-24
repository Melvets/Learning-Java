package nye;

public class OperasiBilanganCetak {
    private void cetakSemua(OperasiBilangan[] OB, double A, double B) {
        for (OperasiBilangan operasi : OB) {
            operasi.set_A(A);
            operasi.set_B(B);
            operasi.set_C();
            System.out.println("--=={" + operasi.namaOperasi + "}==--");
            operasi.get_A();
            operasi.get_B();
            operasi.get_C();
            operasi.tampil();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        OperasiBilangan[] operasiBilanganArr = {new OperasiPenjumlahan(), new OperasiPengurangan(),
                new OperasiPembagian(), new OperasiPerkalian()};

        OperasiBilanganCetak cetak = new OperasiBilanganCetak();
        cetak.cetakSemua(operasiBilanganArr, 10.5, 0.5);
    }
}
