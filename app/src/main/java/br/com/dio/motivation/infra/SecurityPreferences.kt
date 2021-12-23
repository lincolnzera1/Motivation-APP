package br.com.dio.motivation.infra

import android.content.Context
import java.nio.channels.spi.AbstractSelectionKey

class SecurityPreferences(context: Context) { // classe criada, com atribuito do tipo contexto.

    // shared vai salvar pequenos dados, como um BD.
    private val mSharedPreferences =
        context.getSharedPreferences("motivation",Context.MODE_PRIVATE)

    fun storeString(key: String, value: String){
        mSharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String): String {
        return mSharedPreferences.getString(key, "") ?: ""

    }

}