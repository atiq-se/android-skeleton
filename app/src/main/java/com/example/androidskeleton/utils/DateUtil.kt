package com.ebayk.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {

    private const val ISO_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
    private const val SIMPLE_DATE_FORMAT = "dd.MM.yyyy"

    fun format(
        date: String?,
        dateInFormat: String = ISO_DATE_FORMAT,
        dateOutFormat: String = SIMPLE_DATE_FORMAT
    ): String {
        if (date.isNullOrEmpty()) {
            return ""
        }
        return try {
            val inFormat = SimpleDateFormat(dateInFormat, Locale.getDefault())
            val outFormat = SimpleDateFormat(dateOutFormat, Locale.getDefault())
            val backendDate = inFormat.parse(date) ?: return ""
            outFormat.format(backendDate) ?: return ""
        } catch (_: Throwable) {
            ""
        }
    }
}
