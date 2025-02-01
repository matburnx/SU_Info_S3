public class Villageois {
    String nom;
    double poids;
    boolean malade;

    public Villageois(String nomVillageois) {
        nom=nomVillageois;
	poids=Math.random()*(150-50)+50;
	malade=Math.random()<0.2;
    }

    public String toString() {
        String s = "Villageois : " + nom + ", poids : " + String.format("%.2f",poids) + " kg, malade ";
	if(malade)
	    s+="oui";
	else
	    s+="non";
	
	s+= ", peut soulever : " + String.format("%.2f",poidsSouleve()) + " kg";
	
	return s;
    }

    public String getNom() {
        return nom;
    }

    public double getPoids() {
        return poids;
    }

    public boolean getMalade() {
        return malade;
    }
    
    public double poidsSouleve() {
    	double souleve;
    	if(malade)
    		souleve = poids*(1./4.);
    	else
    		souleve = poids*(1./3.);
    	return souleve;
    }
}
