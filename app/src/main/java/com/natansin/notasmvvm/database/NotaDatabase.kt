package com.natansin.notasmvvm.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.natansin.notasmvvm.model.Nota


@Database(entities = [Nota::class], version = 1)
abstract class NotaDatabase: RoomDatabase() {

    abstract fun pegaNotaDao(): NotaDao

    companion object{

        @Volatile
        private var instance: NotaDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK){
            instance?:
            createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            NotaDatabase::class.java,
            "nota_database"
        ).build()

    }
}