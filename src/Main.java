import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public SDLAMethodsFactory sdlaMethodObject = new SDLAMethodsFactory();
    public AgendaData agendaDataObject = new AgendaData();
    public static void menu() {
        System.out.println("welkom bij het menu");
        System.exit(0);
    }
    public static void main(String[] args) {
        SDLAMethodsFactory sdlaMethodObject = new SDLAMethodsFactory();
        sdlaMethodObject.addOpdrachtStart();
    }
}

class AgendaData {
    public static ArrayList<Opdracht> opslag = new ArrayList<>();

    public Opdracht getOpdrachtenOpDatum() {
        Opdracht returned = null;


        return returned;
    }
}

class SDLAMethodsFactory {
    Scanner scanner = new Scanner(System.in);

    public void addOpdrachtStart() {

        boolean a = false;
        String soortOpdracht;

        while (a =false) {
            System.out.println("Voer de soort opdracht in ( toets/huiswerk )");
            soortOpdracht = scanner.nextLine();

            if (soortOpdracht.equalsIgnoreCase("toets") ) {
                this.addToetsOpdracht();
                a = true;
            }

            if (soortOpdracht.equalsIgnoreCase("huiswerk") ) {
                this.addHuiswerkOpdracht();
                a = true;
            }

            if (soortOpdracht.equalsIgnoreCase("menu")) {
                Main.menu();
                a = true;
            }
            a=false;
        }

    }

        private void addToetsOpdracht () {
            System.out.println("Welkom bij het toevoegen van een toets-opdracht, als u wilt stoppen  type dan" + "'stop'");
            System.out.println("Geef de datum in dit format: jjjj-mm-dd" + "/n" + "De datum moet na vandaag zijn!");

            String regDate = scanner.nextLine();
            LocalDate vandaag = LocalDate.now();
            LocalDate date1 = LocalDate.parse(regDate);
            int comparison = date1.compareTo(vandaag);
            if (regDate.equals("stop") || (comparison > -1)) {
                Main.menu();
            }

            System.out.println("Geef de naam van de toets opdracht.:");
            String toetsnaam = scanner.nextLine();
            if (toetsnaam.equals("stop")) {
                Main.menu();
            }

            System.out.println("Geef de naam van het vak waar de toets over gaat.:");
            String vaknaam1 = scanner.nextLine();
            if (vaknaam1.equals("stop")) {
                Main.menu();
            }

            System.out.println("Geef een korte omschrijving over deze toets:");
            String omschrijvingToets = scanner.nextLine();
            if (omschrijvingToets.equals("stop") || omschrijvingToets.length() <= 249) {
                Main.menu();
            }

            System.out.println("Voer het aantal studiepunten in(geheel nummer))");
            String stdinvoer = scanner.nextLine();
            if (stdinvoer.equals("stop")) {
                Main.menu();
            }
            int std = Integer.parseInt(stdinvoer);

            System.out.println("Voer het aantal minuten in(geheel nummer))");
            String mininvoer = scanner.nextLine();
            if (mininvoer.equals("stop")) {
                Main.menu();
            }
            int duur = Integer.parseInt(mininvoer);
            scanner.nextLine();

            System.out.println("Geef het lokaalnummer");
            String lokaal = scanner.nextLine();
            if (lokaal.equals("stop")) {
                Main.menu();
                ToetsOpdracht t1 = new ToetsOpdracht(date1, toetsnaam, vaknaam1, omschrijvingToets, std, duur, lokaal);
                AgendaData.opslag.add(t1);
            }

        }
        private void addHuiswerkOpdracht(){
            System.out.println("Welkom bij het toevoegen van een huiswerk-opdracht, als u wilt stoppen  type dan" + "'stop'");
            System.out.println("Geef de datum in dit format: jjjj-mm-dd" + "/n" + "De datum moet na vandaag zijn!");

            String regDate = scanner.nextLine();
            LocalDate vandaag = LocalDate.now();
            LocalDate date1 = LocalDate.parse(regDate);
            int comparison = date1.compareTo(vandaag);
            if (regDate.equals("stop") || (comparison > -1)) {
                Main.menu();
            }

            System.out.println("Geef de naam van de huiswerk opdracht:");
            String naam1 = scanner.nextLine();
            if (naam1.equals("stop")) {
                Main.menu();
            }
            System.out.println("Geef de naam van het vak:");
            String vaknaam1 = scanner.nextLine();
            if (vaknaam1.equals("stop")) {
                Main.menu();
            }
            System.out.println("Geef een korte omschrijving over deze huiswerk opdracht:");
            String omschrijving = scanner.nextLine();
            if (omschrijving.equals("stop") || omschrijving.length() <= 249) {
                Main.menu();
            }

            System.out.println("Voer je teamgenoten in");
            String teamgenoten = scanner.nextLine();
            if (teamgenoten.equals("stop")) {
                Main.menu();
            }
            System.out.println("Geef de prioriteit op een schaal van tien(geheel nummer)");
            String prio = scanner.nextLine();
            int prioriteit = Integer.parseInt(prio);
            if (prio.equals("stop")) {
                Main.menu();
            } else {
                HuiswerkOpdracht h1 = new HuiswerkOpdracht(date1, naam1, vaknaam1, omschrijving, teamgenoten, prioriteit);
                AgendaData.opslag.add(h1);
            }

    }
}


abstract class Opdracht {
    private LocalDate datum;
    private String naam;
    private String vak;
    private String omschrijving;


    public Opdracht(LocalDate date, String naam, String vak, String omschrijving) {
        this.datum = date;
        this.naam = naam;
        this.vak = vak;
        this.omschrijving = omschrijving;
    }

}

class ToetsOpdracht extends Opdracht {
    private int studiepunten;
    private int minutenduur;
    private String lokaal;

    public ToetsOpdracht(LocalDate date, String naam, String vak, String omschrijving, int studiepunten, int minutenduur, String lokaal) {
        super(date, naam, vak, omschrijving);
        this.studiepunten = studiepunten;
        this.minutenduur = minutenduur;
        this.lokaal = lokaal;
    }
}

class HuiswerkOpdracht extends Opdracht {
    private String teamgenoten;
    private int prioriteitOpSchaalVanTien;

    public HuiswerkOpdracht(LocalDate date, String naam, String vak, String omschrijving, String teamgenoten, int prioriteitOpSchaalVanTien) {
        super(date, naam, vak, omschrijving);
        this.teamgenoten = teamgenoten;
        this.prioriteitOpSchaalVanTien = prioriteitOpSchaalVanTien;
    }
}
