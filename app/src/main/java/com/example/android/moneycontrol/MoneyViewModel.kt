package com.example.android.moneycontrol

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/*
Now that you have a database and a UI, you need to collect data, add the data to the database, and display the data.
All this work is done in the view model. Your sleep-tracker view model will handle button clicks, interact with the database via the DAO,
and provide data to the UI via LiveData. All database operations will have to be run away from the main UI thread,
and you'll do that using coroutines.

In Kotlin, coroutines are the way to handle long-running tasks elegantly and efficiently instead of callbacks.
*/
class MoneyViewModel(application: Application) : AndroidViewModel(application) {
    val MoneyRecord : LiveData<Money>
    val repository : MoneyRepository

    init {
        val dao = MoneyDatabase.getMoneyDatabase(application).getMoneyDao()
        repository = MoneyRepository(dao)
        MoneyRecord = repository.MoneyRecord
    }



    fun insert(money: Money) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(money)
    }

    fun deleteAll()= viewModelScope.launch(Dispatchers.IO){
        repository.deleteAll()
    }

    fun update(money: Money) = viewModelScope.launch(Dispatchers.IO){
        repository.update(money)
    }
}
