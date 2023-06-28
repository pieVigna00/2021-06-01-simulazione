package it.polito.tdp.genes.model;

public class Interactions {
	private Genes gene1;
	private Genes gene2;
	private String type;
	private double expression_core;
	public Interactions(Genes gene1, Genes gene2, String type, double expression_core) {
		super();
		this.gene1 = gene1;
		this.gene2 = gene2;
		this.type = type;
		this.expression_core = expression_core;
	}
	public Genes getGene1() {
		return gene1;
	}
	public void setGene1(Genes gene1) {
		this.gene1 = gene1;
	}
	public Genes getGene2() {
		return gene2;
	}
	public void setGene2(Genes gene2) {
		this.gene2 = gene2;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getExpression_core() {
		return expression_core;
	}
	public void setExpression_core(double expression_core) {
		this.expression_core = expression_core;
	}
	

}
