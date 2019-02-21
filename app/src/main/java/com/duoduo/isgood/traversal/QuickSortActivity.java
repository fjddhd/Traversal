package com.duoduo.isgood.traversal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class QuickSortActivity extends BaseActivity {

    private EditText edinput;
    private Button btn;
    private TextView tvIllustrate;
    private TextView tvResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quicksort_layout);
        FVBid();
        InitToolbar(R.id.tool_bar_quciksort,R.id.drawer_layout_quicksort,R.id.navigation_quicksort,"快速排序轮次");
    }

    public void FVBid(){
        edinput = findViewById(R.id.ed_needtosort_quicksort);
        btn = findViewById(R.id.btn_quicksort);
        tvIllustrate = findViewById(R.id.illustrate_quicksort);
        tvResult = findViewById(R.id.result_stack);
    }
    public Comparable[] addressInput(String inputString){
        if (inputString.length()==0){
            //无输入
        }
        else if (inputString.charAt(0)>='0' && inputString.charAt(0)<='9'){
            String[] splittedInput=inputString.split(",");
            Comparable[] res=new Comparable[splittedInput.length];
            for (int i=0;i<splittedInput.length;++i){
                res[i]=Integer.valueOf(splittedInput[i]);
            }
            return res;
        }
        else if (inputString.charAt(0)>='a' && inputString.charAt(0)<='z' ||inputString.charAt(0)>='A' && inputString.charAt(0)<='Z'){
            String[] splittedInput=inputString.split(",");
            Comparable[] res=new Comparable[splittedInput.length];
            for (int i=0;i<splittedInput.length;++i){
                if (splittedInput[i].charAt(0)>='a' && splittedInput[i].charAt(0)<='z'){
                    res[i]=(char)(splittedInput[i].charAt(0)-32);
                }
                else {
                    res[i]=splittedInput[i];
                }
            }
            return res;
        }
        else {
            //无效输入，应该给予提示
        }
        return null;
    }
}

