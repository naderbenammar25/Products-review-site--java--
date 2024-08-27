package javaProjet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Scanner;
public class Site {
	
	private String nom;
	private ArrayList <Produit> produits;
	private ArrayList<SiteDeLoisir>siteDeLoisirs;
	private ArrayList<Avis>aviss;
	

	
	 // Constructeur non paramétré
    public Site() {
        this.produits = new ArrayList<>();
        this.siteDeLoisirs = new ArrayList<>();
        this.aviss = new ArrayList<>();
        
    }

    // Constructeur paramétré
    public Site(String nom) {
    	this.produits = new ArrayList<>();
        this.siteDeLoisirs = new ArrayList<>();
        this.aviss = new ArrayList<>();
        this.nom = nom;
        
        
    }
    
    
    public ArrayList<Produit> getProduits() {
        return produits;
    }
    
    public ArrayList<SiteDeLoisir> getSiteDeLoisirs() {
        return siteDeLoisirs;
    }
    
    
    public ArrayList<Avis> getAviss()
    {
    	return this.aviss;
    }
    public void publierAvis(Avis a)
    
    {
    	aviss.add(a);
    }
    public void ajouterProduit(Produit p)
    {
    	produits.add(p);
    }
    public void ajouterSiteDeLoisir(SiteDeLoisir s)
    {
    	siteDeLoisirs.add(s);
    }
    
    public void afficherNomProduit()
    {int i = 0;
    	for (Produit a : produits)
    	{	
    		System.out.println("Produit"+(i)+" : "+ a.getNomComplet());
    		i++;
    	}
    }
    public void afficherNomSite()
    {int i = 0;
    	for (SiteDeLoisir a : siteDeLoisirs)
    	{	
    		System.out.println("Site"+(i)+" : "+ a.getNomComplet());
    		i++;
    	}
    }
    
    
    public void numAvis(int i)
    {
    	String nom = (produits.get(i).getNomComplet());
    	for (Avis a : aviss)
    	{	
    		if(nom.equals(a.getElement()))
    		{
    			a.afficherAvis(a);
    		}
    	}
    }
    
    public void numAvis2(int i)
    {
    	String nom = (siteDeLoisirs.get(i).getNomComplet());
    	for (Avis a : aviss)
    	{	
    		if(nom.equals(a.getElement()))
    		{
    			a.afficherAvis(a);
    		}
    	}
    }
    
    public void consulterAvis()
    {
    	System.out.println("veuillez choisir la catégorie d'objets à afficher");
    	System.out.println("1-Produits\n2-Site de loisir");
    	Scanner s = new Scanner(System.in);
    	int choix;
    	do {
    	choix = s.nextInt();
    	}while((choix>2)||(choix)<1);
    	if (choix ==1)
    	{
    		for (Avis a : aviss)
    	{
    		if(a.getObjetAEvaluer()== 1)
    		{
    		System.out.println("----------------------------------------------------");
    		for (Produit x : produits)
        	{	int i = 0;
        		System.out.println("Produits"+(i+1)+" :"+ x.getNomComplet());
        	}
    		System.out.println("utilisateur: "+a.getNomUtilisateur());
    		System.out.println("produit: "+a.getElement());
    		System.out.println("note: "+a.getNote());
    		System.out.println("commentaire: "+a.getCommentaire());
    		System.out.println("----------------------------------------------------");
    		
    		}
    	}
    	}
    	
    	if (choix ==2)
    	{
    		for (Avis a : aviss)
    	{
    		if(a.getObjetAEvaluer() == 2)
    		{
    		System.out.println("----------------------------------------------------");
    		for (SiteDeLoisir m : siteDeLoisirs)
        	{	int i =0;
        		System.out.println("Site"+(i+1)+" : "+ m.getNomComplet());
        	}
    		System.out.println("utilisateur: "+a.getNomUtilisateur());
    		System.out.println("Site: "+a.getElement());
    		System.out.println("note: "+a.getNote());
    		System.out.println("commentaire: "+a.getCommentaire());
    		System.out.println("----------------------------------------------------");
    		}
    	}
    	}
    }
    
    public ArrayList<Avis> rechercherAvisSurObjet(String objetAEvaluer) {
        ArrayList<Avis> avisSurObjet = new ArrayList<>();

        for (Avis avis : this.aviss) {
           // if (avis.getObjetAEvaluer().equalsIgnoreCase(objetAEvaluer)) 
        	{
                avisSurObjet.add(avis);
            }
        }
        return avisSurObjet;
    }
    
    public void supprimerAvis1(Avis avisASupprimer) {
        if (this.aviss.contains(avisASupprimer)) {
            this.aviss.remove(avisASupprimer);
            System.out.println("Avis supprimé avec succès.");
        } else {
            System.out.println("Avis non trouvé. Suppression impossible!");
        }
    }
    
    
    
    public void supprimerAvisParUtilisateur() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir le nom de l'utilisateur pour supprimer ses avis : ");
        String nomUtilisateur = scanner.next();

        // Utilisation d'un itérateur pour éviter ConcurrentModificationException
        Iterator<Avis> iterator = aviss.iterator();
        while (iterator.hasNext()) {
            Avis avis = iterator.next();
            if (avis.getNomUtilisateur().equals(nomUtilisateur)) {
                iterator.remove();
                System.out.println("Avis de l'utilisateur supprimé avec succès.");
            }
        }
    }
    
    
    public void afficherStatistiques() {
        System.out.println("Statistiques du site :");
        System.out.println("-----------------------");

        // Afficher le nombre total d'avis postés
        System.out.println("Nombre total d'avis postés : " + this.aviss.size());

        // Afficher le nombre total d'avis postés par catégorie d'objets
        int compt =0;
        int compt2 =0;
        for(Avis a : aviss)
        {
        	if(a.getObjetAEvaluer()==1)
        	{
        		compt++;
        	}
        	if(a.getObjetAEvaluer()==2)
        	{
        		compt2++;
        	}
        }
        System.out.println("nombre d'avis sur les produits: " + compt);
        System.out.println("nombre d'avis sur les sites de loisirs: "+ compt2);
        
        // Afficher le nombre et la liste des utilisateurs différents utilisant le site
        int utCount = afficherUtilisateurs();
        System.out.println("nombre totale d'utilisateurs : "+utCount);
        

        System.out.println("-----------------------");
    }

    

    private int afficherUtilisateurs() {
        ArrayList<String> ut = new ArrayList();
    	int i=0;
    	for(Avis a : aviss)
        {
        	if(!ut.contains(a.getNomUtilisateur())) {
        		ut.add(a.getNomUtilisateur());
        	}
        }
    	for(String x : ut)
    	{
    		System.out.println("utilisateur n°"+i +": "+ x);
    	}
    	i++;
    	return ut.size();
    }
    
    
    public Avis trouverAvis(String nom)
    {	Avis n = new Avis();
    	for (Avis q : aviss)
    	{
    		if (nom == q.getNomUtilisateur());
    		n = q;
    		
    	}
    	return n;
    }
    

    
    
    
    
    
    
    
    
    
    }


