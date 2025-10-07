import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String output = "ozgecmis.pdf";

        try (PDDocument doc = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            doc.addPage(page);

            // Fotoğraf yolu
            String photoPath = "src/main/resources/photo.jpg"; // kendi fotoğrafının yolu
            PDImageXObject photo = null;
            File photoFile = new File(photoPath);
            if (photoFile.exists()) {
                photo = PDImageXObject.createFromFile(photoPath, doc);
            }

            float margin = 50;
            float x = margin;
            float y = page.getMediaBox().getHeight() - margin;

            try (PDPageContentStream cs = new PDPageContentStream(doc, page)) {

                // Fotoğraf sağ üstte
                if (photo != null) {
                    float imgW = 120;
                    float imgH = 120;
                    float imgX = page.getMediaBox().getWidth() - margin - imgW;
                    float imgY = y - imgH + 20;
                    cs.drawImage(photo, imgX, imgY, imgW, imgH);
                }

                // Başlık ve iletişim
                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA_BOLD, 20);
                cs.setLeading(16);
                cs.newLineAtOffset(x, y);
                cs.showText("Ayse Toptas");
                cs.newLine();
                cs.setFont(PDType1Font.HELVETICA, 11);
                cs.showText("Telefon: +90 555 555 55 55  |  E-posta: ayse.toptas@example.com");
                cs.newLine();
                cs.showText("GitHub: github.com/aysetoptas  |  Adres: Istanbul, Turkiye");
                cs.endText();

                // Profil
                y -= 90;
                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA_BOLD, 14);
                cs.newLineAtOffset(x, y);
                cs.showText("Profil");
                cs.endText();

                y -= 20;
                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA, 11);
                cs.setLeading(14);
                cs.newLineAtOffset(x, y);
                cs.showText("Yazilim muhendisligi ogrencisi. Yazilim gelistirme, problem cozme ve ekip calismasina ilgi duyan,");
                cs.newLine();
                cs.showText("ogrenmeye acik ve disiplinli. Java ve algoritmalar uzerine calisiyor, yeni teknolojileri ogrenmeye hevesli.");
                cs.endText();

                // Is Deneyimi
                y -= 60;
                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA_BOLD, 14);
                cs.newLineAtOffset(x, y);
                cs.showText("Is Deneyimi");
                cs.endText();

                // Deneyim 1
                y -= 24;
                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA, 12);
                cs.newLineAtOffset(x, y);
                cs.showText("Backend Developer — NovaTech Yazilim (06/2023–09/2024)");
                cs.endText();

                y -= 16;
                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA, 11);
                cs.setLeading(14);
                cs.newLineAtOffset(x + 12, y);
                cs.showText("- Java + Spring Boot ile REST API gelistirme, PostgreSQL optimizasyonu");
                cs.newLine();
                cs.showText("- Maven, JUnit, Docker ile CI/CD sureclerini iyilestirme");
                cs.newLine();
                cs.showText("- Ekip icinde kod incelemelerine aktif katilim");
                cs.endText();

                // Deneyim 2
                y -= 60;
                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA, 12);
                cs.newLineAtOffset(x, y);
                cs.showText("Java Developer Intern — Orion Labs (02/2023–05/2023)");
                cs.endText();

                y -= 16;
                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA, 11);
                cs.setLeading(14);
                cs.newLineAtOffset(x + 12, y);
                cs.showText("- Raporlama ve loglama sistemleri gelistirme");
                cs.newLine();
                cs.showText("- Kod inceleme sureclerine destek");
                cs.newLine();
                cs.showText("- Basit servislerin gelistirilmesi ve test edilmesi");
                cs.newLine();
                cs.showText("- Jira ile gorev takibi ve ekip ile iletisim");
                cs.endText();

                // Deneyim 3
                y -= 70;
                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA, 12);
                cs.newLineAtOffset(x, y);
                cs.showText("Junior Developer — Atlas Soft (10/2024–Devam)");
                cs.endText();

                y -= 16;
                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA, 11);
                cs.setLeading(14);
                cs.newLineAtOffset(x + 12, y);
                cs.showText("- Mikroservis entegrasyonlari ve mesajlasma (Kafka)");
                cs.newLine();
                cs.showText("- Unit test kapsamlarini artirma");
                cs.newLine();
                cs.showText("- Yeni ozelliklerin planlanmasi ve uygulanmasi");
                cs.newLine();
                cs.showText("- Agile metodolojisi ile sprint takibi");
                cs.endText();

                // Egitim
                y -= 80;
                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA_BOLD, 14);
                cs.newLineAtOffset(x, y);
                cs.showText("Egitim");
                cs.endText();

                y -= 20;
                cs.beginText();
                cs.setFont(PDType1Font.HELVETICA, 11);
                cs.setLeading(14);
                cs.newLineAtOffset(x, y);
                cs.showText("Kirkklareli Universitesi — Yazilim Muhendisligi (2023–Devam)");
                cs.newLine();
                cs.showText("Ilgi alanlari: Java, algoritmalar, veri yapilari, yazilim gelistirme");
                cs.endText();
            }

            doc.save(output);
            System.out.println("Ozgecmis PDF olusturuldu: " + output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
