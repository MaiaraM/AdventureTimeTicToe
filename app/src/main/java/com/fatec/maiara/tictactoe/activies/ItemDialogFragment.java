package com.fatec.maiara.tictactoe.activies;


import android.app.AlertDialog;
import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.AlertDialogLayout;

public class ItemDialogFragment extends AlertDialog {


    protected ItemDialogFragment(Context context) {
        super(context);
    }

    protected ItemDialogFragment(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    protected ItemDialogFragment(Context context, int themeResId) {
        super(context, themeResId);
    }
}
