package Implementare_modele;

public class Mecanic extends Persoana {
    private TipAutomobil categorieAcceptata;
    private TipVechime vechime;
    private Boolean disponibilitate;
    private int salariu;
    private Atelier atelier;

    ///  Timpul de reparare pentru fiecare categorie de vehicule (in ore)
    public static final int TIMP_CATEGORIA_A=3;
    public static final int TIMP_CATEGORIA_B=5;
    public static final int TIMP_CATEGORIA_C=7;

    ///  Procentul cu care se reduce timpul de reparare in functie de vechimea mecanicului
    public static final double REDUCERE_TIMP_INCEPATOR=0;
    public static double REDUCERE_TIMP_MEDIU=0.25;
    public static double REDUCERE_TIMP_SENIOR=0.5;


    public Mecanic(String nume, String prenume, String email, String telefon, TipAutomobil categorieAcceptata, TipVechime vechime, Boolean disponibilitate, int salariu, Atelier atelier){
        super(nume,prenume,email,telefon);
        setCategorie_Acceptata(categorieAcceptata);
        setVechime(vechime);
        setDisponibilitate(disponibilitate);
        setSalariu(salariu);
        setAtelier(atelier);
    }

    public Mecanic(Persoana p, TipAutomobil categorieAcceptata, TipVechime vechime, Boolean disponibilitate, int salariu, Atelier atelier){
        super(p);
        setCategorie_Acceptata(categorieAcceptata);
        setVechime(vechime);
        setDisponibilitate(disponibilitate);
        setSalariu(salariu);
        setAtelier(atelier);
    }

    public void setCategorie_Acceptata(TipAutomobil categorieAcceptata){
        this.categorieAcceptata=categorieAcceptata;
    }

    public void setVechime(TipVechime vechime){
        this.vechime=vechime;
    }

    public void setDisponibilitate(Boolean disponibilitate){
        this.disponibilitate=disponibilitate;
    }

    public void setSalariu(int salariu){
        this.salariu=Math.max(4050,salariu);
    }

    public void setAtelier(Atelier atelier){
        this.atelier=new Atelier(atelier);
    }

    public TipAutomobil getCategorieAcceptata(){
        return categorieAcceptata;
    }

    public TipVechime getVechime(){
        return vechime;
    }

    public Boolean getDisponibilitate(){
        return disponibilitate;
    }

    public int getSalariu(){
        return salariu;
    }

    public Atelier getAtelier(){
        return atelier;
    }

    public boolean poateReparaMasinaClient(Client client){
        return client.getCategorie()==this.categorieAcceptata;
    }

    public double timpReparareMasina(Client client){
        double timp_reparare;
        if(!this.poateReparaMasinaClient(client)){
            System.out.println("Mecanicul "+this.nume+" "+this.prenume+" nu poate repara acest tip de masina!");
            return -1;
        }

        switch(categorieAcceptata){
            case TipAutomobil.A:{
                timp_reparare=TIMP_CATEGORIA_A;
                break;
            }
            case TipAutomobil.B:{
                timp_reparare=TIMP_CATEGORIA_B;
                break;
            }
            case TipAutomobil.C:{
                timp_reparare=TIMP_CATEGORIA_C;
                break;
            }
            default: timp_reparare=TIMP_CATEGORIA_B;
        }

        switch(vechime){
            case TipVechime.incepator:{
                timp_reparare-=REDUCERE_TIMP_INCEPATOR*timp_reparare;
                break;
            }
            case TipVechime.mediu:{
                timp_reparare-=REDUCERE_TIMP_MEDIU*timp_reparare;
                break;
            }
            case TipVechime.senior:{
                timp_reparare-=REDUCERE_TIMP_SENIOR*timp_reparare;
                break;
            }
            default: timp_reparare-=REDUCERE_TIMP_MEDIU*timp_reparare;
        }

        return timp_reparare;
    }

    public void actualizeazaDisponibilitate(Boolean disponibilitate){
        this.disponibilitate=disponibilitate;
        System.out.println("Disponibilitatea mecanicului " + this.getNume() + " " + this.getPrenume() +
                " a fost actualizată la: " + (disponibilitate ? "Disponibil" : "Indisponibil"));
    }

    public String emitereRaport(Client client, String detaliiReparatie) {
        double timp=timpReparareMasina(client);
        if(timp<0){
            return "Nu pot repara autovehiculul de categorie "+client.getCategorie();
        }

        StringBuilder raport=new StringBuilder();
        raport.append("RAPORT DE REPARAȚIE\n");
        raport.append("---------------------------\n");
        raport.append("Mecanic: ").append(this.getNume()).append(" ").append(this.getPrenume()).append("\n");
        raport.append("Client: ").append(client.getNume()).append(" ").append(client.getPrenume()).append("\n");
        raport.append("Categorie autovehicul: ").append(client.getCategorie()).append("\n");
        raport.append("Durata reparație: ").append(timp).append(" ore\n");
        raport.append("Detalii reparație: ").append(detaliiReparatie).append("\n");
        raport.append("Data emiterii: ").append(java.time.LocalDate.now()).append("\n");
        raport.append("---------------------------\n");

        return raport.toString();
    }

    public boolean adaugarePieseUtilizate(Client client, PiesaAuto[] pieseDisponibile, int[] cantitatiDisponibile,
                                          PiesaAuto[] pieseNecesare, int[] cantitatiNecesare) {

        if(!this.disponibilitate){
            System.out.println("Mecanicul nu este disponibil pentru adăugarea pieselor.");
            return false;
        }

        if(!this.poateReparaMasinaClient(client)){
            System.out.println("Mecanicul " + this.getNume() + " " + this.getPrenume() +
                    " nu poate repara mașina de categorie " + client.getCategorie());
            return false;
        }

        boolean toatePieseleDisponibile=true;
        StringBuilder pieseIndisponibile=new StringBuilder();

        for(int i=0;i<pieseNecesare.length;i++){
            boolean piesaGasita=false;
            for(int j=0;j<pieseDisponibile.length;j++){
                if(pieseNecesare[i]==pieseDisponibile[j]){
                    if(cantitatiDisponibile[j]>=cantitatiNecesare[i]){
                        piesaGasita=true;
                    }
                    break;
                }
            }
            if(!piesaGasita){
                toatePieseleDisponibile=false;
                pieseIndisponibile.append(pieseNecesare[i]).append(" (").append(cantitatiNecesare[i]).append(" buc.), ");
            }
        }

        if(!toatePieseleDisponibile){
            if(pieseIndisponibile.length()>0){
                System.out.println("Următoarele piese nu sunt disponibile în stoc: " +
                        pieseIndisponibile.substring(0,pieseIndisponibile.length()-2));
            }
            System.out.println("Se comandă piesele lipsă...");
            System.out.println("Se continuă doar cu piesele disponibile.");
        }

        StringBuilder pieseAdaugate=new StringBuilder();
        boolean s_auAdaugatPiese=false;

        for(int i=0;i<pieseNecesare.length;i++){
            for (int j=0;j<pieseDisponibile.length;j++){
                if(pieseNecesare[i]==pieseDisponibile[j] && cantitatiDisponibile[j]>=cantitatiNecesare[i]){
                    cantitatiDisponibile[j]-=cantitatiNecesare[i];
                    pieseAdaugate.append(pieseNecesare[i]).append(" (").append(cantitatiNecesare[i]).append(" buc.), ");
                    s_auAdaugatPiese=true;
                    break;
                }
            }
        }

        if(!s_auAdaugatPiese){
            System.out.println("Nu s-au putut adăuga piese la lucrare.");
            return false;
        }

        StringBuilder raport=new StringBuilder();
        raport.append("RAPORT PIESE UTILIZATE\n");
        raport.append("---------------------------\n");
        raport.append("Mecanic: ").append(this.getNume()).append(" ").append(this.getPrenume()).append("\n");
        raport.append("Client: ").append(client.getNume()).append(" ").append(client.getPrenume()).append("\n");
        raport.append("Categorie autovehicul: ").append(client.getCategorie()).append("\n");
        raport.append("Piese utilizate: ").append(pieseAdaugate.substring(0, pieseAdaugate.length() - 2)).append("\n");
        raport.append("Data: ").append(java.time.LocalDate.now()).append("\n");
        raport.append("---------------------------\n");

        emitereRaport(client,raport.toString());

        return s_auAdaugatPiese;
    }

    @Override
    public void afisareDatePersoana(){
        super.afisareDatePersoana();
        System.out.println("Categorie de autovehicule acceptate: "+categorieAcceptata);
        System.out.println("Vechimea mecanicului: "+vechime);
        System.out.print("Disponibilitate: ");
        System.out.println(disponibilitate?"Este disponibil":"Nu este disponibil");
        System.out.println("Salariul mecanicului: "+salariu);
        System.out.println("Atelierul mecanicului:");
        this.atelier.afisareInformatiiAtelier();
    }
}
