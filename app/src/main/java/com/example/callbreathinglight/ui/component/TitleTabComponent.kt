package com.example.callbreathinglight.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.callbreathinglight.MainViewModel
import com.example.callbreathinglight.R

/**
 *@author :ckx
 *@since: 2024/6/7
 *作用：主页标题栏
 */

@Composable
fun TitleTabComponent(text: String,allCheckboxClickable : () -> Unit,settingClickable : () -> Unit) {
    Row (modifier = Modifier.padding(20.dp)){
        Text(
            text = text,
            color = Color.Black,
            fontSize = 24.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .weight(1f),
            fontWeight = FontWeight.Bold,
            maxLines = 1
        )
        Image(
            painterResource(id = R.drawable.all_select),
            contentDescription = null,
            modifier = Modifier.size(20.dp).clickable {
                allCheckboxClickable()
            }
        )
        Spacer(modifier =Modifier.size(20.dp))
        Image(
            painterResource(id = R.drawable.setting),
            contentDescription = null,
            modifier = Modifier.size(20.dp).clickable {
                settingClickable()
            }
        )
    }
}

