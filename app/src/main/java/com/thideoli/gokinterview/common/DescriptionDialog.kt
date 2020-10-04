package com.thideoli.gokinterview.common

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import com.thideoli.gokinterview.R

class DescriptionDialog(
    context: Context
) {

    private val alertDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(context)

    init {
        alertDialogBuilder.create()
        alertDialogBuilder.setCancelable(false)
        alertDialogBuilder.setNeutralButton(R.string.neutral_button_dialog, neutralButtonClick())
    }

    private fun neutralButtonClick(): DialogInterface.OnClickListener {
        return DialogInterface.OnClickListener { dialog, id ->
            dialog.dismiss()
        }
    }

    fun showDialog(title: String?, description: String?) {
        if(title.isNullOrBlank() || description.isNullOrBlank())
            return

        alertDialogBuilder.setTitle(title)
        alertDialogBuilder.setMessage(description)
        alertDialogBuilder.show()
    }
}