package com.iot.composeapp.presentation.compose.screens

import android.util.Log
import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iot.composeapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnhancedLoginScreen(
    onLoginClick: (String, String) -> Unit,
    onSignUpClick: () -> Unit,

    ) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }

    val isValidEmail = remember(email) {
        email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    val isValidPassword = remember(password) {
        password.length >= 6
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Logo/App Icon
            Icon(
                imageVector = Icons.Filled.Lock,
                contentDescription = "App Logo",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(80.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Login to OTA ",
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
            )

            Spacer(modifier = Modifier.height(48.dp))

            // Email Field with Validation
            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                    emailError = null
                },
                label = { Text("Email Address") },
                leadingIcon = {
                    Icon(Icons.Filled.Email, contentDescription = "Email")
                },
                isError = emailError != null,
                supportingText = {
                    if (emailError != null) {
                        Text(text = emailError!!)
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password Field with Validation
            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                    passwordError = null
                },
                label = { Text("Password") },
                leadingIcon = {
                    Icon(Icons.Filled.Lock, contentDescription = "Password")
                },
                visualTransformation = PasswordVisualTransformation(),
                isError = passwordError != null,
                supportingText = {
                    if (passwordError != null) {
                        Text(text = passwordError!!)
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Remember me and Forgot Password Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = false,
                        onCheckedChange = { /* Handle remember me */ }
                    )
                    Text("Remember me")
                }

                TextButton(onClick = { /* Handle forgot password */ }) {
                    Text("Forgot Password?")
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Login Button
            Button(
                onClick = {
                    // Validate inputs
                    when {
                        email.isEmpty() -> emailError = "Email is required"
                        !isValidEmail -> emailError = "Enter a valid email"
                        password.isEmpty() -> passwordError = "Password is required"
                        !isValidPassword -> passwordError = "Password must be at least 6 characters"
                        else -> {
                            isLoading = true
                            onLoginClick(email, password)
                            // Reset loading after login attempt
                            /*LaunchedEffect(Unit) {
                                delay(2000) // Simulate network call
                                isLoading = false
                            }*/
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                enabled = !isLoading && email.isNotEmpty() && password.isNotEmpty(),
                shape = RoundedCornerShape(12.dp)
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        color = Color.White,
                        strokeWidth = 2.dp
                    )
                } else {
                    Text(
                        text = "Sign In",
                        style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Social Login Section
            /*Text(
                text = "Or continue with",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodyMedium
            )
            */
            //Spacer(modifier = Modifier.height(16.dp))
            /*
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Google Sign In Button
                OutlinedButton(
                    onClick = onGoogleSignIn,
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp),
                    border = ButtonDefaults.outlinedButtonBorder.copy(
                        width = 1.dp
                    )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_google), // Add your own icon
                        contentDescription = "Google",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Google")
                }

                // Facebook Sign In Button
                OutlinedButton(
                    onClick = onFacebookSignIn,
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp),
                    border = ButtonDefaults.outlinedButtonBorder.copy(
                        width = 1.dp
                    )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_google), // Add your own icon
                        contentDescription = "Facebook",
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Facebook")
                }
            }
            */
            Spacer(modifier = Modifier.height(32.dp))

            // Sign Up Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Don't have an account? ",
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                TextButton(onClick = onSignUpClick) {
                    Text(
                        text = "Sign Up",
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}
@Composable
fun OTALogin(appname:String, status: String, modifier: Modifier = Modifier){
    Row() {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(vertical = 100.dp, horizontal = 50.dp)
                .padding(16.dp)
                .border(2.dp, Color.Blue)
                .padding(10.dp)
                .border(2.dp, Color.Red)
                .padding(6.dp)
        ) {
            val myLogo = painterResource(id = R.drawable.bcont)
            Image(
                painter = myLogo,
                modifier = Modifier.padding(16.dp),
                contentDescription = "OTA BLE"
            )
            Text(
                text = "$appname ",
                color = Color.Red,
                fontSize = 25.sp,
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )

            /* Text(
                 "$status ...",
                 color = Color.Blue,
                 fontSize = 16.sp,
                 fontStyle = FontStyle.Normal,
                 fontFamily = FontFamily.Default,
             )
             */

            //SimpleButton(modifier)
            Spacer (modifier = Modifier.height(30.dp))
            AddPassward()
            Spacer (modifier = Modifier.height(30.dp))
            EnableOTAButton(onClick = { Log.v("OTA","Enable OTA")})
        }
    }

}

@Composable
fun ShowMyLogo(){
    val myLogo = painterResource(id = R.drawable.bcont)
    Image(
        painter = myLogo,
        modifier = Modifier.padding(2.dp),
        contentDescription = "OTA BLE")
}

@Composable
fun SimpleButton(modifier: Modifier= Modifier){
    Button(
        onClick = { Log.v("OTA","Enable OTA")},
        modifier = Modifier.padding(vertical = 20.dp)
    ) {
        Text("Enable")
    }
}

@Composable
fun EnableOTAButton(onClick: () -> Unit, ){
    ElevatedButton(onClick = onClick,
        elevation = ButtonDefaults.buttonElevation(8.dp)) {
        Text("Enable")
    }
}

@Composable
fun AddPassward(){
    var password by remember { mutableStateOf(TextFieldValue()) }

    TextField(
        value = password,
        onValueChange = {
                newValue -> password = newValue
        }
    )


}

@Preview
@Composable
fun PreviewMessageCard(){
    OTALogin("BLE OTA ", "Connecting to device")
    //EnhancedLoginScreen({},{},{},{} )
}
