/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawnc.classmodeling;

/**
 *
 * @author pisce
 */
public class Home2 {
    private int dimenstionLength;
    private int dimensionWidth;
    private int numFloors;
    private int numWindows;
    private Backyard backyard;

    public int getDimenstionLength() {
        return dimenstionLength;
    }

    public void setDimenstionLength(int dimenstionLength) {
        this.dimenstionLength = dimenstionLength;
    }

    public int getDimensionWidth() {
        return dimensionWidth;
    }

    public void setDimensionWidth(int dimensionWidth) {
        this.dimensionWidth = dimensionWidth;
    }

    public int getNumFloors() {
        return numFloors;
    }

    public void setNumFloors(int numFloors) {
        this.numFloors = numFloors;
    }

    public int getNumWindows() {
        return numWindows;
    }

    public void setNumWindows(int numWindows) {
        this.numWindows = numWindows;
    }

    public Backyard getBackyard() {
        return backyard;
    }

    public void setBackyard(Backyard backyard) {
        this.backyard = backyard;
    }
    
}
