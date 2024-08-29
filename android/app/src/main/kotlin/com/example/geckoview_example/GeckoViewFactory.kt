package com.example.geckoview_example

import android.content.Context
import android.view.View
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory
import org.mozilla.geckoview.GeckoRuntime
import org.mozilla.geckoview.GeckoSession
import org.mozilla.geckoview.GeckoView
import io.flutter.plugin.common.StandardMessageCodec

class GeckoViewFactory(private val context: Context) : PlatformViewFactory(StandardMessageCodec.INSTANCE) {
    override fun create(context: Context?, id: Int, args: Any?): PlatformView {
        return GeckoViewPlatformView(this.context)
    }
}

class GeckoViewPlatformView(private val context: Context) : PlatformView {
    private val geckoView: GeckoView = GeckoView(context)
    private val geckoSession: GeckoSession = GeckoSession()
    private val geckoRuntime: GeckoRuntime = GeckoRuntimeSingleton.getInstance(context)
    private val url: String = "https://example.com"

    init {
        geckoSession.open(geckoRuntime)
        geckoView.setSession(geckoSession)
        geckoSession.loadUri(url)
    }

    override fun getView(): View {
        return geckoView
    }

    override fun dispose() {
        geckoSession.close()
    }
}
