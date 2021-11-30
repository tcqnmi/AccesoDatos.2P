
package examen2021xstream;


public class Disco {
    
    private String TITLE;
    private String ARTIST;
    private String COUNTRY;
    private String COMPANY;
    private double PRICE;
    private int YEAR;

    public Disco(String TITLE, String ARTIST, String COUNTRY, String COMPANY, double PRICE, int YEAR) {
        this.TITLE = TITLE;
        this.ARTIST = ARTIST;
        this.COUNTRY = COUNTRY;
        this.COMPANY = COMPANY;
        this.YEAR = YEAR;
        this.PRICE = PRICE;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getARTIST() {
        return ARTIST;
    }

    public void setARTIST(String ARTIST) {
        this.ARTIST = ARTIST;
    }

    public String getCOUNTRY() {
        return COUNTRY;
    }

    public void setCOUNTRY(String COUNTRY) {
        this.COUNTRY = COUNTRY;
    }

    public String getCOMPANY() {
        return COMPANY;
    }

    public void setCOMPANY(String COMPANY) {
        this.COMPANY = COMPANY;
    }

    public double getPRICE() {
        return PRICE;
    }

    public void setPRICE(double PRICE) {
        this.PRICE = PRICE;
    }

    public int getYEAR() {
        return YEAR;
    }

    public void setYEAR(int YEAR) {
        this.YEAR = YEAR;
    }

    
    
    public void mostrarDisco(){
        System.out.println("TITLE: "+TITLE);
        System.out.println("ARTIST: "+ARTIST);
        System.out.println("COUNTRY: "+COUNTRY);
        System.out.println("COMPANY: "+COMPANY);
        System.out.println("YEAR: "+YEAR);
        System.out.println("PRICE: "+PRICE);
        
          
    }
    
}
