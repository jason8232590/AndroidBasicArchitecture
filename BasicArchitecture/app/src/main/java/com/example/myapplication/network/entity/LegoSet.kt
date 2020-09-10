package com.example.myapplication.network.entity

import com.google.gson.annotations.SerializedName

data class LegoSet (
    @SerializedName("set_num")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("set_img_url")
    val imageUrl: String? = null,
    @SerializedName("theme_id")
    val themeId: Int,
    @SerializedName("last_modified_dt")
    val lastModifiedDate: String? = null,
    @SerializedName("num_parts")
    val numParts: Int? = null,
    @SerializedName("set_url")
    val url: String? = null,
    @SerializedName("year")
    val year: Int? = null
) {

    override fun toString(): String {
        return name
    }
}