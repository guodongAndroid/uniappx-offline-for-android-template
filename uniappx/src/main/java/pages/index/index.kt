@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME")
package uni.UNI2A7E9F3;
import io.dcloud.uniapp.*;
import io.dcloud.uniapp.extapi.*;
import io.dcloud.uniapp.framework.*;
import io.dcloud.uniapp.runtime.*;
import io.dcloud.uniapp.vue.*;
import io.dcloud.uniapp.vue.shared.*;
import io.dcloud.uts.*;
import io.dcloud.uts.Map;
import io.dcloud.uts.Set;
import io.dcloud.uts.UTSAndroid;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.async;
open class GenPagesIndexIndex : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onLoad(fun(_: OnLoadOptions) {}, instance);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("view", null, utsArrayOf(
            createElementVNode("image", utsMapOf("class" to "logo", "src" to "/static/logo.png")),
            createElementVNode("view", utsMapOf("class" to "text-area"), utsArrayOf(
                createElementVNode("text", utsMapOf("class" to "title"), toDisplayString(_ctx.title), 1),
                createElementVNode("text", utsMapOf("class" to "title"), "uni-app x offline for android")
            )),
            createElementVNode("video", utsMapOf("controls" to "true", "show-fullscreen-btn" to "true", "show-center-play-btn" to "true", "show-play-btn" to "true", "show-progress" to "true", "src" to "https://pan.sunxiaodou.com/api/raw/?path=/%E5%AD%A6%E4%B9%A0%E6%97%A5%E8%AE%B0/Spring/07-Spring-Bean%E7%9A%84%E5%90%8E%E7%BD%AE%E5%A4%84%E7%90%86%E5%99%A8.mp4"))
        ));
    }
    open var title: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("title" to "Hello");
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ), utsArrayOf(
                    GenApp.styles
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("logo" to padStyleMapOf(utsMapOf("height" to 100, "width" to 100, "marginTop" to 100, "marginRight" to "auto", "marginBottom" to 25, "marginLeft" to "auto")), "title" to padStyleMapOf(utsMapOf("fontSize" to 18, "color" to "#8f8f94", "textAlign" to "center")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}