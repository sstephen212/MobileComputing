package com.example.mobcomp

import android.app.Application

class MobCompApplication: Application() {
    override fun onCreate(){
        super.onCreate()
        Graph.provide(this)
    }
}