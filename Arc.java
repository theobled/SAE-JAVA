package graphe.core;

public class Arc implements Comparable<Arc>{
    private String n_source;
    private String n_dest;
    private int valuation;

    
    public Arc(String noeud_source,String noeud_dest,int value){
        this.n_source=noeud_source;
        this.n_dest=noeud_dest;
        this.valuation=value;
    }
    public String getSource(){
        return this.n_source;
    }
    public String getDestination(){
        return this.n_dest;
    }
    public int getValuation(){
        return this.valuation;
    }
    public void set_valuation(int new_value){
        this.valuation=new_value;
    }
    public String toString(){
        return this.n_source+"-"+n_dest+"("+this.valuation+")";
    }
    public Boolean is_equal(Arc a){
        return this.n_source.equals(a.n_source) && this.n_dest.equals(a.n_dest);
    }
    public boolean contient(String sommet){
        return sommet.equals(this.n_dest) || sommet.equals(this.n_source);
    }
    @Override
    public int compareTo(Arc a) {
        return this.toString().compareTo(a.toString());
    }
    
 }
