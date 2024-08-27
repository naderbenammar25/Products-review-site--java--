package javaProjet;

import java.util.Scanner;

public class SiteDeLoisir {
	private String nomComplet;
	private String ville;
	private String pays;
	private String type;
	
	public String getNomComplet()
	{
		return this.nomComplet;
	}
	public String getVille()
	{
		return this.ville;
	}
	public String getpays()
	{
		return this.pays;
	}
	public String getType()
	{
		return this.type;
	}
	
	public void setNomComplet(String nomComplet)
	{
		this.nomComplet = nomComplet;
	}
	public void setVille(String ville)
	{
		this.ville = ville;
	}
	public void setPays(String pays)
	{
		this.pays = pays;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public SiteDeLoisir() {}
	public SiteDeLoisir(String nomComplet,String ville,String pays,String type)
	
	{
		this.nomComplet = nomComplet;
		this.ville = ville;
		this.pays = pays;
		this.type = type;
	}
	
	public SiteDeLoisir saisirSiteDeLoisir()
	{	
		Scanner s = new Scanner(System.in);
		SiteDeLoisir ss = new SiteDeLoisir();
		System.out.println("donner le nom du site:");
		ss.nomComplet = s.next();
		System.out.println("donner la ville du site:");
		ss.ville = s.next();
		System.out.println("donner le pays du site:");
		ss.pays = s.next();
		System.out.println("donner le type du site:");
		ss.type = s.next();
		
		return ss;
	}
	
}
