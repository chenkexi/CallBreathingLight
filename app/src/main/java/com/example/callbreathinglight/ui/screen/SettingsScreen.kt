package com.example.callbreathinglight.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 *@author :ckx
 *@since: 2024/6/9
 *作用：权限设置页面
 */
@Composable
fun SettingsScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Spacer(modifier = Modifier.width(20.dp))
            Box(
                modifier = Modifier
                    .height(26.dp)
                    .width(5.dp)
                    .background(color = Color(0xFFE44D4D))
            )

            Text(text = "增强设置", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        }
        Text(
            text = "1. 悬浮框，自启动",
            fontSize = 16.sp,
            modifier = Modifier.padding(20.dp, 20.dp, 20.dp, 0.dp)
        )
        Text(
            "自启动权限可极大提高产品稳定性，强烈建议开启",
            fontSize = 14.sp,
            modifier = Modifier.padding(20.dp, 0.dp, 20.dp, 0.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(80.dp, 0.dp, 80.dp, 0.dp)
                .height(44.dp)
                .align(Alignment.CenterHorizontally),
            border = BorderStroke(1.dp, Color(0xFFB43807)),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color(0xFFB43807),
                disabledContentColor = Color.Gray,
                disabledContainerColor = Color.White
            )
        ) {
            Text(text = "去开启")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Divider(
            Modifier.padding(20.dp, 0.dp, 20.dp, 0.dp),
            color = Color.LightGray,
            thickness = 1f.dp
        )

        Text(
            text = "2. 允许后台运行",
            fontSize = 16.sp,
            modifier = Modifier.padding(20.dp, 20.dp, 20.dp, 0.dp)
        )
        Text(
            "允许后台运行同样可极大提高产品稳定性，强烈建议开启",
            fontSize = 14.sp,
            modifier = Modifier.padding(20.dp, 0.dp, 20.dp, 0.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(80.dp, 0.dp, 80.dp, 0.dp)
                .height(44.dp)
                .align(Alignment.CenterHorizontally),
            border = BorderStroke(1.dp, Color(0xFFB43807)),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color(0xFFB43807),
                disabledContentColor = Color.Gray,
                disabledContainerColor = Color.White
            )
        ) {
            Text(text = "去开启")
        }
    }
}