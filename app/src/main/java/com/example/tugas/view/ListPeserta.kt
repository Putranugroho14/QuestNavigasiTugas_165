package com.example.tugas.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugas.R

data class Peserta(
    val namaLengkap: String,
    val jenisKelamin: String,
    val statusKerja: String,
    val alamat: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListPesertaScreen(
    onBerandaClick: () -> Unit,
    onFormulirClick: () -> Unit
) {
    val dataPeserta = listOf(
        Peserta("Putra", "Laki-laki", "Mahasiswa", "Bantul"),
        Peserta("Asha", "Perempuan", "Mahasiswa", "Genuk")
    )

    Scaffold(
        topBar = { TopAppBar(title = { Text(stringResource(R.string.list_daftar_peserta)) }) },
        bottomBar = {
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = onBerandaClick) { Text(stringResource(R.string.btn_beranda)) }
                Button(onClick = onFormulirClick) { Text(stringResource(R.string.btn_formulir)) }
            }
        }
    ) { isiRuang ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(isiRuang).padding(horizontal = 16.dp),
            contentPadding = PaddingValues(vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(dataPeserta) { peserta ->
                ParticipantCard(peserta = peserta)
            }
        }
    }
}

