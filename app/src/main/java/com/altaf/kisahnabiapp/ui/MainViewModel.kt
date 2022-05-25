package com.altaf.kisahnabiapp.ui

import android.database.DatabaseErrorHandler
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.altaf.kisahnabiapp.data.KisahResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

// MainviewModel inheritance ke ViewModel
// fungsi MainViewModel utk transaksi data dari bussiness logic
// ViewModel supaya menjadi penghubung antara ui(activity) dengan layer data (kisah response)

class MainViewModel: ViewModel(){
    val kisahResponse = MutableLiveData<List<KisahResponse>>()
    // isLoading utk memberikan
    val isLoading = MutableLiveData<Boolean>()
    val isError = MutableLiveData<Throwable>()

    // "->" sebagai resperator / casting (
    private fun getKisahNabi(responHandler: (List<KisahResponse>) -> Unit, errorHandler: (Throwable) -> Unit){
        ApiClient.getApiService().getKisahNabi()
                // subscribeOn utk menyediakan prosses async, menempatkan Api di background ata
            .subscribeOn(Schedulers.io())
                // nge get data utk menmpilkan dimana data nya akan ditampung (di )
            .observeOn(AndroidSchedulers.mainThread())
                // utk menentukan apakah akan direspon atau eror
            .subscribe({
                responHandler(it)
            }, {
                errorHandler(it)
            })
    }

    fun getData(){

        isLoading.postValue(true)

        getKisahNabi({
            isLoading.postValue(true)
            // kt memasukkan kisahResponse ke responHandler dgn .postvalue
            kisahResponse.postValue(it)
        },{
            isLoading.postValue(true)
            isError.postValue(it)
        })
    }
}