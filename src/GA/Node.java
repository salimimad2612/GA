/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA;

/**
 *
 * @author W8
 */
public class Node {
    
    private double X;

    private double Y;

    private int demand;

    private Boolean sudah=false;

    private int node_ke;

    public Node(){
        
    }
    public int getNode_ke() {
        return node_ke;
    }

    public void setNode_ke(int node_ke) {
        this.node_ke = node_ke;
    }

    public Boolean getSudah() {
        return sudah;
    }

    public void setSudah(Boolean sudah) {
        this.sudah = sudah;
    }

    public Node(double X, double Y, int demand, int urut) {
        this.X = X;
        this.Y = Y;
        this.demand = demand;
        this.node_ke = urut;
    }

    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public double getY() {
        return Y;
    }

    public void setY(double Y) {
        this.Y = Y;
    }

    public double getX() {
        return X;
    }

    public void setX(double X) {
        this.X = X;
    }

}
