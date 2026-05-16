package com.example.healthcalculatorkotlin

import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView

/**
 * RecyclerView adapter for the shopping list.
 * Persists checked state to [SharedPreferences] on every change.
 *
 * @param items list of shopping items to display
 * @param prefs SharedPreferences instance used to persist checked state
 */
class ShoppingAdapter(
    private val items: List<ShoppingItem>,
    private val prefs: SharedPreferences
) : RecyclerView.Adapter<ShoppingAdapter.ViewHolder>() {

    private val checked: MutableSet<String> =
        prefs.getStringSet("checked_items", emptySet())!!.toMutableSet()

    init {
        items.forEach { it.isChecked = checked.contains(it.name) }
    }

    /** Holds a reference to the checkbox view for a single list row. */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val checkBox: CheckBox = view.findViewById(R.id.cbItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shopping, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.checkBox.text = item.name
        holder.checkBox.isChecked = item.isChecked
        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            item.isChecked = isChecked
            if (isChecked) checked.add(item.name) else checked.remove(item.name)
            prefs.edit().putStringSet("checked_items", checked).apply()
        }
    }

    override fun getItemCount() = items.size
}
