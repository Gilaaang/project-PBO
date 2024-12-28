public class Penumpang {
    private String nama;
    private String idTiket;
    private Kendaraan kendaraan;
    private Rute rute;
    private Jadwal jadwal;
    
    public Penumpang(String nama, String idTiket, Kendaraan kendaraan, Rute rute, Jadwal jadwal) {
        this.nama = nama;
        this.idTiket = idTiket;
        this.kendaraan = kendaraan;
        this.rute = rute;
        this.jadwal = jadwal;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getIdTiket() {
        return idTiket;
    }

    public void setIdTiket(String idTiket) {
        this.idTiket = idTiket;
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
    public Jadwal getjadwal(){
        return jadwal;
    }

    public void setRute(Rute rute) {
        this.rute = rute;
    }
    public void tampilkanPenumpang(){
        System.out.println("Nama Penumpang: "+getNama());
        System.out.println("Id Tiket: "+getIdTiket());
        System.out.println("Jenis Kendaraan: "+getKendaraan());
        System.out.println("Rute: "+getRute());
        System.out.println("Jam: "+getjadwal());
    }
}
