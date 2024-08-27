package javaProjet;
import java.util.ArrayList;
import java.util.Scanner;
public class Produit {
	private String categorie, nomComplet, marque;
	
	public String getCategorie () {
		return this.categorie;
	}
	
	public String getNomComplet() {
		return this.nomComplet;
	}
	
	public String getMarque () {
		return this.marque;
	}
	
	
	
	public void setCategorie (String categorie) {
		this.categorie = categorie;
	}
	
	public void setNomComplet (String nomComplet) {
		this.nomComplet = nomComplet;
	}
	
	public void setMarque (String marque) {
		this.marque = marque;
	}
	
	public Produit () {}
	
	public Produit (String categorie, String nomComplet, String marque) {
		this.nomComplet = nomComplet;
		this.categorie = categorie;
		this.marque = marque;
	}
	public Produit saisirProduit()
	{	
		Scanner s = new Scanner(System.in);
		Produit p = new Produit();
		System.out.println("donner la categorie du Produit:");
		p.categorie = s.next();
		System.out.println("donner le nom du Produit:");
		p.nomComplet = s.next();
		System.out.println("donner la marque du Produit:");
		p.marque = s.next();
		
		return p;
	}
}
