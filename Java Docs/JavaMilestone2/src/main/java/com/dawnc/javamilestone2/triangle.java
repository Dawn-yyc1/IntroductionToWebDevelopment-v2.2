/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dawnc.javamilestone2;

/**
 *
 * @author pisce
 */
public class triangle extends shape {
    private String shapeColor;
        private int area;
        private int perimeter;

        public String getShapeColor() {
            return shapeColor;
        }

        public void setShapeColor(String shapeColor) {
            this.shapeColor = shapeColor;
        }

        public int getArea() {
            return area;
        }

        public void setArea(int area) {
            this.area = area;
        }

        public int getPerimeter() {
            return perimeter;
        }

        public void setPerimeter(int perimeter) {
            this.perimeter = perimeter;
        }
    //to get a triangle we override base class
    
}
