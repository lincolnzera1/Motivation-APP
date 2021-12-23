package br.com.dio.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.dio.motivation.R
import br.com.dio.motivation.infra.MotivationConstants
import br.com.dio.motivation.infra.SecurityPreferences
import br.com.dio.motivation.repository.Mock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurityPreferences: SecurityPreferences
    private var mphraseFilter: Int = MotivationConstants.PHRASEFILTER.ALL


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonNewPhrase.setOnClickListener(this)
        imageInfinito.setOnClickListener(this)
        imageHappy.setOnClickListener(this)
        imageSun.setOnClickListener(this)

        mSecurityPreferences = SecurityPreferences(this)
        textName.text =
            "Olá, ${mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)}"
        imageInfinito.setColorFilter(resources.getColor(R.color.purple_200))
        handleNewPhrase()


    }

    override fun onClick(view: View) {
        val id = view.id
        val listFilter = listOf(R.id.imageInfinito, R.id.imageHappy, R.id.imageSun)

        if (id == R.id.buttonNewPhrase) {
            handleNewPhrase()
        } else if (id in listFilter) {
            handleFilter(id)
        }
    }


    private fun handleFilter(id: Int) {

        imageInfinito.setColorFilter(resources.getColor(R.color.white))
        imageHappy.setColorFilter(resources.getColor(R.color.white))
        imageSun.setColorFilter(resources.getColor(R.color.white))

        when (id) {
            R.id.imageInfinito -> {
                imageInfinito.setColorFilter(resources.getColor(R.color.purple_200))
                mphraseFilter = MotivationConstants.PHRASEFILTER.ALL
            }
            R.id.imageHappy -> {
                imageHappy.setColorFilter(resources.getColor(R.color.purple_200))
                mphraseFilter = MotivationConstants.PHRASEFILTER.HAPPY
            }
            R.id.imageSun -> {
                imageSun.setColorFilter(resources.getColor(R.color.purple_200))
                mphraseFilter = MotivationConstants.PHRASEFILTER.SUN
            }
        }
    }

    private fun handleNewPhrase() {
        textCenter.text = Mock().getPhrase(mphraseFilter)
    }


}