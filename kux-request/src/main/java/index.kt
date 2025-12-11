@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uts.sdk.modules.kuxRequest
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import io.dcloud.uniapp.extapi.request as uni_request
open class UseOptions (
    @JsonNotNull
    open var baseURL: String,
    open var query: UTSJSONObject? = null,
    open var data: Any? = null,
    open var header: UTSJSONObject? = null,
    open var timeout: Number? = null,
    open var dataType: String? = null,
    open var responseType: String? = null,
    open var sslVerify: Boolean? = null,
    open var withCredentials: Boolean? = null,
    open var firstIpv4: Boolean? = null,
    open var filterRequest: Boolean? = null,
    open var debug: Boolean? = null,
    open var xhrCode: Any? = null,
    open var xhrCodeName: String? = null,
    open var xhrMessageName: String? = null,
    open var openCache: Boolean? = null,
    open var maxCacheSize: Number? = null,
    open var xhrResponse: Boolean? = null,
) : UTSObject()
open class RequestConfig (
    open var baseURL: String? = null,
    open var url: String? = null,
    open var query: UTSJSONObject? = null,
    open var data: Any? = null,
    open var header: UTSJSONObject? = null,
    open var method: RequestMethod? = null,
    open var timeout: Number? = null,
    open var dataType: String? = null,
    open var responseType: String? = null,
    open var sslVerify: Boolean? = null,
    open var withCredentials: Boolean? = null,
    open var firstIpv4: Boolean? = null,
    open var filterRequest: Boolean? = null,
    open var debug: Boolean? = null,
    open var xhrCode: Any? = null,
    open var xhrCodeName: String? = null,
    open var xhrMessageName: String? = null,
    open var openCache: Boolean? = null,
    open var maxCacheSize: Number? = null,
    open var xhrResponse: Boolean? = null,
    open var customData: Any? = null,
    open var needRequestInterceptor: Boolean? = null,
    open var needResponseInterceptor: Boolean? = null,
) : UTSObject()
typealias RequestInterceptor = (options: RequestConfig) -> RequestConfig
typealias RequestInterceptorSync = (options: RequestConfig) -> UTSPromise<RequestConfig>
typealias RequestRejectInterceptor = (options: RequestConfig, reject: (reason: Any) -> Unit) -> RequestConfig
typealias RequestRejectInterceptorSync = (options: RequestConfig, reject: (reason: Any) -> Unit) -> UTSPromise<RequestConfig>
typealias ResponseInterceptor = (response: Any) -> Any
typealias ResponseInterceptorSync = (response: Any) -> UTSPromise<Any>
typealias ResponseXhrInterceptor = (response: RequestSuccess<Any>) -> Any
typealias ResponseRejectInterceptor = (response: RequestSuccess<Any>, reject: (reason: Any) -> Unit) -> Any
typealias ResponseFailInterceptor = (fail: RequestFail, reject: (reason: Any) -> Unit) -> Unit
typealias RequestFailCallback = (fail: RequestFail) -> Unit
open class Interceptors (
    @JsonNotNull
    open var request: UTSArray<RequestInterceptor>,
    @JsonNotNull
    open var requestReject: UTSArray<RequestRejectInterceptor>,
    @JsonNotNull
    open var response: UTSArray<ResponseInterceptor>,
    @JsonNotNull
    open var responseXhr: UTSArray<ResponseXhrInterceptor>,
    @JsonNotNull
    open var responseReject: UTSArray<ResponseRejectInterceptor>,
    open var requestSync: RequestInterceptorSync? = null,
    open var requestRejectSync: RequestRejectInterceptorSync? = null,
    open var responseSync: ResponseInterceptorSync? = null,
    @JsonNotNull
    open var responseFail: UTSArray<ResponseFailInterceptor>,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return InterceptorsReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class InterceptorsReactiveObject : Interceptors, IUTSReactive<Interceptors> {
    override var __v_raw: Interceptors
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: Interceptors, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(request = __v_raw.request, requestReject = __v_raw.requestReject, response = __v_raw.response, responseXhr = __v_raw.responseXhr, responseReject = __v_raw.responseReject, requestSync = __v_raw.requestSync, requestRejectSync = __v_raw.requestRejectSync, responseSync = __v_raw.responseSync, responseFail = __v_raw.responseFail) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): InterceptorsReactiveObject {
        return InterceptorsReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var request: UTSArray<RequestInterceptor>
        get() {
            return _tRG(__v_raw, "request", __v_raw.request, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("request")) {
                return
            }
            val oldValue = __v_raw.request
            __v_raw.request = value
            _tRS(__v_raw, "request", oldValue, value)
        }
    override var requestReject: UTSArray<RequestRejectInterceptor>
        get() {
            return _tRG(__v_raw, "requestReject", __v_raw.requestReject, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("requestReject")) {
                return
            }
            val oldValue = __v_raw.requestReject
            __v_raw.requestReject = value
            _tRS(__v_raw, "requestReject", oldValue, value)
        }
    override var response: UTSArray<ResponseInterceptor>
        get() {
            return _tRG(__v_raw, "response", __v_raw.response, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("response")) {
                return
            }
            val oldValue = __v_raw.response
            __v_raw.response = value
            _tRS(__v_raw, "response", oldValue, value)
        }
    override var responseXhr: UTSArray<ResponseXhrInterceptor>
        get() {
            return _tRG(__v_raw, "responseXhr", __v_raw.responseXhr, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("responseXhr")) {
                return
            }
            val oldValue = __v_raw.responseXhr
            __v_raw.responseXhr = value
            _tRS(__v_raw, "responseXhr", oldValue, value)
        }
    override var responseReject: UTSArray<ResponseRejectInterceptor>
        get() {
            return _tRG(__v_raw, "responseReject", __v_raw.responseReject, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("responseReject")) {
                return
            }
            val oldValue = __v_raw.responseReject
            __v_raw.responseReject = value
            _tRS(__v_raw, "responseReject", oldValue, value)
        }
    override var responseFail: UTSArray<ResponseFailInterceptor>
        get() {
            return _tRG(__v_raw, "responseFail", __v_raw.responseFail, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("responseFail")) {
                return
            }
            val oldValue = __v_raw.responseFail
            __v_raw.responseFail = value
            _tRS(__v_raw, "responseFail", oldValue, value)
        }
}
open class FilterOptions (
    open var debug: Boolean? = null,
) : UTSObject()
typealias PendingRequests = Map<String, UTSPromise<Any>>
open class UseRetryOptions (
    open var maxRetryCount: Number? = null,
    open var initialDelay: Number? = null,
    open var maxDelay: Number? = null,
) : UTSObject()
typealias KuxErrorCode = Number
open class ExecuteBatchRequestResult (
    open var value: Any? = null,
    open var error: Any? = null,
) : UTSObject()
interface KuxRequestFail : IUniError {
    override var errCode: Number
}
interface IRequest {
    fun getKey(url: String, options: RequestConfig): String
    fun clearCache(key: String): IRequest
    fun cache(key: String): IRequest
    fun overrideConfig(config: RequestConfig): IRequest
    fun request(url: String, options: RequestConfig): UTSPromise<Any>
    fun get(url: String, options: RequestConfig): UTSPromise<Any>
    fun post(url: String, options: RequestConfig): UTSPromise<Any>
    fun put(url: String, options: RequestConfig): UTSPromise<Any>
    fun `delete`(url: String, options: RequestConfig): UTSPromise<Any>
    fun abort()
}
interface IInterceptorManager {
    fun useRequest(interceptor: RequestInterceptor): IInterceptorManager
    fun useRequestSync(interceptor: RequestInterceptorSync): IInterceptorManager
    fun useResponse(interceptor: ResponseInterceptor): IInterceptorManager
    fun useResponseXhr(interceptor: ResponseXhrInterceptor): IInterceptorManager
}
interface IRequestFilters {
    fun filterRequest(url: String, options: RequestConfig, request: () -> UTSPromise<Any>): UTSPromise<Any>
}
interface IURLSearchParams {
    fun get(key: String): String?
}
interface IURL {
    var protocol: String
    var host: String
    var pathname: String
    var search: String
    var searchParams: IURLSearchParams
    fun href(): String
}
interface IUtils {
    fun objToQueryString(queryObj: UTSJSONObject): String
    fun sleep(ms: Number): UTSPromise<Any>
    fun deepMerge(target: Any, source: Any): Any
}
interface IRetryManager {
    fun sendRequest(url: String, options: RequestConfig?): UTSPromise<Any>
}
interface IBatchRequestManager {
    fun addRequest(request: UTSPromise<Any>): UTSPromise<Any>
    fun addBatchRequest(requests: UTSArray<UTSPromise<Any>>): UTSArray<UTSPromise<Any>>
    fun executeBatch(): UTSPromise<UTSArray<Any>>
}
open class State (
    @JsonNotNull
    open var interceptors: Interceptors,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return StateReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class StateReactiveObject : State, IUTSReactive<State> {
    override var __v_raw: State
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: State, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(interceptors = __v_raw.interceptors) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): StateReactiveObject {
        return StateReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var interceptors: Interceptors
        get() {
            return _tRG(__v_raw, "interceptors", __v_raw.interceptors, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("interceptors")) {
                return
            }
            val oldValue = __v_raw.interceptors
            __v_raw.interceptors = value
            _tRS(__v_raw, "interceptors", oldValue, value)
        }
}
val state = reactive(State(interceptors = Interceptors(request = _uA(), requestReject = _uA(), response = _uA(), responseXhr = _uA(), responseReject = _uA(), requestSync = null, requestRejectSync = null, responseSync = null, responseFail = _uA())))
val getState = fun(): State {
    return state
}
val setInterceptors = fun(interceptors: Interceptors){
    state.interceptors = interceptors
}
open class InterceptorManager {
    private var interceptors: Interceptors
    constructor(){
        this.interceptors = Interceptors(request = _uA<RequestInterceptor>(), requestReject = _uA<RequestRejectInterceptor>(), response = _uA<ResponseInterceptor>(), responseXhr = _uA<ResponseXhrInterceptor>(), responseReject = _uA<ResponseRejectInterceptor>(), responseFail = _uA<ResponseFailInterceptor>(), requestSync = null, requestRejectSync = null, responseSync = null)
    }
    open fun useRequest(interceptor: RequestInterceptor): InterceptorManager {
        this.interceptors.request.push(interceptor)
        setInterceptors(this.interceptors)
        return this
    }
    open fun useRequestReject(interceptor: RequestRejectInterceptor): InterceptorManager {
        this.interceptors.requestReject.push(interceptor)
        setInterceptors(this.interceptors)
        return this
    }
    open fun useRequestSync(interceptor: RequestInterceptorSync): InterceptorManager {
        this.interceptors.requestSync = interceptor
        setInterceptors(this.interceptors)
        return this
    }
    open fun useRequestRejectSync(interceptor: RequestRejectInterceptorSync): InterceptorManager {
        this.interceptors.requestRejectSync = interceptor
        setInterceptors(this.interceptors)
        return this
    }
    open fun useResponse(interceptor: ResponseInterceptor): InterceptorManager {
        this.interceptors.response.push(interceptor)
        setInterceptors(this.interceptors)
        return this
    }
    open fun useResponseXhr(interceptor: ResponseXhrInterceptor): InterceptorManager {
        this.interceptors.responseXhr.push(interceptor)
        setInterceptors(this.interceptors)
        return this
    }
    open fun useResponseReject(interceptor: ResponseRejectInterceptor): InterceptorManager {
        this.interceptors.responseReject.push(interceptor)
        setInterceptors(this.interceptors)
        return this
    }
    open fun useResponseFail(interceptor: ResponseFailInterceptor): InterceptorManager {
        this.interceptors.responseFail.push(interceptor)
        setInterceptors(this.interceptors)
        return this
    }
    private fun useResponseSync(interceptor: ResponseInterceptorSync): InterceptorManager {
        this.interceptors.responseSync = interceptor
        setInterceptors(this.interceptors)
        return this
    }
}
open class RequestFilters {
    private var pendingRequests: PendingRequests
    private var debug: Boolean
    constructor(options: FilterOptions = FilterOptions()){
        this.pendingRequests = Map<String, UTSPromise<Any>>()
        this.debug = false
        if (options.debug != null) {
            this.debug = options.debug ?: false
        }
    }
    private fun getKey(url: String, options: RequestConfig): String {
        val paramsString = JSON.stringify(options)
        return "" + url + "-" + paramsString
    }
    open fun filterRequest(url: String, options: RequestConfig, request: () -> UTSPromise<Any>): UTSPromise<Any> {
        return wrapUTSPromise(suspend w@{
                val key = this.getKey(url, options)
                if (options.debug != null) {
                    this.debug = options.debug ?: false
                }
                if (this.pendingRequests.has(key)) {
                    if (this.debug) {
                        console.warn("【 kux-request:filterRequest】请求key " + key + " 已存在，本次请求已自动过滤")
                    }
                    return@w this.pendingRequests.get(key)!!
                }
                val promise = request()
                this.pendingRequests.set(key, promise)
                try {
                    val result = await(promise)
                    return@w result
                }
                 catch (err: Throwable) {
                    this.pendingRequests.`delete`(key)
                    throw err
                }
        })
    }
}
open class URLSearchParams {
    private var params: Map<String, String> = Map()
    constructor(search: String){
        search.split("&").filter(fun(param: String): Boolean {
            return param.length > 0
        }
        ).forEach(fun(param: String){
            val paramSplit = param.split("=")
            val key = paramSplit[0]
            val value = paramSplit[1]
            val decodedKey = decodeURIComponent(key)
            val decodedValue = decodeURIComponent(value)
            this.params.set("" + decodedKey, "" + decodedValue)
        }
        )
    }
    open fun get(key: String): String? {
        return this.params.get(key)
    }
}
open class URL {
    open lateinit var protocol: String
    open lateinit var host: String
    open lateinit var pathname: String
    open lateinit var search: String
    open lateinit var searchParams: URLSearchParams
    constructor(url: String){
        val urlRegex = UTSRegExp("^(\\w+):\\/\\/([^\\/?#]+)([^?#]*)(\\?[^#]*)?(#.*)?\$", "")
        val match = url.match(urlRegex)
        if (match == null) {
            throw UTSError("Invalid URL")
        }
        if (UTSAndroid.`typeof`(match) !== "object") {
            throw UTSError("Invalid URL")
        }
        if (match != null && match.length == 0) {
            throw UTSError("Invalid URL")
        }
        this.protocol = match[1]!!
        this.host = match[2]!!
        this.pathname = "/"
        this.search = ""
        if (match.length >= 4 && match[3] != null) {
            this.pathname = "" + match[3]
        }
        if (match.length >= 5 && match[4] != null) {
            this.search = "" + match[4]
        }
        this.searchParams = URLSearchParams(this.search.slice(1))
    }
    private fun toStringURL(): String {
        return "" + this.protocol + "://" + this.host + this.pathname + this.search
    }
    open val href: String
        get(): String {
            return this.toStringURL()
        }
}
open class Utils {
    open fun objToQueryString(queryObj: UTSJSONObject): String {
        var params: UTSArray<String> = _uA()
        queryObj.toMap().forEach(fun(value, key){
            val encodedKey = encodeURIComponent(key)
            val encodedValue = encodeURIComponent("" + value)
            params.push("" + encodedKey + "=" + encodedValue)
        }
        )
        return "" + params.join("&")
    }
    open fun buildUniError(errSubject: String, errCode: Number, errMsg: String, cause: String = ""): UniError {
        val error = UniError(errSubject, errCode, errMsg)
        val sourceError = SourceError(cause)
        error.cause = sourceError
        return error
    }
    open fun sleep(ms: Number): UTSPromise<Any> {
        return UTSPromise(fun(resolve, _reject){
            var timeout: Number = 0
            timeout = setTimeout(fun(){
                clearTimeout(timeout)
                resolve("")
            }
            , ms)
        }
        )
    }
    open fun isObject(target: Any): Boolean {
        return target is UTSJSONObject
    }
    open fun deepMerge(target: Any, source: Any): Any {
        if (!(target is UTSJSONObject) || !(source is UTSJSONObject)) {
            return source
        }
        for(key in resolveUTSKeyIterator(source as UTSJSONObject)){
            if ((source as UTSJSONObject)[key] != null) {
                if (this.isObject((source as UTSJSONObject)[key]!!) && (target as UTSJSONObject)[key] != null) {
                    if (this.isObject((target as UTSJSONObject)[key]!!) && this.isObject((source as UTSJSONObject)[key]!!)) {
                        this.deepMerge((target as UTSJSONObject)[key]!!, (source as UTSJSONObject)[key]!!)
                    } else {
                        (target as UTSJSONObject)[key] = (source as UTSJSONObject)[key]
                    }
                } else {
                    (target as UTSJSONObject)[key] = (source as UTSJSONObject)[key]
                }
            } else {
                (target as UTSJSONObject)[key] = (source as UTSJSONObject)[key]
            }
        }
        return target
    }
}
val UniErrorSubject = "kux-request"
val UniErrors: Map<KuxErrorCode, String> = Map(_uA(
    _uA(
        901404,
        "请求任务不存在"
    ),
    _uA(
        900408,
        "请求超时"
    ),
    _uA(
        900500,
        "请求失败"
    )
))
open class KuxFailImpl : UniError, KuxRequestFail {
    constructor(errCode: KuxErrorCode) : super(UniErrorSubject, errCode, UniErrors.get(errCode) ?: "") {
        this.errSubject = UniErrorSubject
        this.errCode = errCode
        this.errMsg = UniErrors.get(errCode) ?: ""
    }
}
open class Request {
    private var baseURL: String
    private var config: UseOptions
    private var requestFilters: RequestFilters
    open var requestTask: RequestTask? = null
    open var beforeSendOptions: RequestConfig? = null
    private var _cache: Map<String, Any>
    private var isCache: Boolean
    private var cacheKey: String
    private var requestFailCallback: RequestFailCallback?
    private var aborted: Boolean
    private var _state: State?
    constructor(config: UseOptions = UseOptions(baseURL = "")){
        this.baseURL = config.baseURL
        this.config = config
        this.requestFilters = RequestFilters(FilterOptions(debug = this.config.debug ?: false))
        this.requestTask = null
        this.beforeSendOptions = null
        this._cache = Map<String, Any>()
        this.isCache = false
        this.cacheKey = ""
        this.requestFailCallback = null
        this.aborted = false
        this._state = getState()
        console.log(JSON.stringify(config))
    }
    private fun _mergeOptions(options: RequestConfig): RequestConfig {
        val useUtils = Utils()
        var _options = RequestConfig(query = this.config.query, data = this.config.data, timeout = this.config.timeout, dataType = this.config.dataType, responseType = this.config.responseType, sslVerify = this.config.sslVerify, withCredentials = this.config.withCredentials, firstIpv4 = this.config.firstIpv4, header = this.config.header, filterRequest = this.config.filterRequest, debug = this.config.debug, xhrCode = this.config.xhrCode, xhrCodeName = this.config.xhrCodeName, xhrMessageName = this.config.xhrMessageName, maxCacheSize = this.config.maxCacheSize, openCache = this.config.openCache)
        if (options.firstIpv4 != null) {
            _options.firstIpv4 = options.firstIpv4
        }
        if (options.method != null) {
            _options.method = options.method
        }
        if (options.timeout != null) {
            _options.timeout = options.timeout
        }
        if (options.withCredentials != null) {
            _options.withCredentials = options.withCredentials
        }
        if (options.dataType != null) {
            _options.dataType = options.dataType
        }
        if (options.responseType != null) {
            _options.responseType = options.responseType
        }
        if (options.sslVerify != null) {
            _options.sslVerify = options.sslVerify
        }
        if (options.filterRequest != null) {
            _options.filterRequest = options.filterRequest
        }
        if (options.query != null) {
            _options.query = if (_options.query == null) {
                UTSJSONObject()
            } else {
                _options.query
            }
            _options.query = useUtils.deepMerge(JSON.parseObject<UTSJSONObject>(JSON.stringify(_options.query!!))!!, JSON.parseObject<UTSJSONObject>(JSON.stringify(options.query!!))!!) as UTSJSONObject
        }
        if (options.data != null && UTSAndroid.`typeof`(options.data) == "object") {
            _options.data = if (_options.data == null) {
                UTSJSONObject()
            } else {
                _options.data
            }
            _options.data = useUtils.deepMerge(JSON.parseObject<UTSJSONObject>(JSON.stringify(_options.data!!))!!, JSON.parseObject<UTSJSONObject>(JSON.stringify(options.data!!))!!) as UTSJSONObject
        } else {
            _options.data = options.data
        }
        if (options.header != null) {
            _options.header = if (_options.header == null) {
                UTSJSONObject()
            } else {
                _options.header
            }
            _options.header = useUtils.deepMerge(JSON.parseObject<UTSJSONObject>(JSON.stringify(_options.header!!))!!, JSON.parseObject<UTSJSONObject>(JSON.stringify(options.header!!))!!) as UTSJSONObject
        }
        if (options.debug != null) {
            _options.debug = options.debug
        }
        if (options.xhrCode != null) {
            _options.xhrCode = options.xhrCode
        }
        if (options.xhrCodeName != null) {
            _options.xhrCodeName = options.xhrCodeName
        }
        if (options.xhrMessageName != null) {
            _options.xhrMessageName = options.xhrMessageName
        }
        _options.maxCacheSize = 10
        if (options.maxCacheSize != null) {
            _options.maxCacheSize = options.maxCacheSize
        }
        _options.openCache = false
        if (options.openCache != null) {
            _options.openCache = options.openCache
        }
        return _options
    }
    private fun getSearchPrefix(url: String): String {
        val useUrl = URL(url)
        return if (useUrl.search.length > 0) {
            "&"
        } else {
            "?"
        }
    }
    private fun _request(url: String, options: RequestConfig = RequestConfig()): UTSPromise<Any> {
        return wrapUTSPromise(suspend w@{
                val useUtils = Utils()
                var mergedOptions = options
                mergedOptions.url = url
                var interceptorResult: RequestConfig? = null
                var baseURL = this.baseURL
                if (mergedOptions.url != null && mergedOptions.url!!.indexOf("http") > -1) {
                    val urlInstance: URL = URL(mergedOptions.url!!)
                    mergedOptions.url = urlInstance.pathname
                    baseURL = urlInstance.protocol + "://" + urlInstance.host
                }
                if (mergedOptions.needRequestInterceptor == true) {
                    mergedOptions.baseURL = baseURL
                    this._state!!.interceptors.request.forEach(fun(interceptor: RequestInterceptor){
                        interceptorResult = interceptor(mergedOptions)
                    }
                    )
                    if (this._state!!.interceptors.requestSync != null) {
                        interceptorResult = await((this._state!!.interceptors.requestSync as RequestInterceptorSync)(mergedOptions))
                    }
                    if (interceptorResult != null && interceptorResult!!.baseURL != null && interceptorResult!!.baseURL!!.length > 0) {
                        baseURL = interceptorResult!!.baseURL!!
                    }
                    if (interceptorResult != null) {
                        mergedOptions = JSON.parseObject<RequestConfig>(JSON.stringify(useUtils.deepMerge(JSON.parseObject<UTSJSONObject>(JSON.stringify(mergedOptions))!!, JSON.parseObject<UTSJSONObject>(JSON.stringify(interceptorResult!!))!!)))!!
                    }
                }
                var path = mergedOptions.url ?: url
                return@w UTSPromise(fun(resolve, reject){
                    if (this.aborted) {
                        reject(KuxFailImpl(901404))
                        throw KuxFailImpl(901404)
                    }
                    mergedOptions.url = baseURL + path
                    val useUtils = Utils()
                    if (mergedOptions.query != null) {
                        val queryString = useUtils.objToQueryString(mergedOptions.query ?: UTSJSONObject())
                        if (queryString.length > 0) {
                            mergedOptions.url = "" + mergedOptions.url!! + this.getSearchPrefix("" + mergedOptions.url!!) + queryString
                        }
                    }
                    this.beforeSendOptions = mergedOptions
                    var _cacheKey = this.cacheKey
                    if (_cacheKey.length == 0) {
                        _cacheKey = this.getKey(url, this.beforeSendOptions as RequestConfig)
                    }
                    if (this.isCache) {
                        if (mergedOptions.debug != null && mergedOptions.debug as Boolean) {
                            console.warn("【kux-request:request】本次请求 " + _cacheKey + " 为缓存结果")
                        }
                        this.isCache = false
                        if (this._cache.get(_cacheKey) != null) {
                            resolve(this._cache.get(_cacheKey))
                        }
                    }
                    this.requestTask = uni_request<Any>(RequestOptions(url = "" + mergedOptions.url!!, method = mergedOptions.method, data = mergedOptions.data, header = mergedOptions.header, dataType = mergedOptions.dataType, timeout = mergedOptions.timeout ?: 60000, responseType = mergedOptions.responseType, sslVerify = mergedOptions.sslVerify, withCredentials = mergedOptions.withCredentials, success = fun(res: RequestSuccess<Any>){
                        var response = res.data
                        if (mergedOptions.needResponseInterceptor == true) {
                            this._state!!.interceptors.responseXhr.forEach(fun(interceptor: ResponseXhrInterceptor){
                                response = interceptor(res)
                            }
                            )
                            this._state!!.interceptors.response.forEach(fun(interceptor: ResponseInterceptor){
                                response = interceptor(response as Any)
                                if (options.xhrResponse == true || this.config.xhrResponse == true) {
                                    response = res
                                }
                            }
                            )
                            this._state!!.interceptors.responseReject.forEach(fun(interceptor: ResponseRejectInterceptor){
                                response = interceptor(res, reject)
                            }
                            )
                        }
                        if (UTSAndroid.`typeof`(response) === "object" && mergedOptions.xhrCode != null && mergedOptions.xhrCodeName != null) {
                            val _res = response as UTSJSONObject
                            if (_res.getAny("" + mergedOptions.xhrCodeName!!) != mergedOptions.xhrCode) {
                                if (mergedOptions.xhrMessageName != null) {
                                    val error = KuxFailImpl(900500)
                                    error.errMsg = "" + _res.getAny("" + mergedOptions.xhrMessageName!!)
                                    error.cause = SourceError(JSON.stringify(response))
                                } else {
                                    reject(KuxFailImpl(900500))
                                }
                            }
                        }
                        if (mergedOptions.openCache as Boolean) {
                            if (this._cache.size >= parseInt("" + mergedOptions.maxCacheSize)) {
                                var i: Number = 0
                                this._cache.forEach(fun(_, key){
                                    if (i == 0) {
                                        this._cache.`delete`(key)
                                    }
                                    i++
                                }
                                )
                            }
                            this._cache.set(_cacheKey, response as Any)
                        }
                        resolve(response)
                    }
                    , fail = fun(fail: RequestFail){
                        this.requestFailCallback?.invoke(fail)
                        if (mergedOptions.needResponseInterceptor == true) {
                            this._state!!.interceptors.responseFail.forEach(fun(interceptor: ResponseFailInterceptor){
                                interceptor(fail, reject)
                            }
                            )
                        }
                        reject(fail)
                    }
                    ))
                }
                )
        })
    }
    public open fun getKey(url: String, options: RequestConfig): String {
        val paramsString = JSON.stringify(options)
        return "" + url + "-" + paramsString
    }
    open fun clearCache(key: String): Request {
        if (key.length == 0) {
            this._cache.clear()
            return this
        }
        if (this._cache.has(key)) {
            this._cache.`delete`(key)
        }
        return this
    }
    open fun cache(key: String = ""): Request {
        this.isCache = true
        this.cacheKey = key
        return this
    }
    open fun overrideConfig(config: RequestConfig = RequestConfig()): Request {
        if (config.baseURL != null) {
            this.config.baseURL = "" + config.baseURL!!
            this.baseURL = "" + config.baseURL!!
        }
        if (config.query != null) {
            this.config.query = config.query
        }
        if (config.data != null) {
            this.config.data = config.data
        }
        if (config.header != null) {
            this.config.header = config.header
        }
        this.config.xhrResponse = config.xhrResponse
        return this
    }
    open fun onFail(callback: RequestFailCallback) {
        this.requestFailCallback = callback
    }
    open fun request(url: String, options: RequestConfig = RequestConfig()): UTSPromise<Any> {
        return wrapUTSPromise(suspend w@{
                var _options = this._mergeOptions(options)
                if (_options.filterRequest != null && (_options.filterRequest as Boolean)) {
                    return@w this.requestFilters.filterRequest(url, _options, fun(): UTSPromise<Any> {
                        return this._request(url, _options)
                    }
                    )
                }
                _options.xhrResponse = options.xhrResponse ?: false
                this.aborted = false
                _options.customData = options.customData ?: UTSJSONObject()
                _options.needRequestInterceptor = options.needRequestInterceptor ?: true
                _options.needResponseInterceptor = options.needResponseInterceptor ?: true
                return@w this._request(url, _options)
        })
    }
    open fun get(url: String, options: RequestConfig = RequestConfig()): UTSPromise<Any> {
        return wrapUTSPromise(suspend w@{
                var _options = options
                _options.method = "GET"
                this.aborted = false
                return@w this.request(url, _options)
        })
    }
    open fun post(url: String, options: RequestConfig = RequestConfig()): UTSPromise<Any> {
        return wrapUTSPromise(suspend w@{
                var _options = options
                _options.method = "POST"
                this.aborted = false
                return@w this.request(url, _options)
        })
    }
    open fun put(url: String, options: RequestConfig = RequestConfig()): UTSPromise<Any> {
        return wrapUTSPromise(suspend w@{
                var _options = options
                _options.method = "PUT"
                this.aborted = false
                return@w this.request(url, _options)
        })
    }
    open fun `delete`(url: String, options: RequestConfig = RequestConfig()): UTSPromise<Any> {
        return wrapUTSPromise(suspend w@{
                var _options = options
                _options.method = "DELETE"
                this.aborted = false
                return@w this.request(url, _options)
        })
    }
    open fun abort() {
        this.aborted = true
    }
}
open class RetryManager : Request {
    private var maxRetryCount: Number
    private var initialDelay: Number
    private var maxDelay: Number
    constructor(maxRetryCount: Number, initialDelay: Number, maxDelay: Number) : super() {
        this.maxRetryCount = maxRetryCount
        this.initialDelay = initialDelay
        this.maxDelay = maxDelay
    }
    open fun sendRequest(url: String, options: RequestConfig = RequestConfig()): UTSPromise<Any> {
        var retryCount: Number = 0
        var delay = this.initialDelay
        var timeout: Number = 60000
        var _this = this
        if (options?.timeout != null) {
            timeout = parseInt("" + options.timeout!!)
        }
        fun doRequest(): UTSPromise<Any> {
            return wrapUTSPromise(suspend w1@{
                    try {
                        return@w1 await(_this.request(url, options ?: RequestConfig()))
                    }
                     catch (error: Throwable) {
                        if (delay >= timeout) {
                            throw KuxFailImpl(900408)
                        }
                        if (retryCount < _this.maxRetryCount) {
                            retryCount++
                            console.warn("请求失败，正在尝试重试（" + retryCount + "）")
                            await(Utils().sleep(delay))
                            delay = Math.min(delay * 2, _this.maxDelay)
                            return@w1 doRequest()
                        } else {
                            val fail = KuxFailImpl(900500)
                            fail.cause = UniError(JSON.stringify(error))
                            throw fail
                        }
                    }
            })
        }
        return doRequest()
    }
}
open class BatchRequestManager {
    private var requests: UTSArray<UTSPromise<Any>> = _uA()
    open fun addRequest(request: UTSPromise<Any>): UTSPromise<Any> {
        this.requests.push(request)
        return request
    }
    open fun addBatchRequest(requests: UTSArray<UTSPromise<Any>>): UTSArray<UTSPromise<Any>> {
        this.requests = requests
        return this.requests
    }
    open fun executeBatch(): UTSPromise<UTSArray<ExecuteBatchRequestResult>> {
        return wrapUTSPromise(suspend w@{
                val settedResutls = await(UTSPromise.allSettled(this.requests))
                this.requests = _uA()
                return@w settedResutls.map(fun(result): ExecuteBatchRequestResult {
                    if (result.status == "fulfilled") {
                        var res = ExecuteBatchRequestResult()
                        if (result is UTSPromiseFulfilledResult) {
                            return ExecuteBatchRequestResult(value = result.value, error = null)
                        }
                        if (result is UTSPromiseRejectedResult) {
                            return ExecuteBatchRequestResult(value = null, error = result.reason)
                        }
                        return res
                    } else {
                        if (result is UTSPromiseRejectedResult) {
                            return ExecuteBatchRequestResult(value = null, error = result.reason)
                        }
                        return ExecuteBatchRequestResult(value = null, error = result)
                    }
                }
                )
        })
    }
}
val useRequest = fun(options: UseOptions): Request {
    return Request(options)
}
val useInterceptor = fun(): InterceptorManager {
    return InterceptorManager()
}
fun useFilter(options: FilterOptions = FilterOptions()): RequestFilters {
    return RequestFilters(options)
}
val useURL = fun(url: String): URL {
    return URL(url)
}
val useUtils = fun(): Utils {
    return Utils()
}
val useRetry = fun(maxRetryCount: Number, initialDelay: Number, maxDelay: Number): RetryManager {
    return RetryManager(maxRetryCount, initialDelay, maxDelay)
}
val useBatchRequest = fun(): BatchRequestManager {
    return BatchRequestManager()
}
