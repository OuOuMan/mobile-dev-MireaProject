package ru.mirea.miroshnichenko.mireaproject2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class CustomDialogFragment extends DialogFragment {

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_custom_dialog, null);

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        return builder.setTitle("Создать историю")
                .setPositiveButton("Сохранить", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Записать в бд

                        AppDatabase db = App.getInstance().getDatabase();
                        HistoryItemDao historyItemDao = db.historyItemDaoDao();

                        EditText titleEdit = (EditText) view.findViewById(R.id.titleEdit);
                        String title = titleEdit.getText().toString();


                        EditText textEdit = (EditText) view.findViewById(R.id.textEdit);
                        String text = textEdit.getText().toString();

                        EditText hashtagEdit = (EditText) view.findViewById(R.id.hashtagEdit);
                        String hashtag = hashtagEdit.getText().toString();

                        HistoryItem history = new HistoryItem();
                        history.title = title;
                        history.text = text;
                        history.hashtag = hashtag;

                        historyItemDao.insert(history);

                        dialog.cancel();
                    }
                })
                .setView(view)
                .create();
    }
}