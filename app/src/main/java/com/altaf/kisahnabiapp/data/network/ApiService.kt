package com.altaf.kisahnabiapp.data.network

import com.altaf.kisahnabiapp.data.KisahResponse
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.POST

// APiService utk nyediain retrofit
// retrofit = utk ngambil data dari response ()
interface ApiService {

    // ambil data (cm read data)
    @GET("kisahnabi")
    fun getKisahNabi() : Flowable<List<KisahResponse>>

    // kirim data (bisa create data / tambah data)

}