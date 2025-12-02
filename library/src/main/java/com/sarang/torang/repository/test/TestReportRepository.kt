package com.sarang.torang.repository.test

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.sarang.torang.data.ReportReason
import com.sarang.torang.repository.ReportRepository
import kotlinx.coroutines.launch

@Composable
fun TestReportRepository(reportRepository: ReportRepository)
{
    var result by remember { mutableStateOf("") }
    val coroutine = rememberCoroutineScope()
    Column {
        Button(onClick = {
            coroutine.launch {
                try
                {
                    reportRepository.sendReportReason(ReportReason.ABUSE, 103)
                }
                catch (e: Exception)
                {
                    result = e.toString()
                }
            }
        }) {

        }
    }
}