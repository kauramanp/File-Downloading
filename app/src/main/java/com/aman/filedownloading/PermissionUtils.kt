package com.aman.filedownloading

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class PermissionUtils {
}


fun AppCompatActivity.checkForStoragePermissions(proceed: () -> Unit) {
    val launcher = activityResultRegistry.register(
        "Result",
        ActivityResultContracts.RequestPermission()
    ) {
        if (it) {
            proceed()
        } else {
            toast(getString(R.string.permission_denied))
        }
    }

    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
        when {
            ContextCompat.checkSelfPermission(
                this, Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED -> {
                proceed()
            }

            else -> {
                launcher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            }
        }
    } else {
        proceed()
    }
}
