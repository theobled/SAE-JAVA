package graphe.implems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import graphe.core.Arc;

public class GrapheLAdj extends Graphe{
    private Map<String , List<Arc>> ladj;
    
    public GrapheLAdj(){
        this.ladj=new HashMap<>();
    }    
    public GrapheLAdj(String graphe_str){
        this();
        this.peupler(graphe_str);
    }

    @Override
    public List<String> getSommets(){
        List<String> lst_sommet = new LinkedList<>(this.ladj.keySet());

        for (String sommet : this.ladj.keySet()) {
            
            for (String succ : this.getSucc(sommet)) {
                if(!lst_sommet.contains(succ)){
                    lst_sommet.add(succ);
                }
            }

        }
        return lst_sommet;
    }

    @Override
    public List<String> getSucc(String sommet) {
        ArrayList<String> result = new ArrayList<>();
        if(this.ladj.containsKey(sommet)){
            List<Arc> arcs=this.ladj.get(sommet);
            for (Arc arc : arcs) {
                result.add(arc.getDestination());
            }
        }

        return result;
    }

    @Override
    public int getValuation(String src, String dest) {
        if(this.ladj.get(src)==null){
            return -1;
        }
        ArrayList<Arc> arcs= new ArrayList<>(this.ladj.get(src));
        for (Arc arc : arcs) {
            if(arc.getDestination().equals(dest)){
                return arc.getValuation();
            }
        }
        return -1;
    }

    @Override
    public boolean contientSommet(String sommet) {
        return this.ladj.containsKey(sommet);
    }

    @Override
    public boolean contientArc(String src, String dest) {
        return this.getValuation(src, dest)>=0;
    }

    @Override
    public void ajouterSommet(String noeud) {
        if(this.getSommets().contains(noeud)){
            return;
        }
        this.ladj.put(noeud, new ArrayList<>());
    }

    @Override
    public void ajouterArc(String source, String destination, Integer valeur) {
        if(contientArc(source, destination) || valeur<0){
            throw new IllegalArgumentException("Arc deja présent ou valuation négative");
        }
        if (this.ladj.containsKey(source)){
            this.ladj.get(source).add(new Arc(source, destination, valeur));
        }
        else{
            ArrayList<Arc> lst_tmp= new ArrayList<>();
            lst_tmp.add(new Arc(source, destination, valeur));
            this.ladj.put(source, lst_tmp);

        }

    }

    @Override
    public void oterSommet(String noeud) {
        this.ladj.remove(noeud);

        for (String sommet : this.ladj.keySet()){
            for (Arc a : this.ladj.get(sommet)){
                if(a.contient(noeud)){
                    this.ladj.get(sommet).remove(a);
                }
            }
        }
    }


    @Override
    public void oterArc(String source, String destination) {
        if (this.ladj.containsKey(source)) {
            List<Arc> lst_tmp = this.ladj.get(source);
            Iterator<Arc> it = lst_tmp.iterator();
            while (it.hasNext()) {
                Arc arc = it.next();
                if (arc.getDestination().equals(destination)) {
                    it.remove();
                    return;
                }
            }
            throw new IllegalArgumentException("l'arc n'est pas présent");
        } 
        else {
            throw new IllegalArgumentException("la source n'est pas présent");
        }
    }

    
}
