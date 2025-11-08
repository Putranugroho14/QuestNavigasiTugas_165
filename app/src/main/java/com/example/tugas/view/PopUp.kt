package com.example.tugas.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PopUp(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    data: Map<String, String>
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = {
                Text(
                    text = "Data Berhasil Disimpan",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            },
            text = {

                Column {
                    data.forEach { (key, value) ->
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                        ) {

                            Text(
                                text = "$key:",
                                modifier = Modifier.width(100.dp),
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = value,
                                modifier = Modifier.weight(1f)
                            )
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = onDismiss) {
                    Text("OK")
                }
            }
        )
    }
}