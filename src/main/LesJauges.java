package main;

public class LesJauges {
    /**
     * La jauge de Clergé
     */
    public static Jauge jaugeClerge;
    /**
     * La jauge de Peuple
     */
    public static Jauge jaugePeuple;
    /**
     * La jauge d'Armée
     */
    public static Jauge jaugeArmee;
    /**
     * La jauge de Finances
     */
    public static Jauge jaugeFinance;

    /**
     * Affiche une jauge avec un format graphique, en utilisant des "#" pour représenter la valeur de la jauge
     * et des "_" pour représenter la valeur manquante.
     *
     * @param jauge La jauge à afficher
     */
    private static void afficheJauge(Jauge jauge) {
        String resultat = "[";
        // valeur : ####
        for(int i=0;i<jauge.getValeur();i++){
            resultat += "#";
        }
        // on complète avec ____
        for(int i=0;i<50-(jauge.getValeur()>0?jauge.getValeur():0);i++){
            resultat += "_";
        }
        resultat += "] ";
        // affichage du nom
        resultat += jauge.getNom();
        System.out.println(resultat);
    }


    /**
     * Affiche les jauges de Clergé, Peuple, Armée et Finances du personnage.
     */
    public static void AfficheJauges() {
        afficheJauge(jaugeClerge);
        afficheJauge(jaugePeuple);
        afficheJauge(jaugeArmee);
        afficheJauge(jaugeFinance);
        System.out.println();
    }

    public void initJauges() {
        // Initialisation des jauges entre 15 et 35 points
        jaugeClerge = new Jauge("Clergé", 15 + (int)(Math.random() * (35 - 15)));
        jaugePeuple = new Jauge("Peuple", 15 + (int)(Math.random() * (35 - 15)));
        jaugeArmee = new Jauge("Armée", 15 + (int)(Math.random() * (35 - 15)));
        jaugeFinance = new Jauge("Finances", 15 + (int)(Math.random() * (35 - 15)));
    }

    /**
     * Vérifie si le jeu est fini en vérifiant si une des jauges est à 0 ou 50.
     *
     * @return true si le jeu est fini, false sinon
     */
    public static boolean finDuJeu(){
        if(jaugeClerge.getValeur()<=0
                || jaugeClerge.getValeur()>=50
                || jaugePeuple.getValeur()<=0
                || jaugePeuple.getValeur()>=50
                || jaugeArmee.getValeur()<=0
                || jaugeArmee.getValeur()>=50
                || jaugeFinance.getValeur()<=0
                || jaugeFinance.getValeur()>=50){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Retourne la jauge du clergé
     * @return la jauge du clergé
     */
    public static Jauge getJaugeClerge() {
        return jaugeClerge;
    }

    /**
     * Modifie la jauge du clergé
     * @param jaugeClerge La nouvelle jauge du clergé
     */
    public void setJaugeClerge(Jauge jaugeClerge) {
        this.jaugeClerge = jaugeClerge;
    }

    /**
     * Retourne la jauge du peuple
     * @return la jauge du peuple
     */
    public static Jauge getJaugePeuple() {
        return jaugePeuple;
    }
    /**
     * Modifie la jauge du peuple
     * @param jaugePeuple La nouvelle jauge du peuple
     */
    public void setJaugePeuple(Jauge jaugePeuple) {
        this.jaugePeuple = jaugePeuple;
    }

    /**
     * Retourne la jauge de l'armée
     * @return la jauge de l'armée
     */
    public static Jauge getJaugeArmee() {
        return jaugeArmee;
    }
    /**
     * Modifie la jauge de l'armée
     * @param jaugeArmee La nouvelle jauge de l'armée
     */
    public void setJaugeArmee(Jauge jaugeArmee) {
        this.jaugeArmee = jaugeArmee;
    }

    /**
     * Retourne la jauge des finances
     * @return la jauge des finances
     */
    public static Jauge getJaugeFinance() {
        return jaugeFinance;
    }
    /**
     * Modifie la jauge des finances
     * @param jaugeFinance La nouvelle jauge des finances
     */
    public void setJaugeFinance(Jauge jaugeFinance) {
        this.jaugeFinance = jaugeFinance;
    }
}
