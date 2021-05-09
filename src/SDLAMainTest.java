import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class SDLAMainTest{
    @Test
    void equivalntietest(){
        String tekst1  = "Dit\t\t zijn\t\t200\t\tkarakters\t\n" +
                "Dit\t\t zijn\t\t200\t\tkarake\t\n" +
                "Dit\t\t zijn\t\t200\t\tkarakters\t\n" +
                "Dit\t\t zijn\t\t200\t\tkarakters\t\n" +
                "Dit\t\t zijn\t\t200\t\tkarakters\t\n" +
                "Dit\t\t zijn\t\t200\t\tkarakters\t\n" +
                "Dit\t\t zijn\t\t200\t\tkarakters\t\n" +
                "Dit\t\t zijn\t\t200\t\tkarakters\t\n" +
                "Dit\t\t zijn\t\t200kar\t\t\t\t      \n";
        String tekst2  = "";
        String tekst3  = "Dit zijn 100  karakters..\n" +
                "Dit zijn 100  karakters..\n" +
                "\n" +
                "Dit zijn 100  karakters.....\n" +
                "\n" +
                "Dit zijn 100  ..\n";

        LocalDate datum1 = LocalDate.of(1999,1,1);
        LocalDate datum2 =  LocalDate.now();
        LocalDate datum3 =   LocalDate.of(2022,11,11);


        assertFalse(eqMethode(tekst3, datum1));
        assertTrue(eqMethode(tekst3, datum2));
        assertTrue(eqMethode(tekst3, datum3));
        assertFalse(eqMethode(tekst1, datum3));
        assertTrue(eqMethode(tekst2, datum3));
        assertTrue(eqMethode(tekst3, datum3));
    }

    @Test
    void pairwiseTest(){


    }
    @Test
    void MCDC1eTrue () throws ParseException {
        SDLAMain test = new SDLAMain();
        test.addDeadline();
        assertEquals(1, test.opslag.size());
    }
    @Test
    void MCDC2eTrue () throws ParseException {
        SDLAMain test = new SDLAMain();
        test.addDeadline();
        assertEquals(1, test.opslag.size());
    }

    @Test
    void MCDC1eFalse () throws ParseException {
        SDLAMain test = new SDLAMain();
        test.addDeadline();
        assertEquals(0, test.opslag.size());
    }

    @Test
    void MCDC2eFalse () throws ParseException {
        SDLAMain test = new SDLAMain();
        test.addDeadline();
        assertEquals(0, test.opslag.size());
    }

    @Test
    void MCDC3eFalse () throws ParseException {
        SDLAMain test = new SDLAMain();
        test.addDeadline();
        assertEquals(0, test.opslag.size());
    }

    @Test
    void MCDC4eFalse () throws ParseException {
        SDLAMain test = new SDLAMain();
        test.addDeadline();
        assertEquals(0, test.opslag.size()); }

        public boolean eqMethode(String x, LocalDate y){
            LocalDate vandaag = LocalDate.now();
            int comparison= y.compareTo(vandaag);
        //zelfde voorwaarde als in de addDeadline methode
       return x.length() <= 249 && comparison > -1;
    }






}