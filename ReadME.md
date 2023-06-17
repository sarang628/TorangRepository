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


```
@Composable
fun FeedServiceTest(feedServices: FeedServices) {
    val scope = rememberCoroutineScope()

    var error: String by remember { mutableStateOf("") }
    var padding: String by remember { mutableStateOf("") }
    LaunchedEffect(key1 = "", block = {
        scope.launch {
            try {
                val result = feedServices.getFeeds(HashMap())
                padding = GsonBuilder().setPrettyPrinting().create().toJson(result)
            } catch (e: SSLException) {
                Log.e("sryang123", e.toString())
                error = e.toString()
            }
        }
    })

    Column {
        Text(text = "FeedServiceTest")
        Text(text = padding)
        Text(text = error)
    }
}
```