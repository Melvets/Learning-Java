public class App {
    public static void main(String[] args) throws Exception {
        String kata1 = "SAYA";
        String kata2 = "SISWA";
        String kata3 = "SMK";
        String kata4 = "SAYA";
        String kata5 = "ANGKATAN";
        String kata6 = "2024";
        String kata7 = "Saya";

        System.out.println(kata1 + " " + kata2 + " " + kata3);
        System.out.println(kata4 + " " + kata5 + " " + kata6);
        System.out.println((kata7) + (" " + kata2 + " " + kata5 + " " + kata6).toLowerCase());
        System.out.println((kata7) + (" " + kata2 + " " + kata3).toLowerCase());

    }
}
