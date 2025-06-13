package cz.czechitas.ukol06.svatky;

import org.junit.jupiter.api.Test;

import java.time.MonthDay;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class SvatkySluzbaTest {


    private List<String> svatkyKeDni(int mesic, int den) throws IOException {
        return new SvatkySluzba().vyhledatSvatkyKeDni(MonthDay.of(mesic, den));
    }

    @Test
    void jednoJmeno() throws IOException {
        List<String> vysledek = svatkyKeDni(1, 19);
        assertEquals(List.of("Doubravka"), vysledek);
    }

    @Test
    void viceJmen() throws IOException {
        List<String> vysledek = svatkyKeDni(1, 18);
        assertTrue(vysledek.size() > 1);
        assertTrue(vysledek.contains("Vladislav"));
        assertTrue(vysledek.contains("Vladislava"));
    }

    @Test
    void zadneJmeno() throws IOException {
        List<String> vysledek = svatkyKeDni(1, 1);
        assertTrue(vysledek.isEmpty());
    }

}
