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
public class BangPhanCong implements Serializable{
    int maLaixe;
    int maTuyen;

    public BangPhanCong(int maLaixe, int maTuyen) {
        this.maLaixe = maLaixe;
        this.maTuyen = maTuyen;
    }

    public int getMaLaixe() {
        return maLaixe;
    }

    public void setMaLaixe(int maLaixe) {
        this.maLaixe = maLaixe;
    }

    public int getMaTuyen() {
        return maTuyen;
    }

    public void setMaTuyen(int maTuyen) {
        this.maTuyen = maTuyen;
    }
    public Object[] toObject() {
        return new Object[] {
            this.maLaixe,
            this.maTuyen
        };
    }
}
