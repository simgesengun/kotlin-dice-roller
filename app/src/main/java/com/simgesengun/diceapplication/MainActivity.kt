package com.simgesengun.diceapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dice1Image: ImageView = findViewById(R.id.dice1Image)
        val dice2Image: ImageView = findViewById(R.id.dice2Image)
        val rollButton: Button = findViewById(R.id.rollButton)
        val clearButton: Button = findViewById(R.id.clearButton)

        val dice1 = Dice(6)
        val dice2 = Dice(6)

        //zar at butonu
        rollButton.setOnClickListener{
            while(true) {
                val dice1Side = dice1.roll()
                val dice2Side = dice2.roll()
                if (dice1Side != dice2Side) {
                    imageChanger(dice1Side, dice1Image)
                    imageChanger(dice2Side, dice2Image)
                    break
                }
            }
            Toast.makeText(this@MainActivity, "Zar Atıldı!", Toast.LENGTH_SHORT).show()
        }

        //temizle butonu
        clearButton.setOnClickListener{
            dice1Image.setImageResource(R.drawable.default_dice)
            dice2Image.setImageResource(R.drawable.default_dice)
        }
    }

    //Zarın seçili tarafını ve ImageView'ını alarak ImageView'ı değiştirir
    fun imageChanger(diceRoll: Int, diceImage : ImageView){
        when(diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice1)
            2 -> diceImage.setImageResource(R.drawable.dice2)
            3 -> diceImage.setImageResource(R.drawable.dice3)
            4 -> diceImage.setImageResource(R.drawable.dice4)
            5 -> diceImage.setImageResource(R.drawable.dice5)
            else -> diceImage.setImageResource(R.drawable.dice6)
        }
    }


}