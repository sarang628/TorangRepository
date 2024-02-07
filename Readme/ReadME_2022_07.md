# 안드로이드 저장소 테스트 환경 설정하기

[TOC]

## 환경설정하기

### 의존성 추가하기

```
    /** HILT */
    implementation "com.google.dagger:hilt-android:$hiltVersion"
    kapt "com.google.dagger:hilt-android-compiler:$hiltVersion"
    kapt "androidx.hilt:hilt-compiler:$hiltViewModelVersion"
    annotationProcessor "androidx.hilt:hilt-compiler:$hiltViewModelVersion"

    // For Robolectric tests.
    //testImplementation("com.google.dagger:hilt-android-testing:2.38.1")
    // ...with Kotlin.
    //kaptTest("com.google.dagger:hilt-android-compiler:2.38.1")
    // ...with Java.
    //testAnnotationProcessor("com.google.dagger:hilt-android-compiler:2.38.1")
    
    // For instrumented tests.
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.38.1")
    // ...with Kotlin.
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.38.1")
    // ...with Java.
    //androidTestAnnotationProcessor("com.google.dagger:hilt-android-compiler:2.38.1")
```

### build.gradle TestRunner 설정하기

androidTest 폴더에 아래 파일 추가하기

```
// A custom runner to set up the instrumented application class for tests.
class CustomTestRunner : AndroidJUnitRunner() {

    override fun newApplication(cl: ClassLoader?, name: String?, context: Context?): Application {
        return super.newApplication(cl, HiltTestApplication::class.java.name, context)
    }
}
```

```
    defaultConfig {
        ...
        testInstrumentationRunner "해당파일_패키지명.CustomTestRunner"
    }
```

## 로그인 상태 만들기

```
@get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Inject
    lateinit var loggedInUserDao: LoggedInUserDao


    @Test
    fun login() {
        runBlocking {
            loggedInUserDao.insert(
                LoggedInUserEntity(
                    userId = 4
                )
            )
        }
    }
```

# Feed 테스트하기

피드 서비스 모듈

root build.gradle 서비스 모드 선택 정의하기

```
feedService = "\"real\"" // real, local, test
```


```
@InstallIn(SingletonComponent::class)
@Module
class FeedServiceModule {

    @Singleton
    @Provides
    fun provideFeedService(
        feedProductFeedService: ProductFeedService,
        localFeedService: LocalFeedService,
        testFeedServices: TestFeedService
    ): FeedServices {
        return when (BuildConfig.feedService) {
            "test" -> testFeedServices
            "local" -> localFeedService.create()
            "real" -> feedProductFeedService.create()
            else
            -> feedProductFeedService.create()
        }
    }
} 
```
