
package com.project.swwebcam.ui

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.project.swwebcam.ui.component.PermissionScreen
import com.project.swwebcam.ui.component.PreviewCamera

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MainScreen() {
    val campermission: PermissionState = rememberPermissionState(android.Manifest.permission.CAMERA)
    if(campermission.status.isGranted){
        PreviewCamera()
    }else{
        PermissionScreen { campermission.launchPermissionRequest() }
    }
}


