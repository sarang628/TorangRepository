package com.sarang.torang

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sarang.torang.data.remote.response.FilterApiModel
import com.sarang.torang.repository.FindRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

/**
 * runTest를 사용하면 코루틴 안에서 코드를 작성할 수 있다.
 */
@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class FindRepositoryTest {
    @get:Rule var hiltRule = HiltAndroidRule(this)
    @Inject lateinit var findRepository: FindRepository
    @Before fun setUp() { hiltRule.inject() }

    @Test
    fun loadFeedWithPageTest() = runTest {
        findRepository.search(FilterApiModel())
    }
}