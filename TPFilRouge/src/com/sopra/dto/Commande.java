package com.sopra.dto;

public class Commande {

	private Client client;
    private String date;
    private Double montant;
    private String modePaiement;
    private String statutPaiement;
    private String modeLivraison;
    private String statutLivraison;
	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}
	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the montant
	 */
	public Double getMontant() {
		return montant;
	}
	/**
	 * @param montant the montant to set
	 */
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	/**
	 * @return the modePaiement
	 */
	public String getModePaiement() {
		return modePaiement;
	}
	/**
	 * @param modePaiement the modePaiement to set
	 */
	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}
	/**
	 * @return the statutPaiement
	 */
	public String getStatutPaiement() {
		return statutPaiement;
	}
	/**
	 * @param statutPaiement the statutPaiement to set
	 */
	public void setStatutPaiement(String statutPaiement) {
		this.statutPaiement = statutPaiement;
	}
	/**
	 * @return the modeLivraison
	 */
	public String getModeLivraison() {
		return modeLivraison;
	}
	/**
	 * @param modeLivraison the modeLivraison to set
	 */
	public void setModeLivraison(String modeLivraison) {
		this.modeLivraison = modeLivraison;
	}
	/**
	 * @return the statutLivraison
	 */
	public String getStatutLivraison() {
		return statutLivraison;
	}
	/**
	 * @param statutLivraison the statutLivraison to set
	 */
	public void setStatutLivraison(String statutLivraison) {
		this.statutLivraison = statutLivraison;
	}
    
    
}
