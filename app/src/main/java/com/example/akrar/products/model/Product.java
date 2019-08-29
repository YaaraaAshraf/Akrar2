package com.example.akrar.products.model;/*
 * Copyright (C) 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

//package com.google.gson.annotations;

///**
// * An annotation that indicates this member should be serialized to JSON with
// * the provided name value as its field name.
// *
// * <p>This annotation will override any {@link com.google.gson.FieldNamingPolicy}, including
// * the default field naming policy, that may have been set on the {@link com.google.gson.Gson}
// * instance.  A different namin

import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("name")
    private String name;
    @SerializedName("unit")
    private String units;
    private String price;
    private String quantity;
    private int img_edit, img_delete;

    Product product;


    public Product(String name, String units, String price, String quantity) {
        this.name = name;
        this.units = units;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}