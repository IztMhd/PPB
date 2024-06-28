package com.example.alfamind.page

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alfamind.R
import com.example.alfamind.ui.theme.AlfamindTheme

@Composable
fun SignUpSignInScreen(onSkipClicked: () -> Unit, onSignInClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.alfamind_logo),
                        contentDescription = "Alfamind Logo",
                        modifier = Modifier.size(100.dp)
                    )
                    Text(
                        text = "Lewati",
                        color = Color.White,
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable { onSkipClicked() }
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Jadi Store Owner di Alfamind",
                    fontSize = 28.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Wujudkan mimpi kamu memiliki toko ritel sendiri dan dapatkan penghasilan yang melimpah.",
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 24.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            var phoneNumber by remember { mutableStateOf(TextFieldValue("")) }

            BasicTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .border(BorderStroke(1.dp, Color.Red))
                    .padding(16.dp),
                singleLine = true,
                textStyle = TextStyle.Default.copy(color = Color.Black),
                decorationBox = { innerTextField ->
                    if (phoneNumber.text.isEmpty()) {
                        Text(
                            text = "Nomor HP Kamu",
                            color = Color.Gray
                        )
                    }
                    innerTextField()
                }
            )
            Text(
                text = "Dengan mendaftar atau masuk, Kamu secara otomatis menyetujui Syarat & Ketentuan yang berlaku.",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
            )
            Button(
                onClick = { /* Handle sign up */ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(text = "Daftar", fontSize = 16.sp, color = Color.White)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Sudah Punya akun?", color = Color.Black, fontSize = 14.sp)
                Spacer(modifier = Modifier.width(4.dp))
                TextButton(onClick = { onSignInClicked() }) {
                    Text(text = "Masuk di sini", color = Color.Red, fontSize = 14.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpSignInScreenPreview() {
    AlfamindTheme {
        SignUpSignInScreen({}, {})
    }
}
