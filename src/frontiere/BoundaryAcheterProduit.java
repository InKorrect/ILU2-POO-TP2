package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		String produit,marchandProduit,resultat;
		int numeroMarchand, nbProduit;
		boolean possedeProduit;
		System.out.println("Quel produit voulez vous acheter ?");
		produit = scan.next();
		marchandProduit = controlAcheterProduit.AfficherEtalProduit(produit);
		possedeProduit = marchandProduit.length() == 0;
		if (possedeProduit) {
			System.out.println("Desole mais personne ne vend ce produit au marche.");
		} else {
			String nomVendeur;
			numeroMarchand = Clavier
					.entrerEntier("Chez quel commercant voulez vous acheter des " + produit + " ?\n" + marchandProduit);
			nomVendeur = controlAcheterProduit.nomVendeur(produit, numeroMarchand);
			System.out.println(nomAcheteur + " se deplace jusqu a l etal du vendeur " + nomVendeur);
			nbProduit = Clavier.entrerEntier("Bonjour " + nomAcheteur + "\nCombien de " + produit + " voulez vous ?\n");
			resultat = controlAcheterProduit.AcheterProduit(produit, numeroMarchand,nbProduit,nomAcheteur);
			System.out.println(resultat);
		}

	}
}