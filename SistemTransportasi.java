import javax.swing.*; //paket javax.swing yang digunakan untuk membuat antarmuka
import java.awt.*; //paket java.awt (Abstract Window Toolkit) yang menyediakan antarmuka grafis dasar dan alat-alat grafis
import java.awt.event.*; //paket java.awt.event yang menyediakan kelas dan antarmuka untuk menangani berbagai jenis peristiwa
import java.io.IOException; //menunjukkan bahwa telah terjadi kesalahan I/O (Input/Output) selama operasi
import java.util.ArrayList; //implementasi dari antarmuka List yang digunakan untuk membuat daftar dinamis
import java.io.FileWriter; //untuk menulis teks ke file dengan menggunakan encoding
import java.nio.file.Files; //metode statis untuk operasi file dan direktori
import java.nio.file.Paths; //merepresentasikan lokasi file atau direktori di sistem file
import java.nio.file.StandardOpenOption; //digunakan untuk menentukan bagaimana file akan dibuka atau dibuat

public class SistemTransportasi {
    private static int laporanHarian = 0; // Tambahkan variabel untuk laporan harian
    private static double totalPendapatan = 0.0; // Tambahkan variabel untuk total pendapatan

    public static void main(String[] args) {
        //Menghapus atau mengatur ulang file saat program dijalankan untuk kedua kalinya
        try{
            Files.write(Paths.get("Tiket Penumpang.txt"), "".getBytes());
            Files.write(Paths.get("Laporan Harian.txt"), "".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                createGUI(); }
        });
    }

    public static void createGUI() {
        // Membuat jendela utama
        JFrame frame = new JFrame("Aplikasi Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat komponen input
        JLabel nameLabel = new JLabel("Masukkan Nama:");
        JTextField nameField = new JTextField(20);

        JLabel idLabel = new JLabel("Masukkan ID Tiket:");
        JTextField idField = new JTextField(20);

        JLabel amountLabel = new JLabel("Jumlah Pembayaran:");
        JTextField amountField = new JTextField(20);
        amountField.setEditable(false); // Membuat field agar tidak bisa diinput manual

        ArrayList<Kendaraan> kendaraanList = new ArrayList<>();
        kendaraanList.add(new Kendaraan("1", "Bus", 40, 50000, true, "Solo - Bali"));
        kendaraanList.add(new Kendaraan("2", "Taksi", 4, 200000, true, "Surabaya - Yogyakarta"));
        kendaraanList.add(new Kendaraan("3", "Kereta", 200, 15000, true, "Jakarta - Bandung"));

        JComboBox<Kendaraan> kendaraanComboBox = new JComboBox<>(kendaraanList.toArray(new Kendaraan[0]));

        ArrayList<Rute> ruteList = new ArrayList<>();
        ruteList.add(new Route("Rute A", "Solo", "Bali"));
        ruteList.add(new Route("Rute B", "Surabaya", "Yogyakarta"));
        ruteList.add(new Route("Rute C", "Jakarta", "Bandung"));

        JComboBox<Rute> ruteComboBox = new JComboBox<>(ruteList.toArray(new Rute[0]));

        // Membuat jadwal keberangkatan untuk dipilih
        ArrayList<Jadwal> jadwalList = new ArrayList<>();
        jadwalList.add(new Jadwal("08.00"));
        jadwalList.add(new Jadwal("09.00"));
        jadwalList.add(new Jadwal("10.00"));

        JComboBox<Jadwal> jadwalComboBox = new JComboBox<>(jadwalList.toArray(new Jadwal[0]));

        JButton submitButton = new JButton("Kirim");
        JLabel resultLabel = new JLabel("");
        JLabel laporanLabel = new JLabel("Laporan Harian: " + laporanHarian); // Tambahkan label untuk laporan harian
        JLabel pendapatanLabel = new JLabel("Total Pendapatan: " + totalPendapatan); // Tambahkan label untuk total pendapatan

        kendaraanComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kendaraan kendaraan = (Kendaraan) kendaraanComboBox.getSelectedItem();
                if (kendaraan != null) {
                    amountField.setText(String.valueOf(kendaraan.getHargaTiket()));
                }
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = nameField.getText();
                String idTiket = idField.getText();
                String amountStr = amountField.getText();
                Kendaraan kendaraan = (Kendaraan) kendaraanComboBox.getSelectedItem();
                Rute rute = (Rute) ruteComboBox.getSelectedItem();
                Jadwal jadwal = (Jadwal) jadwalComboBox.getSelectedItem();

                if (nama.isEmpty() || idTiket.isEmpty() || amountStr.isEmpty()) {
                    resultLabel.setText("Nama, ID Tiket, dan Jumlah Pembayaran harus diisi!");
                } else {
                    double amount = Double.parseDouble(amountStr);
                    Penumpang penumpang = new Penumpang(nama, idTiket, kendaraan, rute, jadwal);
                    resultLabel.setText("Penumpang: " + penumpang.getNama() + ", ID Tiket: " + penumpang.getIdTiket() +
                            ", Kendaraan: " + penumpang.getKendaraan().getNamaKendaraan() +
                            ", Rute: " + penumpang.getRute().getNamaRute() + ",Jam: " + penumpang.getjadwal().getJamKeberangkatan());

                    // Menambahkan penumpang ke laporan harian
                    laporanHarian++;
                    totalPendapatan += amount;
                    laporanLabel.setText("Laporan Harian: " + laporanHarian);
                    pendapatanLabel.setText("Total Pendapatan: " + totalPendapatan);

                    // Menyimpan data penumpang dan laporan harian ke file
                    try (FileWriter writer = new FileWriter("Tiket Penumpang.txt", true)) {
                        writer.write("Nama Penumpang: " + penumpang.getNama() + "\n");
                        writer.write("ID Tiket: " + penumpang.getIdTiket() + "\n");
                        writer.write("Jenis Kendaraan: " + penumpang.getKendaraan().getNamaKendaraan() + "\n");
                        writer.write("Rute: " + penumpang.getRute().getNamaRute() + "\n");
                        writer.write("Jam Keberangkatan: " + penumpang.getjadwal() + "\n");
                        writer.write("Jumlah Pembayaran: " + amount + "\n\n");
                    } catch (IOException ex) {
                        resultLabel.setText("Terjadi kesalahan saat menyimpan ke file: " + ex.getMessage());
                    }
                    try (FileWriter laporanWriter = new FileWriter("Laporan Harian.txt", true)) {
                        laporanWriter.write("Total Penumpang Harian: " + laporanHarian + "\n");
                        laporanWriter.write("Total Pendapatan Harian: " + totalPendapatan + "\n\n");
                    } catch (IOException ex) {
                        resultLabel.setText("Terjadi kesalahan saat menyimpan ke file laporan: " + ex.getMessage());
                    }
                }
            }
        });

        frame.setLayout(new GridLayout(8, 2));
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(idLabel);
        frame.add(idField);
        frame.add(amountLabel);
        frame.add(amountField);
        frame.add(new JLabel("Pilih Kendaraan:"));
        frame.add(kendaraanComboBox);
        frame.add(new JLabel("Pilih Rute:"));
        frame.add(ruteComboBox);
        frame.add(new JLabel("Pilih jadwal:"));
        frame.add(jadwalComboBox);
        frame.add(submitButton);
        frame.add(resultLabel);
        frame.add(laporanLabel); // Menambahkan label laporan harian
        frame.add(pendapatanLabel); // Menambahkan label pendapatan

        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}