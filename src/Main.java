import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private SDLAmethod inMain1 = new SDLAmethod();
    private agendaData inMain2 = new agendaData();
    public static void menu() {
        System.out.println("welkom bij het menu");
        System.exit(0);
    }
    public static void main(String[] args) {


    }
}

class agendaData {
    public static ArrayList<deadline> opslag = new ArrayList<>();

    public deadline getDatum() {
        deadline returned = null;

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
        System.out.println("Geef de informatie over deze deadline:");
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
                toets t1 = new toets(date1, naam1, vaknaam1, info1, std, duur, lokaal);
                agendaData.opslag.add(t1);            }
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
                huiswerk h1 = new huiswerk(date1, naam1, vaknaam1, info1, team1, prioriteit);
                agendaData.opslag.add(h1);
            }
        }
    }

    public void addInfo(){
    }
}

abstract class deadline {
    private LocalDate datum;
    private String naam;
    private String vak;
    private String informatie;

    public deadline(LocalDate date, String naam, String vak, String informatie) {
        this.datum = date;
        this.naam = naam;
        this.vak = vak;
        this.informatie = informatie;
    }

}

class toets extends deadline {
    private int studiepunten;
    private int minutenduur;
    private String lokaal;

    public toets(LocalDate date, String naam, String vak, String informatie, int studiepunten, int minutenduur, String lokaal) {
        super(date, naam, vak, informatie);
        this.studiepunten = studiepunten;
        this.minutenduur = minutenduur;
        this.lokaal = lokaal;
    }
}

class huiswerk extends deadline {
    private String teamgenoten;
    private int prioriteitOpSchaalVanTien;

    public huiswerk(LocalDate date, String naam, String vak, String informatie, String teamgenoten, int prioriteitOpSchaalVanTien) {
        super(date, naam, vak, informatie);
        this.teamgenoten = teamgenoten;
        this.prioriteitOpSchaalVanTien = prioriteitOpSchaalVanTien;
    }
}
