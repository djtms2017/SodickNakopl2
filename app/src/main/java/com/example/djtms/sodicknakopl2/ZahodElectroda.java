package com.example.djtms.sodicknakopl2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.djtms.sodicknakopl2.R;
import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;

public class ZahodElectroda extends Fragment {

    NiftyDialogBuilder materialDesignAnimatedDialog;
    EditText lengthEl;
    EditText lengthProg;
    EditText zahodEl;
    Button entry;
    Button	clear;
    Button 	exit;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1contacts, container, false);



        lengthEl = (EditText)rootView.findViewById(R.id.lengthEl);
        lengthProg = (EditText)rootView.findViewById(R.id.lengthProg);
        zahodEl = (EditText)rootView.findViewById(R.id.zahodEl);
        entry = (Button)rootView.findViewById(R.id.entry);
        clear = (Button)rootView.findViewById(R.id.clear);
        exit = (Button)rootView.findViewById(R.id.exit);

        materialDesignAnimatedDialog = NiftyDialogBuilder.getInstance(getActivity());


        entry.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calculation();
            }
        });




        clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((EditText)getActivity().findViewById(R.id.lengthEl)).setText(null);
                ((EditText)getActivity().findViewById(R.id.lengthProg)).setText(null);
                ((EditText)getActivity().findViewById(R.id.zahodEl)).setText(null);
            }
        });



        exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Exit();
            }
        });



        return rootView;
    }


    public void calculation(){

        // Проверяем поля на пустоту
        if (TextUtils.isEmpty(lengthEl.getText().toString()))
        {
            errortoast("Введите длину электрода");
            return;
        }

        if (TextUtils.isEmpty(lengthProg.getText().toString()))
        {
            errortoast("Введите длину прожига");
            return;
        }

        if (TextUtils.isEmpty(zahodEl.getText().toString()))
        {
            errortoast("Введите заход электрода");
            return;
        }

        //объявляем локальные переменные
        double a,b,c,sum;

        //извлекаем значения из полей ввожа
        String S1 = lengthEl.getText().toString();
        String S2 = lengthProg.getText().toString();
        String S3 = zahodEl.getText().toString();

        //преобразуем значения из строки
        //в числа
        a = Double.parseDouble(S1);
        b = Double.parseDouble(S2);
        c = Double.parseDouble(S3);

        //вычисляем сумму
        sum = a - b - c + 1;


        String S = String.format("%.4f", Math.abs(sum));
        //обратно преобразуем из
        //цифру в строку
        //String S =  Double.toString(Math.abs(sum));



        calc(S);

    }

    public void calc(String str)
    {
       /* AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Занеси результат в программу")
                .setMessage(str)
                //.setIcon(R.drawable.image_1)
                .setCancelable(false)
                .setNegativeButton("Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id)
                            {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
*/

        materialDesignAnimatedDialog
                .withTitle("Результат")
                .withMessage("Занеси результат в программу" + "\nДлина прожига = " + str)
                .withDialogColor("#1c90ec")
                .withButton1Text("OK")
                .withDuration(700)
                .withEffect(Effectstype.Fall)
                .setButton1Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        materialDesignAnimatedDialog.cancel();
                    }
                })
                .show();

    }


    public void errortoast(String str) {

        Toast.makeText(getActivity(), str, Toast.LENGTH_LONG).show();


    }

    public void Exit(){
           /*
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Выход")
                .setMessage("Вы точно хотите выйти")
                .setCancelable(false)
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id)
                            {
                                dialog.cancel();
                            }
                        })
                .setPositiveButton("Ok",
                        new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int which) {
                                getActivity().finish();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
*/

        materialDesignAnimatedDialog
                .withTitle("Выход")
                .withMessage("Вы точно хотите выйти?")
                .withDialogColor("#1c90ec")
                .withButton1Text("OK")
                .withButton2Text("Cancel")
                .withDuration(700)
                .withEffect(Effectstype.Fliph)
                .setButton1Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getActivity().finish();
                    }
                })
                .setButton2Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        materialDesignAnimatedDialog.cancel();
                    }
                })
                .show();

    }


}



