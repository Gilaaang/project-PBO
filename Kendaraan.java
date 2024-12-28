public class Kendaraan {
    private String idkendaraan;
    private String jenis;
    private int kapasitas;
    private double hargaTiket;
    private boolean statusOperasional;
    private String rute;
    
    public Kendaraan(String idkendaraan, String jenis, int kapasitas, double hargaTiket, boolean statusOperasional, String rute) {
        this.idkendaraan = idkendaraan;
        this.jenis = jenis;
        this.kapasitas = kapasitas;
        this.hargaTiket = hargaTiket;
        this.statusOperasional = statusOperasional;
        this.rute = rute;
    }

    public String getNamaKendaraan() {
        return jenis;
    }
    public double getHargaTiket(){
        return hargaTiket;
    }
 @Override
    public String toString(){
     return jenis;
 }

}
