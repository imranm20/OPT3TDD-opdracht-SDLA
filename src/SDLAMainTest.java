import org.junit.jupiter.api.BeforeEach;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class SDLAMainTest{

    @org.junit.jupiter.api.Test
    void MCDC1eTrue () throws ParseException {
        SDLAMain test = new SDLAMain();
        test.addDeadline();
        assertEquals(1, test.opslag.size());
    }
    @org.junit.jupiter.api.Test
    void MCDC2eTrue () throws ParseException {
        SDLAMain test = new SDLAMain();
        test.addDeadline();
        assertEquals(1, test.opslag.size());
    }

    @org.junit.jupiter.api.Test
    void MCDC1eFalse () throws ParseException {
        SDLAMain test = new SDLAMain();
        test.addDeadline();
        assertEquals(0, test.opslag.size());
    }

    @org.junit.jupiter.api.Test
    void MCDC2eFalse () throws ParseException {
        SDLAMain test = new SDLAMain();
        test.addDeadline();
        assertEquals(0, test.opslag.size());
    }

    @org.junit.jupiter.api.Test
    void MCDC3eFalse () throws ParseException {
        SDLAMain test = new SDLAMain();
        test.addDeadline();
        assertEquals(0, test.opslag.size());
    }

    @org.junit.jupiter.api.Test
    void MCDC4eFalse () throws ParseException {
        SDLAMain test = new SDLAMain();
        test.addDeadline();
        assertEquals(0, test.opslag.size());
    }
}