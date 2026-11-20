package com.example.praktikum8_roomdatabase.repositori

import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import com.example.praktikum8_roomdatabase.room.Siswa
import com.example.praktikum8_roomdatabase.room.SiswaDao
import kotlinx.coroutines.flow.Flow

interface RepositoriSiswa {
    fun getAllSiswaStream(): Flow<List<Siswa>>
    suspend fun insertSiswa(siswa: Siswa)
    //Edit 1 : tambah 3 fugngsi berikut
   fun getSiswaStream(id: Int): Flow<Siswa?>

   suspend fun  deleteSiswa(siswa: Siswa)

   suspend fun  updateSiswa(siswa: Siswa)
}
class OfflineRepositoriSiswa(private val siswaDao: SiswaDao): RepositoriSiswa {
    override fun getAllSiswaStream(): Flow<List<Siswa>> = siswaDao.getAllSiswa()
    override suspend fun insertSiswa(siswa: Siswa) = siswaDao.insert(siswa)
}
