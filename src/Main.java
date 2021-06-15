import javax.print.DocFlavor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static SDLAMethodsFactory sdlaMethodObject = new SDLAMethodsFactory();
    public static AgendaData agendaDataObject = new AgendaData();

    public static void menu() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welkom bij het menu.");
        System.out.println("Voer het nummer in van de optie die u wilt.");
        System.out.println("1: Plaats een opdracht");
        System.out.println("2: Verkrijg uw opdracht");
        int keuze = scanner.nextInt();
        if (keuze == 1){sdlaMethodObject.addOpdrachtStart();}
        else if (keuze == 2){agendaDataObject.printOpdracht();}

    }
    public static void main(String[] args) {
    menu();

    }
}

class AgendaData {

    public ArrayList<Opdracht> opslag = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public Opdracht getOpdrachtenOpDatum(LocalDate dag, String naamOpdracht) {
        for (int i = 0; i < Main.agendaDataObject.opslag.size(); i++)
            if (Main.agendaDataObject.opslag.get(i).getDatum().equals(dag) && Main.agendaDataObject.opslag.get(i).getNaam().equalsIgnoreCase(naamOpdracht)) {
                return Main.agendaDataObject.opslag.get(i);
            }
        return null;
    }

    public void printOpdracht() {
        System.out.println("Geef de datum waarop de opdracht plaats vind, (jjjj-mm-dd)");
        String regDate = scanner.nextLine();
        LocalDate date = LocalDate.parse(regDate);
        System.out.println("Geef de naam van de opdracht");
        String naam = scanner.nextLine();
        Opdracht opdracht = getOpdrachtenOpDatum(date, naam);
        if (opdracht == null) {
            System.out.println("De opdracht bestaat niet");
        } else {
            System.out.println(opdracht.toString());
        }
    }
}
class SDLAMethodsFactory {
    private Scanner scanner = new Scanner(System.in);

    public void addOpdrachtStart() {
        System.out.println("Voer de soort opdracht in ( toets/huiswerk )");

        String soortOpdracht = scanner.nextLine();

            if (soortOpdracht.equalsIgnoreCase("toets") ) {
                this.addToetsOpdracht();
            }

            else if (soortOpdracht.equalsIgnoreCase("huiswerk") ) {
                this.addHuiswerkOpdracht();
            }

            else if (soortOpdracht.equalsIgnoreCase("menu")) {
                Main.menu();
            }

    }

        private void addToetsOpdracht () {
            System.out.println("Welkom bij het toevoegen van een toets-opdracht, als u wilt stoppen  type dan 'stop'");
            System.out.println("Geef de datum in dit format: jjjj-mm-dd, de datum moet na vandaag zijn!");

            String regDate = scanner.nextLine();
            LocalDate vandaag = LocalDate.now();
            LocalDate date1 = LocalDate.parse(regDate);
            int comparison = date1.compareTo(vandaag);
            if (regDate.equals("stop") || (comparison < -1)) {
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
            if (omschrijvingToets.equals("stop") || omschrijvingToets.length() >= 249) {
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
            System.out.println("Geef het lokaalnummer");
            String lokaal = scanner.nextLine();
            if (lokaal.equals("stop")) {
                Main.menu();}
            else {
                ToetsOpdracht t1 = new ToetsOpdracht(date1, toetsnaam, vaknaam1, omschrijvingToets, std, duur, lokaal);
                Main.agendaDataObject.opslag.add(t1);
                System.out.println("Toegevoegd!");
                Main.menu();
            }

        }
        private void addHuiswerkOpdracht(){
            System.out.println("Welkom bij het toevoegen van een huiswerk-opdracht, als u wilt stoppen  type dan" + "'stop'");
            System.out.println("Geef de datum in dit format: jjjj-mm-dd" + "\n" + "De datum moet na vandaag zijn!");

            String regDate = scanner.nextLine();
            LocalDate vandaag = LocalDate.now();
            LocalDate date1 = LocalDate.parse(regDate);
            int comparison = date1.compareTo(vandaag);
            if (regDate.equals("stop") || (comparison < -1)) {
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
            if (omschrijving.equals("stop") || omschrijving.length() >= 249) {
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
                Main.agendaDataObject.opslag.add(h1);
               System.out.println("Toegevoegd!");
                Main.menu();
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
    abstract int getWorkload();

    public String toString(){

        return ( "Vak: "+ this.vak+ ", Naam opdracht: " + this.naam + "\ndatum :" + this.datum.toString() + "\n" + this.omschrijving + "\n");
    }
    public LocalDate getDatum() {
        return datum;
    }

    public String getNaam() {
        return naam;
    }

    public String getVak() {
        return vak;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setVak(String vak) {
        this.vak = vak;
    }

    public void setOmschrijving(String omschrijving) {
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

    @Override
    public int getWorkload() {
        int workload = 0;
        for(int i = 0; i < Main.agendaDataObject.opslag.size(); i++){
        if (Main.agendaDataObject.opslag.get(i) instanceof ToetsOpdracht){
                workload++;}
        }
        return workload;
    }

    @Override
    public String toString() {
        return super.toString() +
                "studiepunten=" + studiepunten +
                " \nminutenduur =" + minutenduur +
                " \nlokaal= " + lokaal + '\n';
    }

    public int getStudiepunten() {
        return studiepunten;
    }

    public int getMinutenduur() {
        return minutenduur;
    }

    public String getLokaal() {
        return lokaal;
    }

    public void setStudiepunten(int studiepunten) {
        this.studiepunten = studiepunten;
    }

    public void setMinutenduur(int minutenduur) {
        this.minutenduur = minutenduur;
    }

    public void setLokaal(String lokaal) {
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

    public String getTeamgenoten() {
        return teamgenoten;
    }

    public int getPrioriteitOpSchaalVanTien() {
        return prioriteitOpSchaalVanTien;
    }

    public void setTeamgenoten(String teamgenoten) {
        this.teamgenoten = teamgenoten;
    }

    public void setPrioriteitOpSchaalVanTien(int prioriteitOpSchaalVanTien) {
        this.prioriteitOpSchaalVanTien = prioriteitOpSchaalVanTien;
    }

    @Override
   public int getWorkload() {
        int workload = 0;
        for(int i = 0; i < Main.agendaDataObject.opslag.size(); i++){
            if (Main.agendaDataObject.opslag.get(i) instanceof HuiswerkOpdracht){
                workload++;}
        }
        return workload;
    }

    @Override
    public String toString() {
        return super.toString() + "HuiswerkOpdracht" +
                "teamgenoten = " + teamgenoten +
                "\nprioriteitOpSchaalVanTien = " + prioriteitOpSchaalVanTien ;
    }
}
