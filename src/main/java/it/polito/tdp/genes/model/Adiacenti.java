package it.polito.tdp.genes.model;

public class Adiacenti implements Comparable<Adiacenti>{
	public Genes gene;
	public Double peso;
	public Adiacenti(Genes gene, Double peso) {
		super();
		this.gene = gene;
		this.peso = peso;
	}
	public Genes getGene() {
		return gene;
	}
	public void setGene(Genes gene) {
		this.gene = gene;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	@Override
	public int compareTo(Adiacenti o) {
		return -(this.peso.compareTo(o.getPeso()));
	}
	
}
