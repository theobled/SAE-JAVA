package graphe.implems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GrapheMAdj extends Graphe {
    private int matrice[][];
    private Map<String, Integer> indices;

    public GrapheMAdj() {
        this.matrice = new int[0][0];
        set_matrice(this.matrice);
        this.indices = new HashMap<>();

    }

    public GrapheMAdj(String graphe_str) {
        this();
        this.peupler(graphe_str);
    }

    @Override
    public List<String> getSommets() {
        return new LinkedList<>(this.indices.keySet());
    }

    @Override
    public List<String> getSucc(String sommet) {
        ArrayList<String> result = new ArrayList<>();
        if (!this.indices.containsKey(sommet)) {
            return result;
        }
        int i = indices.get(sommet);
        int j;

        for (String str : this.indices.keySet()) {
            j = this.indices.get(str);
            if (this.matrice[i][j] != -1) {
                result.add(str);
            }
        }
        return result;
    }

    @Override
    public int getValuation(String src, String dest) {
        if (this.indices.containsKey(src) && this.indices.containsKey(dest)) {
            return this.matrice[indices.get(src)][indices.get(dest)];
        }
        return -1;
    }

    @Override
    public boolean contientSommet(String sommet) {
        return this.indices.containsKey(sommet);
    }

    @Override
    public boolean contientArc(String src, String dest) {
        return this.getValuation(src, dest) >= 0;
    }

    @Override
    public void ajouterSommet(String noeud) {
        // TODO Auto-generated method stub
        if (this.contientSommet(noeud)) {
            return;
        }
        this.matrice = extend_matrice(this.matrice);
        this.indices.put(noeud, this.matrice.length - 1);
    }

    @Override
    public void ajouterArc(String source, String destination, Integer valeur) {
        if (this.contientArc(source, destination) || valeur < 0) {
            throw new IllegalArgumentException("Arc deja present ou valuation négative");
        }

        if (!this.indices.containsKey(source)) {
            this.matrice = extend_matrice(this.matrice);
            this.indices.put(source, this.matrice.length - 1);
        }
        if (!this.indices.containsKey(destination)) {
            this.matrice = extend_matrice(this.matrice);
            this.indices.put(destination, this.matrice.length - 1);
        }
        int i = this.indices.get(source);
        int j = this.indices.get(destination);
        this.matrice[i][j] = valeur;
    }

    @Override
    public void oterSommet(String noeud) {
        this.indices.remove(noeud);
    }

    @Override
    public void oterArc(String source, String destination) {
        if (!this.contientArc(source, destination)) {
            throw new IllegalArgumentException();
        }
        int i = this.indices.get(source);
        int j = this.indices.get(destination);
        this.matrice[i][j] = -1;

    }

    private void set_matrice(int matrice[][]) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                matrice[i][j] = -1;
            }
        }
    }

    private int[][] extend_matrice(int matrice[][]) {

        int matrice_tmp[][] = matrice.clone();
        matrice = new int[matrice.length + 1][matrice.length + 1];
        set_matrice(matrice);
        for (int i = 0; i < matrice_tmp.length; i++) {
            for (int j = 0; j < matrice_tmp[i].length; j++) {
                matrice[i][j] = matrice_tmp[i][j];
            }
        }
        return matrice;
    }

}
