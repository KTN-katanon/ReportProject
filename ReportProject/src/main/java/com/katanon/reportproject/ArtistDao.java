/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.katanon.reportproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nonku
 */
public class ArtistDao implements Dao<Artist> {

    @Override
    public Artist get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Artist> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Artist save(Artist obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Artist update(Artist obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Artist obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Artist> getAll(String where, String order) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<ArtistReport> getArtistByTotalPrice(int limit) {
        ArrayList<ArtistReport> list = new ArrayList();
        String sql = """
                     SELECT art.*, SUM(ini.Quantity) TotalQuantity,
                            SUM(ini.UnitPrice*ini.Quantity) as TotalPrice FROM artists art
                     INNER JOIN albums alb ON alb.ArtistId=art.ArtistId
                     INNER JOIN tracks tra ON tra.AlbumId=alb.AlbumId
                     INNER JOIN invoice_items ini ON ini.TrackId =tra.TrackId
                     INNER JOIN invoices inv ON inv.InvoiceId=ini.InvoiceId
                     --       AND strftime('%Y',inv.InvoiceDate)="2010"
                     GROUP BY art.ArtistId
                     ORDER BY TotalPrice DESC
                     LIMIT ?
                     """;
        Connection conn = DatabaseHelper.getConnect();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, limit);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ArtistReport obj = ArtistReport.fromRS(rs);
                list.add(obj);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
}
