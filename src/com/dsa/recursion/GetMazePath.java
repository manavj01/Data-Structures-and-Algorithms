package com.dsa.recursion;
import java.util.*;
public class GetMazePath {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int sr = scn.nextInt();
        int sc= scn.nextInt();
        int dr = scn.nextInt();
        int dc = scn.nextInt();

        ArrayList<String> res = getMazePaths(sr,sc,dr,dc);
        System.out.println(res);
    }
    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

      if(sr==dr && sc==dc){
          ArrayList<String> bres = new ArrayList<>();
          bres.add("");
          return bres;
      }
        ArrayList<String> vPath= new ArrayList<>();
        ArrayList<String> hPath = new ArrayList<>();
        if (sr<dr){
            vPath= getMazePaths(sr+1,sc,dr,dc);
        }
        if (sc<dc){
            hPath = getMazePaths(sr,sc+1,dr,dc);
        }
        ArrayList<String> result = new ArrayList<>();

        for (String str : vPath) {
            result.add("v"+str);
        }
        for (String str : hPath) {
            result.add("h"+ str);
        }
        return result;
    }
}
