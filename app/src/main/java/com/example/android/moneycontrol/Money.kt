package com.example.android.moneycontrol

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MoneyList")
class Money(
        @PrimaryKey(autoGenerate = true) var id: Int,
        @ColumnInfo(name = "Total") var Total: Int,
        @ColumnInfo(name = "Spent") var Spent: Int,
        @ColumnInfo(name = "Remaining") var Remaining: Int,
        @ColumnInfo(name = "FoodTotal") var FoodTotal: Int,
        @ColumnInfo(name = "EduTotal") var EduTotal: Int,
        @ColumnInfo(name = "HomeTotal") var HomeTotal: Int,
        @ColumnInfo(name = "OnlineTotal") var OnlineTotal: Int,
) {
}
