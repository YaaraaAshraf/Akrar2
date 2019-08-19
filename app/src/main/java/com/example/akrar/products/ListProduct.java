package com.example.akrar.products;

public class ListProduct {
    String prod_desc,units,price;
    int img_edit,img_delete;

    public ListProduct(String prod_desc, String units, String price, int img_edit, int img_delete) {
        this.prod_desc = prod_desc;
        this.units = units;
        this.price = price;
        this.img_edit = img_edit;
        this.img_delete = img_delete;
    }

    public String getProd_desc() {
        return prod_desc;
    }

    public void setProd_desc(String prod_desc) {
        this.prod_desc = prod_desc;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImg_edit() {
        return img_edit;
    }

    public void setImg_edit(int img_edit) {
        this.img_edit = img_edit;
    }

    public int getImg_delete() {
        return img_delete;
    }

    public void setImg_delete(int img_delete) {
        this.img_delete = img_delete;
    }
}
