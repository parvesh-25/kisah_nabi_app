package com.altaf.kisahnabiapp.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

// KisahResponse utk nampung data

@Parcelize
data class KisahResponse(

	@field:SerializedName("KisahResponse")
	val kisahResponse: List<KisahResponseItem?>? = null
) : Parcelable

@Parcelize
data class KisahResponseItem(

	@field:SerializedName("usia")
	val usia: String? = null,

	@field:SerializedName("icon_url")
	val iconUrl: String? = null,

	@field:SerializedName("tmp")
	val tmp: String? = null,

	@field:SerializedName("image_url")
	val imageUrl: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("thn_kelahiran")
	val thnKelahiran: String? = null,

	@field:SerializedName("description")
	val description: String? = null
) : Parcelable
