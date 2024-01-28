package com.sarang.torang.data

enum class Distances {
    NONE, _100M, _300M, _500M, _1KM, _3KM;

    val having: Float
        get() {
            return when (this) {
                NONE -> 999999f
                _100M -> 0.1f
                _300M -> 0.3f
                _500M -> 0.5f
                _1KM -> 1f
                _3KM -> 3f
            }
            return 9999f
        }
}