package com.chrispassold.kotlinsample.data.local.entity

import android.arch.persistence.room.Entity
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Entity(primaryKeys = ["id"])
data class SampleEntity(
    @SerializedName("id")
    val id: Long,

    @SerializedName(value = "header", alternate = ["title", "name"])
    val header: String?
) : Parcelable {


    constructor(source: Parcel) : this(
        source.readLong(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeLong(id)
        writeString(header)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<SampleEntity> = object : Parcelable.Creator<SampleEntity> {
            override fun createFromParcel(source: Parcel): SampleEntity = SampleEntity(source)
            override fun newArray(size: Int): Array<SampleEntity?> = arrayOfNulls(size)
        }
    }
}