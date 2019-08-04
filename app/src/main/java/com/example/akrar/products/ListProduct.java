package com.example.akrar.products;/*
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

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

///**
// * An annotation that indicates this member should be serialized to JSON with
// * the provided name value as its field name.
// *
// * <p>This annotation will override any {@link com.google.gson.FieldNamingPolicy}, including
// * the default field naming policy, that may have been set on the {@link com.google.gson.Gson}
// * instance.  A different namin

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