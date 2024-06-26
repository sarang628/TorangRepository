## 테스트 폴더 만들기
app/src/ 경로에 androidTest 라고 만든다.


```
androidTestImplementation 'androidx.test.ext:junit:1.1.5' //@RunWith(AndroidJUnit4::class) @Test
androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1' // 없으면 테스트 실행시 AndroidJUnitRunner를
```


테스트 하고 싶은 코드 작성
```
@RunWith(AndroidJUnit4::class)
class LoginTest {

    @Inject
    lateinit var apiLogin: ApiLogin

    @Test
    fun loginTest() = runTest {
        apiLogin.emailLogin("sarang628@naver.com", "aaaaa")
    }
}
```

suspend function을 실행하기 위한 runTest 환경 구성하기
다른 라이브러리로는 추가가 잘 안돼 아래 라이브러리 추가
```
androidTestImplementation("androidx.compose.ui:ui-test-junit4") //runTest
```

## Hilt 테스트 환경 추가

API 의존성 주입 위해서는 아래와 같이 코드를 변경해줘야 한다.

```
@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class LoginTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var apiLogin: ApiLogin

    @Test
    fun loginTest() = runTest {
        apiLogin.emailLogin("sarang628@naver.com", "aaaaa")
    }
}
```

```
// For instrumented tests.
    androidTestImplementation 'com.google.dagger:hilt-android-testing:2.44'
```


```
java.lang.IllegalStateException: Hilt test, LoginTest, 
cannot use a @HiltAndroidApp application but found com.sarang.torang.RepositoryTestApplication. 
To fix, configure the test to use HiltTestApplication or a custom Hilt test application generated with @CustomTestApplication.
```

CustomTestRunner 추가하기
```
testInstrumentationRunner "com.sarang.torang.CustomTestRunner"
```

```
java.lang.RuntimeException: Hilt test, LoginTest, is missing generated file: 
com.sarang.torang.LoginTest_TestComponentDataSupplier. 
Check that the test class is  annotated with @HiltAndroidTest and that the processor is running over your test.
```

```
kaptAndroidTest 'com.google.dagger:hilt-android-compiler:2.44'
```


```
kotlin.UninitializedPropertyAccessException: lateinit property apiLogin has not been initialized
```

```
@Before
fun setUp() {
    hiltRule.inject()
}
```