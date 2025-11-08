package com.example.tugas.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataIsian(
    onSumbitSuccess: () -> Unit,
    onBerandaBtnClick: () -> Unit
) {
    var namaLengkap by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var selectedJenisKelamin by remember { mutableStateOf("Laki-laki") }
    var selectedStatusKerja by remember { mutableStateOf("Mahasiswa") }
    var showDialog by remember { mutableStateOf(false) }


}