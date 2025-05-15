package Implementare_modele;

public class Birou {
    private int etaj;
    private int oraDeschidere;
    private int oraInchidere;

     public Birou(int etaj, int oraDeschidere, int oraInchidere){
         setEtaj(etaj);
         setOraDeschidere(oraDeschidere);
         setOraInchidere(oraInchidere);
     }

     private Boolean etajValid(int etaj){
         return etaj>0;
     }

     public void setEtaj(int etaj){
         if(etajValid(etaj))
             this.etaj=etaj;
         else{
             System.out.println();
             System.out.println("Etajul introdus este negativ, deci se va folosi parterul!");
             System.out.println();
             this.etaj=0;
         }
     }

    private Boolean oraDeschidereValid(int oraDeschidere){
        return oraDeschidere>=5 && oraDeschidere<=12;
    }

    public void setOraDeschidere(int oraDeschidere){
        if(oraDeschidereValid(oraDeschidere))
            this.oraDeschidere=oraDeschidere;
        else{
            System.out.println();
            System.out.println("Ora introdusa nu este in range-ul precizat, deci se va seta automat la 5 dimineata!");
            System.out.println();
            this.oraDeschidere=5;
        }
    }

    private Boolean OraInchidereValid(int oraInchidere){
        return oraInchidere>=18 && oraInchidere<=24;
    }

    public void setOraInchidere(int oraInchidere){
        if(OraInchidereValid(oraInchidere))
            this.oraInchidere=oraInchidere;
        else{
            System.out.println();
            System.out.println("Ora introdusa nu este in range-ul precizat, deci se va seta automat la 18 dimineata!");
            System.out.println();
            this.oraInchidere=18;
        }
    }

    public boolean extindeProgramFunctionare(int oraNoua){
        if(OraInchidereValid(oraNoua) && oraNoua>this.oraInchidere){
            this.oraInchidere=oraNoua;
            return true;
        }
        else{
            System.out.println("Ora furnizata nu este valida sau este mai mica decat ora de inchidere curenta");
            return false;
        }
    }

    public int getEtaj(){
        return etaj;
    }

    public int getOraDeschidere(){
        return oraDeschidere;
    }

    public int getOraInchidere(){
        return oraInchidere;
    }

    public void afisareInformatiiBirou(){
        System.out.println("Informatiile despre birou:");
        System.out.println("Etajul unde este pozitionat biroul: "+etaj);
        System.out.println("Ora de deschidere a biroului: "+oraDeschidere);
        System.out.println("Ora de inchidere a biroului: "+oraInchidere);
    }

    public void afisareProgramFunctionare(){
        String deschidereFormat = (oraDeschidere<12) ?
                oraDeschidere + " AM" :
                ((oraDeschidere == 12) ? "12 PM" : (oraDeschidere - 12) + " PM");

        String inchidereFormat = (oraInchidere < 12) ?
                oraInchidere + " AM" :
                ((oraInchidere == 12) ? "12 PM" : (oraInchidere - 12) + " PM");

        System.out.println("Programul de funcționare este între orele " + deschidereFormat + " - " + inchidereFormat);
    }
}
