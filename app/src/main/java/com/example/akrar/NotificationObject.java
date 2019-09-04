package com.example.akrar;/*
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

public class NotificationObject {
    @SerializedName("id")
    private String id;
    @SerializedName("user_id")
    private String user_id;
    @SerializedName("msg")
    private String msg;
    @SerializedName("status")
    private String status;

    public NotificationObject(String created_at) {
        this.created_at = created_at;
    }

    @SerializedName("created_at")
            private String created_at;

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    NotificationObject notification;

    public NotificationObject(String id, String user_id, String msg, String status, NotificationObject notification) {
        this.id = id;
        this.user_id = user_id;
        this.msg = msg;
        this.status = status;
        this.notification = notification;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public NotificationObject getNotification() {
        return notification;
    }

    public void setNotification(NotificationObject notification) {
        this.notification = notification;
    }
}