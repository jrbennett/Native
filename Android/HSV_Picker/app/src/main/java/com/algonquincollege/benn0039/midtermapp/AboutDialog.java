package com.algonquincollege.benn0039.midtermapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by justinbennett on 15-10-21.
 */
public class AboutDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder( getActivity() );

        builder.setTitle( R.string.action_about )
                .setMessage(R.string.author)
                .setCancelable( false )
                .setPositiveButton( android.R.string.ok, new DialogInterface.OnClickListener(){
                    @Override
                public void onClick( DialogInterface dialog, int which ) {
                        dialog.cancel();
                    }

                });
        return builder.create();
    }
}
