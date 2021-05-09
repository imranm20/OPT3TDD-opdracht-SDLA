import org.junit.jupiter.api.*;

import java.text.ParseException;
import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SDLAMainTest {
    public boolean eqMethode(String x, LocalDate y) {
        LocalDate vandaag = LocalDate.now();
        int comparison = y.compareTo(vandaag);
        //zelfde voorwaarde als in de addDeadline methode
        return x.length() <= 249 && comparison > -1;
    }

    @Order(2)
    @Test
    void equivalntietest() {
        String tekst1 = "Dit\t\t zijn\t\t200\t\tkarakters\t\n" +
                "Dit\t\t zijn\t\t200\t\tkarake\t\n" +
                "Dit\t\t zijn\t\t200\t\tkarakters\t\n" +
                "Dit\t\t zijn\t\t200\t\tkarakters\t\n" +
                "Dit\t\t zijn\t\t200\t\tkarakters\t\n" +
                "Dit\t\t zijn\t\t200\t\tkarakters\t\n" +
                "Dit\t\t zijn\t\t200\t\tkarakters\t\n" +
                "Dit\t\t zijn\t\t200\t\tkarakters\t\n" +
                "Dit\t\t zijn\t\t200kar\t\t\t\t      \n";
        String tekst2 = "";
        String tekst3 = "Dit zijn 100  karakters..\n" +
                "Dit zijn 100  karakters..\n" +
                "\n" +
                "Dit zijn 100  karakters.....\n" +
                "\n" +
                "Dit zijn 100  ..\n";

        LocalDate datum1 = LocalDate.of(1999, 1, 1);
        LocalDate datum2 = LocalDate.now();
        LocalDate datum3 = LocalDate.of(2022, 11, 11);


        assertFalse(eqMethode(tekst3, datum1));
        assertTrue(eqMethode(tekst3, datum2));
        assertTrue(eqMethode(tekst3, datum3));
        assertFalse(eqMethode(tekst1, datum3));
        assertTrue(eqMethode(tekst2, datum3));
        assertTrue(eqMethode(tekst3, datum3));
    }

    public boolean PTMethode(String invoer, LocalDate date, int chars, boolean isJuist) {
        LocalDate vandaag = LocalDate.now();
        int comparison = date.compareTo(vandaag);

        if (!(invoer.equalsIgnoreCase("Toets") || invoer.equalsIgnoreCase("Huiswerk"))) {
            return false;
        }
        if (!(comparison > -1)) {
            return false;
        }
        if (chars > 249) {
            return false;
        }
        return isJuist;
    }

    @Order(3)
    @Test
    void pairwiseTest() {
        LocalDate testDate1 = LocalDate.of(2024, 4, 4);
        LocalDate testDate2 = LocalDate.of(1999, 1, 2);
        LocalDate testDate3 = LocalDate.now();
        assertFalse(PTMethode("toets", testDate2, 244, true));
        assertFalse(PTMethode("hallo", testDate1, 123, true));
        assertFalse(PTMethode("Toets", testDate1, 200, false));
        assertFalse(PTMethode("Huiswerk", testDate1, 250, true));

        assertTrue(PTMethode("Huiswerk", testDate1, 15, true));
        assertTrue(PTMethode("toets", testDate3, 20, true));


    }

    @Order(1)
    @Test
    void allMCDCTest() {
    }

    @Disabled
    @Test
    void MCDC1eTrue() throws ParseException {
        SDLAMain test = new SDLAMain();
        test.addDeadline();
        assertEquals(1, test.opslag.size());
    }

    @Disabled
    @Test
    void MCDC2eTrue() throws ParseException {
        SDLAMain test = new SDLAMain();
        test.addDeadline();
        assertEquals(1, test.opslag.size());
    }

    @Disabled
    @Test
    void MCDC1eFalse() throws ParseException {
        SDLAMain test = new SDLAMain();
        test.addDeadline();
        assertEquals(0, test.opslag.size());
    }

    @Disabled
    @Test
    void MCDC2eFalse() throws ParseException {
        SDLAMain test = new SDLAMain();
        test.addDeadline();
        assertEquals(0, test.opslag.size());
    }

    @Disabled
    @Test
    void MCDC3eFalse() throws ParseException {
        SDLAMain test = new SDLAMain();
        test.addDeadline();
        assertEquals(0, test.opslag.size());
    }

    @Disabled
    @Test
    void MCDC4eFalse() throws ParseException {
        SDLAMain test = new SDLAMain();
        test.addDeadline();
        assertEquals(0, test.opslag.size());
    }


}