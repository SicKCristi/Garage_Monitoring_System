package Implementare_modele;

import java.util.ArrayList;
import java.util.Scanner;

class Main{

    // CONSTANTE FOLOSITE

    private static final int NR_MAXIM_CLADIRI=5;
    private static final int NR_MAXIM_ATELIERE_PER_CLADIRE=3;
    private static final int NR_MAXIM_CLIENTI=6;

    // FUNCTII AUXILIARE

    private static void afisare_date_cladiri(ArrayList<Cladire> cladiri){
        if(cladiri==null)
            System.out.println("Nu exista cladiri pentru aceasta companie!");
        else
            for(int i=0;i<cladiri.size();i++){
                System.out.println("Informatii despre cladirea "+(i+1)+":");
                cladiri.get(i).afisareInformatiiCladire();
                System.out.println();
            }
    }

    private static boolean sunt_toate_facilitatile_oferite(boolean[] facilitati){
        for(int i=0;i<facilitati.length;i++)
            if(facilitati[i]==false)
                return false;
        return true;
    }

    public static int calculare_numar_total_ateliere(ArrayList<Cladire> cladiri){
        int nr_ateliere=0;
        for(int i=0;i<cladiri.size();i++)
            nr_ateliere+=cladiri.get(i).getAteliere().size();
        return nr_ateliere;
    }

    public static ArrayList<Atelier> toate_atelierele(ArrayList<Cladire> cladiri){
        ArrayList<Atelier> ateliere=new ArrayList<Atelier>();
        for(int i=0;i<cladiri.size();i++){
            ArrayList<Atelier> aux=cladiri.get(i).getAteliere();
            for(int j=0;j<aux.size();j++)
                ateliere.add(aux.get(j));
        }
        return ateliere;
    }

    public static void afisare_date_clienti(ArrayList<Client> clienti){
        for(int i=0;i<clienti.size();i++){
            System.out.println("Clientul "+(i+1)+":");
            clienti.get(i).afisareDatePersoana();
            System.out.println();
        }
    }

    public static void afisare_date_mecanici(ArrayList<Mecanic> mecanici){
        for(int i=0;i<mecanici.size();i++){
            System.out.println("Mecanicul "+(i+1)+":");
            mecanici.get(i).afisareDatePersoana();
            System.out.println();
        }
    }

    public static void afisare_date_contabili(ArrayList<Contabil> contabili){
        for(int i=0;i<contabili.size();i++){
            System.out.println("Contabilul "+(i+1)+":");
            contabili.get(i).afisareDatePersoana();
            System.out.println();
        }
    }

    public static void main(String[] args) {

         // ////////////////////////// //
        // TESTAREA FUNCTIONALITATILOR //
        // /////////////////////////// //

        // I. Testarea clasei persoana

        // 1. Constructorul cu parametrii
        Persoana pers1=new Persoana("Marian","Cox","mariancox@yahoo.com","0723658750");
        /*pers1.afisareDatePersoana();
        System.out.println();*/

        // 2. Constructorul de copiere
        Persoana pers2=new Persoana(pers1);
        /*pers1.afisareDatePersoana();
        System.out.println();*/

        // 3. Constructorul fara parametrii
        Persoana pers_gol=new Persoana();
        /*pers_gol.afisareDatePersoana();
        System.out.println();*/

        // 4. Getterii
        /*System.out.println("Numele este: "+pers1.getNume());
        System.out.println("Prenumele este: "+pers1.getPrenume());
        System.out.println("Emailul este: "+pers1.getEmail());
        System.out.println("Telefonul este: "+pers1.getTelefon());
        System.out.println();*/

        // 5. Setteri cu succes
        pers2.setNume("Popescu");
        //System.out.println("Numele modificat este: "+pers2.getNume());

        pers2.setPrenume("Daniel");
        //System.out.println("Prenumele modificat este: "+pers2.getPrenume());

        pers2.setTelefon("0729999999");
        //System.out.println("Telefonul modificat este: "+pers2.getTelefon());

        pers2.setEmail("ceva@altceva.ro");
        //System.out.println("Emailul modificat este: "+pers2.getEmail());

        //System.out.println();

        // 6. Setteri fara succes

        /*String aux=null;
        pers2.setNume(aux);
        System.out.println("Numele modificat este: "+pers2.getNume());
        pers2.setPrenume(aux);
        System.out.println("Prenumele modificat este: "+pers2.getPrenume());*/

        /*String nr_telefon_test=new String("072999999");
        pers2.setTelefon(nr_telefon_test);
        System.out.println("Telefonul modificat este: "+pers2.getTelefon());*/

        /*String email_test=new String("mariansentiment");
        pers2.setEmail(email_test);
        System.out.println("Emailul modificat este: "+pers2.getEmail());*/

        //System.out.println();

        // II. Testare clasa Client

        // 1. Constructorii

        PiesaAuto[] pieseNecesare={PiesaAuto.FILTRU_AER,PiesaAuto.FILTRU_ULEI,PiesaAuto.BATERIE};
        int[] cantitiatiNecesare={1,1,1};

        Client cli1=new Client(pers1, TipAutomobil.A,"1234567890123456",2,pieseNecesare,cantitiatiNecesare);
        /*cli1.afisareDatePersoana();
        System.out.println();*/

        Client cli2=new Client(pers1, TipAutomobil.A,"1234567890123456",2);
        /*cli2.afisareDatePersoana();
        System.out.println();*/

        Client cli3=new Client("Marian","Cox","mariancox@yahoo.com","0723658750", TipAutomobil.A,"1234567890123456",2,pieseNecesare,cantitiatiNecesare);
        /*cli3.afisareDatePersoana();
        System.out.println();*/

        Client cli4=new Client("Marian","Cox","mariancox@yahoo.com","0723658750", TipAutomobil.A,"1234567890123456",2);
        /*cli4.afisareDatePersoana();
        System.out.println();*/

        // 2. Getteri
        // Nu mai testam getterii pentru nume, prenume, email si telefon pt ca au fost testati initial

        /*System.out.println("Categoria este: "+cli1.getCategorie());
        System.out.println("Numarul cardului este: "+cli1.getNumarCard());*/

        // Odata cand avem elemente in vectori

        /*PiesaAuto[] pieseNecesare_aux=cli1.getPieseNecesare();
        if(pieseNecesare_aux!=null){
            System.out.println("Piesele clientului");
            for (int i=0;i<pieseNecesare_aux.length;i++)
                System.out.println("Piesa "+(i+1)+": "+pieseNecesare_aux[i]);
        }
        else
            System.out.println("Clientul nu are piese necesare!");

        int[] cantitatiNecesare_aux=cli1.getCantitatiNecesare();
        if(cantitatiNecesare_aux!=null){
            System.out.println("Numarul de piese necesare clientului");
            for (int i=0;i<cantitiatiNecesare.length;i++)
                System.out.println("Cantitatea "+(i+1)+": "+cantitatiNecesare_aux[i]);
        }
        else
            System.out.println("Clientul nu are cantitati pentru piese necesare!");*/

        //System.out.println();

        // Odata cand nu avem elemente in vectori

        /*pieseNecesare_aux=cli2.getPieseNecesare();
        if(pieseNecesare_aux!=null){
            System.out.println("Piesele clientului");
            for (int i=0;i<pieseNecesare_aux.length;i++)
                System.out.println("Piesa "+(i+1)+": "+pieseNecesare_aux[i]);
        }
        else
            System.out.println("Clientul nu are piese necesare!");

        cantitatiNecesare_aux=cli2.getCantitatiNecesare();
        if(cantitatiNecesare_aux!=null){
            System.out.println("Numarul de piese necesare clientului");
            for (int i=0;i<cantitiatiNecesare.length;i++)
                System.out.println("Cantitatea "+(i+1)+": "+cantitatiNecesare_aux[i]);
        }
        else
            System.out.println("Clientul nu are cantitati pentru piese necesare!");*/

        //System.out.println();

        // 3. Actualizeaza numar vizite
        /*System.out.println("Numarul de vizite curent: "+cli2.getNumarViziteService());
        cli2.actualizeazaViziteService();
        System.out.println("Numarul de vizite dupa actualizare: "+cli2.getNumarViziteService());
        System.out.println();*/

        // 4. Calculeaza procent reducere
        /*System.out.println("Procentul de reducere: "+String.format("%.2f",cli2.calculeazaProcentReducere()));
        System.out.println();*/

        // 5. Pret serviciu
        /*System.out.println("Pretul pentru serviciu: "+String.format("%.2f",cli2.pretServiciu()));
        System.out.println();*/

        // 6. Calculeaza pret total
        /*int numar_operatiuni=3;
        System.out.println("Pretul total pentru servici: "+String.format("%.2f",cli2.calculeazaPretTotal(numar_operatiuni)));
        System.out.println();*/

        // 7. Calculeaza fidelitatea
        /*System.out.println("Fidelitatea clientului este: "+cli2.getFidelitate());
        System.out.println();*/

        //  III. Atelier

        // 1. Constructorii cu parametrii

        Atelier at1=new Atelier(100.25,1);
        /*at1.afisareInformatiiAtelier();
        System.out.println();*/

        Atelier at2=new Atelier(100.25, 2, pieseNecesare, cantitiatiNecesare);
        /*at2.afisareInformatiiAtelier();
        System.out.println();*/

        // 2. Constructorul fara parametrii

        Atelier at3=new Atelier();
        /*at3.afisareInformatiiAtelier();
        System.out.println();*/

        // 3. Getterii

        /*System.out.println("Suprafata este: "+at1.getSuprafata());
        System.out.println("Numarul de ordine este: "+at1.getNumarOrdine());*/

        // Nu am mai testat getterii pentru pieseDisponibile si pentru cantitatiDisponibile pentru ca functioneaza
        // in acelasi cod ca cei din clasa Client

        // 4. Extinde suprafata

        /*System.out.println("Suprafata curenta este: "+at2.getSuprafata());
        at2.extindeSuprafata(20);
        System.out.println("Suprafata dupa extindere este: "+at2.getSuprafata());
        System.out.println();*/

        // IV. Mecanic

        // 1. Constructorii cu parametrii

        Mecanic mec1=new Mecanic(pers2, TipAutomobil.A, TipVechime.mediu, true, 5000,at1);
        /*mec1.afisareDatePersoana();
        System.out.println();*/

        Mecanic mec2=new Mecanic("Popa","Mirel","popamirel@yahoo.com","0727777777",TipAutomobil.A, TipVechime.mediu, true, 5000,at1);
        /*mec2.afisareDatePersoana();
        System.out.println();
        System.out.println();*/

        // 2. Getterii

        /*System.out.println("Tipul de automobil este: "+mec2.getCategorieAcceptata());
        System.out.println("Vechimea este: "+mec2.getVechime());
        System.out.println("Disponibilitatea este: "+mec2.getDisponibilitate());
        System.out.println("Salariul este: "+mec2.getSalariu());
        Atelier atelier_aux=mec2.getAtelier();
        atelier_aux.setPieseDisponibile(pieseNecesare);
        atelier_aux.setCantitatiDisponibile(cantitiatiNecesare);
        atelier_aux.afisareInformatiiAtelier();

        System.out.println();*/

        // III. 5. Adauga piese utilizate
        //System.out.println("Operatia a fost realizata cu succes: "+at1.adaugarePieseUtilizate(mec1,cli1));
        System.out.println();

        // 3. Actualizeaza disponibilitatea

        /*System.out.println("Disponibilitatea curenta: "+mec2.getDisponibilitate());
        mec2.actualizeazaDisponibilitate(false);
        System.out.println("Disponibilitatea dupa actualizare: "+mec2.getDisponibilitate());
        System.out.println();*/

        // 4. Emitere raport

        /*System.out.println(mec2.emitereRaport(cli2,"Ceva IDK"));
        System.out.println();*/

        // 5. Poate repara masina

        /*System.out.println("Se poate repara masina: " + (mec2.poateReparaMasinaClient(cli2) ? "DA" : "NU"));
        System.out.println();*/

        // 6. Timp reparare masina

        /*System.out.println("Timpul necesar pentru repararea masinii: "+mec2.timpReparareMasina(cli1));
        System.out.println();*/

        // 7. Emitere raport

        /*System.out.println(mec2.emitereRaport(cli2,"CEVA"));
        System.out.println();*/

        // 8. Adauga piese disponibile

        /*System.out.println("S-a realizat operatia cu succes: "+mec2.adaugarePieseUtilizate(cli1,at2.getPieseDisponibile(),at2.getCantitatiDisponibile(),cli1.getPieseNecesare(),cli1.getCantitatiNecesare()));
        System.out.println();*/

        // V. Birou

        // 1. Constuctorul cu parametii

        Birou bir=new Birou(1,10,20);
        /*bir.afisareInformatiiBirou();
        System.out.println();*/

        // 2. Getterii

        /*System.out.println("Etajul este: "+bir.getEtaj());
        System.out.println("Ora de deschidere este: "+bir.getOraDeschidere());
        System.out.println("Ora de inchidere este: "+bir.getOraInchidere());
        System.out.println();*/

        // 3. Extinde programul de functionare

        /*System.out.println("Ora de inchidere curenta: "+bir.getOraInchidere());
        bir.extindeProgramFunctionare(22);
        System.out.println("Ora de inchidere dupa modificare: "+bir.getOraInchidere());
        System.out.println();*/

        // 4. Afisare program functionare

        /*bir.afisareProgramFunctionare();
        System.out.println();*/

        // VI. Contabil

        // 1. Constructorii cu parametrii

        Contabil con1=new Contabil(pers1, TipVechime.senior,7500,bir);
        /*con1.afisareDatePersoana();
        System.out.println();*/

        Contabil con2=new Contabil("Marian","Sentiment","sentimaalpussslaper69@yahoo.com","0769696969",TipVechime.mediu,6000,bir);
        /*con2.afisareDatePersoana();
        System.out.println();*/

        // 2. Getterii

        /*System.out.println("Vechimea este: "+con2.getVechime());
        System.out.println("Salariul este: "+con2.getSalariu());
        con2.getBirou().afisareInformatiiBirou();
        System.out.println();*/

        // 3. Emitere factura

        ArrayList<String> lista_servicii=new ArrayList<String>();
        lista_servicii.add("Serviciul 1");
        lista_servicii.add("Serviciul 2");
        lista_servicii.add("Serviciul 3");

        /*System.out.println(con2.emitereFactura(cli2,lista_servicii));
        System.out.println();*/

        // 4. Determinare fidelitate

        /*cli3.setNumarViziteService(30);
        System.out.println("Fidelitatea clientului: "+con2.determinareFidelitate(cli3));
        System.out.println();*/

        // 5. Emitere raport financiar

        ArrayList<Client> clienti_aux=new ArrayList<Client>();
        clienti_aux.add(cli1);
        clienti_aux.add(cli2);
        clienti_aux.add(cli3);
        clienti_aux.add(cli4);

        /*System.out.println(con2.emitereRaportFinanciar(clienti));
        System.out.println();*/

        // 6. Calcularea salariu propriu

        /*System.out.println("Salariul propriu al contabilului: "+String.format("%.2f",con2.calculareSalariuPropriu()));
        System.out.println();*/

        // 7. Calcularea salariu (contabili sau mecanici)

        /*System.out.println("Salariul unui contabil: "+con2.calculareSalariu((Persoana)con1));
        System.out.println("Salariul unui mecanic: "+con2.calculareSalariu((Persoana)mec1));
        System.out.println();*/

        // 8. Calculare profit

        ArrayList<Contabil> contabili_aux=new ArrayList<Contabil>();
        contabili_aux.add(con1);
        contabili_aux.add(con2);

        ArrayList<Mecanic> mecanici_aux=new ArrayList<Mecanic>();
        mecanici_aux.add(mec1);
        mecanici_aux.add(mec2);

        /*System.out.println("Profitul companiei este: "+con2.calculareProfit(clienti,mecanici,contabili));
        System.out.println();*/

        // VII. Cladire

        // 1. Constructorul cu parametrii

        ArrayList<Facilitati> facilitati=new ArrayList<Facilitati>();
        facilitati.add(Facilitati.EsspresorCafea);
        facilitati.add(Facilitati.Snacks);

        ArrayList<Atelier> ateliere_aux=new ArrayList<Atelier>();
        ateliere_aux.add(at1);
        ateliere_aux.add(at2);

        Cladire cl=new Cladire("Strada Principala, Nr 220, Bucuresti",facilitati,bir,ateliere_aux);
        /*cl.afisareInformatiiCladire();
        System.out.println();*/

        Cladire cl2=new Cladire("Strada Primaverii, Nr 440, Costinesti");
        /*cl2.afisareInformatiiCladire();
        System.out.println();*/

        // 2. Adaugare facilitati

        cl.adaugareFacilitate(Facilitati.Dozator);
        /*cl.afisareInformatiiCladire();
        System.out.println();*/

        // 3. Getterii

        /*System.out.println("Adresa este: "+cl.getAdresa());
        System.out.println("Birou:");
        cl.getBirou().afisareInformatiiBirou();
        System.out.println("Facilitati:");
        for(int i=0;i<cl.getFacilitati().size();i++)
            System.out.println("Facilitatea "+(i+1)+": "+cl.getFacilitati().get(i));
        System.out.println("Ateliere:");
        for(int i=0;i<cl.getAteliere().size();i++) {
            System.out.println("Atelierul "+(i+1)+": ");
            cl.getAteliere().get(i).afisareInformatiiAtelier();
        }
        System.out.println();*/

        // 4. Ia atelierul dupa indexul dat

        /*Atelier atelier_aux=cl.getAtelierDupaIndexDat(1);
        if(atelier_aux!=null)
            atelier_aux.afisareInformatiiAtelier();*/

        // 5. Ia facilitati dupa index dat

        /*Facilitati facilitate=cl.getFacilitateDupaIndex(2);
        if(facilitate!=null)
            System.out.println(facilitate);*/

        // 6. Adauga atelier

        /*cl.adaugareAtelier(at3);
        cl.afisareInformatiiCladire();
        System.out.println();*/

        // 7. Adauga facilitate

        /*cl.adaugareFacilitate(Facilitati.Dozator);
        cl.afisareInformatiiCladire();
        System.out.println();*/

        // 8. Stergere atelier dupa index

        /*cl.stergereAtelierDupaIndex(2);
        cl.afisareInformatiiCladire();
        System.out.println();*/

        // 9. Corespunde oras

        /*String oras1="Bucuresti";
        String oras2="Pitesti";
        System.out.println("Corespunde oras: "+cl.corespundeOras(oras1));
        System.out.println("Corespunde oras: "+cl.corespundeOras(oras2));
        System.out.println();*/

        // 10. Suprafata totala ateliere

        /*System.out.println("Suprafata totala a atelierelor: "+cl.calculeazaSuprafataTotalaAteliere());
        System.out.println();*/

        // 11. Exista atelier cu numar de ordine

        /*System.out.println("Exista un atelier cu numar de ordine: "+cl.existaAtelierCuNumarOrdine(2));
        System.out.println("Exista un atelier cu numar de ordine: "+cl.existaAtelierCuNumarOrdine(3));
        System.out.println();*/

        // 12. Filtrare ateliere dupa suprafata minima

       /*ArrayList<Atelier> ateliere_filtrate=cl.filtreazaAteliereDupaSuprafata(50);
        if(ateliere_filtrate!=null)
            for(int i=0;i<ateliere_filtrate.size();i++)
                ateliere_filtrate.get(i).afisareInformatiiAtelier();
        System.out.println();*/

        // 13. Sortare dupa suprafata

        /*cl.getAteliere().get(0).setSuprafata(200);
        cl.sorteazaAteliereDupaSuprafata();
        cl.afisareInformatiiCladire();
        System.out.println();*/

        // 14. Sortare dupa numarul de ordine

        /*cl.getAteliere().get(0).setNumarOrdine(2);
        cl.sorteazaAteliereDupaNumarOrdine();
        cl.afisareInformatiiCladire();
        System.out.println();*/

        // ////////////////////////////////////
        // SIMULAREA FUNCTIONARII APLICATIEI //
        // ////////////////////////////////////

        ArrayList<Cladire> cladiri_firma=new ArrayList<Cladire>();

        Scanner s=new Scanner(System.in);

        // Este specificat cate cladiri detine firma respectiva

        int nr_cladiri_dorite=0;
        do{
            System.out.println("Dati numarul de cladiri dorite");
            nr_cladiri_dorite=s.nextInt();
            if(nr_cladiri_dorite<=0 || nr_cladiri_dorite>=NR_MAXIM_CLADIRI){
                System.out.println();
                System.out.println("Numarul introdus nu este valid! Incearca altceva!");
                System.out.println();
            }
        }while(nr_cladiri_dorite<=0 || nr_cladiri_dorite>=NR_MAXIM_CLADIRI);
        s.nextLine();
        System.out.println();

        // Vom citi datele pentru cladirile furnizate

        do{
            System.out.println("Dati datele despre cladirea "+(cladiri_firma.size()+1)+":");
            System.out.print("Dati adresa cladirii:");
            String adresa=s.nextLine();
            cladiri_firma.add(new Cladire(adresa));
        }while(cladiri_firma.size()<nr_cladiri_dorite);
        System.out.println();

        /*Pentru inceput, vom afisa datele despre cladiri
        Main.afisare_date_cladiri(cladiri_firma);*/

        // Vom construi cate un birou pentru fiecare cladire

        int nr_birouri=0;
        do{
            System.out.println("Dati datele despre biroul "+(nr_birouri+1)+":");
            System.out.print("Dati etajul biroului:");
            int etaj=s.nextInt();
            System.out.print("Dati ora de deschidere a biroului:");
            int ora_deschidere=s.nextInt();
            System.out.print("Dati ora de inchidere a biroului:");
            int ora_inchidere=s.nextInt();
            cladiri_firma.get(nr_birouri).setBirou(new Birou(etaj,ora_deschidere,ora_inchidere));
            nr_birouri++;
        }while(nr_birouri<cladiri_firma.size());
        System.out.println();

        /*Vom afisa datele cladirilor dupa ce am adaugat si birourile in componenta acestora
        Main.afisare_date_cladiri(cladiri_firma);*/

        // Vom adauga facilitati pentru fiecare cladire

        int nr_cladiri=0;
        do{
            boolean[] facilitati_prezente={false, false, false};
            do {
                System.out.println("---------------------");
                System.out.println("Selectati facilitatea pe care doriti sa o adaugati");
                System.out.println("1. Dozator");
                System.out.println("2. Esspressor Cafea");
                System.out.println("3. Snacks");
                System.out.println("---------------------");
                System.out.println();
                System.out.println("Sa se dea una dintre optiunile de mai sus:");
                int optiune = s.nextInt();

                switch (optiune){
                    case 1:{
                        cladiri_firma.get(nr_cladiri).adaugareFacilitate(Facilitati.Dozator);
                        facilitati_prezente[0]=true;
                        break;
                    }
                    case 2:{
                        cladiri_firma.get(nr_cladiri).adaugareFacilitate(Facilitati.EsspresorCafea);
                        facilitati_prezente[1]=true;
                        break;
                    }
                    case 3:{
                        cladiri_firma.get(nr_cladiri).adaugareFacilitate(Facilitati.Snacks);
                        facilitati_prezente[2]=true;
                        break;
                    }
                    default:
                        System.out.println("Optiunea nu este valida, nu s-a adaugat nicio facilitate!");
                }

                String raspuns=s.nextLine();
                System.out.println();
                System.out.println("Mai doriti facilitati?");
                System.out.println("d-DA si n-NU");
                raspuns=s.nextLine();
                if(raspuns.equals("n"))
                    break;

                if(Main.sunt_toate_facilitatile_oferite(facilitati_prezente)) {
                    System.out.println();
                    System.out.println("Toate facilitatile au fost luate!");
                }

                System.out.println();
            }while(!Main.sunt_toate_facilitatile_oferite(facilitati_prezente));

            nr_cladiri++;
        }while(nr_cladiri<cladiri_firma.size());
        System.out.println();

        /*Afisam cladirile dupa ce am adaugat si facilitatile
        Main.afisare_date_cladiri(cladiri_firma);*/

        // Adaugam ateliere pentru fiecare cladire

        for(int i=0;i<cladiri_firma.size();i++){
            int nr_ateliere_cladire=0;
            do{
                System.out.print("Sa se precizeze suprafata atelierului:");
                double suprafata=s.nextDouble();

                int nr_ordine=0;
                do{
                    System.out.print("Sa se precizeze numarul de ordine al atelierului:");
                    nr_ordine=s.nextInt();
                    if(nr_ordine<=0){
                        System.out.println();
                        System.out.println("Numarul de ordine trebuie sa fie un intreg pozitiv!");
                        System.out.println();
                    }
                }while(nr_ordine<=0);

                cladiri_firma.get(i).adaugareAtelier(new Atelier(suprafata,nr_ordine));
                System.out.println();
                nr_ateliere_cladire++;

                String raspuns=s.nextLine();
                System.out.println("Doriti sa mai adaugati un atelier?");
                System.out.println("d-DA sau n-NU");
                raspuns=s.nextLine();
                if(raspuns.equals("n"))
                    break;

                if(nr_ateliere_cladire==NR_MAXIM_ATELIERE_PER_CLADIRE){
                    System.out.println();
                    System.out.println("S-au specificat toate atelierele posibile pentru cladirea "+(i+1)+"!");
                }

                System.out.println();
            }while(nr_ateliere_cladire<NR_MAXIM_ATELIERE_PER_CLADIRE);
        }
        System.out.println();

        /*Acum afisam cladirile dupa adaugarea atelierelor
        Main.afisare_date_cladiri(cladiri_firma);*/

        // Cerem numarul de clienti care au trecut pe la atelier

        int nr_clienti=0;
        do{
            System.out.println("Sa se dea numarul de clienti care au venit la atelier");
            nr_clienti=s.nextInt();
            if(nr_clienti<=0 || nr_clienti>=NR_MAXIM_CLIENTI){
                System.out.println();
                System.out.println("Numarul de clienti dat este invalid! Trebuie sa fie pozitiv si mai mic decat "+NR_MAXIM_CLIENTI+"!");
                System.out.println();
            }
        }while(nr_clienti<=0 || nr_clienti>=NR_MAXIM_CLIENTI);
        System.out.println();
        s.nextLine();

        // Citim datele despre clienti

        ArrayList<Client> clienti=new ArrayList<Client>();
        for(int i=0;i<nr_clienti;i++){
            System.out.print("Sa se dea numele clientului:");
            String nume=s.nextLine();
            System.out.print("Sa se dea prenumele clientului:");
            String prenume=s.nextLine();
            System.out.print("Sa se dea emailul clientului:");
            String email=s.nextLine();
            System.out.print("Sa se dea telefonul clientului:");
            String telefon=s.nextLine();

            int optiune;
            do{
                System.out.println("---------------------");
                System.out.println("Selectati categoria autoehiculului clientului:");
                System.out.println("1. Categoria A");
                System.out.println("2. Categoria B");
                System.out.println("3. Categoria C");
                System.out.println("---------------------");
                System.out.println();
                System.out.print("Sa se dea una dintre optiunile de mai sus:");
                optiune=s.nextInt();
                if(optiune<=0 || optiune>3){
                    System.out.println();
                    System.out.println("Optiunea introdusa este invalida! Trebuie sa fie 1, 2 sau 3!");
                    System.out.println();
                }
            }while(optiune<=0 || optiune>3);
            TipAutomobil categorie=TipAutomobil.A;
            switch(optiune){
                case 1:{
                    categorie=TipAutomobil.A;
                    break;
                }
                case 2:{
                    categorie=TipAutomobil.B;
                    break;
                }
                case 3:{
                    categorie=TipAutomobil.C;
                    break;
                }
                default: System.out.println("Categorie invalida");
            }
            s.nextLine();

            System.out.print("Sa se dea numarul cardului clientului:");
            String nr_card=s.nextLine();
            System.out.print("Sa se dea numarul de vizite al clientului:");
            int nr_vizite=s.nextInt();
            s.nextLine();

            clienti.add(new Client(nume,prenume,email,telefon,categorie,nr_card,nr_vizite));
            System.out.println();
        }

        /*Afisam datele despre clienti
        Main.afisare_date_clienti(clienti);*/

        // Acum calculam cate ateliere sunt, pentru a putea sti cati mecanici avem in aplicatie
        // Fiecarui atelier ii corespunde un mecanic

        int nr_mecanici=Main.calculare_numar_total_ateliere(cladiri_firma);
        ArrayList<Mecanic> mecanici=new ArrayList<Mecanic>();
        for(int i=0;i<nr_mecanici;i++){
            System.out.print("Sa se dea numele mecanicului:");
            String nume=s.nextLine();
            System.out.print("Sa se dea prenumele mecanicului:");
            String prenume=s.nextLine();
            System.out.print("Sa se dea emailul mecanicului:");
            String email=s.nextLine();
            System.out.print("Sa se dea telefonul mecanicului:");
            String telefon=s.nextLine();

            int optiune;
            do{
                System.out.println("---------------------");
                System.out.println("Selectati vechimea mecanicului:");
                System.out.println("1. Incepator");
                System.out.println("2. Mediu");
                System.out.println("3. Senior");
                System.out.println("---------------------");
                System.out.println();
                System.out.print("Sa se dea una dintre optiunile de mai sus:");
                optiune=s.nextInt();
                if(optiune<=0 || optiune>3){
                    System.out.println();
                    System.out.println("Optiunea introdusa este invalida! Trebuie sa fie 1, 2 sau 3!");
                    System.out.println();
                }
            }while(optiune<=0 || optiune>3);

            TipVechime vechime=TipVechime.incepator;
            switch(optiune){
                case 1:{
                    vechime=TipVechime.incepator;
                    break;
                }
                case 2:{
                    vechime=TipVechime.mediu;
                    break;
                }
                case 3:{
                    vechime=TipVechime.senior;
                    break;
                }
                default:
                    System.out.println("Vechime invalida");
            }
            System.out.println();

            do{
                System.out.println("---------------------");
                System.out.println("Selectati categoria autoehiculului clientului:");
                System.out.println("1. Categoria A");
                System.out.println("2. Categoria B");
                System.out.println("3. Categoria C");
                System.out.println("---------------------");
                System.out.println();
                System.out.print("Sa se dea una dintre optiunile de mai sus:");
                optiune=s.nextInt();
                if(optiune<=0 || optiune>3){
                    System.out.println();
                    System.out.println("Optiunea introdusa este invalida! Trebuie sa fie 1, 2 sau 3!");
                    System.out.println();
                }
            }while(optiune<=0 || optiune>3);

            TipAutomobil categorie=TipAutomobil.A;
            switch(optiune){
                case 1:{
                    categorie=TipAutomobil.A;
                    break;
                }
                case 2:{
                    categorie=TipAutomobil.B;
                    break;
                }
                case 3:{
                    categorie=TipAutomobil.C;
                    break;
                }
                default: System.out.println("Categorie invalida");
            }

            System.out.print("Sa se dea disponibilitatea mecanicului:");
            boolean disponibilitate=s.nextBoolean();
            System.out.print("Sa se dea salariul mecanicului:");
            int salariu=s.nextInt();
            s.nextLine();

            mecanici.add(new Mecanic(nume,prenume,email,telefon,categorie,vechime,disponibilitate,salariu));
            System.out.println();
        }
        System.out.println();

        // Se asigneaza mecanicilor cate un atelier
        ArrayList<Atelier> ateliere=Main.toate_atelierele(cladiri_firma);
        for(int i=0;i<mecanici.size();i++)
            mecanici.get(i).setAtelier(ateliere.get(i));

        /*Afisam informatiile despre mecanici
        Main.afisare_date_mecanici(mecanici);*/

        ArrayList<Contabil> contabili=new ArrayList<Contabil>();
        for(int i=0;i<cladiri_firma.size();i++){
            System.out.print("Sa se dea numele contabilului:");
            String nume=s.nextLine();
            System.out.print("Sa se dea prenumele contabilului:");
            String prenume=s.nextLine();
            System.out.print("Sa se dea emailul contabilului:");
            String email=s.nextLine();
            System.out.print("Sa se dea telefonul contabilului:");
            String telefon=s.nextLine();

            int optiune;
            do{
                System.out.println("---------------------");
                System.out.println("Selectati vechimea mecanicului:");
                System.out.println("1. Incepator");
                System.out.println("2. Mediu");
                System.out.println("3. Senior");
                System.out.println("---------------------");
                System.out.println();
                System.out.print("Sa se dea una dintre optiunile de mai sus:");
                optiune=s.nextInt();
                if(optiune<=0 || optiune>3){
                    System.out.println();
                    System.out.println("Optiunea introdusa este invalida! Trebuie sa fie 1, 2 sau 3!");
                    System.out.println();
                }
            }while(optiune<=0 || optiune>3);

            TipVechime vechime=TipVechime.incepator;
            switch(optiune){
                case 1:{
                    vechime=TipVechime.incepator;
                    break;
                }
                case 2:{
                    vechime=TipVechime.mediu;
                    break;
                }
                case 3:{
                    vechime=TipVechime.senior;
                    break;
                }
                default:
                    System.out.println("Vechime invalida");
            }
            System.out.println();

            System.out.print("Sa se dea salariul contabilului:");
            int salariu=s.nextInt();

            contabili.add(new Contabil(nume,prenume,email,telefon,vechime,salariu,cladiri_firma.get(i).getBirou()));
            System.out.println();
        }
        System.out.println();

        /*Afiseaza datele despre contabili
        Main.afisare_date_contabili(contabili);*/

        s.close();
    }
}