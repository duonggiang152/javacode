/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giang
 */
public class IOfile implements Serializable {
    public static <T> List<T> doc(String fileName) {
        List<T> m_list = new ArrayList<>();
        try{
            ObjectInputStream oj = new ObjectInputStream(new FileInputStream(fileName));
            m_list = (List<T>)oj.readObject();
            oj.close();
        } catch(ClassNotFoundException exception) {
            System.out.println(exception);
            return null;
        } catch(IOException exception) {
            System.out.println(exception);
            return null;
        }
        return m_list;
    }
    public static <T> void viet(String fileName, List<T> m_list) {
        try{
            ObjectOutputStream oj = new ObjectOutputStream(new FileOutputStream(fileName));
            oj.writeObject(m_list);
            oj.close();
        } catch(IOException exception) {
            System.out.println(exception);
        }
    }
}
