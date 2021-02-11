package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    lateinit var tvExpression: TextView
    lateinit var tvResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvExpression = findViewById(R.id.tvExpression)
        tvResult = findViewById(R.id.tvResult)

        findViewById<Button>(R.id.bt0).setOnClickListener {
            evaluateExpression("0")
        }
        findViewById<Button>(R.id.bt1).setOnClickListener {
            evaluateExpression("1")
        }
        findViewById<Button>(R.id.bt2).setOnClickListener {
            evaluateExpression("2")
        }
        findViewById<Button>(R.id.bt3).setOnClickListener {
            evaluateExpression("3")
        }
        findViewById<Button>(R.id.bt4).setOnClickListener {
            evaluateExpression("4")
        }
        findViewById<Button>(R.id.bt5).setOnClickListener {
            evaluateExpression("5")
        }
        findViewById<Button>(R.id.bt6).setOnClickListener {
            evaluateExpression("6")
        }
        findViewById<Button>(R.id.bt7).setOnClickListener {
            evaluateExpression("7")
        }
        findViewById<Button>(R.id.bt8).setOnClickListener {
            evaluateExpression("8")
        }
        findViewById<Button>(R.id.bt9).setOnClickListener {
            evaluateExpression("9")
        }
        findViewById<Button>(R.id.btPlus).setOnClickListener {
            evaluateExpression("+")
        }
        findViewById<Button>(R.id.btMinus).setOnClickListener {
            evaluateExpression("-")
        }
        findViewById<Button>(R.id.btMul).setOnClickListener {
            evaluateExpression("*")
        }
        findViewById<Button>(R.id.btDivide).setOnClickListener {
            evaluateExpression("/")
        }
        findViewById<Button>(R.id.btDot).setOnClickListener {
            evaluateExpression(".")
        }
        findViewById<Button>(R.id.btClear).setOnClickListener {
            tvExpression.text = ""
            tvResult.text = ""
        }
        findViewById<Button>(R.id.btDelete).setOnClickListener {
            val tvExpressionNew: String = tvExpression.text.toString().dropLast(1)
            tvExpression.text = tvExpressionNew
            tvResult.text = ""
        }
        findViewById<Button>(R.id.btEqual).setOnClickListener {
            var text = tvExpression.text.toString()
            var exp = ExpressionBuilder(text).build()
            var result: Double = exp.evaluate()
            tvResult.text = result.toString()
        }
    }

    private fun evaluateExpression(string: String){
        if(tvResult.text.toString().isEmpty()){
            tvResult.text = ""
            tvExpression.append(string)
        }else{
            tvExpression.text = ""
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""
        }

    }
}