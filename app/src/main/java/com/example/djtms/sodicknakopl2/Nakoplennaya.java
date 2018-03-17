package com.example.djtms.sodicknakopl2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.djtms.sodicknakopl2.R;
import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;

public class Nakoplennaya extends Fragment {

    NiftyDialogBuilder materialDesignAnimatedDialog;


    Integer [] m = new Integer[6];
    // EditText[] p = new EditText[7];
    EditText b2, b3, b4, b5, b6, b7;
    TextView c2, c3, c4, c5, c6, c7;
    TextView d2, d3, d4, d5, d6, d7;
    TextView summary;
    Button entry1;
    Button	clear1;
    Button 	exit1;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2chat, container, false);

    /*    for (int i = 2; i <= 7; i++) {
           p[i-1] = (EditText) rootView.findViewById(R.id.b2);
        }
*/
        materialDesignAnimatedDialog = NiftyDialogBuilder.getInstance(getActivity());

        b2 = (EditText)rootView.findViewById(R.id.b2);
        b3 = (EditText)rootView.findViewById(R.id.b3);
        b4 = (EditText)rootView.findViewById(R.id.b4);
        b5 = (EditText)rootView.findViewById(R.id.b5);
        b6 = (EditText)rootView.findViewById(R.id.b6);
        b7 = (EditText)rootView.findViewById(R.id.b7);

        c2 = (TextView) rootView.findViewById(R.id.c2);
        c3 = (TextView) rootView.findViewById(R.id.c3);
        c4 = (TextView) rootView.findViewById(R.id.c4);
        c5 = (TextView) rootView.findViewById(R.id.c5);
        c6 = (TextView) rootView.findViewById(R.id.c6);
        c7 = (TextView) rootView.findViewById(R.id.c7);

        d2 = (TextView) rootView.findViewById(R.id.d2);
        d3 = (TextView) rootView.findViewById(R.id.d3);
        d4 = (TextView) rootView.findViewById(R.id.d4);
        d5 = (TextView) rootView.findViewById(R.id.d5);
        d6 = (TextView) rootView.findViewById(R.id.d6);
        d7 = (TextView) rootView.findViewById(R.id.d7);


        b2.setText("0");

        summary = (TextView) rootView.findViewById(R.id.summa);

        entry1 = (Button)rootView.findViewById(R.id.entry1);
        clear1 = (Button)rootView.findViewById(R.id.clear1);
        exit1 = (Button)rootView.findViewById(R.id.exit1);




        entry1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calculation1();
            }
        });




        clear1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((EditText)getActivity().findViewById(R.id.b2)).setText("0");
                ((EditText)getActivity().findViewById(R.id.b3)).setText(null);
                ((EditText)getActivity().findViewById(R.id.b4)).setText(null);
                ((EditText)getActivity().findViewById(R.id.b5)).setText(null);
                ((EditText)getActivity().findViewById(R.id.b6)).setText(null);
                ((EditText)getActivity().findViewById(R.id.b7)).setText(null);

                ((TextView)getActivity().findViewById(R.id.c2)).setText(null);
                ((TextView)getActivity().findViewById(R.id.c3)).setText(null);
                ((TextView)getActivity().findViewById(R.id.c4)).setText(null);
                ((TextView)getActivity().findViewById(R.id.c5)).setText(null);
                ((TextView)getActivity().findViewById(R.id.c6)).setText(null);
                ((TextView)getActivity().findViewById(R.id.c7)).setText(null);

                ((TextView)getActivity().findViewById(R.id.d2)).setText(null);
                ((TextView)getActivity().findViewById(R.id.d3)).setText(null);
                ((TextView)getActivity().findViewById(R.id.d4)).setText(null);
                ((TextView)getActivity().findViewById(R.id.d5)).setText(null);
                ((TextView)getActivity().findViewById(R.id.d6)).setText(null);
                ((TextView)getActivity().findViewById(R.id.d7)).setText(null);

                ((EditText)getActivity().findViewById(R.id.b3)).requestFocus();



            }
        });



        exit1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Exit1();
            }
        });

        return rootView;
    }



    public void calculation1(){

        // Проверяем поля на пустоту
        if (TextUtils.isEmpty(b2.getText().toString()))
        {
            editerror("Введите 1-е число");
            return;
        }

        if (TextUtils.isEmpty(b3.getText().toString()))
        {
            editerror("Введите 2-е число");
            return;
        }

        if (TextUtils.isEmpty(b4.getText().toString()))
        {
            editerror("Введите 3-е число");
            return;
        }

        if (TextUtils.isEmpty(b5.getText().toString()))
        {
            editerror("Введите 4-е число");
            return;
        }

        if (TextUtils.isEmpty(b6.getText().toString()))
        {
            editerror("Введите 5-е число");
            return;
        }

        if (TextUtils.isEmpty(b7.getText().toString()))
        {
            editerror("Введите 6-е число");
            return;
        }



        //final String TAG = "ExpressCourse";

        //объявляем локальные переменные
        String  s2, s3, s4, s5, s6, s7;

        Integer e2, e3 ,e4, e5, e6, e7;
        Integer sum;
        Integer result1, res1, res2 = null;
        Integer c22, c23, c24, c25, c26, c27;
        Integer d22, d23, d24, d25, d26, d27;
        Integer min, max, nakoplennaya;



        //извлекаем значения из полей ввожа
        s2 = b2.getText().toString();
        s3 = b3.getText().toString();
        s4 = b4.getText().toString();
        s5 = b5.getText().toString();
        s6 = b6.getText().toString();
        s7 = b7.getText().toString();

        //преобразуем значения из строки
        //в числа
        e2 = Integer.parseInt(s2);
        e3 = Integer.parseInt(s3);
        e4 = Integer.parseInt(s4);
        e5 = Integer.parseInt(s5);
        e6 = Integer.parseInt(s6);
        e7 = Integer.parseInt(s7);

        //вычисляем сумму
        sum = e2+e3+e4+e5+e6+e7;
        result1 = Math.abs(sum);

        //проверка на попадания в диапазон деления на 6
        if (result1 >= 0 && result1 <= 6) res2 = 1;
        if (result1 >= 7 && result1 <= 12) res2 = 2;
        if (result1 >= 13 && result1 <= 18) res2 = 3;
        if (result1 >= 19 && result1 <= 24) res2 = 4;
        if (result1 >= 25 && result1 <= 30) res2 = 5;
        if (result1 >= 31 && result1 <= 36) res2 = 6;
        if (result1 >= 37 && result1 <= 42) res2 = 7;
        if (result1 >= 43 && result1 <= 48) res2 = 8;
        if (result1 >= 49 && result1 <= 54) res2 = 9;
        if (result1 >= 55 && result1 <= 60) res2 = 10;


        //проверка на знак суммы сложения введенных данных
        if(sum < 0)
        {
            res1 = - res2;
        } else {
            res1 = res2;
        }
        //Log.i(TAG, Integer.toString(sum));


        //обратно преобразуем из цифры в строку
        //String s= Integer.toString(sum);


        //вывод суммы в поле ИТОГО
        summary.setText(sum + " : 6 = " + res1);

        c22 = res1 * (-1);
        c23 = e3 + c22;
        c24 = e4 + c22;
        c25 = e5 + c22;
        c26 = e6 + c22;
        c27 = e7 + c22;

        d22 = res1 * (-1);
        d23 = c23 + d22;
        d24 = c24 + d23;
        d25 = c25 + d24;
        d26 = c26 + d25;
        d27 = c27 + d26;

        //Вывод расчетных значений в я чейки таблицы
        c2.setText(Integer.toString(c22));
        c3.setText(Integer.toString(c23));
        c4.setText(Integer.toString(c24));
        c5.setText(Integer.toString(c25));
        c6.setText(Integer.toString(c26));
        c7.setText(Integer.toString(c27));

        d2.setText(Integer.toString(d22));
        d3.setText(Integer.toString(d23));
        d4.setText(Integer.toString(d24));
        d5.setText(Integer.toString(d25));
        d6.setText(Integer.toString(d26));
        d7.setText(Integer.toString(d27));

        //Дописать вычисление мининума и максимума и определения накопленной

        m[0] = d22;
        m[1] = d23;
        m[2] = d24;
        m[3] = d25;
        m[4] = d26;
        m[5] = d27;

        //Нахождение минимума
        min = MinMax(0);
        //Нахождение максимума
        max = MinMax(1);
        //Нахождение накопленной геротора
        nakoplennaya = max - min;

        String minimum= Integer.toString(min);
        String maximum= Integer.toString(max);
        String stringnakoplennaya= Integer.toString(nakoplennaya);

        //Вывод результата в DialogBox
        nakoplen("min = " + minimum + "       max = " + maximum + "\nНакопленная геротора = " + stringnakoplennaya);

    }



    //функция нахождения минимума - максимума
    public int MinMax (int variant) { //variant=0 это мимнимум. 1 - максимум
        //объявляем переменную для хранения результата
        Integer buf = m[0];//присваиваем сразу 0 элемент массива
        //перебираем элементы массива с 0
        for (int i =0; i<6; i++){
            //определим что хочет видеть программа максимум или минимум
            if (variant==0){//ицем минимум
                //сравниваем элемент массива
                if (m[i]<buf) buf=m[i];//если значение буфера больше чем элемент, ложим элемент в буфер
            }
            else {//ищем максимум
                if (m[i]>buf) buf=m[i];//если значение буфера меньше чем элемент, ложим элемент в буфер
            }
        }
        return buf;
    }



    public void nakoplen(String str)
    {
       /* AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Накопленная")
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
                .withTitle("Накопленная")
                .withMessage(str)
                .withDialogColor("#1c90ec")
                .withButton1Text("OK")
                .withDuration(700)
                .withEffect(Effectstype.Slit)
                .setButton1Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        materialDesignAnimatedDialog.cancel();
                    }
                })
                .show();

    }


    public void editerror(String str) {
        Toast.makeText(getActivity(), str, Toast.LENGTH_LONG).show();
    }

    public void Exit1(){

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
                .withEffect(Effectstype.Flipv)
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
