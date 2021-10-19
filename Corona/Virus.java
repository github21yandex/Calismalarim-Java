package Corona;


public class Virus {
    
    private String virusAd;
    private double bulasOran;
    private double iyilesmeOran;
    
    public String getVirusAd() {
        return virusAd;
    }

    public void setVirusAd(String virusAd) {
        this.virusAd = virusAd;
    }

    public double getBulasOran() {
        return bulasOran;
    }

    public void setBulasOran(double bulasOran) {
        this.bulasOran = bulasOran;
    }

    public double getIyilesmeOran() {
        return iyilesmeOran;
    }

    public void setIyilesmeOran(double iyilesmeOran) {
        this.iyilesmeOran = iyilesmeOran;
    }
    

    public Virus (String virusAd, double bulasOran ) {
        this.virusAd = virusAd;
        this.bulasOran = bulasOran;
    }

    public Virus (String virusAd, double bulasOran, double iyilesmeOran) {
        this.virusAd = virusAd;
        this.bulasOran = bulasOran;
        this.iyilesmeOran = iyilesmeOran;
    }
    
    public Virus ( Virus obj){
        
        this.virusAd = obj.virusAd;
        this.bulasOran = obj.bulasOran;
        this.iyilesmeOran = obj.iyilesmeOran;
    }
    
    public String toString()
    {
        return "Virus [bulasOran=" + bulasOran + ", iyilesmeOran=" + iyilesmeOran + ", virusAd=" + virusAd + "]";
    }
    
    
    
}
