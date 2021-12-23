package br.com.dio.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.dio.motivation.R
import br.com.dio.motivation.infra.MotivationConstants
import br.com.dio.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash2.*

class SplashActivity2 : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash2)

        buttonSave.setOnClickListener(this)

        mSecurityPreferences = SecurityPreferences(this)

    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonSave) {
            handleSave()
        }

    }

    private fun handleSave() {

        val name = editName.text.toString()
        if (name != "") {
            mSecurityPreferences.storeString(
                MotivationConstants.KEY.PERSON_NAME,
                name
            ) // salvando a string, como em um BD
            startActivity(
                Intent(
                    this,
                    MainActivity::class.java
                )
            )// Uma intenção de fazer algo após apertar o botão. No caso, muda para a tela do MainActivity

        } else {
            Toast.makeText(this, "Informe um nome!", Toast.LENGTH_SHORT).show()
        }
    }

}