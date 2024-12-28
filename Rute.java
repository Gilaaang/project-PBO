public abstract class Rute {
    private String namaRute;
    private String titikAwall;
    private String titikAkhir;
    
    public Rute(String namaRute, String titikAwall, String titikAkhir) {
        this.namaRute = namaRute;
        this.titikAwall = titikAwall;
        this.titikAkhir = titikAkhir;
    }

    public String getNamaRute() {
        return namaRute;
    }
    public String toString(){
        return namaRute;
    }

    public void setNamaRute(String namaRute) {
        this.namaRute = namaRute;
    }

    public String getTitikAwall() {
        return titikAwall;
    }

    public void setTitikAwall(String titikAwall) {
        this.titikAwall = titikAwall;
    }

    public String getTitikAkhir() {
        return titikAkhir;
    }

    public void setTitikAkhir(String titikAkhir) {
        this.titikAkhir = titikAkhir;
    }

    public abstract void tampilkanRute();
}
