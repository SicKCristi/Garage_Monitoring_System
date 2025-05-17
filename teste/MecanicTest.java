package Implementare_modele;

import Implementare_modele.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MecanicTest {

    // Pentru a nu mai sta de fiecare data sa apelam constructorii in test, vom folosi aceasta functie pentru instantieri
    private Mecanic creeazaMecanic(TipAutomobil categorie, TipVechime vechime){
        Atelier atelier = new Atelier();
        return new Mecanic(
                "Ion", "Popescu", "ion@mail.com", "0712345678",
                categorie, vechime, true, 3000, atelier
        );
    }

    // La fel si pentru Client
    private Client creeazaClient(TipAutomobil categorie){
        return new Client(
                "Ana", "Ionescu", "ana@mail.com", "0722334455",
                categorie, "1234567890123456", 2
        );
    }

    // Motivul pentru care am facut acest lucru este datorat si de faptul ca singurele atribute cu care operam cu adevarat
    // sunt vechimea mecanicului, tipul de autoturism pe care acesta il poate repara si categoria autovehicului clientului

    @Test
    public void testCategorieA_Incepator(){
        Mecanic mecanic=creeazaMecanic(TipAutomobil.A,TipVechime.incepator);
        Client client=creeazaClient(TipAutomobil.A);

        double rezultat=mecanic.timpReparareMasina(client);
        double expected=Mecanic.TIMP_CATEGORIA_A-Mecanic.REDUCERE_TIMP_INCEPATOR*Mecanic.TIMP_CATEGORIA_A;
        assertEquals(expected,rezultat,0.01);
    }

    @Test
    public void testCategorieA_Mediu(){
        Mecanic mecanic=creeazaMecanic(TipAutomobil.A,TipVechime.mediu);
        Client client=creeazaClient(TipAutomobil.A);

        double rezultat=mecanic.timpReparareMasina(client);
        double expected=Mecanic.TIMP_CATEGORIA_A-Mecanic.REDUCERE_TIMP_MEDIU*Mecanic.TIMP_CATEGORIA_A;
        assertEquals(expected,rezultat,0.01);
    }

    @Test
    public void testCategorieA_Senior(){
        Mecanic mecanic=creeazaMecanic(TipAutomobil.A,TipVechime.senior);
        Client client=creeazaClient(TipAutomobil.A);

        double rezultat=mecanic.timpReparareMasina(client);
        double expected=Mecanic.TIMP_CATEGORIA_A-Mecanic.REDUCERE_TIMP_SENIOR*Mecanic.TIMP_CATEGORIA_A;
        assertEquals(expected,rezultat,0.01);
    }

    @Test
    public void testCategorieB_Incepator() {
        Mecanic mecanic=creeazaMecanic(TipAutomobil.B,TipVechime.incepator);
        Client client=creeazaClient(TipAutomobil.B);

        double rezultat=mecanic.timpReparareMasina(client);
        double expected=Mecanic.TIMP_CATEGORIA_B-Mecanic.REDUCERE_TIMP_INCEPATOR*Mecanic.TIMP_CATEGORIA_B;
        assertEquals(expected,rezultat,0.01);
    }

    @Test
    public void testCategorieB_Mediu(){
        Mecanic mecanic=creeazaMecanic(TipAutomobil.B,TipVechime.mediu);
        Client client=creeazaClient(TipAutomobil.B);

        double rezultat=mecanic.timpReparareMasina(client);
        double expected=Mecanic.TIMP_CATEGORIA_B-Mecanic.REDUCERE_TIMP_MEDIU*Mecanic.TIMP_CATEGORIA_B;
        assertEquals(expected,rezultat,0.01);
    }

    @Test
    public void testCategorieB_Senior(){
        Mecanic mecanic=creeazaMecanic(TipAutomobil.B,TipVechime.senior);
        Client client=creeazaClient(TipAutomobil.B);

        double rezultat=mecanic.timpReparareMasina(client);
        double expected=Mecanic.TIMP_CATEGORIA_B-Mecanic.REDUCERE_TIMP_SENIOR*Mecanic.TIMP_CATEGORIA_B;
        assertEquals(expected,rezultat,0.01);
    }

    @Test
    public void testCategorieC_Incepator(){
        Mecanic mecanic=creeazaMecanic(TipAutomobil.C,TipVechime.incepator);
        Client client=creeazaClient(TipAutomobil.C);

        double rezultat=mecanic.timpReparareMasina(client);
        double expected=Mecanic.TIMP_CATEGORIA_C-Mecanic.REDUCERE_TIMP_INCEPATOR*Mecanic.TIMP_CATEGORIA_C;
        assertEquals(expected,rezultat,0.01);
    }

    @Test
    public void testCategorieC_Mediu(){
        Mecanic mecanic=creeazaMecanic(TipAutomobil.C,TipVechime.mediu);
        Client client=creeazaClient(TipAutomobil.C);

        double rezultat=mecanic.timpReparareMasina(client);
        double expected=Mecanic.TIMP_CATEGORIA_C-Mecanic.REDUCERE_TIMP_MEDIU*Mecanic.TIMP_CATEGORIA_C;
        assertEquals(expected,rezultat,0.01);
    }

    @Test
    public void testCategorieC_Senior(){
        Mecanic mecanic=creeazaMecanic(TipAutomobil.C,TipVechime.senior);
        Client client=creeazaClient(TipAutomobil.C);

        double rezultat=mecanic.timpReparareMasina(client);
        double expected=Mecanic.TIMP_CATEGORIA_C-Mecanic.REDUCERE_TIMP_SENIOR*Mecanic.TIMP_CATEGORIA_C;
        assertEquals(expected,rezultat,0.01);
    }

    @Test
    public void testCategorieA_Incepator_NuPoateRepara() {
        Mecanic mecanic=creeazaMecanic(TipAutomobil.A, TipVechime.incepator);
        Client client=creeazaClient(TipAutomobil.B); // diferit

        double rezultat=mecanic.timpReparareMasina(client);
        assertEquals(-1,rezultat);
    }

    @Test
    public void testCategorieA_Mediu_NuPoateRepara() {
        Mecanic mecanic=creeazaMecanic(TipAutomobil.A, TipVechime.mediu);
        Client client=creeazaClient(TipAutomobil.C);

        double rezultat=mecanic.timpReparareMasina(client);
        assertEquals(-1,rezultat);
    }

    @Test
    public void testCategorieA_Senior_NuPoateRepara() {
        Mecanic mecanic=creeazaMecanic(TipAutomobil.A, TipVechime.senior);
        Client client=creeazaClient(TipAutomobil.B);

        double rezultat=mecanic.timpReparareMasina(client);
        assertEquals(-1,rezultat);
    }

    @Test
    public void testCategorieB_Incepator_NuPoateRepara() {
        Mecanic mecanic=creeazaMecanic(TipAutomobil.B, TipVechime.incepator);
        Client client=creeazaClient(TipAutomobil.A);

        double rezultat=mecanic.timpReparareMasina(client);
        assertEquals(-1,rezultat);
    }

    @Test
    public void testCategorieB_Mediu_NuPoateRepara() {
        Mecanic mecanic=creeazaMecanic(TipAutomobil.B, TipVechime.mediu);
        Client client=creeazaClient(TipAutomobil.C);

        double rezultat=mecanic.timpReparareMasina(client);
        assertEquals(-1,rezultat);
    }

    @Test
    public void testCategorieB_Senior_NuPoateRepara() {
        Mecanic mecanic=creeazaMecanic(TipAutomobil.B, TipVechime.senior);
        Client client=creeazaClient(TipAutomobil.A);

        double rezultat=mecanic.timpReparareMasina(client);
        assertEquals(-1,rezultat);
    }

    @Test
    public void testCategorieC_Incepator_NuPoateRepara() {
        Mecanic mecanic=creeazaMecanic(TipAutomobil.C,TipVechime.incepator);
        Client client=creeazaClient(TipAutomobil.B);

        double rezultat=mecanic.timpReparareMasina(client);
        assertEquals(-1,rezultat);
    }

    @Test
    public void testCategorieC_Mediu_NuPoateRepara() {
        Mecanic mecanic=creeazaMecanic(TipAutomobil.C, TipVechime.mediu);
        Client client=creeazaClient(TipAutomobil.A);

        double rezultat=mecanic.timpReparareMasina(client);
        assertEquals(-1,rezultat);
    }

    @Test
    public void testCategorieC_Senior_NuPoateRepara() {
        Mecanic mecanic=creeazaMecanic(TipAutomobil.C, TipVechime.senior);
        Client client=creeazaClient(TipAutomobil.B);

        double rezultat=mecanic.timpReparareMasina(client);
        assertEquals(-1,rezultat);
    }
}
