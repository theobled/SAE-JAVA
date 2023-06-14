package graphe.implems;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import graphe.core.Arc;

public class GrapheLArcs extends Graphe {
    private List<Arc> arcs;
    
    public GrapheLArcs(){
        this.arcs=new ArrayList<>();
    }
    public GrapheLArcs(String graphe_str){
        this();
        this.peupler(graphe_str);
    }

    @Override
    public List<String> getSommets() {
        List<String> result=new LinkedList<>();
        for (Arc arc : this.arcs){ 
            if(arc.getDestination().equals(""))
            {
                result.add(arc.getSource());
                continue;
            }

            if(!result.contains(arc.getSource()))
            {
                result.add(arc.getSource());
            }
            if(!result.contains(arc.getDestination() ))
            {
                result.add(arc.getDestination());
            }
        }
        Collections.sort(result);
        return result;
    }

    @Override
    public List<String> getSucc(String sommet) {
        ArrayList<String> result=new ArrayList<>();
        for (Arc arc : this.arcs) {
            if(arc.getSource().equals(sommet)==true && !arc.getDestination().equals(""))
                result.add(arc.getDestination());
        }
        return result;
    }

    @Override
    public int getValuation(String src, String dest) {
        Arc a_tmp=new Arc(src, dest, 0);
        for (Arc arc : this.arcs) {
            if(arc.is_equal(a_tmp)){
                return arc.getValuation(); 
            }
        }
        return -1; 
    }

    @Override
    public boolean contientSommet(String sommet) {
        return this.getSommets().contains(sommet);
    }

    @Override
    public boolean contientArc(String src, String dest) {
        return this.getValuation(src, dest)>=0;
    }

    @Override
    public void ajouterSommet(String noeud) {
        if(contientSommet(noeud)) return;
        this.arcs.add(new Arc(noeud, "", 0));      
    }

    @Override
    public void ajouterArc(String source, String destination, Integer valeur) {
        if (contientArc(source, destination) || valeur<0){
            throw new IllegalArgumentException("Arc deja présent ou valeur négative");
        }
        for (Arc arc : this.arcs){ 
            if(arc.getDestination().equals("") && arc.getSource().equals(source)){
                this.arcs.remove(arc);
                break;
            }
        }
        this.arcs.add(new Arc(source, destination, valeur));

    }

    @Override
    public void oterSommet(String noeud) {
        if(!this.contientSommet(noeud)){
            return;
        }
        Iterator<Arc> iter = this.arcs.iterator();
        while (iter.hasNext()) {
            Arc arc = iter.next();
            if (arc.getSource().equals(noeud)) {
                this.ajouterSommet(arc.getDestination());
                iter.remove();
            }
            else if(arc.getDestination().equals(noeud)){
                this.ajouterSommet(arc.getSource());
                iter.remove();

            }
        }
    }

    @Override
    public void oterArc(String source, String destination) {
        if (!contientArc(source, destination)){
            throw new IllegalArgumentException("L'arc n'est pas présent dans le graphe");
        }
        Arc a_tmp=new Arc(source, destination, 0);

        for (Arc arc : this.arcs) {
            if(arc.is_equal(a_tmp)){
                this.arcs.remove(arc);
                this.arcs.add(new Arc(source, "", 0));
                break;
            }
        }
    }


}
