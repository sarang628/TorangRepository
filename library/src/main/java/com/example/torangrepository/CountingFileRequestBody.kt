package com.example.torangrepository

import okio.source
import okhttp3.internal.closeQuietly
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okio.BufferedSink
import okio.Source
import java.io.File
import java.io.IOException

class CountingFileRequestBody(
    private val file: File,
    private val contentType: String,
    private val listener: ProgressListener
) : RequestBody() {
    override fun contentLength(): Long {
        return file.length()
    }

    override fun contentType(): MediaType? {
        return contentType.toMediaTypeOrNull()
    }

    @Throws(IOException::class)
    override fun writeTo(sink: BufferedSink) {
        var source: Source? = null
        try {
            source = file.source()
            var total: Long = 0
            var read: Long
            while (source.read(sink.buffer(), SEGMENT_SIZE.toLong()).also { read = it } != -1L) {
                total += read
                sink.flush()
                listener.transferred(total)
            }
        } finally {
            source!!.closeQuietly()
        }
    }

    interface ProgressListener {
        fun transferred(num: Long)
    }

    companion object {
        private const val SEGMENT_SIZE = 2048
    }
}