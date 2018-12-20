/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author mr-ali
 */
public class Service {

    private SimpleIntegerProperty ids;
    private SimpleStringProperty noms;
    private SimpleDoubleProperty prixs;

    public Service(int ids, String noms, double prixs) {
        this.ids = new SimpleIntegerProperty(ids);
        this.noms = new SimpleStringProperty(noms);
        this.prixs = new SimpleDoubleProperty(prixs);
    }

    public Service(String noms, double prixs) {
        this.noms = new SimpleStringProperty(noms);
        this.prixs = new SimpleDoubleProperty(prixs);
    }

    public int getIds() {
        return ids.get();
    }

    public String getNoms() {
        return noms.get();
    }

    public void setNoms(String noms) {
        this.noms = new SimpleStringProperty(noms);
    }

    public Double getPrixs() {
        return prixs.get();
    }

    public void setPrixs(double prixs) {
        this.prixs = new SimpleDoubleProperty(prixs);
    }

}
