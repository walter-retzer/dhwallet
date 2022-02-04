package com.digitalhouse.dhwallet.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
class Card(
    val limite: String,
    val number: String,
    val name: String,
    val expireAt: String,
    @DrawableRes val brand: Int,
    @DrawableRes val background: Int
) : Parcelable
