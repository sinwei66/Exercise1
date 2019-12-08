package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculate:Button = findViewById(R.id.buttonCalculate)
        val btnReset:Button = findViewById(R.id.buttonReset)
        btnCalculate.setOnClickListener{calculate()}
        btnReset.setOnClickListener{reset()}
    }

    private fun calculate()
    {
        val carPrice:EditText = findViewById(R.id.editTextCarPrice)
        val downPayment:EditText = findViewById(R.id.editTextDownPayment)
        val period:EditText = findViewById(R.id.editTextLoanPeriod)
        val interestRate:EditText = findViewById(R.id.editTextInterestRate)
        //val loan2:TextView = findViewById(R.id.textViewLoan)
        //val interest2:TextView = findViewById(R.id.textViewInterest)
        //val monthlyPayment2:TextView = findViewById(R.id.textViewMonthlyRepayment)

        val loan = carPrice.text.toString().toInt() - downPayment.text.toString().toInt()
        val interest = loan * interestRate.text.toString().toInt() * period.text.toString().toInt()
        val monthlyPayment = (loan + interest) / period.text.toString().toInt() / 12

        textViewLoan.text = "Loan: RM " + loan.toString()
        textViewInterest.text = "Interest: RM " + interest.toString()
        textViewMonthlyRepayment.text = "Monthly Repayment: RM " + monthlyPayment.toString()

        //val loan:TextView = findViewById(R.id.textViewLoan)
        //loan.setText("Loan: " + editTextCarPrice)
    }

    private fun reset()
    {
        editTextCarPrice.setText("")
        editTextDownPayment.setText("")
        editTextInterestRate.setText("")
        editTextLoanPeriod.setText("")

        textViewLoan.setText(R.string.loan)
        textViewInterest.setText(R.string.interest)
        textViewMonthlyRepayment.setText(R.string.monthly_repayment)
    }
}
