package TugasPemlan3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<DataMahasiswa> daftarMahasiswa = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihanMenu;
        boolean lanjutMenu = true;

        while (lanjutMenu) {
            while (true) {
                System.out.println("============ Program KHS ============");
                System.out.println("1. Input KHS");
                System.out.println("2. Cetak KHS");
                System.out.println("3. Keluar dari sistem");
                System.out.print("Pilihan: ");
                pilihanMenu = sc.nextInt();
                sc.nextLine();

                switch (pilihanMenu) {
                    case 1:
                        // Input data mahasiswa
                        System.out.print("NIM Mahasiswa: ");
                        String nim = sc.nextLine();
                        System.out.print("Nama Mahasiswa: ");
                        String nama = sc.nextLine();

                        DataMahasiswa mahasiswa = new DataMahasiswa();
                        mahasiswa.setMhs_nim(nim);
                        mahasiswa.setMhs_nama(nama);
                        mahasiswa.setDaftarMataKuliah(new ArrayList<>());

                        daftarMahasiswa.add(mahasiswa);

                        while (true) {
                            // Input data mata kuliah
                            MataKuliah mataKuliah = new MataKuliah();
                            System.out.print("Kode Mata Kuliah: ");
                            String kodeMk = sc.nextLine();
                            mataKuliah.setMk_kode(kodeMk);
                            System.out.print("Nama Mata Kuliah: ");
                            String namaMk = sc.nextLine();
                            mataKuliah.setMk_nama(namaMk);

                            // Input nilai
                            System.out.print("Nilai (0.0-4.0): ");
                            double nilaiAngka = Double.parseDouble(sc.nextLine());
                            if (nilaiAngka < 0.0 || nilaiAngka > 4.0) {
                                System.out.println("Nilai harus dalam rentang 0.0 hingga 4.0.");
                                return;
                            }

                            String nilaiHuruf;
                            if (nilaiAngka >= 3.7) {
                                nilaiHuruf = "A";
                            } else if (nilaiAngka >= 3.2) {
                                nilaiHuruf = "B+";
                            } else if (nilaiAngka >= 2.7) {
                                nilaiHuruf = "B";
                            } else if (nilaiAngka >= 2.2) {
                                nilaiHuruf = "C+";
                            } else if (nilaiAngka >= 1.7) {
                                nilaiHuruf = "C";
                            } else if (nilaiAngka >= 1.2) {
                                nilaiHuruf = "D";
                            } else {
                                nilaiHuruf = "E";
                            }

                            mataKuliah.setMk_nilai(nilaiHuruf);
                            mahasiswa.getDaftarMataKuliah().add(mataKuliah);

                            System.out.print("Tambah mata kuliah lagi? (Y/n) ");
                            String opsi = sc.nextLine();
                            if (!opsi.equalsIgnoreCase("y")) {
                                break;
                            }
                        }
                        break;
                    case 2:
                        System.out.print("Masukkan NIM: ");
                        String inputNIM = sc.nextLine();
                        boolean nimKetemu = false;
                        for (DataMahasiswa mhs : daftarMahasiswa) {
                            if (mhs.getMhs_nim().equals(inputNIM)) {
                                nimKetemu = true;
                                System.out.println("Kartu Hasil Studi (KHS) untuk Mahasiswa dengan NIM " + inputNIM + ":");
                                System.out.println("Nama Mahasiswa: " + mhs.getMhs_nama());
                                for (MataKuliah mk : mhs.getDaftarMataKuliah()) {
                                    System.out.println("Kode Mata Kuliah: " + mk.getMk_kode());
                                    System.out.println("Nama Mata Kuliah: " + mk.getMk_nama());
                                    System.out.println("Nilai: " + mk.getMk_nilai());
                                    System.out.println();
                                }
                                break;
                            }
                        }
                        if (!nimKetemu) {
                            System.out.println("Mahasiswa dengan NIM " + inputNIM + " tidak ditemukan.");
                        }
                        break;
                    case 3:
                        System.out.println("SISTEM BERHENTI");
                        lanjutMenu = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih 1-3.");
                }

                if (!lanjutMenu) {
                    break;
                }
            }
        }
    }
}
