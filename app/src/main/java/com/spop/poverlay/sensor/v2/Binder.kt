package com.spop.poverlay.sensor.v2

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import timber.log.Timber
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

const val SERVICE_ACTION = "com.onepeloton.affernetservice.IBikeInterface"
private const val SERVICE_PACKAGE = "com.onepeloton.affernetservice"
private const val SERVICE_INTENT = "com.onepeloton.affernetservice.AffernetService"

suspend fun getV2Binder(context: Context) = suspendCoroutine<IBinder> { ctx ->
    context.bindService(
        Intent(SERVICE_INTENT).apply {
            setAction(SERVICE_ACTION)
            setPackage(SERVICE_PACKAGE)
        }, object : ServiceConnection {
            override fun onServiceConnected(p0: ComponentName?, iBinder: IBinder?) {
                Timber.i("sensor service connected $p0")
                if(iBinder == null){
                    Timber.i("sensor service resolution failed $p0")
                    ctx.resumeWithException(Exception("sensor service resolution failed"))
                }else{
                    ctx.resume(iBinder)
                }
            }

            override fun onBindingDied(name: ComponentName?) {
                super.onBindingDied(name)
                Timber.i("sensor service binding died $name")
            }
            override fun onNullBinding(name: ComponentName?) {
                Timber.i("sensor service null binding $name")
            }

            override fun onServiceDisconnected(p0: ComponentName?) {
                Timber.i("sensor service disconnected $p0")
            }

        }, Context.BIND_AUTO_CREATE)
}