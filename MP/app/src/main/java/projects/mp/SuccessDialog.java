package projects.mp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;

/**
 * Created by isiah on 13/11/2017.
 */

public class SuccessDialog extends DialogFragment {

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder
                .setTitle("Registration")
                .setMessage("Registration successful!")
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getActivity(), LogInActivity.class);
                        dismiss();
                        getActivity().startActivity(intent);
                    }
                });

        return builder.create();
    }
}
