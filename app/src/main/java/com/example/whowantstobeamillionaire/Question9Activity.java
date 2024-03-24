package com.example.whowantstobeamillionaire;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.graphics.Typeface;

public class Question9Activity extends AppCompatActivity {
    private int moneyEarned = 500000; // Starting amount of money earned

    private static final String CORRECT_ANSWER = "Mount Everest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question9);

        // Initialize UI elements
        RadioGroup optionsRadioGroup = findViewById(R.id.optionsRadioGroup);
        TextView questionTextView = findViewById(R.id.questionTextView);
        TextView moneyTextView = findViewById(R.id.moneyTextView);


        // Create AlphaAnimation for blinking effect
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500); // Duration of each cycle in milliseconds
        anim.setRepeatMode(Animation.REVERSE); // Reverse the animation when it reaches the end
        anim.setRepeatCount(Animation.INFINITE); // Repeat the animation infinitely

        // Set the animation to the TextView
        moneyTextView.startAnimation(anim);

        // Display the current amount of money earned at the top of the question
        updateMoneyEarnedText(moneyTextView);

        // Set click listener for confirm button
        findViewById(R.id.confirmButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton selectedRadioButton = findViewById(optionsRadioGroup.getCheckedRadioButtonId());
                if (selectedRadioButton != null) {
                    checkAnswer(selectedRadioButton.getText().toString());
                } else {
                    Toast.makeText(Question9Activity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Method to update the money earned text
    private void updateMoneyEarnedText(TextView moneyTextView) {
        String moneyEarnedText = "Money Earned: $" + moneyEarned;
        moneyTextView.setText(moneyEarnedText);

    }

    // Method to check the selected answer
    private void checkAnswer(String selectedAnswer) {
        if (selectedAnswer.equals(CORRECT_ANSWER)) {
            // Increase the money earned and update the display
            moneyEarned += 250000;
            TextView moneyTextView = findViewById(R.id.moneyTextView);
            updateMoneyEarnedText(moneyTextView);

            // Show toast for correct answer
            Toast.makeText(this, "Correct! You earned $"+moneyEarned, Toast.LENGTH_SHORT).show();

            // Move to the next question
            startActivity(new Intent(Question9Activity.this, Question10Activity.class));
            finish(); // Close this activity
        } else {
            // Show toast for wrong answer
            Toast.makeText(this, "Incorrect Answer!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Question9Activity.this, GameLostActivity.class));
            finish();
        }
    }

}
