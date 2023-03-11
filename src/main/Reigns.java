package main;

import java.util.ArrayList;
import java.util.Scanner;

import static main.LesJauges.finDuJeu;

/**
 * La classe Reigns représente le programme principal du jeu Reigns
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Reigns {
    /**
     * le personnage joué
     */
    private static Personnage personnage;



    /**
     * La méthode main lance le jeu Reigns. Il initialise les questions, le personnage,
     * affiche les jauges du personnage et lance une boucle de jeu qui se termine lorsque le personnage perd.
     * Il affiche également le nombre de tours de jeu que le personnage a joué.
     *
     * @param args les arguments de la ligne de commande
     */
    public static void main(String[] args){

        // début du jeu
        lancerJeu();

        // tirage des questions
        int nbTours = 0;
        while(!finDuJeu()){
            nbTours++;
            Question question = getQuestionAleatoire();
            reponseQuestion(question);
            LesJauges.AfficheJauges();
        }

        // fin du jeu
        System.out.println(
                personnage.getNom()
                        + " a perdu ! Son règne a duré "
                        +nbTours
                        + " tours");

    }

    public static void lancerJeu(){
        System.out.println("Bienvenue dans Reigns !");

        BanqueQuestions.initBanqueQuestions();

        System.out.println("Création du personnage...");

        initPersonnage();

        System.out.println(personnage.getGenre().longRegne()
                +" "+personnage.getNom());

        LesJauges.AfficheJauges();
    }



    /**
     * Cette fonction permet de gérer la réponse à une question donnée. Elle affiche la question, demande à
     * l'utilisateur d'entrer une réponse (soit "G" soit "D") et en fonction de la réponse, elle appelle la méthode
     * appropriée pour appliquer les conséquences sur les jauges du personnage.
     * @param question La question à laquelle il faut répondre
     */
    private static void reponseQuestion(Question question){
        question.afficheQuestion();
        Scanner scanner = new Scanner(System.in);
        String reponse;
        do {
            System.out.print("Entrez la réponse (G ou D): ");
            reponse = scanner.nextLine().toUpperCase();
        } while (!reponse.equals("G") && !reponse.equals("D"));
        if (reponse.equals("G")) {
            question.appliqueEffetsGauche(personnage);
        } else {
            question.appliqueEffetsDroite(personnage);
        }
    }

    /**
     * Cette fonction permet d'initialiser le personnage joué. Elle demande à l'utilisateur de saisir le nom du personnage
     * et le genre (Roi ou Reine). Elle crée ensuite le personnage.
     */

    private static void initPersonnage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom du personnage: ");
        System.out.flush();
        String nom = scanner.nextLine();
        System.out.println(
                "Faut-il vous appeler Roi ou Reine ? (1 pour Roi, 2 pour Reine)");
        Genre roiReine = scanner.nextInt() == 1 ? Genre.ROI : Genre.REINE;
        Reigns.personnage = new Personnage(nom, roiReine);
        }
    }


    /**
     * Cette fonction permet de tirer une question aléatoire dans la banque de questions.
     * @return Une question aléatoire
     */
    private static Question getQuestionAleatoire(){
        int numQuestion = (int) (Math.random()*questions.size());
        return questions.get(numQuestion);
    }
}