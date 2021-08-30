package net.xkern.passenger.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import net.xkern.passenger.data.local.db.dao.VoucherDao
import net.xkern.passenger.data.model.db.Voucher

@Database(entities = [Voucher::class], version = 8)
abstract class AppDatabase : RoomDatabase() {
    abstract fun voucherDao(): VoucherDao
}