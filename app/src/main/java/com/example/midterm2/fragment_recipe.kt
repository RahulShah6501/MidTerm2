package com.example.midterm2


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class RecipeFragment : Fragment() {

    companion object {
        private const val ARG_CUISINE = "cuisine"

        fun newInstance(cuisine: String): RecipeFragment {
            val fragment = RecipeFragment()
            val args = Bundle()
            args.putString(ARG_CUISINE, cuisine)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recipe, container, false)
        val recipesTextView: TextView = view.findViewById(R.id.recipes_text_view)

        val cuisine = arguments?.getString(ARG_CUISINE) ?: ""
        val recipes = getRecipesForCuisine(cuisine)
        recipesTextView.text = recipes.joinToString("\n")

        return view
    }

    private fun getRecipesForCuisine(cuisine: String): List<String> {
        return when (cuisine) {
            "Italian" -> listOf("Spaghetti Carbonara", "Margherita Pizza", "Lasagna")
            "Chinese" -> listOf("Kung Pao Chicken", "Spring Rolls", "Sweet and Sour Pork")
            "Mexican" -> listOf("Tacos", "Guacamole", "Quesadillas")
            "Indian" -> listOf("Butter Chicken", "Palak Paneer", "Chole Bhature")
            else -> listOf("No recipes available")
        }
    }
}
