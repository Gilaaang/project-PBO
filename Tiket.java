public class Tiket {
    private String idTiket;
    private Penumpang penumpang;
    private Kendaraan kendaraan;
    private Rute rute;
    private double hargaTiket;
    
    public Tiket(String idTiket, Penumpang penumpang, Kendaraan kendaraan, Rute rute, double hargaTiket) {
        this.idTiket = idTiket;
        this.penumpang = penumpang;
        this.kendaraan = kendaraan;
        this.rute = rute;
        this.hargaTiket = hargaTiket;
    }

    public String getIdTiket() {
        return idTiket;
    }

    public void setIdTiket(String idTiket) {
        this.idTiket = idTiket;
    }

    public Penumpang getPenumpang() {
        return penumpang;
    }

    public void setPenumpang(Penumpang penumpang) {
        this.penumpang = penumpang;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public void setKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
    }

    public Rute getRute() {
        return rute;
    }

    public void setRute(Rute rute) {
        this.rute = rute;
    }

    public double getHargaTiket() {
        return hargaTiket;
    }

    public void setHargaTiket(double hargaTiket) {
        this.hargaTiket = hargaTiket;
    }
    
    public void tampilkanInfoTiket() {
        System.out.println("ID Tiket:");
    }
}
