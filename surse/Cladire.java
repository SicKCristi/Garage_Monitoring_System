package Implementare_modele;

import java.util.ArrayList;
import java.util.Collections;

public class Cladire {
    private String adresa;
    private ArrayList<Facilitati> facilitati;
    private Birou birou;
    private ArrayList<Atelier> ateliere;

    public Cladire(String adresa, ArrayList<Facilitati> facilitati, Birou birou, ArrayList<Atelier> ateliere){
        setAdresa(adresa);
        setFacilitati(facilitati);
        setBirou(birou);
        setAteliere(ateliere);
    }

    public Cladire(String adresa){
        setAdresa(adresa);
        facilitati=new ArrayList<Facilitati>();
        ateliere=new ArrayList<Atelier>();
        birou=null;
    }

    public void setAdresa(String adresa){
        if(adresa!=null)
            this.adresa=adresa;
        else{
            System.out.println();
            System.out.println("Adresa introdusa este valida!");
            System.out.println();
            this.adresa=null;
        }
    }

    public void setFacilitati(ArrayList<Facilitati> facilitati){
        if(!facilitati.isEmpty())
            this.facilitati=new ArrayList<Facilitati>(facilitati);
        else
            this.facilitati=new ArrayList<Facilitati>();
    }

    public void setBirou(Birou birou){
        this.birou=birou;
    }

    public void setAteliere(ArrayList<Atelier> ateliere){
        if(!ateliere.isEmpty())
            this.ateliere=new ArrayList<Atelier>(ateliere);
        else
            this.ateliere=new ArrayList<Atelier>();
    }

    public String getAdresa(){
        return adresa;
    }

    public ArrayList<Facilitati> getFacilitati(){
        return facilitati;
    }

    public Birou getBirou(){
        return birou;
    }

    public ArrayList<Atelier> getAteliere(){
        return ateliere;
    }

    public Atelier getAtelierDupaIndexDat(int index){
        if(index>=0 && index<ateliere.size())
            return ateliere.get(index);
        else {
            System.out.println();
            System.out.println("Indexul dat nu este valid, asa ca nu putem returna atelierul corespunzator indexului furnizat!");
            System.out.println();
            return null;
        }
    }

    public Facilitati getFacilitateDupaIndex(int index){
        if(index>=0 && index<facilitati.size())
            return facilitati.get(index);
        else {
            System.out.println();
            System.out.println("Indexul dat nu este valid, asa ca nu putem returna facilitatea corespunzatoare indexului furnizat!");
            System.out.println();
            return null;
        }
    }

    public void adaugareAtelier(Atelier atelier){
        int i=0;
        while(i<ateliere.size() && atelier.getNumarOrdine()!=ateliere.get(i).getNumarOrdine())
            i++;
        if(i>=ateliere.size())
            this.ateliere.add(atelier);
        else{
            System.out.println();
            System.out.println("Numarul de ordine al atelierului de adaugat exista deja, deci nu s-a realizat adaugarea!");
            System.out.println();
        }
    }

    public void adaugareFacilitate(Facilitati facilitate){
        int i=0;
        while(i<facilitati.size())
            if(facilitati.get(i).equals(facilitate))
                break;
            else
                i++;
        if(i>=facilitati.size())
            this.facilitati.add(facilitate);
        else{
            System.out.println();
            System.out.println("Facilitatea specificata este deja prezenta in cladire!");
            System.out.println();
        }
    }

    public void stergereAtelierDupaIndex(int index){
        if(index>=0 && index<ateliere.size())
            this.ateliere.remove(index);
        else{
            System.out.println();
            System.out.println("Indexul dat nu este invalid, stergerea nu a putut fi efectuata!");
            System.out.println();
        }
    }

    public Boolean corespundeOras(String oras){
        return this.adresa.contains(oras);
    }

    public double calculeazaSuprafataTotalaAteliere(){
        double suprafataTotala=0.0;
        for(int i=0;i<ateliere.size();i++)
            suprafataTotala+=ateliere.get(i).getSuprafata();
        return suprafataTotala;
    }

    public boolean existaAtelierCuNumarOrdine(int numarOrdine){
        for(int i=0;i<ateliere.size();i++)
            if(ateliere.get(i).getNumarOrdine()==numarOrdine)
                return true;
        return false;
    }

    public ArrayList<Atelier> filtreazaAteliereDupaSuprafata(double suprafataMinima){
        ArrayList<Atelier> ateliere_ramase=new ArrayList<>();
        for(int i=0;i<ateliere.size();i++)
            if (ateliere.get(i).getSuprafata() >= suprafataMinima)
                ateliere_ramase.add(ateliere.get(i));
        return ateliere_ramase;
    }

    public void sorteazaAteliereDupaSuprafata(){
        Collections.sort(ateliere, (a1, a2) -> Double.compare(a1.getSuprafata(), a2.getSuprafata()));
    }

    public void sorteazaAteliereDupaNumarOrdine(){
        Collections.sort(ateliere,(a1, a2) -> Integer.compare(a1.getNumarOrdine(), a2.getNumarOrdine()));
    }

    public void afisareInformatiiCladire(){
        System.out.println("Informatii despre cladire:");
        System.out.print("Adresa unde este situata cladirea: ");
        if(adresa!=null)
            System.out.println(adresa);
        else
            System.out.println();
        if(!facilitati.isEmpty()){
            System.out.println("Faciltatile pe care le ofera cladirea:");
            for (int i=0;i<facilitati.size();i++)
                System.out.println("Facilitatea " + (i+1) + ": " + facilitati.get(i));
        }
        else
            System.out.println("Cladirea nu ofera facilitati extra!");
        System.out.println("Biroul cladirii:");
        if(birou!=null)
            birou.afisareInformatiiBirou();
        System.out.println("Atelierele care se afla in cladire:");
        for(int i=0;i<ateliere.size();i++){
            System.out.println("Atelierul "+(i+1)+":");
            ateliere.get(i).afisareInformatiiAtelier();
            System.out.println();
        }
    }
}
