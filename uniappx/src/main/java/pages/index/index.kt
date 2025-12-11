@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI2A7E9F3
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlin.properties.Delegates
open class GenPagesIndexIndex : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onLoad(fun(_: OnLoadOptions) {}, __ins)
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this
        val _cache = this.`$`.renderCache
        return _cE("view", null, _uA(
            _cE("image", _uM("class" to "logo", "src" to "/static/logo.png")),
            _cE("view", _uM("class" to "text-area"), _uA(
                _cE("text", _uM("class" to "title"), _tD(_ctx.title), 1),
                _cE("text", _uM("class" to "title"), "uni-app x offline for android")
            )),
            _cE("video", _uM("controls" to "true", "show-fullscreen-btn" to "true", "show-center-play-btn" to "true", "show-play-btn" to "true", "show-progress" to "true", "src" to "https://qiniu-web-assets.dcloud.net.cn/video/sample/2minute-demo.mp4"))
        ))
    }
    open var title: String by `$data`
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return _uM("title" to "Hello")
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ), _uA(
                GenApp.styles
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("logo" to _pS(_uM("height" to 100, "width" to 100, "marginTop" to 100, "marginRight" to "auto", "marginBottom" to 25, "marginLeft" to "auto")), "title" to _pS(_uM("fontSize" to 18, "color" to "#8f8f94", "textAlign" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
