package com.thideoli.gokinterview.common

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import com.thideoli.gokinterview.R

class GeneralDialog(
    context: Context
) {

    private val alertDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(context)

    init {
        alertDialogBuilder.create()
        alertDialogBuilder.setCancelable(false)
    }

    fun showDialog(
        title: String? = null,
        description: String? = null,
        positiveButtonText: String? = null,
        positiveButtonCallback: DialogInterface.OnClickListener? = null,
        negativeButtonText: String? = null,
        negativeButtonCallback: DialogInterface.OnClickListener? = null,
        neutralButtonText: String? = null,
        neutralButtonCallback: DialogInterface.OnClickListener? = null
    ) {
        title?.let {
            alertDialogBuilder.setTitle(it)
        }
        
        description?.let {
            alertDialogBuilder.setMessage(description)
        }
        
        if (!positiveButtonText.isNullOrBlank() && positiveButtonCallback != null)
            alertDialogBuilder.setPositiveButton(positiveButtonText, positiveButtonCallback)
        
        if (!negativeButtonText.isNullOrBlank() && negativeButtonCallback != null)
            alertDialogBuilder.setNegativeButton(negativeButtonText, negativeButtonCallback)
        
        if (!neutralButtonText.isNullOrBlank() && neutralButtonCallback != null)
            alertDialogBuilder.setNegativeButton(neutralButtonText, neutralButtonCallback)

        alertDialogBuilder.show()
    }
}