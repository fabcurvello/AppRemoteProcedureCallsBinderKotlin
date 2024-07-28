package br.com.fabriciocurvello.appremoteprocedurecallsbinderkotlin

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection

import android.os.IBinder
import android.view.View



class MainActivity : AppCompatActivity() {

    private var mService: MyService? = null
    private var mBound = false

    lateinit var btnBindService: Button
    lateinit var tvMessage: TextView

    // Define callbacks para o service binding, passados para bindService()
    private val connection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            // Ligamos ao MyService, lançamos o IBinder e obtemos a instância do MyService
            val binder = service as MyService.LocalBinder
            mService = binder.getService()
            mBound = true
        }

        override fun onServiceDisconnected(arg0: ComponentName) {
            mBound = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnBindService = findViewById(R.id.btn_bind_service)
        tvMessage = findViewById(R.id.tv_message)

        btnBindService.setOnClickListener {
            if (mBound) {
                val message = mService?.getMessage()
                tvMessage.text = message
            }
        }
    }

    override fun onStart() {
        super.onStart()

        // Vincula ao LocalService
        Intent(this, MyService::class.java).also { intent ->
            bindService(intent, connection, Context.BIND_AUTO_CREATE)
        }
    }

    override fun onStop() {
        super.onStop()

        //Desvincula-se do serviço
        if (mBound) {
            unbindService(connection)
            mBound = false
        }
    }
}