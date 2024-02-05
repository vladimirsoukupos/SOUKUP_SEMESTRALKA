package com.example.soukup_semestralka


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*
// Importování potřebných tříd pro práci s Androidem a ukládáním dat (kontext, preference, atd.).

// Definice třídy `sekce1`, která je potomkem `AppCompatActivity` pro správné chování v rámci životního cyklu aktivity.
class sekce1 : AppCompatActivity() {
    private lateinit var editTextInput: EditText
    private lateinit var buttonSubmit: Button
    private lateinit var textViewDisplay: TextView
    // Deklarace tří privátních proměnných, které reprezentují ovládací prvky v XML layoutu (EditText, Button, TextView)

    companion object {
        private const val PREFS_NAME = "MyPrefs"
        private const val KEY_TEXT = "sekce1_text"
    }
    // Definice companion objectu, který obsahuje konstanty pro název souboru s nastaveními (SharedPreferences) a klíč pro uložení textu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.prvni_sekce)
        // Přepsání metody `onCreate`, která se volá při vytváření aktivity. Nastavuje layout pro tuto aktivitu

        editTextInput = findViewById(R.id.editTextInput)
        buttonSubmit = findViewById(R.id.buttonSubmit)
        textViewDisplay = findViewById(R.id.textViewDisplay)
        // Přiřazení ovládacích prvků z layoutu k příslušným proměnným.

        buttonSubmit.setOnClickListener {
            // Při stisknutí tlačítka "Odeslat" se provede následující kód:
            val newText = editTextInput.text.toString()
            // Získání textu z pole EditText.
            val existingText = textViewDisplay.text.toString()
            // Získání existujícího textu z pole TextView.
            val combinedText = if (existingText.isNotEmpty()) "$newText\n\n$existingText" else newText
            // Kombinace nového textu a existujícího textu, odděleného novým řádkem, pokud existuje nějaký existující text. // Kombinace nového textu a existujícího textu, odděleného novým řádkem, pokud existuje nějaký existující text.

            textViewDisplay.text = combinedText
            // Nastavení kombinovaného textu do pole TextView.
            saveTextToSharedPreferences(combinedText, KEY_TEXT)
            // Uložení kombinovaného textu do SharedPreferences pro pozdější načtení.

            editTextInput.text.clear()
            // Vyčištění obsahu pole EditText.
        }

        val savedText = loadTextFromSharedPreferences(KEY_TEXT)
        textViewDisplay.text = savedText
        // Načtení uloženého textu z SharedPreferences a nastavení do pole TextView při vytváření aktivity.

        val backButton: Button = findViewById(R.id.backButton)
        // Přiřazení tlačítka pro zpětnou navigaci (zde není obsaženo v XML layoutu).

        backButton.setOnClickListener {
            // Při stisknutí tlačítka zpětné navigace se ukončí aktuální aktivita (vrátí se na předchozí obrazovku nebo ukončí aplikace).
            finish()
        }

        // Zakázání možnosti editace textu v TextView
        textViewDisplay.isClickable = false
        textViewDisplay.isFocusable = false
        textViewDisplay.isLongClickable = false

    }


    private fun saveTextToSharedPreferences(text: String, key: String) {
        // Metoda pro uložení textu do SharedPreferences.

        val sharedPreferences: SharedPreferences = getSharedPreferences()
        // Získání instance SharedPreferences pro nastavení.

        val editor = sharedPreferences.edit()
        // Získání editoru pro provedení změn v SharedPreferences.

        editor.putString(key, text)
        // Uložení textu pod klíčem do SharedPreferences.

        editor.apply()
        // Potvrzení provedených změn.
    }


    private fun loadTextFromSharedPreferences(key: String): String {
        // Metoda pro načtení textu z SharedPreferences.

        val sharedPreferences: SharedPreferences = getSharedPreferences()
        // Získání instance SharedPreferences pro čtení.

        return sharedPreferences.getString(key, "") ?: ""
        // Načtení textu pod klíčem z SharedPreferences. Pokud klíč neexistuje, vrací se prázdný řetězec.
    }


    private fun getSharedPreferences(): SharedPreferences {
        // Metoda pro získání instance SharedPreferences s názvem "MyPrefs" a režimem Context.MODE_PRIVATE.
        return getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }
}
