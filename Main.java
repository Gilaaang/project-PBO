import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String namaPembeli;
        double totalHarga, uangBayar, uangKembali;
        double panjang, lebar, tinggi, volumeBalok;

        try {
            System.out.print("Masukkan nama pembeli: ");
            namaPembeli = scanner.nextLine();
            while (true) {
                try {
                    System.out.print("Masukkan total harga: ");
                    totalHarga = Double.parseDouble(scanner.nextLine());
                    if (totalHarga <= 0) {
                        System.out.println("Total harga harus lebih besar dari 0.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input harus berupa angka.");
                }
            }
            while (true) {
                try {
                    System.out.print("Masukkan uang bayar: ");
                    uangBayar = Double.parseDouble(scanner.nextLine());
                    if (uangBayar < totalHarga) {
                        System.out.println("Uang bayar harus lebih besar atau sama dengan total harga.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input harus berupa angka.");
                }
            }
            while (true) {
                try {
                    System.out.print("Masukkan panjang balok (dalam cm): ");
                    panjang = Double.parseDouble(scanner.nextLine());
                    if (panjang <= 0) {
                        System.out.println("Panjang balok harus lebih besar dari 0.");
                        continue;
                    }
                    System.out.print("Masukkan lebar balok (dalam cm): ");
                    lebar = Double.parseDouble(scanner.nextLine());
                    if (lebar <= 0) {
                        System.out.println("Lebar balok harus lebih besar dari 0.");
                        continue;
                    }
                    System.out.print("Masukkan tinggi balok (dalam cm): ");
                    tinggi = Double.parseDouble(scanner.nextLine());
                    if (tinggi <= 0) {
                        System.out.println("Tinggi balok harus lebih besar dari 0.");
                        continue;
                    }
                    break; // Keluar dari loop jika semua input valid
                } catch (NumberFormatException e) {
                    System.out.println("Input harus berupa angka.");
                }
            }
            volumeBalok = panjang * lebar * tinggi;
            System.out.println("\nVolume balok kayu: " + volumeBalok + " cm³");

            uangKembali = uangBayar - totalHarga;
            System.out.println("\nUang Kembalian: " + uangKembali);

            try (FileWriter writer = new FileWriter("transaksi_belanja.txt")) {
                writer.write("Nama Pembeli: " + namaPembeli + "\n");
                writer.write("Total Harga: " + totalHarga + "\n");
                writer.write("Uang Bayar: " + uangBayar + "\n");
                writer.write("Uang Kembalian: " + uangKembali + "\n");
                writer.write("Volume Balok Kayu: " + volumeBalok + " cm³\n");
                System.out.println("\nHasil telah disimpan ke file 'transaksi_belanja.txt'.");
            } catch (IOException e) {
                System.out.println("Terjadi kesalahan saat menyimpan ke file: " + e.getMessage());
            }
        } finally {
            System.out.println("Transaksi selesai.");
            scanner.close();
        }
    }
}
