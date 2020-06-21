package fr.dappli.sdk.core.di

import com.google.gson.Gson

interface BaseCoreComponent {
    fun gson(): Gson
}