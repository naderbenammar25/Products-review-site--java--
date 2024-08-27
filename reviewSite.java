package javaProjet;
import java.util.Scanner;

public class reviewSite {

    public static void main(String[] args) {
        Produit p1 = new Produit("vetements", "pull", "teletext");
        Produit p2 = new Produit("informatique", "legion", "lenovo");
        Produit p3 = new Produit("alimentation", "burger", "kfc");

        SiteDeLoisir s1 = new SiteDeLoisir("obladi", "lac", "tunisie", "cafe");
        SiteDeLoisir s2 = new SiteDeLoisir("pathe", "geant", "tunisie", "cinema");
        SiteDeLoisir s3 = new SiteDeLoisir("x", "gammarth", "tunisie", "club");

        Site monSite = new Site();
        monSite.ajouterProduit(p1);
        monSite.ajouterProduit(p2);
        monSite.ajouterProduit(p3);
        monSite.ajouterSiteDeLoisir(s1);
        monSite.ajouterSiteDeLoisir(s2);
        monSite.ajouterSiteDeLoisir(s3);

        Scanner s = new Scanner(System.in);
        int choix;
        int choix2;
        int mdp;

        System.out.println("Bienvenue!");

        do {
            System.out.println("Etes-vous un : 1-Administrateur 2-Visiteur");
            choix = s.nextInt();

            if (choix == 2) {
                do {
                    System.out.println("1. Publier un avis");
                    System.out.println("2. Consulter tous les avis");
                    System.out.println("3. Consulter les avis sur un objet");
                    System.out.println("0. Quitter");
                    System.out.print("Choisissez une option : ");

                    choix2 = s.nextInt();

                    switch (choix2) {
                        case 1:
                            Avis a = new Avis();
                            a = a.saisirAvis();
                            monSite.publierAvis(a);
                            break;

                        case 2:
                        	System.out.println("Produits:\n");
                            monSite.afficherNomProduit();
                            System.out.println("Sites de loisirs:\n");
                            monSite.afficherNomSite();
                            monSite.consulterAvis();
                            break;

                        case 3:
                        	int num = 0;
                        	Scanner scan = new Scanner(System.in);
                            
                            	int choix5;
                            	do {
                            	System.out.println("s'agit-t-il d'un: 1-produit | 2-site de loisirs");
                            	choix5 = scan.nextInt();}while((choix5<1)||(choix5>2));
                            	if(choix5 == 1)
                            	{
                            	monSite.afficherNomProduit();
                            	do {
                            	System.out.println("choisir le numero du produit pour voir les avis associés ");
                            	num = scan.nextInt();}while(num > monSite.getProduits().size());
                            	monSite.numAvis(num); }
                            	if(choix5==2)
                            	{
                            		monSite.afficherNomSite();
                            		do {
                                    	System.out.println("choisir le numero du site pour voir les avis associés ");
                                    	num = scan.nextInt();
                            		}while(num > monSite.getProduits().size());
                            		monSite.numAvis2(num);		
                            	}
                            break;

                        case 0:
                            System.out.println("Retour au menu principal.");
                            break;

                        default:
                            System.out.println("Option invalide. Veuillez choisir une option valide.");
                    }

                } while (choix2 != 0);

            } else if (choix == 1) {
                // Vérifier le mot de passe de l'administrateur
                do {
                    System.out.println("Veuillez saisir votre mot de passe :");
                    mdp = s.nextInt();
                } while (mdp != 1234);

                do {
                    System.out.println("1. Consulter tous les avis");
                    System.out.println("2. Supprimer un avis");
                    System.out.println("3. afficher les statistiques");
                    System.out.println("0. Quitter");
                    System.out.print("Choisissez une option : ");

                    choix2 = s.nextInt();

                    switch (choix2) {
                        case 1:
                            
                            
                            System.out.println("Produits:\n");
                            monSite.afficherNomProduit();
                            System.out.println("Sites de loisirs:\n");
                            monSite.afficherNomSite();
                            monSite.consulterAvis();
                            break;

                        case 2:
                            monSite.supprimerAvisParUtilisateur();
                            break;

                        case 3:
                            monSite.afficherStatistiques();
                            break;

                        case 0:
                            System.out.println("Retour au menu principal.");
                            break;

                        default:
                            System.out.println("Option invalide. Veuillez choisir une option valide.");
                    }

                } while (choix2 != 0);
            }
        } while (choix != 0); // Sortir de la boucle principale si choix == 0
    }
}
