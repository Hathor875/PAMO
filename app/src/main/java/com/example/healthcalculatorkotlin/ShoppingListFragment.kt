package com.example.healthcalculatorkotlin

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Fragment displaying a shopping list with checkable items.
 * Checked state is persisted via SharedPreferences across sessions.
 */
class ShoppingListFragment : Fragment() {

    private val shoppingItems = listOf(
        ShoppingItem("Kurczak pierś (500g)"),
        ShoppingItem("Ryż brązowy (1kg)"),
        ShoppingItem("Brokuły (1 szt.)"),
        ShoppingItem("Jajka (10 szt.)"),
        ShoppingItem("Twaróg chudy (200g)"),
        ShoppingItem("Oliwa z oliwek (500ml)"),
        ShoppingItem("Płatki owsiane (1kg)"),
        ShoppingItem("Banan (4 szt.)"),
        ShoppingItem("Jogurt naturalny (400g)"),
        ShoppingItem("Migdały (100g)"),
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_shopping_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvShoppingList)
        val prefs = requireContext().getSharedPreferences("shopping_list", Context.MODE_PRIVATE)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ShoppingAdapter(shoppingItems, prefs)
    }
}
