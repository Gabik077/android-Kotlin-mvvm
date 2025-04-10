package com.cursoandroidm2

import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import java.util.Locale

class Utils {

    companion object {
        fun setLanguage(language: String) {
            AppCompatDelegate.setApplicationLocales(
                LocaleListCompat.create(Locale.forLanguageTag(language))
            )

        }
    }
}