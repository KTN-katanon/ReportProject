/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.katanon.reportproject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nonku
 */
public class ArtistReport {

    private int id;
    private String name;
    private int totalQuantity;
    private float totalPrice;

    public ArtistReport(int id, String name, int totalQuantity, float totalPrice) {
        this.id = id;
        this.name = name;
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;
    }

    public ArtistReport(String name, int totalQuantity, float totalPrice) {
        this.id = -1;
        this.name = name;
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;
    }

    public ArtistReport() {
        this(-1, "", 0, 0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "ArtistReport{" + "id=" + id + ", name=" + name + ", totalQuantity=" + totalQuantity + ", totalPrice=" + totalPrice + '}';
    }

    public static ArtistReport fromRS(ResultSet rs) {
        ArtistReport obj = new ArtistReport();
        try {
            obj.setId(rs.getInt("ArtistId"));
            obj.setName(rs.getString("Name"));
            obj.setTotalQuantity(rs.getInt("TotalQuantity"));
            obj.setTotalPrice(rs.getFloat("TotalPrice"));
        } catch (SQLException ex) {
            Logger.getLogger(ArtistReport.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return obj;
    }
}
