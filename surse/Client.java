package Implementare_modele;

public class Client extends Persoana {
    private TipAutomobil categorie;
    private String numarCard;
    private int numarViziteService;
    private PiesaAuto[] pieseNecesare;
    private int[] cantitatiNecesare;

    /// Mai jos vom defini cat costa reparatia in functie de categoria vehiculului
    private final int PRET_CATEGORIA_A=3500;
    private final int PRET_CATEGORIA_B=4500;
    private final int PRET_CATEGORIA_C=5000;

    ///  Mai jos vom defini procentul din pret care se scade din pret.
    private final double PROCENT_REDUCERE=0.05;

    public Client(String nume, String prenume, String email, String telefon, TipAutomobil categorie, String numarCard, int numarViziteService){
        super(nume,prenume,email,telefon);
        setCategorie(categorie);
        setNumarCard(numarCard);
        setNumarViziteService(numarViziteService);
        this.pieseNecesare=null;
        this.cantitatiNecesare=null;
    }

    public Client(String nume, String prenume, String email, String telefon, TipAutomobil categorie, String numarCard, int numarViziteService, PiesaAuto[] pieseNecesare, int[] cantitatiNecesare){
        super(nume,prenume,email,telefon);
        setCategorie(categorie);
        setNumarCard(numarCard);
        setNumarViziteService(numarViziteService);
        setPieseNecesare(pieseNecesare);
        setCantitatiNecesare(cantitatiNecesare);
    }

    public Client(Persoana p, TipAutomobil categorie, String numarCard, int numarViziteService){
        super(p);
        setCategorie(categorie);
        setNumarCard(numarCard);
        setNumarViziteService(numarViziteService);
        this.pieseNecesare=null;
        this.cantitatiNecesare=null;
    }

    public Client(Persoana p, TipAutomobil categorie, String numarCard, int numarViziteService, PiesaAuto[] pieseNecesare, int[] cantitatiNecesare){
        super(p);
        setCategorie(categorie);
        setNumarCard(numarCard);
        setNumarViziteService(numarViziteService);
        setPieseNecesare(pieseNecesare);
        setCantitatiNecesare(cantitatiNecesare);
    }

    public TipAutomobil getCategorie(){
        return categorie;
    }

    public String getNumarCard(){
        return numarCard;
    }

    public int getNumarViziteService(){
        return numarViziteService;
    }

    public PiesaAuto[] getPieseNecesare(){
        return pieseNecesare;
    }

    public int[] getCantitatiNecesare(){
        return cantitatiNecesare;
    }

    public void setCategorie(TipAutomobil categorie){
        this.categorie=categorie;
    }

    public Boolean esteNumarCardValid(String numarCard){
        return numarCard.length()==16;
    }

    public void setNumarCard(String numarCard){
        if(esteNumarCardValid(numarCard)){
            this.numarCard=numarCard;
        }
        else{
            System.out.println();
            System.out.println("Numarul de card dat nu este valid!");
            System.out.println();
            this.numarCard=null;
        }
    }

    public Boolean esteNumarViziteServiceValid(int numarViziteService){
        return numarViziteService>0;
    }

    public void setNumarViziteService(int numarViziteService){
        if(esteNumarViziteServiceValid(numarViziteService))
            this.numarViziteService=numarViziteService;
        else{
            System.out.println();
            System.out.println("Numarul dat este negativ, asa ca vom pune 0!");
            System.out.println();
            this.numarViziteService=0;
        }
    }

    public void setPieseNecesare(PiesaAuto[] pieseNecesare){
        if(pieseNecesare==null)
            this.pieseNecesare=null;
        else{
            this.pieseNecesare=new PiesaAuto[pieseNecesare.length];
            for(int i=0;i<pieseNecesare.length;i++)
                this.pieseNecesare[i]=pieseNecesare[i];
        }
    }

    public void setCantitatiNecesare(int[] cantitatiNecesare){
        if(cantitatiNecesare==null)
            this.cantitatiNecesare=null;
        else{
            this.cantitatiNecesare=new int[cantitatiNecesare.length];
            for(int i=0;i<cantitatiNecesare.length;i++)
                this.cantitatiNecesare[i]=cantitatiNecesare[i];
        }
    }

    public void actualizeazaViziteService(){
        this.numarViziteService++;
        System.out.println("Clientul " + this.getNume() + " " + this.getPrenume() +
                " a efectuat o nouă vizită. Număr total vizite: " + this.numarViziteService);
    }

    public double calculeazaProcentReducere(){
        return PROCENT_REDUCERE*numarViziteService;
    }

    public double pretServiciu(){
        double pret_serviciu;
        switch(categorie){
            case A:{
                pret_serviciu=PRET_CATEGORIA_A;
                break;
            }
            case B:{
                pret_serviciu=PRET_CATEGORIA_B;
                break;
            }
            case C:{
                pret_serviciu=PRET_CATEGORIA_C;
                break;
            }
            default: pret_serviciu=PRET_CATEGORIA_B;
        }

        pret_serviciu-=pret_serviciu*calculeazaProcentReducere();
        return pret_serviciu;
    }

    public double calculeazaPretTotal(int numarOperatiuni){
        double pretPerOperatiune=pretServiciu();
        return pretPerOperatiune*numarOperatiuni;
    }

    public TipFidelitate getFidelitate(){
        if(numarViziteService>=50)
            return TipFidelitate.Diamond;
        else if(numarViziteService>=30)
            return TipFidelitate.Gold;
        else
            return TipFidelitate.Silver;
    }

    @Override
    public void afisareDatePersoana(){
        System.out.println("Informatii despre client:");
        super.afisareDatePersoana();
        System.out.println("Categoria: "+categorie);
        System.out.println("Numarul de card: ");
        if(numarCard!=null)
            System.out.println(numarCard);
        else
            System.out.println();
        System.out.println("Numarul de vizite la service: "+numarViziteService);

        System.out.println("Piesele necesare:");
        if(pieseNecesare!=null)
            for(int i=0;i<pieseNecesare.length;i++)
                System.out.println("Piesa "+(i+1)+": "+pieseNecesare[i]);

        System.out.println("Numarul de piese necesare:");
        if(cantitatiNecesare!=null)
            for(int i=0;i<cantitatiNecesare.length;i++)
                System.out.println("Cantitatea"+(i+1)+": "+cantitatiNecesare[i]);
    }
}
