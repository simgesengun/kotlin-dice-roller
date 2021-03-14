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

        rollButton.setOnClickListener{
            rollDice(dice1, dice1Image)
            rollDice(dice2, dice2Image)

            Toast.makeText(this@MainActivity, "Zar Atıldı!", Toast.LENGTH_SHORT).show()
        }

        clearButton.setOnClickListener{
            dice1Image.setImageResource(R.drawable.empty_dice)
            dice2Image.setImageResource(R.drawable.empty_dice)
        }
    }

    //Zarları sallar ve zarın ImageView'ı değiştirir
    fun rollDice(dice: Dice, diceImage : ImageView){
        when(dice.roll()) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            else -> diceImage.setImageResource(R.drawable.dice_6)
        }
    }


}