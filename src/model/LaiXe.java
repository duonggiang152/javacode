/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author giang
 */
public class LaiXe implements Serializable{
    int maLaiXe;
    String hoten;
    String diachi;
    String trinhdo;
    public static int next_maLaiXe;

    public int getMaLaiXe() {
        return maLaiXe;
    }

    public void setMaLaiXe(int maLaiXe) {
        this.maLaiXe = maLaiXe;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getTrinhdo() {
        return trinhdo;
    }

    public void setTrinhdo(String trinhdo) {
        this.trinhdo = trinhdo;
    }

    public static int getNext_maLaiXe() {
        return next_maLaiXe;
    }

    public static void setNext_maLaiXe(int next_maLaiXe) {
        LaiXe.next_maLaiXe = next_maLaiXe;
    }

    public LaiXe(int maLaiXe, String hoten, String diachi, String trinhdo) {
        this.maLaiXe = maLaiXe;
        this.hoten = hoten;
        this.diachi = diachi;
        this.trinhdo = trinhdo;
    }
    public Object[] toObject() {
        return new Object[] {
            this.maLaiXe,
            this.hoten,
            this.diachi,
            this.trinhdo
        };
    }
}
