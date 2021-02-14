package com.mia.ysc.ui.common.dialogs.progress;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.mia.ysc.R;

/**
 * Progress dialog
 */
public class ProgressDialog {

    /**
     * Show progress dialog.
     *
     * @param context the context
     * @return the dialog
     */
    @SuppressLint("ResourceType")
    public Dialog show(final Context context) {
        Dialog progressDialog = new Dialog(context, R.style.progress_dialog_theme);
        progressDialog.setContentView(R.layout.dialog_progress);
        ImageView imageView = progressDialog.findViewById(R.id.ivExpression);
        Glide.with(context)
                .load(R.drawable.congrates_icon)
                .skipMemoryCache(true)
                .into(imageView);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        return progressDialog;
    }
}
