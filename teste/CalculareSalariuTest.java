package Implementare_modele;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Implementare_modele.Contabil;
import Implementare_modele.TipAutomobil;
import Implementare_modele.Birou;
import Implementare_modele.TipVechime;
import Implementare_modele.Client;
import Implementare_modele.Mecanic;

public class CalculareSalariuTest {

    @org.junit.Test
    public void testPersoanaNull() {

        Birou b2=new Birou(4,8,18);
        Contabil contabil1 = new Contabil("Georgescu",
                "Andrei",
                "andrei.georgescu@firma.com",
                "0733111222",
                TipVechime.mediu,
                4500,
                b2);

        Persoana persoanaNull = new Persoana();

        assertEquals(0, contabil1.calculareSalariu(persoanaNull));
    }

    @org.junit.Test
    public void testClient() {

        Birou b2=new Birou(4,8,18);
        Contabil contabil1 = new Contabil("Georgescu",
                "Andrei",
                "andrei.georgescu@firma.com",
                "0733111222",
                TipVechime.mediu,
                4500,
                b2);

        Client client = new Client(
                "Romeo",
                "Constantin",
                "constantin.romica1@gmail.com",
                "0737451298",
                TipAutomobil.B,
                "4890453287125681",
                0
        );
        assertEquals(0, contabil1.calculareSalariu(client));
    }

    @org.junit.Test
    public void testContabilSalariuPropriu() {

        Birou b2=new Birou(4,8,18);
        Contabil contabil1 = new Contabil("Georgescu",
                "Andrei",
                "andrei.georgescu@firma.com",
                "0733111222",
                TipVechime.mediu,
                4500,
                b2);

        assertEquals(4950, contabil1.calculareSalariuPropriu());
    }

    @org.junit.Test
    public void testContabilIncepator() {
        Birou b2=new Birou(4,8,18);
        Contabil contabil1 = new Contabil("Georgescu",
                "Andrei",
                "andrei.georgescu@firma.com",
                "0733111222",
                TipVechime.incepator,
                4500,
                b2);

        Contabil contabilIncepator = new Contabil("Anghel",
                "Radu",
                "radu.anghel@firma.com",
                "0798107524",
                TipVechime.incepator,
                4500,
                b2);

        assertNotEquals(4950, contabil1.calculareSalariu(contabilIncepator));
    }

    @org.junit.Test
    public void testContabilMediu() {

        Birou b2=new Birou(4,8,18);
        Contabil contabil1 = new Contabil("Georgescu",
                "Andrei",
                "andrei.georgescu@firma.com",
                "0733111222",
                TipVechime.mediu,
                4500,
                b2);
        Contabil contabilMediu = new Contabil("Hatu",
                "Robert",
                "robert.hatu@firma.com",
                "0763524491",
                TipVechime.mediu,
                4750,
                b2);

        assertEquals(5225, contabil1.calculareSalariu(contabilMediu));
    }

    @org.junit.Test
    public void testContabilSenior() {

        Birou b2=new Birou(4,8,18);
        Contabil contabil1 = new Contabil("Georgescu",
                "Andrei",
                "andrei.georgescu@firma.com",
                "0733111222",
                TipVechime.mediu,
                4500,
                b2);

        Contabil contabilSenior = new Contabil("Negoescu",
                "Roxana",
                "roxana.negoescu@firma.com",
                "0747398761",
                TipVechime.senior,
                4500,
                b2);

        assertEquals(5850, contabil1.calculareSalariu(contabilSenior));
    }

    @org.junit.Test
    public void testMecanicIncepator() {

        Birou b2 = new Birou(4, 8, 18);
        Contabil contabil1 = new Contabil("Georgescu",
                "Andrei",
                "andrei.georgescu@firma.com",
                "0733111222",
                TipVechime.mediu,
                4500,
                b2);
        Mecanic mecanicSenior = new Mecanic(
                "Iuliue",
                "Vlad",
                "vlad.iuliu@firma.com",
                "0767439761",
                TipAutomobil.A,
                TipVechime.incepator,
                true,
                5000
        );

        assertNotEquals(6500, contabil1.calculareSalariu(mecanicSenior));
    }

    @org.junit.Test
    public void testMecanicMediu() {

        Birou b2 = new Birou(4, 8, 18);
        Contabil contabil1 = new Contabil("Georgescu",
                "Andrei",
                "andrei.georgescu@firma.com",
                "0733111222",
                TipVechime.mediu,
                4500,
                b2);
        Mecanic mecanicMediu = new Mecanic(
                "Costache",
                "Cosmin",
                "cosmin.costache@firma.com",
                "0745951963",
                TipAutomobil.C,
                TipVechime.mediu,
                true,
                5000
        );

        assertEquals(5500, contabil1.calculareSalariu(mecanicMediu));
    }

    @org.junit.Test
    public void testMecanicSenior() {

        Birou b2 = new Birou(4, 8, 18);
        Contabil contabil1 = new Contabil("Georgescu",
                "Andrei",
                "andrei.georgescu@firma.com",
                "0733111222",
                TipVechime.mediu,
                4500,
                b2);
        Mecanic mecanicSenior = new Mecanic(
                "Necula",
                "Andrei",
                "andrei.numarul1@firma.com",
                "0723967712",
                TipAutomobil.B,
                TipVechime.senior,
                true,
                5000
        );

        assertEquals(6500, contabil1.calculareSalariu(mecanicSenior));
    }

}
