package it.polito.tdp.genes.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.genes.db.GenesDao;
//da guardare per valore assoluto e ragionamento per la query 
//ultimo punto richiede adiacenti
public class Model {
	GenesDao dao;
	Graph<Genes, DefaultWeightedEdge> grafo;
	Map<String, Genes> mappaGeni;
	public Model() {
		dao= new GenesDao();
		this.mappaGeni= new HashMap<>();
		dao.getAllGenesEssential(mappaGeni);
	}
	public void buildGraph() {
		grafo= new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		Graphs.addAllVertices(grafo, dao.getAllGenesEssential(mappaGeni));
		List<Interactions> archi= this.dao.getAllInteractions(mappaGeni);
		for(Interactions i: archi) {
			if(i.getGene1().getChromosome()!=i.getGene2().getChromosome()) {
				Graphs.addEdge(grafo,i.getGene1(), i.getGene2(),Math.abs(i.getExpression_core()));
			}else {
				Graphs.addEdge(grafo,i.getGene1(), i.getGene2(),Math.abs(i.getExpression_core()*2.0));
			}
		}
	}
	public Set<Genes> getVertici(){
		return grafo.vertexSet();
	}
	public int getNumVertici() {
		return this.grafo.vertexSet().size();
	}
	public int getNumArchi() {
		return this.grafo.edgeSet().size();
	}
	public List<Adiacenti> getAdiacenti(Genes gene){
		List<Adiacenti> result= new ArrayList<>();
		List<Genes> adiacenti=Graphs.neighborListOf(grafo ,gene);
		for(Genes g: adiacenti) {
			DefaultWeightedEdge arco=grafo.getEdge(gene, g);
			double peso= grafo.getEdgeWeight(arco);
			Adiacenti adiacente=new Adiacenti(g,peso);
			result.add(adiacente);
		}
		return result;
	}
}
