package com.example.healthcalculatorkotlin

/**
 * Represents a single item on the shopping list.
 *
 * @property name display name of the item
 * @property isChecked whether the item has been purchased
 */
data class ShoppingItem(val name: String, var isChecked: Boolean = false)
