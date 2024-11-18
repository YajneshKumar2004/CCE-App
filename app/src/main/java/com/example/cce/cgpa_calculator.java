package com.example.cce;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class cgpa_calculator extends Fragment {

    public cgpa_calculator() {
        // Required empty public constructor
    }

    Button button;
    EditText sub1_credit, sub2_credit, sub3_credit, sub4_credit, sub5_credit, sub6_credit, sub7_credit, sub8_credit;
    EditText sub1_grade, sub2_grade, sub3_grade, sub4_grade, sub5_grade, sub6_grade, sub7_grade, sub8_grade;
    TextView cgpa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cgpa_calculator, container, false);

        // Binding UI elements
        button = view.findViewById(R.id.button);
        sub1_credit = view.findViewById(R.id.sub1_credit);
        sub2_credit = view.findViewById(R.id.sub2_credit);
        sub3_credit = view.findViewById(R.id.sub3_credit);
        sub4_credit = view.findViewById(R.id.sub4_credit);
        sub5_credit = view.findViewById(R.id.sub5_credit);
        sub6_credit = view.findViewById(R.id.sub6_credit);
        sub7_credit = view.findViewById(R.id.sub7_credit);
        sub8_credit = view.findViewById(R.id.sub8_credit);

        sub1_grade = view.findViewById(R.id.sub1_grade);
        sub2_grade = view.findViewById(R.id.sub2_grade);
        sub3_grade = view.findViewById(R.id.sub3_grade);
        sub4_grade = view.findViewById(R.id.sub4_grade);
        sub5_grade = view.findViewById(R.id.sub5_grade);
        sub6_grade = view.findViewById(R.id.sub6_grade);
        sub7_grade = view.findViewById(R.id.sub7_grade);
        sub8_grade = view.findViewById(R.id.sub8_grade);

        cgpa = view.findViewById(R.id.text_cgpa);

        // Setting up the button click listener to calculate CGPA
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Try-catch to handle empty or invalid input
                try {
                    // Fetching the inputs for credits and grade points
                    double[] credits = {
                            Double.parseDouble(sub1_credit.getText().toString()),
                            Double.parseDouble(sub2_credit.getText().toString()),
                            Double.parseDouble(sub3_credit.getText().toString()),
                            Double.parseDouble(sub4_credit.getText().toString()),
                            Double.parseDouble(sub5_credit.getText().toString()),
                            Double.parseDouble(sub6_credit.getText().toString()),
                            Double.parseDouble(sub7_credit.getText().toString()),
                            Double.parseDouble(sub8_credit.getText().toString())
                    };

                    double[] grades = {
                            Double.parseDouble(sub1_grade.getText().toString()),
                            Double.parseDouble(sub2_grade.getText().toString()),
                            Double.parseDouble(sub3_grade.getText().toString()),
                            Double.parseDouble(sub4_grade.getText().toString()),
                            Double.parseDouble(sub5_grade.getText().toString()),
                            Double.parseDouble(sub6_grade.getText().toString()),
                            Double.parseDouble(sub7_grade.getText().toString()),
                            Double.parseDouble(sub8_grade.getText().toString())
                    };

                    // Calculating total credits and weighted grade points
                    double totalCredits = 0, totalGradePoints = 0;
                    for (int i = 0; i < credits.length; i++) {
                        totalCredits += credits[i];
                        totalGradePoints += credits[i] * grades[i];
                    }

                    // Calculating CGPA
                    double cgpaResult = totalGradePoints / totalCredits;

                    // Displaying the CGPA
                    cgpa.setText(String.format("Your CGPA is: %.2f", cgpaResult));
                } catch (NumberFormatException e) {
                    Toast.makeText(requireContext(), "Please enter valid numbers", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
