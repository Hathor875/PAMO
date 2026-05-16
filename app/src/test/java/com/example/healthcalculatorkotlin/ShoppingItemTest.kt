package com.example.healthcalculatorkotlin

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ShoppingItemTest {

    @Test
    fun default_state_is_unchecked() {
        val item = ShoppingItem("Kurczak")
        assertFalse(item.isChecked)
    }

    @Test
    fun item_can_be_checked() {
        val item = ShoppingItem("Kurczak")
        item.isChecked = true
        assertTrue(item.isChecked)
    }

    @Test
    fun item_can_be_unchecked_after_checking() {
        val item = ShoppingItem("Kurczak", isChecked = true)
        item.isChecked = false
        assertFalse(item.isChecked)
    }

    @Test
    fun items_with_same_name_are_equal() {
        val item1 = ShoppingItem("Kurczak")
        val item2 = ShoppingItem("Kurczak")
        assertEquals(item1, item2)
    }

    @Test
    fun items_with_different_names_are_not_equal() {
        val item1 = ShoppingItem("Kurczak")
        val item2 = ShoppingItem("Ryż")
        assertFalse(item1 == item2)
    }
}
