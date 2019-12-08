package com.taweesak.changeratefmrecyclerview.dataModel;

public class Model {
    String unit;
    String text;
    Integer fraction;
    Double normalPrice, promoPrice;
    boolean isPromo;
    boolean isChecked;

    int image;

    public Model(String text) {
        this.text = text;
    }

    public Model(String text, int image) {
        this.text = text;
        this.image = image;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

   /* public Integer getFraction() {
        return fraction;
    }*/

    /*public void setFraction(Integer fraction) {
        this.fraction = fraction;
    }*/

    /*public Double getNormalPrice() {
        return normalPrice;
    }*/

   /* public void setNormalPrice(Double normalPrice) {
        this.normalPrice = normalPrice;
    }*/

    /*public Double getPromoPrice() {
        return promoPrice;
    }*/

    /*public void setPromoPrice(Double promoPrice) {
        this.promoPrice = promoPrice;
    }*/

    public boolean isPromo() {
        return isPromo;
    }

    public void setPromo(boolean promo) {
        isPromo = promo;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
