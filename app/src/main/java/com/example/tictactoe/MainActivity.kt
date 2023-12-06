package com.example.tictactoe

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var currentTurn = 1;
        var displayText = findViewById<TextView>(R.id.DisplayText)

        val TopLeft = findViewById<Button>(R.id.Board1)
        val TopMiddle = findViewById<Button>(R.id.Board2)
        val TopRight = findViewById<Button>(R.id.Board3)
        val MiddleLeft = findViewById<Button>(R.id.Board4)
        val Middle = findViewById<Button>(R.id.Board5)
        val MiddleRight = findViewById<Button>(R.id.Board6)
        val BottomLeft = findViewById<Button>(R.id.Board7)
        val BottomMiddle = findViewById<Button>(R.id.Board8)
        val BottomRight = findViewById<Button>(R.id.Board9)



        fun CheckBoard() : CharSequence? {
            if (TopLeft.text != ""){
                if (TopLeft.text.equals(TopMiddle.text) && TopMiddle.text.equals(TopRight.text)){
                    return TopLeft.text;
                }
                if (TopLeft.text.equals(Middle.text) && Middle.text.equals(BottomRight.text)){
                    return TopLeft.text;
                }
                if (TopLeft.text.equals(MiddleLeft.text) && MiddleLeft.text.equals(BottomLeft.text)){
                    return TopLeft.text;
                }
            }
            if (BottomRight.text != ""){
                if (BottomRight.text.equals(MiddleRight.text) && MiddleRight.text.equals(TopRight.text)){
                    return BottomRight.text;
                }
                if (BottomRight.text.equals(BottomMiddle.text) && BottomMiddle.text.equals(BottomLeft.text)){
                    return TopLeft.text;
                }
            }
            if (Middle.text != ""){
                if (MiddleLeft.text.equals(Middle.text) && Middle.text.equals(MiddleRight.text)){
                    return Middle.text;
                }
                if (TopMiddle.text.equals(Middle.text) && Middle.text.equals(BottomMiddle.text)){
                    return Middle.text;
                }
            }
            for (i in 1 until 10) {
                val buttonID = "Board$i"
                val resID = resources.getIdentifier(buttonID, "id", packageName)
                var boardButton = findViewById<Button>(resID)
                if (boardButton.text == ""){ //Check if there's a playable spot
                    return null;
                }
            }
            return "Over";
        }

        for (i in 1 until 10)
        {
            val buttonID = "Board$i"
            val resID = resources.getIdentifier(buttonID, "id", packageName)
            var boardButton = findViewById<Button>(resID)
            boardButton.setOnClickListener{
                if (boardButton.text != "X" && boardButton.text != "O"){
                    if (currentTurn == 1){
                        boardButton.setText("X")
                        displayText.setText("O's Turn")
                        currentTurn = 2
                    } else if (currentTurn == 2){
                        boardButton.setText("O")
                        displayText.setText("X's Turn")
                        currentTurn = 1
                    }
                    val Result = CheckBoard()

                    if (Result != null){
                        if (Result == "X"){
                            currentTurn = 0;
                            displayText.setText("X has won!");
                        } else if (Result == "O") {
                            currentTurn = 0;
                            displayText.setText("O has won!");
                        } else {
                            currentTurn = 0;
                            displayText.setText("No one wins!");
                        }
                    }
                }
            }
        }

        val newGame = findViewById<Button>(R.id.NewGame)
        newGame.setOnClickListener {
            for (i in 1 until 10)
            {
                val buttonID = "Board$i"
                val resID = resources.getIdentifier(buttonID, "id", packageName)
                var boardButton = findViewById<Button>(resID)
                boardButton.setText("")
                currentTurn = 1
                displayText.setText("X's Turn")
            }
        }
    }

}