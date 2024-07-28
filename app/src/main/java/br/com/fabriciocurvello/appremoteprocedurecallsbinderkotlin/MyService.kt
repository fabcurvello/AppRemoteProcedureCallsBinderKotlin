package br.com.fabriciocurvello.appremoteprocedurecallsbinderkotlin

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.Binder

class MyService : Service() {

    // Binder entregue aos clientes
    private val binder = LocalBinder()
    private var cont = 0

    // Classe utilizada para o cliente Binder
    inner class LocalBinder : Binder() {
        fun getService(): MyService = this@MyService
    }

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    // Uma função simples que os clientes podem chamar
    fun getMessage(): String {
        cont++
        return "Hello from the Service! Counter: $cont"
    }
}