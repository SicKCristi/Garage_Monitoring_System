package Implementare_modele;
import Implementare_modele.Client;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Implementare_modele.Contabil;
import Implementare_modele.TipAutomobil;
import Implementare_modele.Birou;
import Implementare_modele.TipVechime;
import Implementare_modele.Client;

public class ContabilTest {

    @org.junit.Test
    public void testClientNou() {
        Birou b1=new Birou(1,12,18);
        Contabil contabil = new Contabil("Radu",
                "Ioana",
                "ioana.radu@firma.com",
                "0722000111",
                TipVechime.incepator,
                3000,
                b1);
        Client client = new Client("Popescu",
                "Ion",
                "ion.popescu@email.com",
                "0744000000",
                TipAutomobil.A,
                "1234567891012345",
                11);
        assertEquals("Client nou", contabil.determinareFidelitate(client));
    }

    @org.junit.Test
    public void testClientFidel() {
        Birou b2=new Birou(4,8,18);
        Contabil contabil = new Contabil("Georgescu",
                "Andrei",
                "andrei.georgescu@firma.com",
                "0733111222",
                TipVechime.mediu,
                4500,
                b2);
        Client client  = new Client(
                "Pop",
                "Andrei",
                "andrei.pop@yahoo.com",
                "0744555666",
                TipAutomobil.B,
                "1234567891012345",
                45
        );

        assertEquals("Client fidel", contabil.determinareFidelitate(client));
    }

    @org.junit.Test
    public void testClientLoial() {
        Birou b3=new Birou(2,10,18);
        Contabil contabil = new Contabil("Popa",
                "Elena",
                "elena.popa@firma.com",
                "0744222333",
                TipVechime.senior,
                6000,
                b3);
        Client client = new Client("Dumitrescu",
                "Elena",
                "elena.dumitrescu@outlook.com",
                "0755666777",
                TipAutomobil.C,
                "1234567891012846",
                52);
        assertEquals("Client loial", contabil.determinareFidelitate(client));
    }

    @org.junit.Test
    public void testClientFaraVizite() {
        Birou b4=new Birou(0,6,14);
        Contabil contabil = new Contabil("Marin",
                "Cristian",
                "cristian.marin@firma.com",
                "0755333444",
                TipVechime.mediu,
                5000,
                b4);
        Client client = new Client("Ionescu",
                "Maria",
                "maria.ionescu@gmail.com",
                "0722333444",
                TipAutomobil.A,
                "1234577291052745",
                0);
        assertEquals("Fara vizite inregistrate", contabil.determinareFidelitate(client));
    }
}
