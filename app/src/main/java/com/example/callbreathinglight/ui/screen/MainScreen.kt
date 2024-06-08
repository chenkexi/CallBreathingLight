package com.example.callbreathinglight.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.callbreathinglight.MainViewModel
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
            allCheckboxClickable={ viewModel.showCheckbox = !viewModel.showCheckbox },
            settingClickable={ navController.navigate(RouterManage.SettingsScreen) })

        Scaffold(floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(30.dp),
                onClick = { navController.navigate(RouterManage.AddScreen) }) {
                Icon(Icons.Filled.Add, contentDescription = "Add")
            }
        }) {
            LightListComponent(
                lightLists = viewModel.lightDataList,
                modifier = Modifier.padding(it)
            )


        }
    }
}