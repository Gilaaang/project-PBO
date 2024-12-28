public class Route extends Rute{
    public Route(String namaRute, String titikAwal, String titikAkhir){
        super(namaRute, titikAwal, titikAkhir);
    }

    @Override
    public void tampilkanRute() {
        System.out.println("Rute: "+ getNamaRute());
        System.out.println("Titik Awal: "+ getTitikAwall());
        System.out.println("Titik Akhir: "+ getTitikAkhir());
    }
}
