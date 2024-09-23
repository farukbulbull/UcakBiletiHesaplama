import java.util.Scanner;

public class UcakBiletiHesapla {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan giriş alma
        System.out.print("Mesafe (KM) giriniz: ");
        double mesafe = scanner.nextDouble();
        System.out.print("Yaşınızı giriniz: ");
        int yas = scanner.nextInt();
        System.out.print("Yolculuk tipini seçiniz (1: Tek Yön, 2: Gidiş-Dönüş): ");
        int yolculukTipi = scanner.nextInt();

        // Geçerlilik kontrolü
        if (mesafe <= 0 || yas < 0 || (yolculukTipi != 1 && yolculukTipi != 2)) {
            System.out.println("Hatalı Veri Girdiniz !");
            return; // Programdan çık
        }

        // Bilet fiyatı hesaplama
        double birimFiyat = 0.10; // TL/km
        double toplamFiyat = mesafe * birimFiyat;

        // İndirim hesaplama
        if (yas < 12) {
            toplamFiyat *= 0.50; // %50 indirim
        } else if (yas >= 12 && yas <= 24) {
            toplamFiyat *= 0.90; // %10 indirim
        } else if (yas > 65) {
            toplamFiyat *= 0.70; // %30 indirim
        }

        if (yolculukTipi == 2) {
            toplamFiyat *= 0.80; // %20 indirim
        }

        // Sonucu yazdırma
        System.out.printf("Toplam Uçak Bileti Fiyatı: %.2f TL%n", toplamFiyat);
    }
}
