package com.example.android.moneycontrol

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MoneyDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(money : Money)

    @Delete
    suspend fun delete(money: Money)

    @Query("Select * from MoneyList order by id ASC")
    fun getRecord() : LiveData<Money>

    @Query("DELETE FROM MoneyList")
    suspend fun nukeTable()

    @Update
    suspend fun update(money: Money) : Int

}
