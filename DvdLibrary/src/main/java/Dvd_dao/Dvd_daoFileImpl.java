/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dvd_dao;

import Dvd_dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author pisce
 */
public class Dvd_daoFileImpl implements Dvd_dao {;
        
    public static final String UPLOAD_FILE = "dvdLibrary.txt";
    public static final String DELIMITER = "::";
    private Map<String, Dvd> dvdMap = new HashMap<>();
    
    private Dvd unmarshallDvd(String dvdAsText) throws Dvd_daoDaoException {
        String[] dvdTokens = dvdAsText.toUpperCase().split(DELIMITER);
        String title = dvdTokens[0];
        Dvd dvdFromFile = new Dvd (title);
        dvdFromFile.setReleaseDate(dvdTokens[1]);
        dvdFromFile.setRating(dvdTokens[2]);
        dvdFromFile.setDirector(dvdTokens[3]);
        dvdFromFile.setStudio(dvdTokens[4]);
        dvdFromFile.setNotes(dvdTokens[5]);
        return dvdFromFile;
    }
    
    private void loadLibrary()throws Dvd_daoDaoException {
        Scanner reader;
        try {
            reader = new Scanner (new BufferedReader(new FileReader(UPLOAD_FILE)));
        }catch (FileNotFoundException ex) {
            throw new Dvd_daoDaoException("Could not load file", ex);
        }
        String currentLine; 
        Dvd currentDvd;
        while (reader.hasNextLine()){
            currentLine = reader.nextLine();
            currentDvd = unmarshallDvd(currentLine.toUpperCase());
            dvdMap.put(currentDvd.getTitle().toUpperCase(), currentDvd);
        }    
        reader.close();
    }
    
    private String marshallDvd (Dvd aDvd) throws Dvd_daoDaoException {
        String dvdAsText = aDvd.getTitle().toUpperCase() + DELIMITER;
        dvdAsText += aDvd.getReleaseDate().toUpperCase() + DELIMITER;
        dvdAsText += aDvd.getRating().toUpperCase() + DELIMITER;
        dvdAsText += aDvd.getDirector().toUpperCase() + DELIMITER;
        dvdAsText += aDvd.getStudio().toUpperCase() + DELIMITER;
        dvdAsText += aDvd.getNotes().toUpperCase();
        return dvdAsText;
    }
    
    private void writeLibrary() throws Dvd_daoDaoException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(UPLOAD_FILE));
        }catch(IOException e){
            throw new Dvd_daoDaoException("Could not save Dvd.", e);
        }
        String dvdAsText;
        List<Dvd> dvdList = this.getAllDvd();
        for(Dvd currentDvd : dvdList) {
            dvdAsText = marshallDvd(currentDvd);
            out.println(dvdAsText);
            out.flush();
        }
        out.close();
    }
   
    
    @Override
    public Dvd addDvd(String title, Dvd dvd) throws Dvd_daoDaoException {
        loadLibrary(); 
        Dvd newDvd = dvdMap.put(title.toUpperCase(), dvd);
        writeLibrary();
        return newDvd;
    }

    @Override
    public Dvd deleteDvd(String title) throws Dvd_daoDaoException{
        loadLibrary();
        Dvd deletedDvd = dvdMap.remove(title.toUpperCase());
        writeLibrary();
        return deletedDvd;
    }

    @Override
    public Dvd searchDvd(String title)throws Dvd_daoDaoException {
        Scanner read = new Scanner(System.in);        
        String searchTitle = read.nextLine();
        searchTitle.toUpperCase().equals(title.toUpperCase());
        return dvdMap.get(title.toUpperCase());
    }

    @Override
    public Dvd editDvd(String title, Dvd dvd) throws Dvd_daoDaoException {
        loadLibrary();
        Dvd editedDvd = dvdMap.put(title.toUpperCase(), dvd);
        writeLibrary();
        return editedDvd;
    }

    @Override
    public List<Dvd> getAllDvd()throws Dvd_daoDaoException {
        loadLibrary();
        return new ArrayList<Dvd>(dvdMap.values());
    }

}
