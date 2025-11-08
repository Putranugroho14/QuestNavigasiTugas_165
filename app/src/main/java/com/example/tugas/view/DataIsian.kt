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
        ) {
            Card(
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {


                    Text(text = "NAMA LENGKAP", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                    OutlinedTextField(
                        value = namaLengkap, onValueChange = { namaLengkap = it },
                        label = { Text("Isikan nama lengkap") },
                        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp), singleLine = true
                    )


                    Text(text = "JENIS KELAMIN", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        RadioButtonOption(label = "Laki-laki", selected = selectedJenisKelamin == "Laki-laki", onClick = { selectedJenisKelamin = "Laki-laki" })
                        RadioButtonOption(label = "Perempuan", selected = selectedJenisKelamin == "Perempuan", onClick = { selectedJenisKelamin = "Perempuan" })
                    }

                    Spacer(modifier = Modifier.height(8.dp))


                    Text(text = "STATUS PERKERJAAN", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            RadioButtonOption(label = "Mahasiswa", selected = selectedStatusKerja == "Mahasiswa", onClick = { selectedStatusKerja = "Mahasiswa" })
                            RadioButtonOption(label = "Wiraswasta", selected = selectedStatusKerja == "Wiraswasta", onClick = { selectedStatusKerja = "Wiraswasta" })
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth().padding(top = 4.dp), // Menambahkan jarak atas
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            RadioButtonOption(label = "Guru", selected = selectedStatusKerja == "Guru", onClick = { selectedStatusKerja = "Guru" })
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))


                    Text(text = "ALAMAT", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                    OutlinedTextField(
                        value = alamat, onValueChange = { alamat = it },
                        label = { Text("Isikan alamat") },
                        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp), minLines = 3
                    )
                }
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