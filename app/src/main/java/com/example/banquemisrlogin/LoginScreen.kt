package com.example.banquemisrlogin

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.banquemisrlogin.ui.theme.DarkRed
import com.example.banquemisrlogin.ui.theme.LightRed

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    val locale = Locale.current
    val isArabic = com.example.banquemisrlogin.ui.theme.locale.language == "ar"
    val fontFamily = if (isArabic) FontFamily(Font(R.font.changa)) else FontFamily.Default

    Column(
        modifier = modifier
            .padding(top = 72.dp, start = 24.dp, end = 24.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 28.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.bm_icon),
                contentDescription = "Banque Misr",
            )
            Text(text = stringResource(R.string.language),
                fontFamily = FontFamily(Font(R.font.changa)),
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                color = DarkRed,
                modifier = modifier.clickable {})
        }
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var isPasswordVisible by remember {
            mutableStateOf(false)
        }
        CustomOutlinedTextField(
            value = username,
            onValueChange = { username = it },
            modifier = Modifier
                .padding(vertical = 28.dp)
                .fillMaxWidth()
                .height(64.dp),
            labelText = stringResource(R.string.username),
            visualTransformation = VisualTransformation.None,
        )
        CustomOutlinedTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),

            labelText = stringResource(R.string.password),
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        painter = if (isPasswordVisible) painterResource(id = R.drawable.outline_visibility_24)
                        else painterResource(id = R.drawable.outline_visibility_off_24),
                        contentDescription = "Toggle password visibility"
                    )
                }
            },
        )
        Text(
            text = stringResource(R.string.forgot_username_password),
            fontSize = 10.sp,
            style = TextStyle(textDecoration = TextDecoration.Underline),
            fontFamily = fontFamily,
            modifier = modifier
                .align(alignment = Alignment.Start)
                .padding(top = 20.dp)
        )
        Button(
            onClick = {},
            modifier
                .fillMaxWidth()
                .padding(top = 32.dp)
                .height(52.dp),
            shape = RoundedCornerShape(8.dp),
            enabled = username.isNotEmpty() && (password.isNotEmpty() && password.length >= 6),
            colors = ButtonColors(
                contentColor = Color.White,
                disabledContainerColor = LightRed,
                disabledContentColor = Color.White,
                containerColor = if (username.isNotEmpty() && password.isNotEmpty()) DarkRed else LightRed
            ),

            ) {
            Text(
                text = stringResource(R.string.login),
                style = TextStyle(fontWeight = FontWeight.Bold, fontFamily = fontFamily)
            )


        }
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        ) {
            Text(
                text = stringResource(R.string.need_help),
                fontSize = 12.sp,
                modifier = modifier.padding(end = 2.dp)

            )
            Text(
                text = stringResource(R.string.contact_us),
                fontSize = 12.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                color = DarkRed,
                style = TextStyle(textDecoration = TextDecoration.Underline),
            )
        }
        HorizontalDivider(
            modifier = modifier.padding(top = 48.dp, bottom = 16.dp),
            thickness = 1.dp,
            color = Color.LightGray
        )
        Row(
            modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomService(
                serviceName = stringResource(R.string.our_products),
                serviceImage = R.drawable.our_products
            )
            CustomService(
                serviceName = stringResource(R.string.exchange_rate),
                serviceImage = R.drawable.exchange_rate
            )
            CustomService(
                serviceName = stringResource(R.string.security_tips),
                serviceImage = R.drawable.security_tips
            )
            CustomService(
                serviceName = stringResource(R.string.nearest_branch_or_atm),
                serviceImage = R.drawable.nearest_branch_or_atm
            )


        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}