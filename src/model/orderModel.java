/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author ACER
 */
public class orderModel implements  Serializable{
    private String IDOrder;
    private String NameOrder;
    private String SizeOrder;
    private Double PriceOrder;

    public orderModel(String IDOrder, String NameOrder, String SizeOrder, Double PriceOrder) {
        this.IDOrder = IDOrder;
        this.NameOrder = NameOrder;
        this.SizeOrder = SizeOrder;
        this.PriceOrder = PriceOrder;
    }

    public String getIDOrder() {
        return IDOrder;
    }

    public void setIDOrder(String IDOrder) {
        this.IDOrder = IDOrder;
    }

    public String getNameOrder() {
        return NameOrder;
    }

    public void setNameOrder(String NameOrder) {
        this.NameOrder = NameOrder;
    }

    public String getSizeOrder() {
        return SizeOrder;
    }

    public void setSizeOrder(String SizeOrder) {
        this.SizeOrder = SizeOrder;
    }

    public Double getPriceOrder() {
        return PriceOrder;
    }

    public void setPriceOrder(Double PriceOrder) {
        this.PriceOrder = PriceOrder;
    }

}



    