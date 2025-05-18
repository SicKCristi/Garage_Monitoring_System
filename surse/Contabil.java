package Implementare_modele;

import java.util.ArrayList;

public class Contabil extends Persoana {
    private TipVechime vechime;
    private int salariu;
    private Birou birou;

    private final double AMPLIFICARE_SALARIU_INCEPATOR=1;
    private final double AMPLIFICARE_SALARIU_MEDIU=1.1;
    private final double AMPLIFICARE_SALARIU_SENIOR=1.3;

    public Contabil(String nume, String prenume, String email, String telefon, TipVechime vechime, int salariu, Birou birou){
        super(nume,prenume,email,telefon);
        setVechime(vechime);
        setSalariu(salariu);
        setBirou(birou);
    }

    public Contabil(Persoana p, TipVechime vechime, int salariu, Birou birou){
        super(p);
        setVechime(vechime);
        setSalariu(salariu);
        setBirou(birou);
    }

    public void setVechime(TipVechime vechime){
        this.vechime=vechime;
    }

    public void setSalariu(int salariu){
        this.salariu=Math.max(4050,salariu);
    }

    public void setBirou(Birou birou){
        this.birou=birou;
    }

    public TipVechime getVechime(){
        return vechime;
    }

    public int getSalariu(){
        return salariu;
    }

    public Birou getBirou(){
        return birou;
    }

    public String emitereFactura(Client client, ArrayList<String> serviciiEfectuate){
        double pretFaraReducere=client.pretServiciu();
        double procentReducere=client.calculeazaProcentReducere();
        double reducere=pretFaraReducere*procentReducere;
        double pretTotal=pretFaraReducere-reducere;

        StringBuilder factura=new StringBuilder();
        factura.append("FACTURĂ\n");
        factura.append("---------------------------\n");
        factura.append("Emisă de: ").append(this.getNume()).append(" ").append(this.getPrenume()).append("\n");
        factura.append("Data: ").append(java.time.LocalDate.now()).append("\n\n");
        factura.append("Client: ").append(client.getNume()).append(" ").append(client.getPrenume()).append("\n");
        factura.append("Categorie autovehicul: ").append(client.getCategorie()).append("\n\n");
        factura.append("Servicii efectuate:\n");

        if(serviciiEfectuate!=null && !serviciiEfectuate.isEmpty()){
            for(int i=0;i<serviciiEfectuate.size();i++)
                factura.append(i+1).append(". ").append(serviciiEfectuate.get(i)).append("\n");
        }else
            factura.append("- Serviciu standard pentru categoria ").append(client.getCategorie()).append("\n");

        factura.append("\nDetalii cost:\n");
        factura.append("Preț servicii: ").append(pretFaraReducere).append(" lei\n");
        factura.append("Reducere fidelitate (").append(client.calculeazaProcentReducere() * 100).append("%): -");
        factura.append(reducere).append(" lei\n");
        factura.append("Total de plată: ").append(pretTotal).append(" lei\n");
        factura.append("---------------------------\n");

        return factura.toString();
    }

    public String determinareFidelitate(Client client){
        TipFidelitate rank=client.getFidelitate();
        int numar_vizite=client.getNumarViziteService();
        if(numar_vizite==0)
            return "Fara vizite inregistrate";
        else{
            if(rank==TipFidelitate.Silver)
                return "Client nou";
            if(rank==TipFidelitate.Gold)
                return "Client fidel";
        }
        return "Client loial";
    }

    public String emitereRaportFinanciar(ArrayList<Client> clienti){
        if (clienti==null || clienti.isEmpty()){
            return "Nu există clienți pentru a genera raportul financiar.";
        }

        double venitTotal=0;
        int numarClienti=clienti.size();

        StringBuilder raport=new StringBuilder();
        raport.append("RAPORT FINANCIAR\n");
        raport.append("---------------------------\n");
        raport.append("Generat de: ").append(this.getNume()).append(" ").append(this.getPrenume()).append("\n");
        raport.append("Data: ").append(java.time.LocalDate.now()).append("\n\n");
        raport.append("Detalii venituri:\n");

        for(int i=0;i<numarClienti;i++){
            Client client=clienti.get(i);
            double pretClient=client.pretServiciu();
            venitTotal+=pretClient;

            raport.append(i+1).append(". ");
            raport.append(client.getNume()).append(" ").append(client.getPrenume());
            raport.append(" (cat. ").append(client.getCategorie()).append(")");
            raport.append(": ").append(pretClient).append(" lei\n");
        }

        raport.append("\nRezumat:\n");
        raport.append("Număr total clienți: ").append(numarClienti).append("\n");
        raport.append("Venit total: ").append(venitTotal).append(" lei\n");
        raport.append("Venit mediu per client: ").append(venitTotal / numarClienti).append(" lei\n");
        raport.append("---------------------------\n");

        return raport.toString();
    }

    public double calculareSalariuPropriu(){
        double salariu_baza=this.salariu;

        switch(vechime){
            case incepator:
                return salariu_baza*AMPLIFICARE_SALARIU_INCEPATOR;
            case mediu:
                return salariu_baza*AMPLIFICARE_SALARIU_MEDIU;
            case senior:
                return salariu_baza*AMPLIFICARE_SALARIU_SENIOR;
            default:
                return salariu_baza;
        }
    }

    public int calculareSalariu(Persoana persoana){
        if(persoana==null)
            return 0;

        int salariu_baza=0;
        double coeficientBonus=1;
        if(persoana instanceof Mecanic){
            Mecanic mecanic=(Mecanic) persoana;
            salariu_baza=mecanic.getSalariu();

            switch(mecanic.getVechime()){
                case incepator:
                    coeficientBonus=AMPLIFICARE_SALARIU_INCEPATOR;
                    break;
                case mediu:
                    coeficientBonus=AMPLIFICARE_SALARIU_MEDIU;
                    break;
                case senior:
                    coeficientBonus=AMPLIFICARE_SALARIU_SENIOR;
                    break;
                default:
                    coeficientBonus=AMPLIFICARE_SALARIU_INCEPATOR;
            }
        }else if(persoana instanceof Contabil){
            Contabil contabil=(Contabil) persoana;
            salariu_baza=contabil.getSalariu();

            switch(contabil.getVechime()){
                case incepator:
                    coeficientBonus=AMPLIFICARE_SALARIU_INCEPATOR;
                    break;
                case mediu:
                    coeficientBonus=AMPLIFICARE_SALARIU_MEDIU;
                    break;
                case senior:
                    coeficientBonus=AMPLIFICARE_SALARIU_SENIOR;
                    break;
                default:
                    coeficientBonus=AMPLIFICARE_SALARIU_INCEPATOR;
            }
        } else return 0;

        return (int)(salariu_baza*coeficientBonus);
    }

    public double calculareProfit(ArrayList<Client> clienti, ArrayList<Mecanic> mecanici, ArrayList<Contabil> contabili){
        double venitTotal=0;
        for(int i=0;i<clienti.size();i++)
            venitTotal+=clienti.get(i).pretServiciu();

        double cheltuieliSalarii=0;
        for(int i=0;i<mecanici.size();i++)
            cheltuieliSalarii+=this.calculareSalariu(mecanici.get(i));
        for(int i=0;i<contabili.size();i++)
            cheltuieliSalarii+=this.calculareSalariu(contabili.get(i));

        return venitTotal-cheltuieliSalarii;
    }

    @Override
    public void afisareDatePersoana(){
        super.afisareDatePersoana();
        System.out.println("Vechimea contabilului: "+vechime);
        System.out.println("Salariul contabilului: "+salariu);
        System.out.println("Biroul contabilului:");
        this.birou.afisareInformatiiBirou();
    }
}
