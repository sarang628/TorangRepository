# 안드로이드 저장소 테스트 환경 설정하기

[TOC]

## 환경설정하기

```
@Singleton
class FeedServiceProductImpl @Inject constructor(
    private val torangOkHttpClientImpl: TorangOkhttpClient,
    private val retrofitModule: RetrofitModule
) {
    private var url = "http://sarang628.iptime.org:8081/"

    //    private var url = "https://www.vrscoo.com:8080/"
    fun create(): FeedServices {
        return retrofitModule
            .getRetrofit(torangOkHttpClientImpl.getUnsafeOkHttpClient(), url)
            .create(FeedServices::class.java)
    }
}
```

# Feed 테스트하기

피드 서비스 모듈

```
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var feedServices: FeedServices

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            /*FeedRepositoryTest(
                context = this@MainActivity,
                feedDao = feedDao,
                pictureDao = pictureDao
            )*/


            FeedServiceTest(feedServices)
        }
    }
}
```

# 피드 서비스 모듈 설정하기

```
/**
 * 피드 서비스 Product
 */
@Singleton
class FeedServiceProductImpl @Inject constructor(
    private val torangOkHttpClientImpl: TorangOkhttpClient,
    private val retrofitModule: RetrofitModule
) {
    private var url = "http://sarang628.iptime.org:8081/"
    fun create(): FeedServices {
        return retrofitModule
//            .getRetrofit(torangOkHttpClientImpl.getUnsafeOkHttpClient(), url)
            .getRetrofit(torangOkHttpClientImpl.getHttpClient(), url)
            .create(FeedServices::class.java)
    }
}
```

```
@Composable
fun FeedServiceTest(feedServices: FeedServices) {
    val scope = rememberCoroutineScope()

    var error: String by remember { mutableStateOf("") }
    var padding: String by remember { mutableStateOf("") }
    var loading: Boolean by remember { mutableStateOf(false) }

    Column {
        Text(text = "FeedServiceTest")
        Button(onClick = {
            if (loading)
                return@Button

            loading = true
            scope.launch {
                try {
                    val result = feedServices.getFeeds(HashMap())
                    padding = GsonBuilder().setPrettyPrinting().create().toJson(result)
                } catch (e: SSLException) {
                    Log.e("sryang123", e.toString())
                    error = e.toString()
                    loading = false
                } catch (e: SocketTimeoutException) {
                    Log.e("sryang123", e.toString())
                    error = e.toString()
                    loading = false
                } catch (e: HttpException){
                    Log.e("sryang123", e.toString())
                    error = e.toString()
                    loading = false
                }
            }
        }) {
            if (loading) {
                Text(text = "요청중")
            } else {
                Text(text = "요청하기")
            }
        }
        if (padding.isNotBlank())
            Text(text = padding)
        if (error.isNotBlank())
            Text(text = error)
        if (loading)
            CircularProgressIndicator()
    }
}
```