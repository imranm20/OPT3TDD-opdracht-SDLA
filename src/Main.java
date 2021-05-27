import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private SDLAmethod inMain1 = new SDLAmethod();
    private AgendaData inMain2 = new AgendaData();
    public static void menu() {
        System.out.println("welkom bij het menu");
        System.exit(0);
    }
    public static void main(String[] args) {


    }
}

class AgendaData {
    public static ArrayList<Opdracht> opslag = new ArrayList<>();

    public Opdracht getDatum() {
        Opdracht returned = null;

        return returned;
    }
}

class SDLAmethod {
      Scanner s = new Scanner(System.in);

    public void addDeadline() throws ParseException {
        System.out.println("Welkom bij het toevoegen van een deadline, als u wilt stoppen  type dan" + "'stop'");
        System.out.println("Geef de datum in dit format: jjjj-mm-dd");

        String regDate = s.nextLine();
        LocalDate vandaag = LocalDate.now();
        LocalDate date1 = LocalDate.parse(regDate);
        int comparison = date1.compareTo(vandaag);
        if (regDate.equals("stop") || (comparison > -1)) {
            Main.menu();       }

        System.out.println("Geef de naam van de deadline:");
        String naam1 = s.nextLine();
        if (naam1.equals("stop")) {
            Main.menu();        }
        System.out.println("Geef de naam van het vak:");
        String vaknaam1 = s.nextLine();
        if (vaknaam1.equals("stop")) {
            Main.menu();        }
        System.out.println("Geef de omschrijving over deze deadline:");
        String info1 = s.nextLine();
        if (info1.equals("stop") || info1.length() <= 249) {
            Main.menu();       }
        System.out.println("Voer de soort deadline in ( toets/huiswerk )");
        String dd = s.nextLine();
        if (dd.equals("stop") || !(dd.equalsIgnoreCase("toets") || dd.equalsIgnoreCase("huiswerk"))) {
            Main.menu();        }
        if (dd.equalsIgnoreCase("toets")) {
            s.nextLine();
            System.out.println("Voer het aantal studiepunten in(geheel nummer))");
            String stdinvoer = s.nextLine();
            if (stdinvoer.equals("stop")) {
                Main.menu();            }
            int std = Integer.parseInt(stdinvoer);
            System.out.println("Voer het aantal minuten in(geheel nummer))");
            String mininvoer = s.nextLine();
            if (mininvoer.equals("stop")) {
                Main.menu();            }
            int duur = Integer.parseInt(mininvoer);
            s.nextLine();
            System.out.println("Geef het lokaalnummer");
            String lokaal = s.nextLine();
            if (lokaal.equals("stop")) {
                Main.menu();
            } else {
                ToetsOpdracht t1 = new ToetsOpdracht(date1, naam1, vaknaam1, info1, std, duur, lokaal);
                AgendaData.opslag.add(t1);            }
            }
             else if (dd.equalsIgnoreCase("huiswerk")) {
            System.out.println("Voer je teamgenoten in");
            String team1 = s.nextLine();
            if (team1.equals("stop")) {
                Main.menu();
            }
            System.out.println("Geef de prioriteit op een schaal van tien(geheel nummer)");
            String prio = s.nextLine();
            int prioriteit = Integer.parseInt(prio);
            if (prio.equals("stop")) {
                Main.menu();
            } else {
                HuiswerkOpdracht h1 = new HuiswerkOpdracht(date1, naam1, vaknaam1, info1, team1, prioriteit);
                AgendaData.opslag.add(h1);
            }
        }
    }

    public void addInfo(){
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
