# 토랑 저장소

## 역할

앱에서 필요로하는 데이터를 저장하는 역할<br>
앱에서 제공하는 서비스를 전반적으로 이해하여 필요로하는 데이터를 제공<br>
변경과 유지보수가 유연하게 설계하기

## 서비스

내부 DB 데이터 UDF가 적용된 FLOW 데이터 타입으로 제공
원격 서버와 통신하여 데이터 동기화 및 UI에서 필요로하는 API 제공
자주 변경되는 API는 UI에서 직접 구현 할 수 있는 API 호출 가이드 제공

## API 자동화 테스트 필요

- [테스트 환경 구성하기](./Documents/Test%20Enviroment.md)

## 의존성 추가

```
implementation 'com.github.sarang628:TorangRepository:928fce8039'
```

```
/** root build.gradle */
room_version = "2.5.1"
/** Room */
implementation "androidx.room:room-runtime:$room_version"
annotationProcessor "androidx.room:room-compiler:$room_version"
// To use Kotlin annotation processing tool (kapt)
kapt "androidx.room:room-compiler:$room_version"
// optional - RxJava2 support for Room
implementation "androidx.room:room-rxjava2:$room_version"
// optional - RxJava3 support for Room
implementation "androidx.room:room-rxjava3:$room_version"
// optional - Guava support for Room, including Optional and ListenableFuture
implementation "androidx.room:room-guava:$room_version"
// optional - Test helpers
testImplementation "androidx.room:room-testing:$room_version"
// optional - Paging 3 Integration
implementation "androidx.room:room-paging:$room_version"
```

```
/** Retrofit */
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
implementation 'com.squareup.okhttp3:logging-interceptor:4.10.0'
```

## 안드로이드 저장소 테스트 환경 설정하기

### 환경설정하기

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

### Feed 테스트하기

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

### 피드 서비스 모듈 설정하기

```
@InstallIn(SingletonComponent::class)
@Module
class RestaurantServiceModule {
    @Singleton
    @Provides
    fun provideFeedServiceService(
        productFeedServiceImpl: FeedServiceProductImpl
    ): FeedServices {
        return productFeedServiceImpl.create()
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

# 모듈 추가하기

```
// 모듈에 주입해야하는 구현채
git submodule add (or git clone) https://github.com/sarang628/repository.git

// 모듈 추가
implementation("com.github.sarang628:TorangRepository:e0d12661da")

implementation("com.squareup.retrofit2:retrofit:2.9.0")
implementation("com.squareup.retrofit2:converter-gson:2.9.0")
implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")

implementation("androidx.room:room-runtime:2.5.1")
annotationProcessor("androidx.room:room-compiler:2.5.1")
implementation("androidx.room:room-paging:2.5.1")
```

```
android.buildFeatures.buildConfig = true

    buildTypes {
        getByName("debug") {
            buildConfigField("String", "SERVER_URL", "\"http://sarang628.iptime.org\"")
            buildConfigField("String", "IMAGE_PORT", "\"89\"")
            buildConfigField("String", "PROFILE_IMAGE_SERVER_URL", "\"http://sarang628.iptime.org:89/profile_images/\"")
            buildConfigField("String", "REVIEW_IMAGE_SERVER_URL", "\"http://sarang628.iptime.org:89/review_images/\"")
            buildConfigField("String", "RESTAURANT_IMAGE_SERVER_URL", "\"http://sarang628.iptime.org:89/restaurant_images/\"")
            buildConfigField("String", "MENU_IMAGE_SERVER_URL", "\"http://sarang628.iptime.org:89/menu_images/\"")
        }

        getByName("release") {
            buildConfigField("String", "SERVER_URL", "\"http://sarang628.iptime.org\"")
            buildConfigField("String", "IMAGE_PORT", "\"89\"")
            buildConfigField("String", "PROFILE_IMAGE_SERVER_URL", "\"http://sarang628.iptime.org:89/profile_images/\"")
            buildConfigField("String", "REVIEW_IMAGE_SERVER_URL", "\"http://sarang628.iptime.org:89/review_images/\"")
            buildConfigField("String", "RESTAURANT_IMAGE_SERVER_URL", "\"http://sarang628.iptime.org:89/restaurant_images/\"")
            buildConfigField("String", "MENU_IMAGE_SERVER_URL", "\"http://sarang628.iptime.org:89/menu_images/\"")
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("debug")
        }
    }

```

### 2025.01 피드(리뷰)를 이미지만 추출, 그리드 형식으로 보여주는 화면을 위한 데이터 제공 기능 구현
