package javaProjet;
import java.util.Scanner;
public class Avis {
	private int objetAEvaluer;
	private int note;
	private String commentaire;
	private Utilisateur utilisateur;
	private String element;
	private String nomUtilisateur;
	
	
	 public Avis() {
	        // Initialisation par défaut si nécessaire
	    }

	    // Constructeur paramétré
	    public Avis(int objetAEvaluer, int note, String commentaire,Utilisateur utilisateur, String element,String nomUtilisateur) {
	        this.objetAEvaluer = objetAEvaluer;
	        this.note = note;
	        this.commentaire = commentaire;
	        this.utilisateur = utilisateur;
	        this.element = element;
	        this.nomUtilisateur = nomUtilisateur;
	    }

	    
	    public Utilisateur getUtilisateur() {
	        return utilisateur;
	    }

	    public void setUtilisateur(Utilisateur utilisateur) {
	        this.utilisateur = utilisateur;
	    }
	
	    
	    // Méthodes getters et setters
	    public int getObjetAEvaluer() {
	        return objetAEvaluer;
	    }

	    public void setObjetAEvaluer(int objetAEvaluer) {
	        this.objetAEvaluer = objetAEvaluer;
	    }

	    public int getNote() {
	        return note;
	    }

	    public void setNote(int note) {
	        this.note = note;
	    }

	    public String getCommentaire() {
	        return commentaire;
	    }

	    public void setCommentaire(String commentaire) {
	        this.commentaire = commentaire;
	    }
	    public String getElement() {
	        return element;
	    }
	    public void setElement(String element) {
	        this.element = element;
	    }
	    
	    public String getNomUtilisateur() {
	        return nomUtilisateur;
	    }

	    public void setNomUtilisateur(String nomUtilisateur) {
	        this.nomUtilisateur = nomUtilisateur;
	    }
	    
	   
	    
	    public Avis saisirAvis() {
	        Scanner s = new Scanner(System.in);

	        System.out.println("Saisir un nouvel avis :");
	        Avis a = new Avis();
	        System.out.println("Indiquer l'objet à évaluer : 1-produit 2-Site de loisir ");
	         a.objetAEvaluer = s.nextInt();
	         Produit p = new Produit();
	         SiteDeLoisir si = new SiteDeLoisir ();
	         System.out.println("donner votre nom ou pseudonyme");
	         a.nomUtilisateur = s.next();
	         System.out.println("donner le nom du produit/Site");
	         a.element = s.next();
	         if (a.objetAEvaluer == 1)
	         {
	        	 
	        	 p.saisirProduit();
	        	 
	        	 
	         }
	         
	         if (a.objetAEvaluer == 2)
	         {
	        	 
	        	 si.saisirSiteDeLoisir();
	        	 
	         }
	        System.out.println("Note (entre 0 et 5 étoiles) : ");
	        do
	        {
	        a.note = s.nextInt();
	        }while((a.note>5)||(a.note<0));

	        System.out.println("Commentaire : ");
	        a.commentaire = s.next();
	        // retourner un nouvel objet Avis avec les informations saisies
	        return a;
	    }
	    
	    public void afficherAvis(Avis a)
	    {	System.out.println("----------------------------------------------------------");
	    	System.out.println("nom d'objet: " + a.element);
	    	System.out.println("Utilisateur : " + a.nomUtilisateur);
	    	System.out.println("note: " + a.note);
	    	System.out.println("commentaire: " + a.commentaire);
		   	System.out.println("----------------------------------------------------------");

	    }
	    
	    
}
