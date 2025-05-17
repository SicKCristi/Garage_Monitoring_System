package Teste;

import Implementare_modele.*;
import org.junit.Test;

import static org.junit.Assert.*;


public class TestAdaugarePieseUtilizate {

    @Test
    public void testAdaugarePieseUtilizate_Succes() {
        Atelier atelier = new Atelier(150, 1);
        Mecanic mecanic = new Mecanic("Ion", "Popescu", "ionpop@yahoo.com", "0712345678",
                TipAutomobil.B, TipVechime.mediu, true, 5000, atelier);

        Client client = new Client("Vasile", "Ionescu", "vasile_ionescu143@outlook.com", "0723456789",
                TipAutomobil.B, "3154567812740648", 3,
                new PiesaAuto[]{PiesaAuto.FILTRU_ULEI, PiesaAuto.BUJIE},
                new int[]{2, 1});

        PiesaAuto[] pieseDisponibile = {
                PiesaAuto.FILTRU_ULEI, PiesaAuto.PLACUTE_FRANA, PiesaAuto.BUJIE
        };
        int[] cantitatiDisponibile = {
                5, 10, 3
        };

        atelier.setPieseDisponibile(pieseDisponibile);
        atelier.setCantitatiDisponibile(cantitatiDisponibile);

        boolean rezultat = atelier.adaugarePieseUtilizate(mecanic, client);

        assertTrue(rezultat);
    }

    @Test
    public void testAdaugarePieseUtilizate_EroareCategorieMasina() {
        Atelier atelier = new Atelier(185, 4);
        Mecanic mecanic = new Mecanic("Rat", "Razvan", "razvanrat@yahoo.com", "0745432751",
                TipAutomobil.C, TipVechime.senior, true, 6000, atelier);

        Client client = new Client("Andrei", "Ciobanu", "andreyciobi@gmail.com", "0759482993",
                TipAutomobil.A, "8473980256304983", 2,
                new PiesaAuto[]{PiesaAuto.BUJIE, PiesaAuto.CUREA_DISTRIBUTIE},
                new int[]{2, 1});

        PiesaAuto[] pieseDisponibile = {
                PiesaAuto.AMBREIAJ, PiesaAuto.BUJIE, PiesaAuto.CUREA_DISTRIBUTIE
        };
        int[] cantitatiDisponibile = {
                5, 10, 3
        };

        atelier.setPieseDisponibile(pieseDisponibile);
        atelier.setCantitatiDisponibile(cantitatiDisponibile);

        boolean rezultat = atelier.adaugarePieseUtilizate(mecanic, client);
        assertFalse(rezultat);
    }

    @Test
    public void testAdaugarePieseUtilizate_EroareMecanicDisponibilitate() {
        Atelier atelier = new Atelier(185, 4);
        Mecanic mecanic = new Mecanic("Ganea", "Cosmin", "razvanrat@yahoo.com", "0745432751",
                TipAutomobil.A, TipVechime.senior, false, 6000, atelier);

        Client client = new Client("Patrascu", "Miruna", "andreyciobi@gmail.com", "0759482993",
                TipAutomobil.A, "8473980256304983", 2,
                new PiesaAuto[]{PiesaAuto.AMORTIZOR, PiesaAuto.DISC_FRANA, PiesaAuto.AMBREIAJ},
                new int[]{2, 1, 3});

        PiesaAuto[] pieseDisponibile = {
                PiesaAuto.AMORTIZOR, PiesaAuto.PLACUTE_FRANA, PiesaAuto.DISC_FRANA, PiesaAuto.AMBREIAJ
        };
        int[] cantitatiDisponibile = {
                5, 10, 3, 7
        };

        atelier.setPieseDisponibile(pieseDisponibile);
        atelier.setCantitatiDisponibile(cantitatiDisponibile);

        boolean rezultat = atelier.adaugarePieseUtilizate(mecanic, client);
        assertFalse(rezultat);
    }

    @Test
    public void testAdaugarePieseUtilizate_EroarePiesaIndisponibila() {
        Atelier atelier = new Atelier(166, 2);
        Mecanic mecanic = new Mecanic("Ana", "Marin", "anamarin17@icloud.com", "0754193853",
                TipAutomobil.C, TipVechime.senior, true, 6000, atelier);

        Client client = new Client("George", "Dinu", "george_dinuuu@gmail.com", "0756709243",
                TipAutomobil.C, "8765432187654321", 2,
                new PiesaAuto[]{PiesaAuto.DISC_FRANA},
                new int[]{2});

        PiesaAuto[] pieseDisponibile = {
                PiesaAuto.PLACUTE_FRANA
        };
        int[] cantitatiDisponibile = {
                5
        };

        atelier.setPieseDisponibile(pieseDisponibile);
        atelier.setCantitatiDisponibile(cantitatiDisponibile);

        boolean rezultat = atelier.adaugarePieseUtilizate(mecanic, client);
        assertFalse(rezultat);
    }

    @Test
    public void testAdaugarePieseUtilizate_PiesePartialDisponibile() {
        Atelier atelier = new Atelier(110, 2);
        Mecanic mecanic = new Mecanic("Florin", "Vlad", "florin.vlad@yahoo.com", "0765347892",
                TipAutomobil.B, TipVechime.mediu, true, 4700, atelier);

        Client client = new Client("Cristi", "Enache", "cristi.enache@gmail.com", "0745678923",
                TipAutomobil.B, "2345678901234567", 2,
                new PiesaAuto[]{PiesaAuto.FILTRU_ULEI, PiesaAuto.DISC_FRANA},
                new int[]{2, 1});

        PiesaAuto[] pieseDisponibile = { PiesaAuto.FILTRU_ULEI };
        int[] cantitatiDisponibile = { 3 };

        atelier.setPieseDisponibile(pieseDisponibile);
        atelier.setCantitatiDisponibile(cantitatiDisponibile);

        boolean rezultat = atelier.adaugarePieseUtilizate(mecanic, client);
        assertTrue(rezultat);
    }

    @Test
    public void testAdaugarePieseUtilizate_CantitateInsuficienta() {
        Atelier atelier = new Atelier(90, 3);
        Mecanic mecanic = new Mecanic("Elena", "Toma", "elena.toma@mail.com", "0734567890",
                TipAutomobil.A, TipVechime.senior, true, 7000, atelier);

        Client client = new Client("Radu", "Iancu", "radu.iancu@outlook.com", "0723987654",
                TipAutomobil.A, "3456789012345678", 1,
                new PiesaAuto[]{PiesaAuto.BUJIE},
                new int[]{2});

        PiesaAuto[] pieseDisponibile = { PiesaAuto.BUJIE };
        int[] cantitatiDisponibile = { 1 };

        atelier.setPieseDisponibile(pieseDisponibile);
        atelier.setCantitatiDisponibile(cantitatiDisponibile);

        boolean rezultat = atelier.adaugarePieseUtilizate(mecanic, client);
        assertFalse(rezultat);
        assertEquals(1, cantitatiDisponibile[0]);
    }

    @Test
    public void testAdaugarePieseUtilizate_PieseGoale() {
        Atelier atelier = new Atelier(100, 2);
        Mecanic mecanic = new Mecanic("Diana", "Pop", "diana.pop@gmail.com", "0711122233",
                TipAutomobil.B, TipVechime.incepator, true, 4000, atelier);

        Client client = new Client("Alex", "Matei", "alex.matei@yahoo.com", "0700000000",
                TipAutomobil.B, "5678901234567890", 2,
                new PiesaAuto[]{},
                new int[]{});

        PiesaAuto[] pieseDisponibile = {};
        int[] cantitatiDisponibile = {};

        atelier.setPieseDisponibile(pieseDisponibile);
        atelier.setCantitatiDisponibile(cantitatiDisponibile);

        boolean rezultat = atelier.adaugarePieseUtilizate(mecanic, client);
        assertFalse(rezultat);
    }

    @Test
    public void testAdaugarePieseUtilizate_NullLaPieseNecesare() {
        Atelier atelier = new Atelier(100, 2);
        Mecanic mecanic = new Mecanic("Diana", "Pop", "diana.pop@gmail.com", "0711122233",
                TipAutomobil.B, TipVechime.incepator, true, 4000, atelier);

        Client client = new Client("Alex", "Matei", "alex.matei@yahoo.com", "0700000000",
                TipAutomobil.B, "5678901234567890", 2,
                null, null);

        PiesaAuto[] pieseDisponibile = { PiesaAuto.BUJIE };
        int[] cantitatiDisponibile = { 2 };

        atelier.setPieseDisponibile(pieseDisponibile);
        atelier.setCantitatiDisponibile(cantitatiDisponibile);

        assertFalse(atelier.adaugarePieseUtilizate(mecanic, client));
    }

    @Test
    public void testAdaugarePieseUtilizate_TablouriLungimiDiferite() {
        Atelier atelier = new Atelier(130, 2);
        Mecanic mecanic = new Mecanic("Ioana", "Dobre", "ioana.dobre@gmail.com", "0722333444",
                TipAutomobil.C, TipVechime.mediu, true, 4100, atelier);

        Client client = new Client("Vlad", "Marin", "vlad.marin@yahoo.com", "0700222333",
                TipAutomobil.C, "1234567890123456", 1,
                new PiesaAuto[]{PiesaAuto.AMBREIAJ, PiesaAuto.DISC_FRANA},
                new int[]{1});

        PiesaAuto[] pieseDisponibile = { PiesaAuto.AMBREIAJ };
        int[] cantitatiDisponibile = { 3 };

        atelier.setPieseDisponibile(pieseDisponibile);
        atelier.setCantitatiDisponibile(cantitatiDisponibile);

        assertFalse(atelier.adaugarePieseUtilizate(mecanic, client));
    }

    @Test
    public void testAdaugarePieseUtilizate_CantitateNegativa() {
        Atelier atelier = new Atelier(110, 3);
        Mecanic mecanic = new Mecanic("Andrei", "Stoica", "andrei.stoica@gmail.com", "0744111222",
                TipAutomobil.A, TipVechime.senior, true, 4500, atelier);

        Client client = new Client("Simona", "Manea", "simona.manea@gmail.com", "0711222333",
                TipAutomobil.A, "2345678901234567", 2,
                new PiesaAuto[]{PiesaAuto.BUJIE},
                new int[]{-1});

        PiesaAuto[] pieseDisponibile = { PiesaAuto.BUJIE };
        int[] cantitatiDisponibile = { 5 };

        atelier.setPieseDisponibile(pieseDisponibile);
        atelier.setCantitatiDisponibile(cantitatiDisponibile);

        assertThrows(IllegalArgumentException.class, () -> {
            atelier.adaugarePieseUtilizate(mecanic, client);
        });
    }

    @Test
    public void testAdaugarePieseUtilizate_TablouriMari() {
        int N = 100000;
        Atelier atelier = new Atelier(300, 5);
        Mecanic mecanic = new Mecanic("Larisa", "Voicu", "larisa.voicu@gmail.com", "0799111222",
                TipAutomobil.C, TipVechime.senior, true, 9000, atelier);

        PiesaAuto[] pieseNecesare = new PiesaAuto[N];
        int[] cantitatiNecesare = new int[N];
        for (int i = 0; i < N; i++) {
            pieseNecesare[i] = PiesaAuto.FILTRU_ULEI;
            cantitatiNecesare[i] = 1;
        }

        Client client = new Client("Marius", "Ilie", "marius.ilie@gmail.com", "0711777888",
                TipAutomobil.C, "9999888877776666", 1,
                pieseNecesare, cantitatiNecesare);

        PiesaAuto[] pieseDisponibile = new PiesaAuto[N];
        int[] cantitatiDisponibile = new int[N];
        for (int i = 0; i < N; i++) {
            pieseDisponibile[i] = PiesaAuto.FILTRU_ULEI;
            cantitatiDisponibile[i] = 10;
        }

        atelier.setPieseDisponibile(pieseDisponibile);
        atelier.setCantitatiDisponibile(cantitatiDisponibile);

        boolean rezultat = atelier.adaugarePieseUtilizate(mecanic, client);
        assertTrue(rezultat);
    }

    @Test
    public void testAdaugarePieseUtilizate_NullClient() {
        Atelier atelier = new Atelier(100, 2);
        Mecanic mecanic = new Mecanic("Roxana", "Ionescu", "roxana.ionescu@gmail.com", "0722111222",
                TipAutomobil.B, TipVechime.mediu, true, 5000, atelier);

        PiesaAuto[] pieseDisponibile = { PiesaAuto.BUJIE };
        int[] cantitatiDisponibile = { 3 };

        atelier.setPieseDisponibile(pieseDisponibile);
        atelier.setCantitatiDisponibile(cantitatiDisponibile);

        assertThrows(NullPointerException.class, () -> {
            atelier.adaugarePieseUtilizate(mecanic, null);
        });
    }
}