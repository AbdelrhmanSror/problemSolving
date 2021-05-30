package com.company.heaps

 fun Number.compareTo(other: Number, operator: Char): Boolean {
    val result = when (this) {
        is Long -> this.toLong().compareTo(other.toLong())
        is Int -> this.toInt().compareTo(other.toInt())
        is Short -> this.toShort().compareTo(other.toShort())
        is Byte -> this.toByte().compareTo(other.toByte())
        is Double -> this.toDouble().compareTo(other.toDouble())
        is Float -> this.toFloat().compareTo(other.toFloat())
        else -> throw RuntimeException("Unknown numeric type")
    }
    return operator == '>' && result == 1 || operator == '<' && result == -1 || operator == '=' && result == 0
}
