
import java.io.*;

import static java.time.Clock.system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.math.*;


public class LCS_Bryan {

 
  
    public static void fil_col_zero (int mat[][], int n , int m){ // n i m guardan la longitud de las cades x e y
        int i, j;
        for(i=0; i< n ; i++){
            mat[i][0]=2*i;
        }

        for (j=0; j< m; j++){
            mat[0][j]=2*j;
        }
    }

    
    public static  int lcs (String x, String y, int n, int m){
        int [][] mat= new int[n][m];
        for(int i=1; i< n ; i++){
            for(int j=1; j< m;j++){
                if(x.charAt(i-1) != y.charAt(j-1)){
                    mat[i][j]=mat[i-1][j-1]+1;
                    mat[i][j]= Math.min(mat[i-1][j]+2,mat[i][j]);
                    mat[i][j]= Math.min(mat[i][j-1]+2,mat[i][j]);

                }
                else{
                    mat[i][j]=mat[i-1][j-1];
                }
            
            }
        }
        return mat[n-1][m-1];
    }

    



    public static void main(String[] argv) throws IOException{
        String cad = null;
        int m=argv.length;
        List<String> noms= new ArrayList<String>();
        List<String> ncadenes=new ArrayList<String>();
        List<Genoma> genomes = new ArrayList<Genoma>();

        noms.add("Bovi");noms.add("Cocodril");noms.add("Conill");noms.add("Gallina");noms.add("Gat");noms.add("Gos"); noms.add("huma");noms.add("macaco"); noms.add("orangutan");
        noms.add("ovi"); noms.add("porc");noms.add("ratoli");noms.add("ximpanze");
        for(int i=0;i < m; i++){
            String cadena;
            File fichero;
            FileReader f;
            BufferedReader b;
            fichero = new File("C:/Users/Skylake-Adry/Desktop/PROP/Nucleotids proteina albumina/",argv[i]);
            f=new FileReader(fichero);
            b=new BufferedReader(f);
            String linea;
            while((linea=b.readLine())!=null){
                cad=linea;
            }
            ncadenes.add(cad);
        }

        Iterator it=noms.iterator();
        Iterator it2=ncadenes.iterator();

        while(it.hasNext() && it2.hasNext()){
            Genoma g;
            g=new Genoma((String) it2.next(), (String) it.next());
            genomes.add(g);
        }

        /*int[][] taula=taula_coincidencies(genomes);
        for (int i = 0; i < genomes.size(); i++) {
            for (int j = 0; j <genomes.size() ; j++) {
                System.out.println(taula[i][j]);
            }
        }
*/

    }
   /* public static  int[][] taula_coincidencies(List<Genoma> a){
        int [][] taula_coinci=new int [a.size()][a.size()];
        Iterator it =a.iterator();
        Iterator it2=a.iterator();
        int i=0;
        int j=0;
        while(i<a.size() || it2.hasNext()){
            while(j<a.size() || it.hasNext()){
                taula_coinci[i][j]=lcs(it.next().getCadena(),it2.next().getCadena(),it.next().getCadena().length(),it2.next().getCadena().length());
                if(j==a.size()-1){
                    j=0;
                }
                else ++j;

                if(!it.hasNext()){
                    it=a.iterator();
                }
                if(!it.hasNext()){
                    it=a.iterator();
                }
            }
            if(i==a.size()-1){
                i=0;
            }
            else ++i;
            if(!it2.hasNext()){
                it=a.iterator();
            }
        }
        return taula_coinci;
    }
*/

}
