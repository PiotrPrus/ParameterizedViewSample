package com.example.piotrprus.parameterizedviewsample

import android.content.Context
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class Params(
    val mainImageResId: Int,
    val mainText: String,
    val secondaryText: String,
    val mainButtonText: String,
    val secondaryButtonText: String,
    val mainButtonFunction: Serializable,
    val secondaryButtonFunction: Serializable
) : Parcelable {
    @Suppress("UNCHECKED_CAST")
    fun mainOnClick() = mainButtonFunction as (Context) -> Unit

    @Suppress("UNCHECKED_CAST")
    fun secondaryOnClick() = secondaryButtonFunction as (Context) -> Unit

    companion object {
        fun create(
            mainImageResId: Int,
            mainText: String,
            secondaryText: String,
            mainButtonText: String,
            secondaryButtonText: String,
            mainButtonFunction: (Context) -> Unit = {},
            secondaryButtonFunction: (Context) -> Unit = {}
        ): Params = Params(
            mainImageResId,
            mainText,
            secondaryText,
            mainButtonText,
            secondaryButtonText,
            mainButtonFunction as Serializable,
            secondaryButtonFunction as Serializable
        )
    }
}