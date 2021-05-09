import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        SDLAMain main = new SDLAMain();
        try {
            main.addDeadline();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

class SDLAMain {
    Scanner s = new Scanner(System.in);

    public final ArrayList<deadline> opslag = new ArrayList<deadline>();

    public void addDeadline() throws ParseException {
        System.out.println("Welkom bij het toevoegen van een deadline, als u wilt stoppen  type dan" + "'stop'");
        System.out.println("Geef de datum in dit format: jjjj-mm-dd");

        String regDate = s.nextLine();
        LocalDate vandaag = LocalDate.now();
        LocalDate date1 = LocalDate.parse(regDate);
        int comparison = date1.compareTo(vandaag);
        if (regDate.equals("stop") || (comparison > -1)) {
            menu();
        }

        System.out.println("Geef de naam van de deadline:");
        String naam1 = s.nextLine();
        if (naam1.equals("stop")) {
            menu();
        }
        s.nextLine();
        System.out.println("Geef de naam van het vak:");
        String vaknaam1 = s.nextLine();
        if (vaknaam1.equals("stop")) {
            menu();
        }
        s.nextLine();
        System.out.println("Geef de informatie over deze deadline:");
        String info1 = s.nextLine();
        if (info1.equals("stop") || info1.length() <= 249) {
            menu();
        }
        s.nextLine();
        System.out.println("Voer de soort deadline in ( toets/huiswerk )");
        String dd = s.nextLine();
        if (dd.equals("stop") || !(dd.equalsIgnoreCase("toets") || dd.equalsIgnoreCase("huiswerk"))) {
            menu();
        }
        if (dd.equalsIgnoreCase("toets")) {
            s.nextLine();
            System.out.println("Voer het aantal studiepunten in(geheel nummer))");
            String stdinvoer = s.nextLine();
            if (stdinvoer.equals("stop")) {
                menu();
            }
            int std = Integer.parseInt(stdinvoer);
            s.nextLine();
            System.out.println("Voer het aantal minuten in(geheel nummer))");
            String mininvoer = s.nextLine();
            if (mininvoer.equals("stop")) {
                menu();
            }
            int duur = Integer.parseInt(mininvoer);
            s.nextLine();
            System.out.println("Geef het lokaalnummer");
            String lokaal = s.nextLine();
            if (lokaal.equals("stop")) {
                menu();
            } else {
                toets t1 = new toets(date1, naam1, vaknaam1, info1, std, duur, lokaal);
                opslag.add(t1);
            }

        } else if (dd.equalsIgnoreCase("huiswerk")) {
            System.out.println("Voer je teamgenoten in");
            String team1 = s.nextLine();
            if (team1.equals("stop")) {
                menu();
            }
            s.nextLine();
            System.out.println("Geef de prioriteit op een schaal van tien(geheel nummer)");
            String prio = s.nextLine();
            int prioriteit = Integer.parseInt(prio);
            if (prio.equals("stop")) {
                menu();
            } else {
                huiswerk h1 = new huiswerk(date1, naam1, vaknaam1, info1, team1, prioriteit);
                opslag.add(h1);
            }

        }

    }

    public void menu() {
        System.out.println("welkom bij het menu");
        System.exit(0);
    }
}

abstract class deadline {
    LocalDate datum;
    String naam;
    String vak;
    String informatie;

    public deadline(LocalDate d, String x, String y, String z) {
        this.datum = d;
        this.naam = x;
        this.vak = y;
        this.informatie = z;
    }

}

class toets extends deadline {
    int studiepunten;
    int Minutenduur;
    String lokaal;

    public toets(LocalDate d, String x, String y, String z, int studiepunten, int minutenduur, String lokaal) {
        super(d, x, y, z);
        this.studiepunten = studiepunten;
        this.Minutenduur = minutenduur;
        this.lokaal = lokaal;
    }
}

class huiswerk extends deadline {
    String teamgenoten;
    int prioriteitOpSchaalVanTien;

    public huiswerk(LocalDate d, String x, String y, String z, String teamgenoten, int prioriteitOpSchaalVanTien) {
        super(d, x, y, z);
        this.teamgenoten = teamgenoten;
        this.prioriteitOpSchaalVanTien = prioriteitOpSchaalVanTien;
    }
}
