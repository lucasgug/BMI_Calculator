package com.lucasgugliuzza.bmi_calculator.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucasgugliuzza.bmi_calculator.theme.Orange

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BMIScreen() {


    ModalBottomSheetLayout(
        sheetContent = {

        },
        content = { //contenido principal de la pantalla
            ScreenContent()
        }
    )

}

@Composable
fun ScreenContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(15.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "BMI Calculator",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                UnitItem(
                    text = "Weight",
                    onClick = {}
                )

                InputUnitValue(
                    inputValue = "80",
                    inputUnit = "Kilograms",
                    inputColor = Orange ,
                    onUnitValueClicked = {}
                )

            }

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                UnitItem(
                    text = "Height",
                    onClick = {}
                )

                InputUnitValue(
                    inputValue = "170",
                    inputUnit = "Centimeters",
                    inputColor = Orange ,
                    onUnitValueClicked = {}
                )

            }



        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        ) {

            Divider()

            Spacer(modifier = Modifier.height(20.dp))

            Row (
                modifier = Modifier.fillMaxSize()
            ){
                NumberKeyboard(
                    modifier = Modifier.weight(7f),
                    onNumberClick = {}
                )
                Column(
                    modifier = Modifier.weight(3f)
                ) {
                    SymbolButton(symbol = "AC", onClick = {})
                    SymbolButtonWithIcon(onClick = {} )
                    SymbolButton(symbol = "GO", onClick = {})

                }
            }

        }

    }

}






@Preview(showBackground = true)
@Composable
fun BMIScreenPreview() {
    BMIScreen()
}