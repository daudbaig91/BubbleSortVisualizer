package com.example.davisualiser

import android.content.Context
import android.util.Log
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class CodeSource {
    val bubleSortCode = arrayOf(
        arrayOf("do"), arrayOf(
            """  swapped = false

  for i = 1 to indexOfLastUnsortedElement-1""",
            "Checking if 32 > 20 and swap them if that is true; swapped = false."
        ), arrayOf(
            "    if leftElement > rightElement", """
     Set the swapped flag to false.
     Then iterate from index 1 to 13 inclusive.
     """.trimIndent()
        ), arrayOf(
            """      swap(leftElement, rightElement)

      swapped = true; ++swapCounter""",
            """
              Swapping the positions of 43 and 33 and set swapped = true.
              For inversion index: Add 1 to swapCounter, now = 11.
              """.trimIndent()
        ), arrayOf(
            "while swapped", """
     Mark this element as sorted now.
     As at least one swap is done in this pass, we continue.
     """.trimIndent()
        )
    )
    val selSortCode = arrayOf(
        arrayOf("repeat (numOfElements - 1) times\n" +
                "\n" +
                "  set the first unsorted element as the minimum\n" +
                "\n" +
                "  for each of the unsorted elements",
            "Iteration 2: Set 41 as the current minimum, then iterate through the remaining unsorted elements to find the true minimum."),
        arrayOf("    if element < currentMinimum","Check if 48 is smaller than the current minimum (41)."), arrayOf(
            "      set element as new minimum", "Set 19 as the new minimum.".trimIndent()), arrayOf( "  swap minimum with first unsorted position", "Swap the minimum (13) with the first unsorted element (41).".trimIndent()))
    val insSortCode = arrayOf(
        arrayOf("do"), arrayOf(
            """  swapped = false

  for i = 1 to indexOfLastUnsortedElement-1""",
            "Checking if 32 > 20 and swap them if that is true; swapped = false."
        ), arrayOf(
            "    if leftElement > rightElement", """
     Set the swapped flag to false.
     Then iterate from index 1 to 13 inclusive.
     """.trimIndent()
        ), arrayOf(
            """      swap(leftElement, rightElement)

      swapped = true; ++swapCounter""",
            """
              Swapping the positions of 43 and 33 and set swapped = true.
              For inversion index: Add 1 to swapCounter, now = 11.
              """.trimIndent()
        ), arrayOf(
            "while swapped", """
     Mark this element as sorted now.
     As at least one swap is done in this pass, we continue.
     """.trimIndent()
        )
    )
    val merSortCode = arrayOf(
        arrayOf("do"), arrayOf(
            """  swapped = false

  for i = 1 to indexOfLastUnsortedElement-1""",
            "Checking if 32 > 20 and swap them if that is true; swapped = false."
        ), arrayOf(
            "    if leftElement > rightElement", """
     Set the swapped flag to false.
     Then iterate from index 1 to 13 inclusive.
     """.trimIndent()
        ), arrayOf(
            """      swap(leftElement, rightElement)

      swapped = true; ++swapCounter""",
            """
              Swapping the positions of 43 and 33 and set swapped = true.
              For inversion index: Add 1 to swapCounter, now = 11.
              """.trimIndent()
        ), arrayOf(
            "while swapped", """
     Mark this element as sorted now.
     As at least one swap is done in this pass, we continue.
     """.trimIndent()
        )
    )

    fun createLinearCode(s: String?,context: Context, linearLayout: LinearLayout): LinearLayout {
        var textView:TextView
        var array:Array<Array<String>> = bubleSortCode

        if (s == "1") {
             array = bubleSortCode
        }
        else if (s == "2") {
            array = selSortCode
        }
        else if (s == "3") {
            array = insSortCode
        }
        else if (s == "4") {
            array = merSortCode
        }

        for (arr in array) {
            textView = TextView(context)
            textView.text = arr.get(0)

            linearLayout.addView(textView)
            Log.d("test", arr.get(0));
        }

        return linearLayout
    }
}