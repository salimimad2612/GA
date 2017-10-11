/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author W8
 */
public class Driver {
    /**

     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Kromosom data = new Kromosom();
        data.addGen(82,76,0,1);
        data.addGen(96,44,19,2);
        data.addGen(50,5,21,3);
        data.addGen(49,8,6,4);
        data.addGen(13,7,19,5);
        data.addGen(29,89,7,6);
        data.addGen(58,30,12,7);
        data.addGen(84,39,16,8);
        data.addGen(14,24,6,9);
        data.addGen(2,39,16,10);
        data.addGen(3,82,8,11);
        data.addGen(5,10,14,12);
        data.addGen(98,52,21,13);
        data.addGen(84,25,6,14);
        data.addGen(61,59,3,15);
        data.addGen(1,65,22,16);
        data.addGen(88,51,18,17);
        data.addGen(91,2,19,18);
        data.addGen(19,32,1,19);
        data.addGen(93,3,24,20);
        data.addGen(50,93,8,21);
        data.addGen(98,14,12,22);
        data.addGen(5,42,4,23);
        data.addGen(42,9,8,24);
        data.addGen(61,62,24,25);
        data.addGen(9,97,24,25);
        data.addGen(80,55,2,27);
        data.addGen(57,69,20,28);
        data.addGen(23,15,15,29);
        data.addGen(20,70,2,30);
        data.addGen(85,60,14,31);
        data.addGen(98,5,9,32);
        
        data.getKrom().get(0).setSudah(true);
        double fitnessrata=0;
       Scanner in  =  new Scanner(System.in);
        System.out.println("Masukkan jumlah populasi = ");
        int h1 = in.nextInt();
        System.out.println("Masukkan jumlah generasi = ");
        int t = in.nextInt();
        ArrayList<Kromosom> Populasi = new ArrayList<>();
       
        for(int a=0; a<h1; a++){
            Random rand = new Random();
            Boolean done = false;
            Boolean end;
            int count=0;
            int angka_random;
            int i=0;
            Kromosom temp = new Kromosom();
            while (!done){
                angka_random=(rand.nextInt(31))+1;
                if(data.getKrom().get(angka_random).getSudah()==false){
                        temp.getKrom().add(data.getKrom().get(angka_random));
                        data.getKrom().get(angka_random).setSudah(true);
                        

                } else{
                    i=0;
                    end=false;
                    while(i<data.getKrom().size() && !end){
                        if(data.getKrom().get(i).getSudah()==false){
                            done=false;
                            end = true;
                        } else {
                            done=true;
                        }
                        i++;
                        }
                }

            }
            temp.generateJF(data.getKrom().get(0));
            Populasi.add(temp);
            for(int b=1; b<=31; b++){ //ubah disini
                data.getKrom().get(b).setSudah(false);
            }
        }
        
        int berhasil=0;
        while(berhasil<t){
            ArrayList<Kromosom> P1 = new ArrayList<>();
        
            Random rd = new Random();
            int acak;

            for (int c=0; c<Populasi.size(); c++){
                acak = rd.nextInt(Populasi.size());
                P1.add(Populasi.get(acak));
            }


            //Crossover
            double bil_acak;
            int bil_acak1;
            double PC = 0.75;
            ArrayList<Kromosom> Child = new ArrayList<>();
            //System.out.println((int)(P1.size()/2));
            //hati2 disini
            int loop=0;
            
            while(loop <(P1.size()-1)){

                Boolean cek_sama=false;
                Kromosom temp = new Kromosom();
                Kromosom temp1 = new Kromosom();
                Kromosom temp2 = new Kromosom();
                bil_acak = rd.nextDouble();
//                System.out.println(bil_acak1);
//                System.out.println(bil_acak);
                if (PC>=bil_acak){

                    //Pembentukan anak 1
                     bil_acak1 = rd.nextInt(P1.get(0).getKrom().size());
                    for(int q=0; q < bil_acak1 ; q++){
                        temp2.addGen(P1.get(loop+1).getKrom().get(q));
                    }
                    for(int p=0; p <P1.get(loop).getKrom().size(); p++){
                        for(int q=0; q < bil_acak1 ; q++){
                            if(temp2.getKrom().get(q)==P1.get(loop).getKrom().get(p)){
                                cek_sama=true;
                            }
                        }
                        if (!cek_sama){
                            temp1.addGen(P1.get(loop).getKrom().get(p));
                        }
                            cek_sama=false;
                    }
                    for(int q=0; q < bil_acak1 ; q++){
                        temp1.addGen(temp2.getKrom().get(q));
                    }
                    temp1.generateJF(data.getKrom().get(0));
                    Child.add(temp1);

                    //Pembentukan anak 2
                    for(int q=0; q < bil_acak1 ; q++){
                        temp.addGen(P1.get(loop).getKrom().get(q));
                    }
                    for(int p=0; p <P1.get(loop).getKrom().size(); p++){
                        int h=0;
                        while(h<bil_acak1 && !cek_sama){
                            if(temp.getKrom().get(h)==P1.get(loop+1).getKrom().get(p)){
                                cek_sama=true;
                                //System.out.print("hai, ");
                            }
                            h++;
                        }
                        if (!cek_sama){
                            temp.addGen(P1.get(loop+1).getKrom().get(p));
                            //cek_sama=false;
                            //System.out.print("huuuu, ");
                        }
                        cek_sama=false;
                    }
                    temp.generateJF(data.getKrom().get(0));
                    Child.add(temp);


                } else {
                    Child.add(P1.get(loop));
                    Child.add(P1.get(loop+1));
                }

                loop = loop+2;
            }
            if (P1.size() % 2 == 1){
                Child.add(P1.get(P1.size()-1));
            }




            //Mutasi
//            System.out.println("-------------------------");
            double PM = 0.1;
            for (int i=0; i<Child.size(); i++){
                double bil_acak_mut = rd.nextDouble();
                //System.out.println(bil_acak_mut);
                if(bil_acak_mut<PM){
                    Node tampung = new Node();
                    int acak1=rd.nextInt(Child.get(0).getKrom().size());
                    int acak2=rd.nextInt(Child.get(0).getKrom().size());
                    tampung = Child.get(i).getKrom().get(acak1);
                    Child.get(i).getKrom().set(acak1, Child.get(i).getKrom().get(acak2));
                    Child.get(i).getKrom().set(acak2, tampung);
                    Child.get(i).generateJF(data.getKrom().get(0));
                }
            }


            //Penggabungan dasn sorting Ortu dan anak
            ArrayList<Kromosom> Tampung_Populasi = new ArrayList<>();
            ArrayList<Kromosom> Populasi_Baru = new ArrayList<>();
            for(int i=0; i<Populasi.size(); i++){
                Tampung_Populasi.add(Populasi.get(i));
                P1.get(i).generateJF(data.getKrom().get(0));
            }
            for(int i=0; i<Child.size(); i++){
                Tampung_Populasi.add(Child.get(i));
                Child.get(i).generateJF(data.getKrom().get(0));
            }

            Collections.sort(Tampung_Populasi, Kromosom.fitComparator);
            
            for(int i=0; i<Child.size(); i++){
                Populasi_Baru.add(Tampung_Populasi.get(i));
            }
           
            

            Populasi = Populasi_Baru;
            berhasil++;
            System.out.println("Iterasi ke - "+berhasil);
            System.out.println("Jarak = "+Populasi.get(0).getJarak());
            System.out.println("Fitness = "+Populasi.get(0).getFitness());
            System.out.print("Rute = ");
            
            ArrayList<Node> k1 = new ArrayList<>();
            ArrayList<Node> k2 = new ArrayList<>();
            k1 = Populasi.get(0).getKrom();
            fitnessrata = fitnessrata + Populasi.get(0).getFitness();
            Node data1 = new Node(82,76,0,1);
            k2.add(data1);
            int aduh =0;
            for (int i=0; i<k1.size(); i++){
                if (aduh+k1.get(i).getDemand()>100){
                    k2.add(data1);
                    aduh =0;
                }
                aduh += k1.get(i).getDemand();
                k2.add(k1.get(i));
            }
            k2.add(data1);
                for (int k=0;k<k2.size(); k++){
                        System.out.print(k2.get(k).getNode_ke()+", ");
                    }
                System.out.println("-------------------\n");

            }
        
        System.out.println("Solusi : ");
        double pembagi = (double) t;
       
            ArrayList<Node> k1 = new ArrayList<>();
            ArrayList<Node> k2 = new ArrayList<>();
        k1 = Populasi.get(0).getKrom();
            Node data1 = new Node(82,76,0,1);
            k2.add(data1);
            int aduh =0;
            for (int i=0; i<k1.size(); i++){
                if (aduh+k1.get(i).getDemand()>100){
                    k2.add(data1);
                    aduh =0;
                }
                aduh += k1.get(i).getDemand();
                k2.add(k1.get(i));
            }
            k2.add(data1);
                for (int k=0;k<k2.size(); k++){
                        System.out.print(k2.get(k).getNode_ke()+", ");
                    }
                 System.out.println("fitness rata-rata = "+fitnessrata/t);
                System.out.println("\n-------------------");
    }
    
}
