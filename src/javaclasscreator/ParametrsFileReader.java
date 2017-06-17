/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaclasscreator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collection;


/**
 *
 * @author filip
 */
public class ParametrsFileReader {
    
    FileReader fr = null;
    String line = " ";
    String pub= "public";
    List<String> newLines = new ArrayList<>();
    List<String> words =  Arrays.asList();
    List<String> parametrsList = new ArrayList<String>();
    

//    
//    public static void main(String[] args){
//       String pathh = "C:\\Users\\filip\\Desktop\\Adrianowy kod\\java\\pl\\bikegame\\model\\item\\bikeparts\\parameters\\WornablePartParameters.java";
//       ParametrsFileReader parametrsFileReader = new ParametrsFileReader();
//       parametrsFileReader.readFile(pathh);
//        List<String> parList = parametrsFileReader.getParametrsList();
//        
//        for(String pa: parList)
//            System.out.println(pa);
//    }
//    


    
    void readFile(String path) {
        try {
            fr = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.out.println("FILE OPEN ERROR!");
            System.exit(1);
        }
        
        BufferedReader bfr = new BufferedReader(fr);
        
        try {

            while ((line = bfr.readLine()) != null) {
                //Check if it is extends by other interface
                if (line.startsWith(pub)) { 
                    words = Arrays.asList(line.split(" "));
                    if (5 <= words.size()) { 
                       String newPath = (path.replace(words.get(2), words.get(4)));
                       ParametrsFileReader parametrsFileReader = new ParametrsFileReader();
                       parametrsFileReader.readFile(newPath);
                       List<String> parLists = parametrsFileReader.getParametrsList();
                       parametrsList.addAll(parLists);
                    }
                } 
                //Search paramters
                if (line.startsWith("    ")) {
                    words = Arrays.asList(line.split(" "));
                    if (words.get(4).equals("float")) {
                        parametrsList.add(words.get(5).substring(3, words.get(5).length() - 3));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("FILE READ ERROR");
            System.exit(2);
        }
        //Close file
        try {
            fr.close();
        } catch (IOException e) {
            System.out.println("FILE CLOSE ERROR");
            System.exit(3);
        }

    }
    
    void addParametr(String path) {
        try {
            fr = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.out.println("FILE OPEN ERROR!");
            System.exit(1);
        }
        
        BufferedReader bfr = new BufferedReader(fr);
        
        try {
            int i = 0;
            while ((line = bfr.readLine()) != null) {
                
                
               newLines.set(i, line); 
               i++;
            }
            Files.write(Paths.get(path), newLines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("FILE READ ERROR");
            System.exit(2);
        }
        //Close file
        try {
            fr.close();
        } catch (IOException e) {
            System.out.println("FILE CLOSE ERROR");
            System.exit(3);
        }

    }
    
    public List<String> getParametrsList() {
        return parametrsList;
    }
   
    
}
