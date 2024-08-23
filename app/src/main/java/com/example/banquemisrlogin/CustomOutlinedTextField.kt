package com.example.banquemisrlogin

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.banquemisrlogin.ui.theme.Black
import com.example.banquemisrlogin.ui.theme.locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    labelText: String,
    trailingIcon: @Composable () -> Unit = {},
    visualTransformation: VisualTransformation = VisualTransformation.None,

    ) {
    val isArabic = locale.language == "ar"
    val fontFamily = if (isArabic) FontFamily(Font(R.font.changa)) else FontFamily.Default

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = labelText,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Medium,
                color = Gray
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.LightGray,
            unfocusedBorderColor = Color.LightGray,
            cursorColor = Black,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.LightGray
        ),
        textStyle = TextStyle(
            color = Black,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.lexendt))
        ),
        visualTransformation = visualTransformation,
        trailingIcon = trailingIcon,
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
    )
}