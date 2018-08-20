package com.calculator.so_ni.calculator

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    var dotCheck:Boolean=false
    var signPlus:Boolean =true
    var writingNo:Boolean= false
    var screenNo:String="0"

    fun buNumberEvent(view: View)
    {


        var buSelected = view as Button
        screenNo= screen.text.toString()

        if(!writingNo)
        {
            writingNo = true
            screenNo = ""
        }

        when(buSelected.id)
        {
            bu0.id ->
            {
                if(screenNo!="0")
                {
                    screenNo+="0"
                }

            }
            bu1.id ->
            {
                screenNo+="1"
            }
            bu2.id ->
            {
                screenNo+="2"
            }
            bu3.id ->
            {
                screenNo+="3"
            }
            bu4.id ->
            {
                screenNo+="4"
            }
            bu5.id ->
            {
                screenNo+="5"
            }
            bu6.id ->
            {
                screenNo+="6"
            }
            bu7.id ->
            {
                screenNo+="7"
            }
            bu8.id ->
            {
                screenNo+="8"
            }
            bu9.id ->
            {
                screenNo+="9"
            }
            buDot.id ->
            {
                if(!dotCheck)
                {
                    screenNo+="."
                    dotCheck = true
                }

            }
            buSign.id ->
            {
                if(signPlus)
                {
                    screenNo = "-" + screenNo

                    signPlus= false
                }
                else
                {
                   screenNo= screenNo?.removePrefix("-")
                    signPlus = true

                }




            }


        }
        screen.text = screenNo



    }

    var num1:Float=0.0f
    var num2:Float=0.0f
    var op:String?=null
    var ans:Float=0.0f

    fun buOpEvent(view:View)
    {

        val opBuSelected:Button = view as Button

        screenNo = screen.text.toString()

        num1 = screenNo.toFloat()

        if(writingNo)
        {
            writingNo = false
        }



        when(opBuSelected.id)
        {

            buDiv.id ->
            {
                op = "/"
            }
            buMul.id ->
            {
                op = "*"
            }
            buSub.id ->
            {
                op = "-"
            }
            buAdd.id ->
            {
                op = "+"
            }


        }

        dotCheck= false
    }


    fun  buEqualEvent(view :View)
    {

        var denoZero:Boolean


        denoZero= false
        num2= screenNo?.toFloat()


        if(op!=null)
        {

            when(op)
            {
                "/" ->
                {
                    if(num2!=0f)
                        ans=num1/num2
                    else
                        denoZero = true
                }
                "*" ->
                {
                    ans=num1*num2
                }
                "+" ->
                {
                    ans=num1+num2
                }
                "-" ->
                {
                    ans=num1-num2
                }
            }

            if(denoZero)
            {
                screen.setText("Error")
            }
            else
            {
                screen.text= ans.toString()
            }

        }
        else
        {
            screen.text = screenNo
        }
        op= null

        writingNo = false

        dotCheck = false






    }

    fun buPcEvent(view :View)
    {
        screenNo = screen.text.toString()

        num1 = screenNo.toFloat()

        screen.text = (num1/100).toString()

        writingNo = false
        dotCheck = false

    }

    fun buAcEvent(view :View)
    {
        num1=0f
        num2=0f

        writingNo = false
        dotCheck = false

        screen.text = "0"
    }
}
