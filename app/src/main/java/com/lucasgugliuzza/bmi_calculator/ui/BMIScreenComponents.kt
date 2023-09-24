package com.lucasgugliuzza.bmi_calculator.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucasgugliuzza.bmi_calculator.R
import com.lucasgugliuzza.bmi_calculator.theme.NormalGreen
import com.lucasgugliuzza.bmi_calculator.theme.Orange
import com.lucasgugliuzza.bmi_calculator.theme.OverweightRed
import com.lucasgugliuzza.bmi_calculator.theme.UnderweightBlue


@Composable
fun UnitItem(
    text: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier.clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            fontSize = 22.sp
        )
        Icon(
            imageVector = Icons.Default.ArrowDropDown, contentDescription = "Select Icon"
        )

    }
}


@Composable
fun InputUnitValue(
    inputValue: String,
    inputUnit: String,
    inputColor: Color,
    onUnitValueClicked: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.End
    ) {
        Text(
            text = inputValue,
            fontSize = 40.sp,
            color = inputColor,
            modifier = Modifier.clickable { onUnitValueClicked() },
        )
        Text(text = inputUnit, fontSize = 12.sp)
    }

}

@Composable
fun NumberKeyboard(
    modifier: Modifier = Modifier,
    onNumberClick: (String) -> Unit
) {

    Column(
        modifier = modifier
    ) {

        val numberButtonList = listOf(
            "7", "8", "9", "4", "5", "6",
            "1", "2", "3", "", "0", "."
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3)
        ) {
            items(numberButtonList) { item ->
                NumberButton(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f),
                    number = item,
                    onClick = { onNumberClick(item) }
                )
            }
        }
    }

}


@Composable
fun NumberButton(
    number: String,
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .padding(10.dp)
            .clip(CircleShape)
            .clickable { onClick(number) }
    ) {
        Text(text = number, fontSize = 40.sp)
    }
}

@Composable
fun ColumnScope.SymbolButton(
    symbol: String,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(20.dp)
            .clip(RoundedCornerShape(15.dp))
            .clickable { onClick() }
            .padding(15.dp)
            .weight(1f)
            .aspectRatio(1f)
    ) {
        Text(text = symbol, fontSize = 26.sp, color = Orange)
    }


}

@Composable
fun ColumnScope.SymbolButtonWithIcon(
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(20.dp)
            .clip(RoundedCornerShape(15.dp))
            .clickable { onClick() }
            .padding(15.dp)
            .weight(1f)
            .aspectRatio(1f)
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_backspace),
            contentDescription = "delete icon",
            tint = Orange
        )
    }
}

@Composable
fun BMIResultCard(
    bmi:Double,
    bmiStage :String = "Normal",
    bmiStageColor:Color = NormalGreen
) {

    Column(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(15.dp)
            )
            .clip(RoundedCornerShape(15.dp))
            .background(Color.White)
            .padding(20.dp)

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "$bmi",
                fontSize = 70.sp,
                color = Orange
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "BMI",
                    fontSize = 40.sp,
                    color = Color.Gray
                )
                Text(
                    text = bmiStage,
                    fontSize = 18.sp,
                    color = bmiStageColor
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Divider(
            modifier = Modifier
                .background(Color.Gray)
                .shadow(elevation = 5.dp),
            thickness = 5.dp
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Information",
            textAlign = TextAlign.Center,
            color = Color.Gray,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "Underweight", color = UnderweightBlue)
            Text(text = "Normal", color = NormalGreen)
            Text(text = "Overweight", color = OverweightRed)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Divider(
                modifier = Modifier
                    .weight(1f),
                color = UnderweightBlue,
                thickness = 5.dp
            )
            Divider(
                modifier = Modifier
                    .weight(1f),
                color = NormalGreen,
                thickness = 5.dp
            )
            Divider(
                modifier = Modifier
                    .weight(1f),
                color = OverweightRed,
                thickness = 5.dp
            )
        }
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "16.0", fontSize = 18.sp, color = Color.DarkGray)
            Text(text = "18.5", fontSize = 18.sp, color = Color.DarkGray)
            Text(text = "25.0", fontSize = 18.sp, color = Color.DarkGray)
            Text(text = "40.0", fontSize = 18.sp, color = Color.DarkGray)
        }
    }
}

@Composable
fun ShareButton(
    modifier: Modifier =Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Orange,
            contentColor = Color.White
        )
    ) {
        Text(
            text = "Share",
            modifier = Modifier.padding(10.dp)
        )
    }
}

@Composable
fun BottomSheetContent(
    sheetTitle:String,
    sheetItemList : List<String>,
    onItemClicked : (String) -> Unit,
    onCancelClicked : () -> Unit
) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        text = sheetTitle ,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
        sheetItemList.forEach{
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClicked(it)  }
        ) {
            Text(text = it , modifier = Modifier.padding(15.dp))
        }
    }
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        onClick = { onCancelClicked() },
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Black,
            backgroundColor = Color.LightGray
        )
    ) {
        Text(text = "Cancel")
    }
}


@Preview(showBackground = true)
@Composable
fun UnitItemPreview() {
    Column {

    }

}