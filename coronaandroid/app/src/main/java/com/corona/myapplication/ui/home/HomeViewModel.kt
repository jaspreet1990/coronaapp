package com.corona.myapplication.ui.home

import com.corona.myapplication.domain.CoronaInfoService
import com.corona.myapplication.domain.CoronaInfoUseCase
import com.corona.myapplication.repo.db.CoronaCoutryWiseTable
import com.corona.myapplication.ui.base.BaseViewModel
import com.corona.myapplication.util.SingleLiveEvent
 import io.reactivex.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*


open class HomeViewModel(private val coronaInfoUseCase: CoronaInfoService):
    BaseViewModel() {

     val countryBasedCoronaResponseLiveData = SingleLiveEvent<MutableList<CoronaCoutryWiseTable>>()
     val countryCoronaData = SingleLiveEvent<CoronaCoutryWiseTable>()


    fun getAllCountries() {
        coronaInfoUseCase.getAllCountries()
            .observeOn(Schedulers.io())
            .subscribeOn(Schedulers.io())
            .subscribe {
                countryBasedCoronaResponseLiveData.postValue(it)
            }
    }

  fun getCasesBasedOnCountry(countryName: String)  {
         coronaInfoUseCase.getCasesBasedOnCountry(
            "YYYY-MM-DD",
            "2020-10-04",
            countryName
        )
           .observeOn(Schedulers.io())
            .subscribeOn(Schedulers.io())
           .subscribe {
               countryCoronaData.postValue(it)
           }
    }
    fun getCurrentDate(): String {
        val currentTime: String = SimpleDateFormat(
            "YYYY-MM-DD",
            Locale.getDefault()
        ).format(Date())

        return currentTime
    }

    override fun onCleared() {
        super.onCleared()
    }

}