package com.example.alfamind

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.alfamind.page.*
import com.example.alfamind.ui.theme.AlfamindTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlfamindTheme {
                var currentScreen by remember { mutableStateOf("SignUpSignIn") }

                when (currentScreen) {
                    "SignUpSignIn" -> SignUpSignInScreen(
                        onSkipClicked = { currentScreen = "Category" },
                        onSignInClicked = { currentScreen = "Registration" }
                    )
                    "Category" -> CategoryScreen(
                        onHomeClick = { currentScreen = "Category" },
                        onAccountClick = { currentScreen = "Registration" },
                        onStoreClick = { currentScreen = "StoreProfile" }
                    )
                    "Registration" -> RegistrationScreen(
                        onBackClicked = { currentScreen = "Category" },
                        onSkipClicked = { currentScreen = "Category" },
                        onSignUpClicked = { currentScreen = "SignUpSignIn" },
                        onSignInClicked = { currentScreen = "Category" }  // Navigate to Category on sign in
                    )
                    "StoreProfile" -> StoreProfileScreen(
                        onBackClicked = { currentScreen = "Category" },
                        onAccountClick = { currentScreen = "Registration" },
                        onStoreClick = { currentScreen = "StoreProfile" }, // No-op or handle accordingly
                        onProfileClick = { currentScreen = "ProfileStore" },
                        onHomeClick = { currentScreen = "Category" }
                    )
                    "ProfileStore" -> ProfileStoreScreen(
                        onBackClicked = { currentScreen = "StoreProfile" },
                        onSaveClicked = { currentScreen = "Category" } // Navigate to Category on save
                    )
                }
            }
        }
    }
}
