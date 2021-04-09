package com.muhammadfurqan.bangkitfclass.content_provider

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.muhammadfurqan.bangkitfclass.R

class ContentProviderActivity : AppCompatActivity() {

    private lateinit var btnGetPhone: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)

        btnGetPhone = findViewById(R.id.btn_get_phone_list)
        btnGetPhone.setOnClickListener {
            requestContactPermission()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            REQUEST_PERMISSION_CODE -> {
                if (grantResults.isNotEmpty() &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED
                ) {
                    onGetPhone()
                } else {
                    Toast.makeText(
                        this,
                        "Why you are not allow us to check your contact?\n Is there any secret?",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun onGetPhone() {
        // Sets the columns to retrieve for the user profile
        val projection = arrayOf(
            ContactsContract.Profile._ID,
            ContactsContract.Profile.DISPLAY_NAME,
            ContactsContract.Profile.PHOTO_THUMBNAIL_URI,
        )

        // Retrieves the profile from the Contacts Provider
        val profileCursor = contentResolver.query(
            ContactsContract.Profile.CONTENT_URI,
            projection,
            null, null, null //selection, selectionArgs, sortOrder
        )

        profileCursor?.apply {
            val contactList: MutableList<String> = mutableListOf()
            while (moveToNext()) {
                val name =
                    getString(getColumnIndexOrThrow(ContactsContract.Profile.DISPLAY_NAME))

                contactList.add(name)
            }
            Toast.makeText(
                this@ContentProviderActivity,
                contactList.joinToString(separator = "\n"),
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        Toast.makeText(this, "You don't have any contact", Toast.LENGTH_SHORT).show()

    }

    private fun requestContactPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
            != PackageManager.PERMISSION_GRANTED
        ) {
            // ask permission
            AlertDialog.Builder(this).apply {
                setTitle("Read Contact Permission")
                setPositiveButton("OK", null)
                setMessage("Please enable access to read contacts.")
                setOnDismissListener {
                    requestPermissions(
                        arrayOf(Manifest.permission.READ_CONTACTS),
                        REQUEST_PERMISSION_CODE
                    )
                }
                show()
            }
        } else {
            onGetPhone()
        }
    }

    companion object {
        private const val REQUEST_PERMISSION_CODE = 101
    }
}