/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dvd_ui;

import Dvd_dto.Dvd;
import java.util.List;

/**
 *
 * @author pisce
 */
public class Dvd_view {
    
    private Dvd_UserIO io;
    
    public Dvd_view(Dvd_UserIO io){
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("--- Main Menu---");
        io.print("1. Add new DVD");
        io.print("2. Delete DVD");
        io.print("3. Edit DVD entry");
        io.print("4. Display all DVDs");
        io.print("5. Search DVD by title");
        io.print("6. Exit");
       

        return io.readInt("Please select from the above choices 1 - 6");
    }
    
    public Dvd addDvd() {
        String title = io.readString("Please enter Dvd title");
        String releaseDate = io.readString("Please enter release date");
        String rating = io.readString("Please enter MPAA rating ");
        String director = io.readString("Please enter director's name");
        String studio = io.readString("Please enter studio");
        String notes = io.readString("Please enter rating or notes ");
        Dvd currentDvd = new Dvd(title);
        currentDvd.setTitle(title);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setRating(rating);
        currentDvd.setStudio(studio);
        currentDvd.setDirector(director);
        currentDvd.setNotes(notes);
        return currentDvd;
    }
    
    public Dvd editDvd() {     
        String title = io.readString("Enter Dvd title you wish to edit");
        String releaseDate = io.readString("Edit release date");
        String rating = io.readString("Edit MPAA rating");
        String director = io.readString("Edit director's name");
        String studio = io.readString("Edit studio name");
        String notes = io.readString("Edit rating or notes");
        Dvd editedDvd = new Dvd(title);
        editedDvd.setTitle(title);
        editedDvd.setReleaseDate(releaseDate);
        editedDvd.setRating(rating);
        editedDvd.setStudio(studio);
        editedDvd.setDirector(director);
        editedDvd.setNotes(notes);
        return editedDvd;
    }
    
    public void displayEditMenuBanner(){
        io.print("*** Edit Menu ***");
    }
    public void displayEditSuccessBanner(){
        io.print("Edit Complete. Press enter to continue.\n");
    }
    
    public void displayCreateDvdBanner(){
        io.print("--- Add Dvd ---");
    }
    
    public void displayCreateSuccessBanner() {
        io.print("Dvd added successfully. Press enter to continue.\n");
    }
    
    public void displayDvdList(List<Dvd> dvdList){
        for (Dvd currentDvd : dvdList){
            String dvdInfo = String.format("%s | %s | %s |%s | %s | %s ", 
                currentDvd.getTitle(),
                currentDvd.getReleaseDate(),
                currentDvd.getRating(),
                currentDvd.getDirector(),
                currentDvd.getStudio(),               
                currentDvd.getNotes());
            io.print(dvdInfo);
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayDisplayAllBanner() {
        io.print("\n--- All Dvds in Library ---");
    }
    
    public void displayDeleteBanner(){
        io.print("--- Delete Dvd ---");
    }
    //dvdEntry = local var
    public void displayRemoveResult(Dvd dvdEntry) {
        if(dvdEntry != null) {
            io.print("Dvd deleted successfully.\n");           
        }else{
            io.print("Entry does not exist.\n");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public String getUserInput(){
        return io.readString("Please enter Dvd title.");
    }
    
    public void searchDvdBanner(){
        io.print("\n--- Search Result ---");
    }
    
    public void displaySearchDvd(Dvd dvd){
        if(dvd != null) {           
            io.print(dvd.getTitle() + " | " +
                dvd.getReleaseDate() + " | " +
                dvd.getRating() + " | " +
                dvd.getDirector() + " | " +
                dvd.getStudio() + " | " +
                dvd.getNotes());
        }else{
            io.print("No such Dvd.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayErrorMessage(String errorMsg) {
    io.print("--- ERROR ---");
    io.print(errorMsg);
    }
    
    public void displayExitBanner(){
        io.print("Good Bye!!!");
    }
    public void displayUnknownCommandBanner(){
        io.print("Unknown Command!!!");
    }
}

