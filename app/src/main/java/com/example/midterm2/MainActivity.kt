package com.example.midterm2


import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var cuisineSpinner: Spinner
    private lateinit var findRecipesButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cuisineSpinner = findViewById(R.id.cuisine_spinner)
        findRecipesButton = findViewById(R.id.find_recipes_button)

        val cuisines = arrayOf("Italian", "Chinese", "Mexican", "Indian")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, cuisines)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        cuisineSpinner.adapter = adapter

        // Retrieve data from intent
        val cuisineType = intent.getStringExtra("cuisineType")
        if (cuisineType != null) {
            val position = cuisines.indexOf(cuisineType)
            if (position >= 0) {
                cuisineSpinner.setSelection(position)
            }
        }

        cuisineSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // Handle selection
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Handle no selection
            }
        }

        findRecipesButton.setOnClickListener {
            val selectedCuisine = cuisineSpinner.selectedItem.toString()
            val fragment = RecipeFragment.newInstance(selectedCuisine)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
        }
    }
}
