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
public class Tuyen implements Serializable {
    int matuyen;
    int khoangCach;
    int diemDung;
    public static int nextma;

    public int getMatuyen() {
        return matuyen;
    }

    public void setMatuyen(int matuyen) {
        this.matuyen = matuyen;
    }

    public int getKhoangCach() {
        return khoangCach;
    }

    public void setKhoangCach(int khoangCach) {
        this.khoangCach = khoangCach;
    }

    public int getDiemDung() {
        return diemDung;
    }

    public void setDiemDung(int diemDung) {
        this.diemDung = diemDung;
    }

    public static int getNextma() {
        return nextma;
    }

    public static void setNextma(int nextma) {
        Tuyen.nextma = nextma;
    }

    public Tuyen(int matuyen, int khoangCach, int diemDung) {
        this.matuyen = matuyen;
        this.khoangCach = khoangCach;
        this.diemDung = diemDung;
    }
    public Object[] toObject() {
        return new Object[]{
          this.matuyen,
            this.khoangCach,
            this.diemDung
        };
    }
}
