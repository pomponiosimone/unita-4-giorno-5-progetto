//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ElementoMulti[] elementi = new ElementoMulti[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Inserisci il tipo di elemento multimediale (1: Immagine, 2: Audio, 3: Video) 0 per terminare inserimento: ");
            int tipo = scanner.nextInt();
            scanner.nextLine();
            if (tipo == 0) {
                System.out.println("Terminato inserimento elementi.");
                break;
            }

            if (tipo > 3) {
                System.out.println("Inserisci un numero da 1 a 3!!!!!");
                i--;
                continue;
            }


            System.out.println("Inserisci il titolo:");
            String titolo = scanner.nextLine();


            switch (tipo) {
                case 1:
                    System.out.println("Inserisci la luminosità (da 1 a 5): ");
                    int luminosita = scanner.nextInt();
                    scanner.nextLine();
                    elementi[i] = new Immagine(titolo, luminosita);
                    break;
                case 2:
                    System.out.println("Inserisci la durata (minuti): ");
                    int durataAudio = scanner.nextInt();
                    System.out.println("Inserisci il volume(da 1 a 5): ");
                    int volumeAudio = scanner.nextInt();
                    scanner.nextLine();
                    elementi[i] = new Audio(titolo, durataAudio, volumeAudio);
                    break;
                case 3:
                    System.out.println("Inserisci la durata (minuti): ");
                    int durataVideo = scanner.nextInt();
                    System.out.println("Inserisci il volume(da 1 a 5):  ");
                    int volumeVideo = scanner.nextInt();
                    System.out.println("Inserisci la luminosità(da 1 a 5): ");
                    int luminositaVideo = scanner.nextInt();
                    scanner.nextLine();
                    elementi[i] = new Video(titolo, durataVideo, volumeVideo, luminositaVideo);
                    break;
                default:
                    System.out.println("Tipo non valido.");
                    i--;
                    break;
            }
        }

        while (true) {
            System.out.println("Scegli un numero da 1 a 5? ( 0 per finire):");
            int scelta = scanner.nextInt();

            if (scelta == 0) {
                break;
            } else if (scelta >= 1 && scelta <= 5) {
                ElementoMulti elemento = elementi[scelta - 1];
                if (elemento instanceof Riproduzione) {
                    ((Riproduzione) elemento).play();
                } else if (elemento instanceof Immagine) {
                    ((Immagine) elemento).show();
                }
            } else {
                System.out.println("Scelta non valida.");
            }
        }

        scanner.close();
    }
}


