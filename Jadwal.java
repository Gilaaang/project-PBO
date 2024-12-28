public class Jadwal {
    private String JamKeberangkatan;

    public Jadwal(String jamKeberangkatan) {
        this.JamKeberangkatan = jamKeberangkatan;
    }

    public String getNamaRute() {
        return JamKeberangkatan;
    }
    public String toString(){return JamKeberangkatan;} // bawaan dari kelas Object, sehingga ketika objek Jadwal dicetak, yang ditampilkan adalah nilai JamKeberangkatan.

    public String getJamKeberangkatan() {
        return JamKeberangkatan;
    }

    public void setJamKeberangkatan(String jamKeberangkatan) {
        JamKeberangkatan = jamKeberangkatan;
    }

    public void tampilkanJadwal() {
        System.out.println("jam keberangkatan " + getJamKeberangkatan());
    }


}
