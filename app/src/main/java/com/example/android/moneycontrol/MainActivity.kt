package com.example.android.moneycontrol

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.android.moneycontrol.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding : ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var MainMoney: Money
    private lateinit var viewModel: MoneyViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        viewModel = ViewModelProvider(
                this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(MoneyViewModel::class.java)
        viewModel.MoneyRecord.observe(this, Observer { list ->
            list?.let {
                updateUi(it)
                MainMoney = it
            }
        })



        binding.AddTotal.setOnClickListener {
            if(binding.EnterTotal.text != null) {
                val totalAmount = binding.EnterTotal.text.toString()
                val numTotal = totalAmount.toInt()
                viewModel.insert(Money(1,numTotal,0,numTotal,0,0,0,0))
//                val TotalAmount = binding.EnterTotal.text.toString()
//                var numTotal = TotalAmount.toInt()
//                val spent = MainMoney.Spent
//                val remaing = MainMoney.Remaining
//                val book = MainMoney.EduTotal
//                val online = MainMoney.OnlineTotal
//                val home = MainMoney.HomeTotal
//                val food = MainMoney.FoodTotal
//                val total = MainMoney.Total + numTotal
//                viewModel.update(Money(1,total,spent,remaing,food,book,home,online))
                binding.EnterTotal.setText("")
            }
        }
        binding.Reset.setOnClickListener {
            viewModel.deleteAll()
            binding.EnterTotal.setText("")
            binding.Remaining.text = "0"
            binding.Total.text = "Total Amount"
            binding.Spent.text = "0"
            binding.FoodTotal.text = "Food"
            binding.Booktotal.text = "Books"
            binding.HomeTotal.text = "Home"
            binding.OnlineTotal.text = "Online"
        }

        binding.addFood.setOnClickListener {
            val FoodAmount = binding.FoodEnter.text.toString()
            val numTotal = FoodAmount.toInt()
            val spent = MainMoney.Spent + numTotal
            val remaing = MainMoney.Remaining - numTotal
            val book = MainMoney.EduTotal
            val online = MainMoney.OnlineTotal
            val home = MainMoney.HomeTotal
            val food = MainMoney.FoodTotal + numTotal
            val total = MainMoney.Total
            viewModel.update(Money(1,total,spent,remaing,food,book,home,online))
            binding.FoodEnter.setText("")
        }

        binding.addEdu.setOnClickListener {
            val BookAmount = binding.EduTotal.text.toString()
            val numTotal = BookAmount.toInt()
            val spent = MainMoney.Spent + numTotal
            val remaing = MainMoney.Remaining - numTotal
            val book = MainMoney.EduTotal + numTotal
            val online = MainMoney.OnlineTotal
            val home = MainMoney.HomeTotal
            val food = MainMoney.FoodTotal
            val total = MainMoney.Total
            viewModel.update(Money(1,total,spent,remaing,food,book,home,online))
            binding.EduTotal.setText("")
        }
        binding.addHome.setOnClickListener {
            val HomeAmount = binding.HomeEnter.text.toString()
            val numTotal = HomeAmount.toInt()
            val spent = MainMoney.Spent + numTotal
            val remaing = MainMoney.Remaining - numTotal
            val book = MainMoney.EduTotal
            val online = MainMoney.OnlineTotal
            val home = MainMoney.HomeTotal + numTotal
            val food = MainMoney.FoodTotal
            val total = MainMoney.Total
            viewModel.update(Money(1,total,spent,remaing,food,book,home,online))
            binding.HomeEnter.setText("")
        }

        binding.addOnline.setOnClickListener {
            val OnlineAmount = binding.OnlinEnter.text.toString()
            val numTotal = OnlineAmount.toInt()
            val spent = MainMoney.Spent + numTotal
            val remaing = MainMoney.Remaining - numTotal
            val book = MainMoney.EduTotal
            val online = MainMoney.OnlineTotal + numTotal
            val home = MainMoney.HomeTotal
            val food = MainMoney.FoodTotal
            val total = MainMoney.Total
            viewModel.update(Money(1,total,spent,remaing,food,book,home,online))
            binding.OnlinEnter.setText("")
        }
    }

    private fun updateUi(money: Money) {
        binding.Total.text = money.Total.toString()
        binding.Spent.text = money.Spent.toString()
        binding.Remaining.text = money.Remaining.toString()
        binding.FoodTotal.text = money.FoodTotal.toString()
        binding.Booktotal.text = money.EduTotal.toString()
        binding.HomeTotal.text = money.HomeTotal.toString()
        binding.OnlineTotal.text = money.OnlineTotal.toString()
    }
}