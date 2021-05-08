import java.util.Date;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }




}

abstract class deadline{
    Date datum;
    String naam = "";
    String vak = "";
    String informatie = "";

    public deadline(Date d, String x, String y, String z) {
        this.datum = d;
        this.naam = x;
        this.vak = y;
        this.informatie = z;
    }


}
class toets extends deadline{
    int studiepunten;
    int Minutenduur;
    String lokaal;

    public toets(Date d, String x, String y, String z,   int studiepunten, int minutenduur ,String lokaal) {
        super(d, x, y, z);
        this.studiepunten = studiepunten;
        this.Minutenduur = minutenduur;
        this.lokaal = lokaal;
    }
}
class huiswerk extends deadline{
    String teamgenoten = "";
    int prioriteitOpSchaalVanTien;

    public huiswerk(Date d, String x, String y, String z,   String teamgenoten, int prioriteitOpSchaalVanTien) {
        super(d, x, y, z);
        this.teamgenoten = teamgenoten;
        this.prioriteitOpSchaalVanTien = prioriteitOpSchaalVanTien;
    }
}