package com.example.canteensystem.meal;

import javax.persistence.*;

@Entity
@Table
public class Meal {

    @Id
    @SequenceGenerator(
            name = "meal_sequence",
            sequenceName = "meal_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "meal_sequence"
    )
    private Integer mealId;

    @Column(nullable = false)
    private String mealName;

    @Column(nullable = false)
    private String amount;

    @Column(nullable = true)
    private String allergy;


    public Meal() {
    }


    public Meal(String mealName, String amount, String allergy) {
        this.mealName = mealName;
        this.amount = amount;
        this.allergy = allergy;
    }

    public Meal(Integer mealId, String mealName, String amount, String allergy) {
        this.mealId = mealId;
        this.mealName = mealName;
        this.amount = amount;
        this.allergy = allergy;
    }


    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }





    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "mealId=" + mealId +
                ", mealName='" + mealName + '\'' +
                ", amount=" + amount +
                ", allergy='" + allergy + '\'' +
                '}';
    }
}
