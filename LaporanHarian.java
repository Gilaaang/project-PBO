public class LaporanHarian implements Laporan {
    private int jumlahPenumpang;
    private double pendapatan;
    
    public LaporanHarian() {
        this.jumlahPenumpang = 0;
        this.pendapatan = 0.0;
    }

    @Override
    public void catatLaporan(int jumlahPenumpang, double pendapatan) {
        this.jumlahPenumpang += jumlahPenumpang;
        this.pendapatan += pendapatan;
    }

    @Override
    public void tampilkanLaporan() {
        System.out.println("Laporan Harian:");
        System.out.println("Jumlah Penumpang: "+jumlahPenumpang);
        System.out.println("Pendapatan: "+pendapatan);
    }
    public void tambahLaporan(String rute, int jumlahPenumpang, double pendapatan){
        System.out.println("Laporan Ditambahkan");
    }
}
