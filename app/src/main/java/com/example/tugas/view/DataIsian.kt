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

    Scaffold(
        topBar = { TopAppBar(title = { Text("Formulir Pendaftaran") }) }
    ) { isiRuang ->
        Column(
            modifier = Modifier.padding(isiRuang).fillMaxSize().padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {}
            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = onBerandaBtnClick, modifier = Modifier.weight(1f).height(50.dp).padding(end = 8.dp), colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)) {
                    Text("Beranda", color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
                Button(
                    onClick = { showDialog = true },
                    modifier = Modifier.weight(1f).height(50.dp).padding(start = 8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text("Submit", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
    PopUp(
        showDialog = showDialog,
        onDismiss = { showDialog = false; onSumbitSuccess() },
        data = mapOf(
            "Nama" to namaLengkap.ifEmpty { "..." },
            "Jenis Kelamin" to selectedJenisKelamin,
            "Status" to selectedStatusKerja,
            "Alamat" to alamat.ifEmpty { "..." }
        )
    )
}
@Composable
fun RadioButtonOption(label: String, selected: Boolean, onClick: () -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = selected, onClick = onClick)
        Text(text = label, modifier = Modifier.padding(start = 4.dp))
    }
}