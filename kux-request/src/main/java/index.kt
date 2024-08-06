@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME")
package uts.sdk.modules.kuxRequest;
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
import io.dcloud.uniapp.extapi.request as uni_request;
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
typealias RequestInterceptor = (options: RequestConfig) -> RequestConfig;
typealias RequestInterceptorSync = (options: RequestConfig) -> UTSPromise<RequestConfig>;
typealias ResponseInterceptor = (response: Any) -> Any;
typealias ResponseInterceptorSync = (response: Any) -> UTSPromise<Any>;
typealias ResponseXhrInterceptor = (response: RequestSuccess<Any>) -> Any;
typealias RequestFailCallback = (fail: RequestFail) -> Unit;
open class Interceptors (
    @JsonNotNull
    open var request: UTSArray<RequestInterceptor>,
    @JsonNotNull
    open var response: UTSArray<ResponseInterceptor>,
    @JsonNotNull
    open var responseXhr: UTSArray<ResponseXhrInterceptor>,
    open var requestSync: RequestInterceptorSync? = null,
    open var responseSync: ResponseInterceptorSync? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return InterceptorsReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class InterceptorsReactiveObject : Interceptors, IUTSReactive<Interceptors> {
    override var __v_raw: Interceptors;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: Interceptors, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(request = __v_raw.request, response = __v_raw.response, responseXhr = __v_raw.responseXhr, requestSync = __v_raw.requestSync, responseSync = __v_raw.responseSync) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): InterceptorsReactiveObject {
        return InterceptorsReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var request: UTSArray<RequestInterceptor>
        get() {
            return trackReactiveGet(__v_raw, "request", __v_raw.request, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("request")) {
                return;
            }
            val oldValue = __v_raw.request;
            __v_raw.request = value;
            triggerReactiveSet(__v_raw, "request", oldValue, value);
        }
    override var response: UTSArray<ResponseInterceptor>
        get() {
            return trackReactiveGet(__v_raw, "response", __v_raw.response, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("response")) {
                return;
            }
            val oldValue = __v_raw.response;
            __v_raw.response = value;
            triggerReactiveSet(__v_raw, "response", oldValue, value);
        }
    override var responseXhr: UTSArray<ResponseXhrInterceptor>
        get() {
            return trackReactiveGet(__v_raw, "responseXhr", __v_raw.responseXhr, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("responseXhr")) {
                return;
            }
            val oldValue = __v_raw.responseXhr;
            __v_raw.responseXhr = value;
            triggerReactiveSet(__v_raw, "responseXhr", oldValue, value);
        }
}
open class FilterOptions (
    open var debug: Boolean? = null,
) : UTSObject()
typealias PendingRequests = Map<String, UTSPromise<Any>>;
open class UseRetryOptions (
    open var maxRetryCount: Number? = null,
    open var initialDelay: Number? = null,
    open var maxDelay: Number? = null,
) : UTSObject()
typealias KuxErrorCode = Number;
interface KuxRequestFail : IUniError {
    override var errCode: KuxErrorCode
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
open class StateReactiveObject : State, IUTSReactive<State> {
    override var __v_raw: State;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: State, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(interceptors = __v_raw.interceptors) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): StateReactiveObject {
        return StateReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var interceptors: Interceptors
        get() {
            return trackReactiveGet(__v_raw, "interceptors", __v_raw.interceptors, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("interceptors")) {
                return;
            }
            val oldValue = __v_raw.interceptors;
            __v_raw.interceptors = value;
            triggerReactiveSet(__v_raw, "interceptors", oldValue, value);
        }
}
val state = reactive(State(interceptors = Interceptors(request = utsArrayOf(), response = utsArrayOf(), responseXhr = utsArrayOf(), requestSync = null, responseSync = null)));
val setInterceptors = fun(interceptors: Interceptors){
    state.interceptors = interceptors;
}
;
open class InterceptorManager {
    private var interceptors: Interceptors;
    constructor(){
        this.interceptors = Interceptors(request = utsArrayOf<RequestInterceptor>(), response = utsArrayOf<ResponseInterceptor>(), responseXhr = utsArrayOf<ResponseXhrInterceptor>(), requestSync = null, responseSync = null);
    }
    open fun useRequest(interceptor: RequestInterceptor): InterceptorManager {
        this.interceptors.request.push(interceptor);
        setInterceptors(this.interceptors);
        return this;
    }
    open fun useRequestSync(interceptor: RequestInterceptorSync): InterceptorManager {
        this.interceptors.requestSync = interceptor;
        setInterceptors(this.interceptors);
        return this;
    }
    open fun useResponse(interceptor: ResponseInterceptor): InterceptorManager {
        this.interceptors.response.push(interceptor);
        setInterceptors(this.interceptors);
        return this;
    }
    open fun useResponseXhr(interceptor: ResponseXhrInterceptor): InterceptorManager {
        this.interceptors.responseXhr.push(interceptor);
        setInterceptors(this.interceptors);
        return this;
    }
    private fun useResponseSync(interceptor: ResponseInterceptorSync): InterceptorManager {
        this.interceptors.responseSync = interceptor;
        setInterceptors(this.interceptors);
        return this;
    }
}
open class RequestFilters {
    private var pendingRequests: PendingRequests;
    private var debug: Boolean;
    constructor(options: FilterOptions = FilterOptions()){
        this.pendingRequests = Map<String, UTSPromise<Any>>();
        this.debug = false;
        if (options.debug !== null) {
            this.debug = options.debug ?: false;
        }
    }
    private fun getKey(url: String, options: RequestConfig): String {
        val paramsString = JSON.stringify(options);
        return "" + url + "-" + paramsString;
    }
    open fun filterRequest(url: String, options: RequestConfig, request: () -> UTSPromise<Any>): UTSPromise<Any> {
        suspend fun async(): Any? {
            val key = this.getKey(url, options);
            if (options.debug !== null) {
                this.debug = options.debug ?: false;
            }
            if (this.pendingRequests.has(key)) {
                if (this.debug) {
                    console.warn("\u3010 kux-request:filterRequest\u3011\u8BF7\u6C42key " + key + " \u5DF2\u5B58\u5728\uFF0C\u672C\u6B21\u8BF7\u6C42\u5DF2\u81EA\u52A8\u8FC7\u6EE4", " at uni_modules/kux-request/common/filters.uts:29");
                }
                return this.pendingRequests.get(key);
            }
            val promise = request();
            this.pendingRequests.set(key, promise);
            try {
                val result = await(promise);
                return result;
            }
             catch (err: Throwable) {
                this.pendingRequests.`delete`(key);
                throw err;
            }
        }
        return UTSPromise(fun(resolve, reject) {
            kotlinx.coroutines.CoroutineScope(io.dcloud.uts.UTSAndroid.getDomCoroutineDispatcher()).async {
                try {
                    val result = async();
                    resolve(if (result is UTSPromise<*>) {
                        @Suppress("UNCHECKED_CAST")
                        `await`(result as UTSPromise<Any>);
                    } else {
                        result as Any;
                    }
                    );
                }
                 catch (e: Throwable) {
                    reject(e);
                }
            }
            ;
        }
        );
    }
}
open class URLSearchParams {
    private var params: Map<String, String> = Map();
    constructor(search: String){
        search.split("&").filter(fun(param: String): Boolean {
            return param.length > 0;
        }
        ).forEach(fun(param: String){
            val paramSplit = param.split("=");
            val key = paramSplit[0];
            val value = paramSplit[1];
            val decodedKey = decodeURIComponent(key);
            val decodedValue = decodeURIComponent(value);
            this.params.set("" + decodedKey, "" + decodedValue);
        }
        );
    }
    open fun get(key: String): String? {
        return this.params.get(key);
    }
}
open class URL {
    open var protocol: String;
    open var host: String;
    open var pathname: String;
    open var search: String;
    open var searchParams: URLSearchParams;
    constructor(url: String){
        val urlRegex = UTSRegExp("^(\\w+):\\/\\/([^\\/?#]+)([^?#]*)(\\?[^#]*)?(#.*)?\$", "");
        val match = url.match(urlRegex);
        if (match == null) {
            throw UTSError("Invalid URL");
        }
        if (UTSAndroid.`typeof`( match) !== "object") {
            throw UTSError("Invalid URL");
        }
        if (match != null && match.length == 0) {
            throw UTSError("Invalid URL");
        }
        this.protocol = match[1]!!;
        this.host = match[2]!!;
        this.pathname = "/";
        this.search = "";
        if (match.length >= 4 && match[3] != null) {
            this.pathname = "" + match[3];
        }
        if (match.length >= 5 && match[4] != null) {
            this.search = "" + match[4];
        }
        this.searchParams = URLSearchParams(this.search.slice(1));
    }
    private fun toStringURL(): String {
        return "" + this.protocol + "://" + this.host + this.pathname + this.search;
    }
    open val href: String
        get(): String {
            return this.toStringURL();
        }
}
open class Utils {
    open fun objToQueryString(queryObj: UTSJSONObject): String {
        var params: UTSArray<String> = utsArrayOf();
        queryObj.toMap().forEach(fun(value, key){
            val encodedKey = encodeURIComponent(key);
            val encodedValue = encodeURIComponent("" + value);
            params.push("" + encodedKey + "=" + encodedValue);
        }
        );
        return "" + params.join("&");
    }
    open fun buildUniError(errSubject: String, errCode: Number, errMsg: String, cause: String = ""): UniError {
        val error = UniError(errSubject, errCode, errMsg);
        val sourceError = SourceError(cause);
        error.cause = sourceError;
        return error;
    }
    open fun sleep(ms: Number): UTSPromise<Any> {
        return UTSPromise(fun(resolve){
            var timeout: Number = 0;
            timeout = setTimeout(fun(){
                clearTimeout(timeout);
                resolve("");
            }
            , ms);
        }
        );
    }
    open fun isObject(target: Any): Boolean {
        return target is UTSJSONObject;
    }
    open fun deepMerge(target: Any, source: Any): Any {
        if (!(target is UTSJSONObject) || !(source is UTSJSONObject)) {
            return source;
        }
        for(key in source){
            if (source[key] != null) {
                if (this.isObject(source[key]!!) && target[key] != null) {
                    if (this.isObject(target[key]!!) && this.isObject(source[key]!!)) {
                        this.deepMerge(target[key]!!, source[key]!!);
                    } else {
                        target[key] = source[key];
                    }
                } else {
                    target[key] = source[key];
                }
            }
        }
        return target;
    }
}
val UniErrorSubject = "kux-request";
val UniErrors: Map<KuxErrorCode, String> = Map(utsArrayOf(
    utsArrayOf(
        901404,
        "请求任务不存在"
    ),
    utsArrayOf(
        900408,
        "请求超时"
    ),
    utsArrayOf(
        900500,
        "请求失败"
    )
));
open class KuxFailImpl : UniError, KuxRequestFail {
    constructor(errCode: KuxErrorCode) : super(UniErrorSubject, errCode, UniErrors.get(errCode) ?: "") {
        this.errSubject = UniErrorSubject;
        this.errCode = errCode;
        this.errMsg = UniErrors.get(errCode) ?: "";
    }
}
open class Request {
    private var baseURL: String;
    private var config: UseOptions;
    private var requestFilters: RequestFilters;
    open var requestTask: RequestTask?;
    open var beforeSendOptions: RequestConfig?;
    private var _cache: Map<String, Any>;
    private var isCache: Boolean;
    private var cacheKey: String;
    private var requestFailCallback: RequestFailCallback?;
    private var aborted: Boolean;
    constructor(config: UseOptions = UseOptions(baseURL = "")){
        this.baseURL = config.baseURL;
        this.config = config;
        this.requestFilters = RequestFilters(FilterOptions(debug = this.config.debug ?: false));
        this.requestTask = null;
        this.beforeSendOptions = null;
        this._cache = Map<String, Any>();
        this.isCache = false;
        this.cacheKey = "";
        this.requestFailCallback = null;
        this.aborted = false;
    }
    private fun _mergeOptions(options: RequestConfig): RequestConfig {
        val useUtils = Utils();
        var _options = RequestConfig(query = this.config.query, data = this.config.data, timeout = this.config.timeout, dataType = this.config.dataType, responseType = this.config.responseType, sslVerify = this.config.sslVerify, withCredentials = this.config.withCredentials, firstIpv4 = this.config.firstIpv4, header = this.config.header, filterRequest = this.config.filterRequest, debug = this.config.debug, xhrCode = this.config.xhrCode, xhrCodeName = this.config.xhrCodeName, xhrMessageName = this.config.xhrMessageName, maxCacheSize = this.config.maxCacheSize, openCache = this.config.openCache);
        if (options.firstIpv4 != null) {
            _options.firstIpv4 = options.firstIpv4;
        }
        if (options.method != null) {
            _options.method = options.method;
        }
        if (options.timeout != null) {
            _options.timeout = options.timeout;
        }
        if (options.withCredentials != null) {
            _options.withCredentials = options.withCredentials;
        }
        if (options.dataType != null) {
            _options.dataType = options.dataType;
        }
        if (options.responseType != null) {
            _options.responseType = options.responseType;
        }
        if (options.sslVerify != null) {
            _options.sslVerify = options.sslVerify;
        }
        if (options.filterRequest != null) {
            _options.filterRequest = options.filterRequest;
        }
        if (options.query != null) {
            _options.query = if (_options.query == null) {
                UTSJSONObject();
            } else {
                options.query;
            }
            ;
            _options.query = useUtils.deepMerge(JSON.parseObject<UTSJSONObject>(JSON.stringify(_options.query!!))!!, JSON.parseObject<UTSJSONObject>(JSON.stringify(options.query!!))!!) as UTSJSONObject;
        }
        if (options.data != null) {
            _options.data = if (_options.data == null) {
                UTSJSONObject();
            } else {
                options.data;
            }
            ;
            _options.data = useUtils.deepMerge(JSON.parseObject<UTSJSONObject>(JSON.stringify(_options.data!!))!!, JSON.parseObject<UTSJSONObject>(JSON.stringify(options.data!!))!!) as UTSJSONObject;
        }
        if (options.header != null) {
            _options.header = if (_options.header == null) {
                UTSJSONObject();
            } else {
                options.header;
            }
            ;
            _options.header = useUtils.deepMerge(JSON.parseObject<UTSJSONObject>(JSON.stringify(_options.header!!))!!, JSON.parseObject<UTSJSONObject>(JSON.stringify(options.header!!))!!) as UTSJSONObject;
        }
        if (options.debug != null) {
            _options.debug = options.debug;
        }
        if (options.xhrCode != null) {
            _options.xhrCode = options.xhrCode;
        }
        if (options.xhrCodeName != null) {
            _options.xhrCodeName = options.xhrCodeName;
        }
        if (options.xhrMessageName != null) {
            _options.xhrMessageName = options.xhrMessageName;
        }
        _options.maxCacheSize = 10;
        if (options.maxCacheSize != null) {
            _options.maxCacheSize = options.maxCacheSize;
        }
        _options.openCache = false;
        if (options.openCache != null) {
            _options.openCache = options.openCache;
        }
        return _options;
    }
    private fun getSearchPrefix(url: String): String {
        val useUrl = URL(url);
        return if (useUrl.search.length > 0) {
            "&";
        } else {
            "?";
        }
        ;
    }
    private fun _request(url: String, options: RequestConfig = RequestConfig()): UTSPromise<Any> {
        suspend fun async(): Any? {
            var mergedOptions = options;
            mergedOptions.url = url;
            mergedOptions.baseURL = this.baseURL;
            var baseURL = this.baseURL;
            if (mergedOptions.url != null && mergedOptions.url!!.indexOf("http") > -1) {
                val urlInstance: URL = URL(mergedOptions.url!!);
                mergedOptions.url = urlInstance.pathname;
                baseURL = urlInstance.protocol + "://" + urlInstance.host;
            }
            if (mergedOptions.needRequestInterceptor == true) {
                state.interceptors.request.forEach(fun(interceptor: RequestInterceptor){
                    mergedOptions = interceptor(mergedOptions);
                }
                );
                if (state.interceptors.requestSync !== null) {
                    mergedOptions = await((state.interceptors.requestSync as RequestInterceptorSync)(mergedOptions));
                }
            }
            var path = mergedOptions.url;
            return UTSPromise(fun(resolve, reject){
                if (this.aborted) {
                    reject(KuxFailImpl(901404));
                    return;
                }
                mergedOptions.url = baseURL + path;
                val useUtils = Utils();
                val queryString = useUtils.objToQueryString(mergedOptions.query ?: UTSJSONObject());
                if (queryString.length > 0) {
                    mergedOptions.url += "" + this.getSearchPrefix("" + mergedOptions.url) + queryString;
                }
                this.beforeSendOptions = mergedOptions;
                var _cacheKey = this.cacheKey;
                if (_cacheKey.length == 0) {
                    _cacheKey = this.getKey(url, this.beforeSendOptions as RequestConfig);
                }
                if (this.isCache) {
                    if (mergedOptions.debug != null && mergedOptions.debug as Boolean) {
                        console.warn("\u3010kux-request:request\u3011\u672C\u6B21\u8BF7\u6C42 " + _cacheKey + " \u4E3A\u7F13\u5B58\u7ED3\u679C", " at uni_modules/kux-request/common/request.uts:198");
                    }
                    this.isCache = false;
                    if (this._cache.get(_cacheKey) != null) {
                        resolve(this._cache.get(_cacheKey));
                    }
                }
                this.requestTask = uni_request<Any>(RequestOptions(url = "" + mergedOptions.url, method = mergedOptions.method, data = mergedOptions.data, header = mergedOptions.header, dataType = mergedOptions.dataType, timeout = mergedOptions.timeout ?: 60000, responseType = mergedOptions.responseType, sslVerify = mergedOptions.sslVerify, withCredentials = mergedOptions.withCredentials, success = fun(res: RequestSuccess<Any>){
                    var response = res.data;
                    if (mergedOptions.needResponseInterceptor == true) {
                        state.interceptors.responseXhr.forEach(fun(interceptor: ResponseXhrInterceptor){
                            response = interceptor(res);
                        }
                        );
                        state.interceptors.response.forEach(fun(interceptor: ResponseInterceptor){
                            response = interceptor(response as Any);
                            if (options.xhrResponse == true || this.config.xhrResponse == true) {
                                response = res;
                            }
                        }
                        );
                    }
                    if (UTSAndroid.`typeof`( response) === "object" && mergedOptions.xhrCode != null && mergedOptions.xhrCodeName != null) {
                        val _res = response as UTSJSONObject;
                        if (_res.getAny("" + mergedOptions.xhrCodeName) != mergedOptions.xhrCode) {
                            if (mergedOptions.xhrMessageName != null) {
                                val error = KuxFailImpl(900500);
                                error.errMsg = "" + _res.getAny("" + mergedOptions.xhrMessageName);
                                error.cause = SourceError(JSON.stringify(response));
                            } else {
                                reject(KuxFailImpl(900500));
                            }
                        }
                    }
                    if (mergedOptions.openCache as Boolean) {
                        if (this._cache.size >= parseInt("" + mergedOptions.maxCacheSize)) {
                            var i: Number = 0;
                            this._cache.forEach(fun(_, key){
                                if (i == 0) {
                                    this._cache.`delete`(key);
                                }
                                i++;
                            }
                            );
                        }
                        this._cache.set(_cacheKey, response as Any);
                    }
                    resolve(response);
                }
                , fail = fun(fail: RequestFail){
                    this.requestFailCallback?.invoke(fail);
                    reject(fail);
                }
                ));
            }
            );
        }
        return UTSPromise(fun(resolve, reject) {
            kotlinx.coroutines.CoroutineScope(io.dcloud.uts.UTSAndroid.getDomCoroutineDispatcher()).async {
                try {
                    val result = async();
                    resolve(if (result is UTSPromise<*>) {
                        @Suppress("UNCHECKED_CAST")
                        `await`(result as UTSPromise<Any>);
                    } else {
                        result as Any;
                    }
                    );
                }
                 catch (e: Throwable) {
                    reject(e);
                }
            }
            ;
        }
        );
    }
    public open fun getKey(url: String, options: RequestConfig): String {
        val paramsString = JSON.stringify(options);
        return "" + url + "-" + paramsString;
    }
    open fun clearCache(key: String): Request {
        if (key.length == 0) {
            this._cache.clear();
            return this;
        }
        if (this._cache.has(key)) {
            this._cache.`delete`(key);
        }
        return this;
    }
    open fun cache(key: String = ""): Request {
        this.isCache = true;
        this.cacheKey = key;
        return this;
    }
    open fun overrideConfig(config: RequestConfig = RequestConfig()): Request {
        if (config.baseURL != null) {
            this.config.baseURL = "" + config.baseURL;
            this.baseURL = "" + config.baseURL;
        }
        if (config.query != null) {
            this.config.query = config.query;
        }
        if (config.data != null) {
            this.config.data = config.data;
        }
        if (config.header != null) {
            this.config.header = config.header;
        }
        this.config.xhrResponse = config.xhrResponse;
        return this;
    }
    open fun onFail(callback: RequestFailCallback) {
        this.requestFailCallback = callback;
    }
    open fun request(url: String, options: RequestConfig = RequestConfig()): UTSPromise<Any> {
        suspend fun async(): Any? {
            var _options = this._mergeOptions(options);
            if (_options.filterRequest != null && (_options.filterRequest as Boolean)) {
                return this.requestFilters.filterRequest(url, _options, fun(): UTSPromise<Any> {
                    return this._request(url, _options);
                }
                );
            }
            _options.xhrResponse = options.xhrResponse ?: false;
            this.aborted = false;
            _options.customData = options.customData ?: null;
            _options.needRequestInterceptor = options.needRequestInterceptor ?: true;
            _options.needResponseInterceptor = options.needResponseInterceptor ?: true;
            return this._request(url, _options);
        }
        return UTSPromise(fun(resolve, reject) {
            kotlinx.coroutines.CoroutineScope(io.dcloud.uts.UTSAndroid.getDomCoroutineDispatcher()).async {
                try {
                    val result = async();
                    resolve(if (result is UTSPromise<*>) {
                        @Suppress("UNCHECKED_CAST")
                        `await`(result as UTSPromise<Any>);
                    } else {
                        result as Any;
                    }
                    );
                }
                 catch (e: Throwable) {
                    reject(e);
                }
            }
            ;
        }
        );
    }
    open fun get(url: String, options: RequestConfig = RequestConfig()): UTSPromise<Any> {
        suspend fun async(): Any? {
            var _options = options;
            _options.method = "GET";
            this.aborted = false;
            return this.request(url, _options);
        }
        return UTSPromise(fun(resolve, reject) {
            kotlinx.coroutines.CoroutineScope(io.dcloud.uts.UTSAndroid.getDomCoroutineDispatcher()).async {
                try {
                    val result = async();
                    resolve(if (result is UTSPromise<*>) {
                        @Suppress("UNCHECKED_CAST")
                        `await`(result as UTSPromise<Any>);
                    } else {
                        result as Any;
                    }
                    );
                }
                 catch (e: Throwable) {
                    reject(e);
                }
            }
            ;
        }
        );
    }
    open fun post(url: String, options: RequestConfig = RequestConfig()): UTSPromise<Any> {
        suspend fun async(): Any? {
            var _options = options;
            _options.method = "POST";
            this.aborted = false;
            return this.request(url, _options);
        }
        return UTSPromise(fun(resolve, reject) {
            kotlinx.coroutines.CoroutineScope(io.dcloud.uts.UTSAndroid.getDomCoroutineDispatcher()).async {
                try {
                    val result = async();
                    resolve(if (result is UTSPromise<*>) {
                        @Suppress("UNCHECKED_CAST")
                        `await`(result as UTSPromise<Any>);
                    } else {
                        result as Any;
                    }
                    );
                }
                 catch (e: Throwable) {
                    reject(e);
                }
            }
            ;
        }
        );
    }
    open fun put(url: String, options: RequestConfig = RequestConfig()): UTSPromise<Any> {
        suspend fun async(): Any? {
            var _options = options;
            _options.method = "PUT";
            this.aborted = false;
            return this.request(url, _options);
        }
        return UTSPromise(fun(resolve, reject) {
            kotlinx.coroutines.CoroutineScope(io.dcloud.uts.UTSAndroid.getDomCoroutineDispatcher()).async {
                try {
                    val result = async();
                    resolve(if (result is UTSPromise<*>) {
                        @Suppress("UNCHECKED_CAST")
                        `await`(result as UTSPromise<Any>);
                    } else {
                        result as Any;
                    }
                    );
                }
                 catch (e: Throwable) {
                    reject(e);
                }
            }
            ;
        }
        );
    }
    open fun `delete`(url: String, options: RequestConfig = RequestConfig()): UTSPromise<Any> {
        suspend fun async(): Any? {
            var _options = options;
            _options.method = "DELETE";
            this.aborted = false;
            return this.request(url, _options);
        }
        return UTSPromise(fun(resolve, reject) {
            kotlinx.coroutines.CoroutineScope(io.dcloud.uts.UTSAndroid.getDomCoroutineDispatcher()).async {
                try {
                    val result = async();
                    resolve(if (result is UTSPromise<*>) {
                        @Suppress("UNCHECKED_CAST")
                        `await`(result as UTSPromise<Any>);
                    } else {
                        result as Any;
                    }
                    );
                }
                 catch (e: Throwable) {
                    reject(e);
                }
            }
            ;
        }
        );
    }
    open fun abort() {
        this.aborted = true;
    }
}
open class RetryManager : Request {
    private var maxRetryCount: Number;
    private var initialDelay: Number;
    private var maxDelay: Number;
    constructor(maxRetryCount: Number, initialDelay: Number, maxDelay: Number) : super() {
        this.maxRetryCount = maxRetryCount;
        this.initialDelay = initialDelay;
        this.maxDelay = maxDelay;
    }
    open fun sendRequest(url: String, options: RequestConfig = RequestConfig()): UTSPromise<Any> {
        var retryCount: Number = 0;
        var delay = this.initialDelay;
        var timeout: Number = 60000;
        var _this = this;
        if (options?.timeout != null) {
            timeout = parseInt("" + options.timeout);
        }
        fun doRequest(): UTSPromise<Any> {
            suspend fun async(): Any? {
                try {
                    return await(_this.request(url, options ?: RequestConfig()));
                }
                 catch (error: Throwable) {
                    if (delay >= timeout) {
                        throw KuxFailImpl(900408);
                    }
                    if (retryCount < _this.maxRetryCount) {
                        retryCount++;
                        console.warn("\u8BF7\u6C42\u5931\u8D25\uFF0C\u6B63\u5728\u5C1D\u8BD5\u91CD\u8BD5\uFF08" + retryCount + "\uFF09", " at uni_modules/kux-request/common/retry.uts:38");
                        await(Utils().sleep(delay));
                        delay = Math.min(delay * 2, _this.maxDelay);
                        return doRequest();
                    } else {
                        val fail = KuxFailImpl(900500);
                        fail.cause = UniError(JSON.stringify(error));
                        throw fail;
                    }
                }
            }
            return UTSPromise(fun(resolve, reject) {
                kotlinx.coroutines.CoroutineScope(io.dcloud.uts.UTSAndroid.getDomCoroutineDispatcher()).async {
                    try {
                        val result = async();
                        resolve(if (result is UTSPromise<*>) {
                            @Suppress("UNCHECKED_CAST")
                            `await`(result as UTSPromise<Any>);
                        } else {
                            result as Any;
                        }
                        );
                    }
                     catch (e: Throwable) {
                        reject(e);
                    }
                }
                ;
            }
            );
        }
        return doRequest();
    }
}
open class BatchRequestManager {
    private var requests: UTSArray<UTSPromise<Any>> = utsArrayOf();
    open fun addRequest(request: UTSPromise<Any>): UTSPromise<Any> {
        this.requests.push(request);
        return request;
    }
    open fun addBatchRequest(requests: UTSArray<UTSPromise<Any>>): UTSArray<UTSPromise<Any>> {
        this.requests = requests;
        return this.requests;
    }
    open fun executeBatch(): UTSPromise<UTSArray<Any>> {
        suspend fun async(): Any? {
            val results = await(UTSPromise.all(this.requests));
            this.requests = utsArrayOf();
            return results;
        }
        return UTSPromise(fun(resolve, reject) {
            kotlinx.coroutines.CoroutineScope(io.dcloud.uts.UTSAndroid.getDomCoroutineDispatcher()).async {
                try {
                    val result = async();
                    resolve(if (result is UTSPromise<*>) {
                        @Suppress("UNCHECKED_CAST")
                        `await`(result as UTSPromise<UTSArray<Any>>);
                    } else {
                        result as UTSArray<Any>;
                    }
                    );
                }
                 catch (e: Throwable) {
                    reject(e);
                }
            }
            ;
        }
        );
    }
}
val useRequest = fun(options: UseOptions): Request {
    return Request(options);
}
;
val useInterceptor = fun(): InterceptorManager {
    return InterceptorManager();
}
;
fun useFilter(options: FilterOptions = FilterOptions()): RequestFilters {
    return RequestFilters(options);
}
val useURL = fun(url: String): URL {
    return URL(url);
}
;
val useUtils = fun(): Utils {
    return Utils();
}
;
val useRetry = fun(maxRetryCount: Number, initialDelay: Number, maxDelay: Number): RetryManager {
    return RetryManager(maxRetryCount, initialDelay, maxDelay);
}
;
val useBatchRequest = fun(): BatchRequestManager {
    return BatchRequestManager();
}
;
