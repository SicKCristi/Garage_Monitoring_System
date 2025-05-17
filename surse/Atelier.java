package Implementare_modele;

public class Atelier {
    private double suprafata;
    private int numarOrdine;
    private PiesaAuto[] pieseDisponibile;
    private int[] cantitatiDisponibile;

    public Atelier(double suprafata, int numarOrdine, PiesaAuto[] pieseDisponibile, int[] cantitatiDisponibile){
        setSuprafata(suprafata);
        setNumarOrdine(numarOrdine);
        setPieseDisponibile(pieseDisponibile);
        setCantitatiDisponibile(cantitatiDisponibile);
    }

    public Atelier(double suprafata, int numarOrdine){
        setSuprafata(suprafata);
        setNumarOrdine(numarOrdine);
        this.pieseDisponibile=null;
        this.cantitatiDisponibile=null;
    }

    public Atelier(){
        this.suprafata=0;
        this.numarOrdine=0;
        this.pieseDisponibile=null;
        this.cantitatiDisponibile=null;
    }

    public Atelier(Atelier atelier){
        setSuprafata(atelier.getSuprafata());
        setNumarOrdine(atelier.getNumarOrdine());
        setPieseDisponibile(atelier.pieseDisponibile);
        setCantitatiDisponibile(atelier.cantitatiDisponibile);
    }

    public void setPieseDisponibile(PiesaAuto[] pieseDisponibile){
        if(pieseDisponibile==null)
            this.pieseDisponibile=null;
        else{
            this.pieseDisponibile=new PiesaAuto[pieseDisponibile.length];
            for(int i=0;i<pieseDisponibile.length;i++)
                this.pieseDisponibile[i]=pieseDisponibile[i];
        }
    }

    public void setCantitatiDisponibile(int[] cantitatiDisponibile){
        if(cantitatiDisponibile==null)
            this.cantitatiDisponibile=null;
        else{
            this.cantitatiDisponibile=new int[cantitatiDisponibile.length];
            for(int i=0;i<cantitatiDisponibile.length;i++)
                this.cantitatiDisponibile[i]=cantitatiDisponibile[i];
        }
    }

    private Boolean suprafataValid(double suprafata){
        return suprafata>0.0;
    }

    public void setSuprafata(double suprafata){
        if(suprafataValid(suprafata))
            this.suprafata=suprafata;
        else {
            System.out.println("\nSuprafata introdusa este negativa, deci va avea valoarea 0!\n");
            this.suprafata=0.0;
        }
    }

    public void extindeSuprafata(double valoareExtindere) {
        if(valoareExtindere>0){
            this.suprafata+=valoareExtindere;
            System.out.println("Suprafața atelierului a fost extinsă la " + this.suprafata + " metri pătrați.");
        }else{
            System.out.println("Valoarea de extindere trebuie să fie pozitivă!");
        }
    }

    private Boolean numarOrdineValid(int numarOrdine){
        return numarOrdine>0;
    }

    public void setNumarOrdine(int numarOrdine){
        if(numarOrdineValid(numarOrdine))
            this.numarOrdine=numarOrdine;
        else {
            System.out.println("\nNumarul de ordine introdus este negativ, deci va avea valoarea 0!\n");
            this.numarOrdine=0;
        }
    }

    public double getSuprafata(){
        return suprafata;
    }

    public int getNumarOrdine(){
        return numarOrdine;
    }

    public PiesaAuto[] getPieseDisponibile(){
        return pieseDisponibile;
    }

    public int[] getCantitatiDisponibile(){
        return cantitatiDisponibile;
    }

    public boolean adaugarePieseUtilizate(Mecanic mecanic,Client client){
        if(!mecanic.getDisponibilitate()){
            System.out.println("Mecanicul nu este disponibil pentru adaugarea pieselor.");
            return false;
        }

        if(!mecanic.poateReparaMasinaClient(client)){
            System.out.println("Mecanicul " + mecanic.getNume() + " " + mecanic.getPrenume() +
                    " nu poate repara masina de categorie " + client.getCategorie() + ".");
            return false;
        }

        PiesaAuto[] pieseNecesare=client.getPieseNecesare();
        int[] cantitatiNecesare=client.getCantitatiNecesare();

        if(pieseNecesare==null || cantitatiNecesare==null){
            System.out.println("Nu se cunoaste concret de ce piese are nevoie clientul.");
            return false;
        }

        if(pieseNecesare.length!=cantitatiNecesare.length){
            System.out.println("Cantitati necesare diferite de numarul total necesar de piese.");
            return false;
        }

        for (int k : cantitatiNecesare) {
            if (k < 0) {
                System.out.println("Cantitatea pieselor nu poate fi negativă.");
                throw new IllegalArgumentException();
            }
        }

        if(pieseDisponibile==null || cantitatiDisponibile==null){
            System.out.println("Stocul de piese nu este disponibil.");
            return false;
        }

        boolean toatePieseleDisponibile=true;
        StringBuilder pieseIndisponibile=new StringBuilder();

        for (int i=0;i<pieseNecesare.length;i++){
            boolean piesaGasita=false;
            for (int j=0;j<pieseDisponibile.length; j++){
                if(pieseNecesare[i]==pieseDisponibile[j]){
                    if(cantitatiDisponibile[j]>=cantitatiNecesare[i]){
                        piesaGasita=true;
                    }
                    break;
                }
            }
            if(!piesaGasita){
                toatePieseleDisponibile=false;
                pieseIndisponibile.append(pieseNecesare[i]).append(" (")
                        .append(cantitatiNecesare[i]).append(" buc.), ");
            }
        }

        if(!toatePieseleDisponibile){
            if(pieseIndisponibile.length() > 0){
                System.out.println("Urmatoarele piese nu sunt disponibile în stoc: " +
                        pieseIndisponibile.substring(0, pieseIndisponibile.length()-2));
            }
            System.out.println("Se continua doar cu piesele disponibile.");
        }

        StringBuilder pieseAdaugate=new StringBuilder();
        boolean s_auAdaugatPiese=false;

        for(int i=0;i<pieseNecesare.length;i++){
            for(int j=0;j<pieseDisponibile.length; j++){
                if(pieseNecesare[i]==pieseDisponibile[j] &&
                        cantitatiDisponibile[j]>=cantitatiNecesare[i]){
                    cantitatiDisponibile[j]-=cantitatiNecesare[i];
                    pieseAdaugate.append(pieseNecesare[i]).append(" (")
                            .append(cantitatiNecesare[i]).append(" buc.), ");
                    s_auAdaugatPiese=true;
                    break;
                }
            }
        }

        if (!s_auAdaugatPiese) {
            System.out.println("Nu s-a putut adauga nicio piesa, stocul este insuficient.");
            return false;
        } else {
            if (!toatePieseleDisponibile) {
                System.out.println("S-au adăugat doar o parte din piesele necesare.");
            } else {
                System.out.println("Au fost adaugate toate piesele cu succes.");
            }
        }

        mecanic.emitereRaport(client,pieseAdaugate.toString());
        return true;
    }

    public void afisareInformatiiAtelier(){
        System.out.println("Informatiile despre atelier:");
        System.out.println("Suprafata atelierului: "+suprafata);
        System.out.println("Numarul de ordine al atelierului: "+numarOrdine);
        System.out.println("Piesele disponibile:");
        if(pieseDisponibile!=null)
            for(int i=0;i<pieseDisponibile.length;i++)
                System.out.println("Piesa "+(i+1)+": "+pieseDisponibile[i]);

        System.out.println("Numarul de piese dispobilie:");
        if(cantitatiDisponibile!=null)
            for(int i=0;i<cantitatiDisponibile.length;i++)
                System.out.println("Cantitatea"+(i+1)+": "+cantitatiDisponibile[i]);
    }
}

