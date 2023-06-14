package graphe.implems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GrapheHHAdj extends Graphe {
    private Map<String, Map<String, Integer>> hhadj;

    public GrapheHHAdj() {
        this.hhadj = new HashMap<>();
    }

    public GrapheHHAdj(String graphe_str) {
        this();
        this.peupler(graphe_str);
    }

    @Override
    public List<String> getSommets() {
        return new LinkedList<>(this.hhadj.keySet()); 
    }

    @Override
    public List<String> getSucc(String sommet) {
        
        return new ArrayList<>(this.hhadj.get(sommet).keySet());
    }

    @Override
    public int getValuation(String src, String dest) {
        if (this.hhadj.containsKey(src) && this.hhadj.get(src).containsKey(dest)) {
            return this.hhadj.get(src).get(dest);
        }
        return -1;
    }

    @Override
    public boolean contientSommet(String sommet) {
        return getSommets().contains(sommet);
    }

    @Override
    public boolean contientArc(String src, String dest) {
        return this.hhadj.containsKey(src) && this.hhadj.get(src).containsKey(dest);
    }

    @Override
    public void ajouterSommet(String noeud) {
        if (!this.contientSommet(noeud)) {
            this.hhadj.put(noeud, new HashMap<>());
        }
    }

    @Override
    public void ajouterArc(String source, String destination, Integer valeur) {
        if (contientArc(source, destination) || valeur < 0) {
            throw new IllegalArgumentException("Arc deja présent ou valeur négative");
        }
        if (!this.hhadj.containsKey(source)) {
            this.hhadj.put(source, new HashMap<>());
        }
        if (!this.hhadj.containsKey(destination)) {
            this.hhadj.put(destination, new HashMap<>());
        }
        Map<String, Integer> map_tmp = this.hhadj.get(source);
        map_tmp.put(destination, valeur);

        this.hhadj.put(source, map_tmp);
    }

    @Override
    public void oterSommet(String noeud) {
        this.hhadj.remove(noeud);

        for (String sommet : this.hhadj.keySet()){
            if(getSucc(sommet).contains(noeud)){
                this.hhadj.get(sommet).remove(noeud);
            }
        }
    }

    @Override
    public void oterArc(String source, String destination) {
        if (!this.contientArc(source, destination)) {
            throw new IllegalArgumentException("l'arc n'est pas présent");

        }
        this.hhadj.get(source).remove(destination);

    }


}
