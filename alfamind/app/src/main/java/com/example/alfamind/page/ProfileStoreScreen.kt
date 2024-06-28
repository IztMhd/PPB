package com.example.alfamind.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alfamind.ui.theme.AlfamindTheme
import androidx.compose.ui.text.font.FontWeight

@Composable
fun ProfileStoreScreen(onBackClicked: () -> Unit, onSaveClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopAppBar(
            title = { Text("Profil Toko") },
            navigationIcon = {
                IconButton(onClick = { onBackClicked() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                }
            },
            backgroundColor = Color.White,
            contentColor = Color.Black
        )

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Data Toko",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Nama Saya
            Text(text = "Nama Saya*")
            TextField(
                value = "Labib",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            // Nama Toko
            Text(text = "Nama Toko*")
            TextField(
                value = "Labibs16",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            // Nomor HP
            Text(text = "Nomor Hp*")
            TextField(
                value = "081279740303",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            // Email Topup
            Text(text = "Email Topup")
            TextField(
                value = "6281279740303@tokovirtualku.com",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            // Alamat Toko
            Text(text = "Alamat TokoSaya*")
            TextField(
                value = "ASEMROWO, KOTA SURABAYA",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            // Simpan Button
            Button(
                onClick = { onSaveClicked() }, // Navigate to Beranda on click
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
            ) {
                Text(text = "Simpan", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileStoreScreenPreview() {
    AlfamindTheme {
        ProfileStoreScreen({}, {})
    }
}
