package io.fotoapparat.parameter

import android.support.annotation.IntRange

/**
 * Resolution. Units in pixels.
 */
data class Resolution(
        @[JvmField IntRange(from = 0L)] val width: Int,
        @[JvmField IntRange(from = 0L)] val height: Int
) : Parameter {

    /**
     * The total area this [Resolution] is covering.
     */
    val area: Int by lazy { width * height }

    /**
     * The aspect ratio for this size. [Float.NaN] if invalid dimensions.
     */
    val aspectRatio: Float by lazy {
        when {
            width == 0 -> Float.NaN
            height == 0 -> Float.NaN
            else -> width.toFloat() / height
        }
    }

    /**
     * @return new instance of [Resolution] with width and height being swapped.
     */
    fun flipDimensions(): Resolution = Resolution(height, width)

}