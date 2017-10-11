/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA;

import static java.lang.Math.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author W8
 */
public class Kromosom {
    private ArrayList<Node> krom = new ArrayList<>();
    
    private double jarak;

    private double fitness;
    
    private Boolean sudah=false;

    public static Comparator<Kromosom> fitComparator = new Comparator<Kromosom>(){
        public int compare(Kromosom k1, Kromosom k2){
            return Double.compare(k2.getFitness(), k1.getFitness());
        }
    };
    
    public Boolean getSudah() {
        return sudah;
    }

    public void setSudah(Boolean sudah) {
        this.sudah = sudah;
    }

    public void generateJF(Node data1){
        double temp=0;
        double aduh=0;
        ArrayList<Node> t1 = new ArrayList<>();
        t1.add(data1);
        for (int i=0; i<krom.size(); i++){
            if (aduh+krom.get(i).getDemand()>100){
                t1.add(data1);
                aduh =0;
            }
            aduh += krom.get(i).getDemand();
            t1.add(krom.get(i));
        }
        t1.add(data1);
        for(int i=0; i<t1.size()-1;i++){
            temp = temp + abs(sqrt((Math.pow((t1.get(i).getX()-t1.get(i+1).getX()),2)+(Math.pow((t1.get(i).getY()-t1.get(i+1).getY()),2)))));
        }
        this.jarak = temp;
        this.fitness = (1/(jarak+0.01));
    }
    
    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public double getJarak() {
        return jarak;
    }

    public void setJarak(double jarak) {
        this.jarak = jarak;
    }
    
    public void addGen(Node n){
        krom.add(n);
    }

    public void addGen(double x, double y, int d, int u){
        Node n = new Node(x,y,d,u);
        krom.add(n);
    }
    
    public ArrayList<Node> getKrom(){
        return krom;
    }
}
