/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.katanon.reportproject;

import java.util.List;

/**
 *
 * @author nonku
 */
public class ArtistService {

    public List<ArtistReport> getTopTenArtistByTotalPrice() {
        ArtistDao artistDao = new ArtistDao();
        return artistDao.getArtistByTotalPrice(10);
    }

    public List<ArtistReport> getTopTenArtistByTotalPrice(String begin, String end) {
        ArtistDao artistDao = new ArtistDao();
        return artistDao.getArtistByTotalPrice(begin, end, 10);
    }
}
