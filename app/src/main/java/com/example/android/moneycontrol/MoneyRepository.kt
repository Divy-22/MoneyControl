package com.example.android.moneycontrol

import androidx.lifecycle.LiveData

class MoneyRepository(private val moneyDao: MoneyDao) {


    val MoneyRecord : LiveData<Money> = moneyDao.getRecord()


    suspend fun insert(money : Money){
        moneyDao.insert(money)
    }
    suspend fun delete(money: Money){
        moneyDao.delete(money)
    }

    suspend fun deleteAll(){
        moneyDao.nukeTable()
    }
    suspend fun update(money: Money){
        moneyDao.update(money)
    }


}