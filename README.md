# 토랑 저장소

- 앱에서 필요로하는 데이터를 저장
- 앱에서 제공하는 서비스를 이해하여 필요한 데이터를 제공
- room library를 활용 flow data 제공하여 UDF를 적용.
- remote 서버와 통신, 데이터 동기화

## 의존성 추가

```
implementation 'com.github.sarang628:TorangRepository:최신커밋'
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