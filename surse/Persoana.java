package Implementare_modele;

public class Persoana {
    protected String nume;
    protected String prenume;
    protected String email;
    protected String telefon;

    public Persoana(String nume, String prenume, String email, String telefon){
        setNume(nume);
        setPrenume(prenume);
        setEmail(email);
        setTelefon(telefon);
    }

    public Persoana(Persoana p){
        setNume(p.getNume());
        setPrenume(p.getPrenume());
        setEmail(p.getEmail());
        setTelefon(p.getTelefon());
    }

    public Persoana(){
        nume=null;
        prenume=null;
        email=null;
        telefon=null;
    }

    public String getNume(){
        return nume;
    }

    public String getPrenume(){
        return prenume;
    }

    public String getEmail(){
        return email;
    }

    public String getTelefon(){
        return telefon;
    }

    public void setNume(String nume){
        if(nume==null)
            this.nume=null;
        else
            this.nume=nume;
    }

    public void setPrenume(String prenume){
        if(prenume==null)
            this.prenume=null;
        else
            this.prenume=prenume;
    }

    private Boolean emailValid(String email){
        if(email==null || email.isEmpty())
            return false;

        int pozitie_arond=email.indexOf('@');
        if(pozitie_arond<=0 || pozitie_arond==email.length()-1)
            return false;

        int pozitiePunct=email.indexOf('.', pozitie_arond);

        return pozitiePunct!=-1 && pozitiePunct!= pozitie_arond +1 && pozitiePunct!=email.length()-1;
    }

    public void setEmail(String email){
        if(emailValid(email))
            this.email=email;
        else{
            System.out.println();
            System.out.println("Emailul dat nu este valid!");
            System.out.println();
            this.email=null;
        }

    }

    private Boolean telefonValid(String telefon){
        if(telefon==null || telefon.isEmpty())
            return false;

        if(telefon.length()!= 10)
            return false;

        for(int i=0;i<telefon.length();i++)
            if(telefon.charAt(i)<'0' || telefon.charAt(i)>'9')
                return false;

        return true;
    }

    public void setTelefon(String telefon){
        if(telefonValid(telefon))
            this.telefon=telefon;
        else{
            System.out.println();
            System.out.println("Telefonul dat nu este valid!");
            System.out.println();
            this.telefon=null;
        }
    }

    public void afisareDatePersoana(){
        System.out.print("Numele: ");
        if(nume!=null){
            System.out.println(nume);
        } else{
            System.out.println();
        }

        System.out.print("Prenumele: ");
        if(prenume!=null){
            System.out.println(prenume);
        } else{
            System.out.println();
        }

        System.out.print("Emailul: ");
        if(email!=null){
            System.out.println(email);
        } else{
            System.out.println();
        }

        System.out.print("Telefonul: ");
        if(telefon!=null){
            System.out.println(telefon);
        } else{
            System.out.println();
        }
    }
}
