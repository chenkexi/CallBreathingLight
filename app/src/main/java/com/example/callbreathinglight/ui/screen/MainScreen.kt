package com.example.callbreathinglight.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.callbreathinglight.MainViewModel
import com.example.callbreathinglight.R
import com.example.callbreathinglight.ui.component.LightListComponent
import com.example.callbreathinglight.ui.component.TitleTabComponent
import com.example.callbreathinglight.ui.router.RouterManage

/**
 *@author :ckx
 *@since: 2024/6/9
 *作用：
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
    val viewModel: MainViewModel = viewModel()
    Column {
        TitleTabComponent("呼吸灯列表",
            allCheckboxClickable = { viewModel.showCheckbox = !viewModel.showCheckbox },
            settingClickable = { navController.navigate(RouterManage.SettingsScreen) })

        Scaffold(floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(30.dp),
                onClick = { navController.navigate(RouterManage.AddScreen) }) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }
        }) {
            if (viewModel.lightDataList.isEmpty()) {
                emptyView { navController.navigate(RouterManage.AddScreen) }
            } else {
                LightListComponent(
                    lightLists = viewModel.lightDataList,
                    modifier = Modifier.padding(it)
                )
            }
        }
    }
}

@Composable
fun emptyView(addButtonClick: () -> Unit) {
    Column {
        Spacer(modifier = Modifier.weight(0.8f))
        Image(
            painterResource(id = R.drawable.empty),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(100.dp),
            colorFilter = ColorFilter.tint(Color(0xFFB9B8B7))
        )
        Text(
            text = "暂无呼吸灯，去创建一个吧",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            color = Color(0xFF8A8988)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = addButtonClick,
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
            Text(text = "去添加")
        }
        Spacer(modifier = Modifier.weight(1.8f))

    }
}