package com.example.ppb_01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ppb_01.ui.theme.PPB01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PPB01Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, nama: String, nrp: String, kelas: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Hello $name!")
        Text(text = "Nama: $nama")
        Text(text = "Nrp: $nrp")
        Text(text = "Kelas: $kelas")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PPB01Theme {
        Greeting("Android", "Izzati Mukhammad", "5025201075", "PPB I")
    }
}
