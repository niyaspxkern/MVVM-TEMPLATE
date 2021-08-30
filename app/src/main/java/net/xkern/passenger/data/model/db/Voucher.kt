package net.xkern.passenger.data.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "vouchers_table")
data class Voucher(
        @PrimaryKey
        @SerializedName("id")
        var id: String,
        @SerializedName("amount")
        var amount: String,
)