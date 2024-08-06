package com.guodong.uniappx.offline

import android.util.Log
import io.dcloud.uniapp.UniApplication
import io.dcloud.uniapp.UniSDKEngine
import io.dcloud.uniapp.ui.component.IComponent
import io.dcloud.uts.UTSAndroidHookProxy

class App : UniApplication() {

    private val TAG = "App"

    override fun onCreate() {
        super.onCreate()
        register()
    }

    private fun register() {
        try {
            registerComponents("video", "uts.sdk.modules.DCloudUniVideo.VideoComponent")
        } catch (e: Exception) {
            Log.e(TAG, "register: 无法注册 video 组件", e)
        }

        try {
            registerHooksClass("uts.sdk.modules.zlText.ZlTextHook")
        } catch (e: Exception) {
            Log.e(TAG, "register: 无法注册 ZlTextHook 生命周期监听函数", e)
        }
    }

    /**
     * "name": 对应 buildConfigField UTSRegisterComponents 配置中的 name
     * "className": 对应 buildConfigField UTSRegisterComponents 配置中的 class
     */
    @Throws(ClassNotFoundException::class)
    private fun registerComponents(name: String, className: String) {
        UniSDKEngine.registerUniComponent(name, Class.forName(className) as Class<out IComponent>)
    }

    /**
     * "className": 对应 buildConfigField UTSHooksClassArray 配置中的值
     */
    @Throws(ClassNotFoundException::class)
    private fun registerHooksClass(className: String) {
        // 注册应用程序生命周期监听函数
        val instance = Class.forName(className).newInstance()
        if (instance is UTSAndroidHookProxy) {
            instance.onCreate(this)
        }
    }
}