package com.datasorcerers.smswipe.logic;

import java.io.File;
import java.util.List;

/**
 * Created by MishaRJ on 01.10.2015.
 */


//THESE METHODS SHOULD BE TESTED. I'm not sure whether they work.
public class Util {
    public static void removeFile(List<String> files){
        for (int i = 0; i <files.size() ; i++) {
            File file = new File(files.get(i));
            boolean deleted = file.delete();
        }
    }
    public static void removeDirectory(List<String> directories){
        for (int i = 0; i <directories.size() ; i++) {
            File dir = new File(directories.get(i));
            if (dir!= null && dir.isDirectory()){
                String[] dirFiles = dir.list();
                for (int j = 0; j <dirFiles.length ; j++) {
                    File tempo = new File(dirFiles[j]);
                    tempo.delete();
                }
            }
        }
    }
}
