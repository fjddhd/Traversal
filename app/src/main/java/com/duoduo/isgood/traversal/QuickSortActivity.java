package com.duoduo.isgood.traversal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.duoduo.isgood.traversal.Sorts.Quick;

import java.util.Timer;
import java.util.TimerTask;

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

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputString=edinput.getText().toString();
                char inputRegex='.';//默认分隔符为英文句号
                for (int i=0;i<inputString.length();++i){//寻找第一个非字母数字字符为分隔符,保存到inputRegex变量中去
                    char temp=inputString.charAt(i);
                    if (!(temp>='0' && temp<='9') &&
                            !(temp>='a' && temp<='z') &&
                            !(temp>='A' && temp<='Z')){
                        inputRegex=temp;
                        break;
                    }
                }
                StringBuilder output=new StringBuilder();
                Quick quick=new Quick(output);
                if (inputString.charAt(0)>='0' && inputString.charAt(0)<='9'){
                    Integer[] input=addressIntInput(inputString,inputRegex);
                    quick.sort(input);
                }else if (inputString.charAt(0)>='a' && inputString.charAt(0)<='z' ||inputString.charAt(0)>='A' && inputString.charAt(0)<='Z'){
                    Character[] input=addressCharacterInput(inputString,inputRegex);
                    quick.sort(input);
                }

                tvIllustrate.setVisibility(View.GONE);
                tvResult.setText(Html.fromHtml(quick.sb.toString()));//支持html的文本
                tvResult.setVisibility(View.VISIBLE);

                //延时20秒清空结果
                Timer timer=new Timer();
                TimerTask timertask=new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tvResult.setText("");
                                tvResult.setVisibility(View.GONE);
                                tvIllustrate.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                };
                timer.schedule(timertask,20000);


            }
        });
    }

    public void FVBid(){
        edinput = findViewById(R.id.ed_needtosort_quicksort);
        btn = findViewById(R.id.btn_quicksort);
        tvIllustrate = findViewById(R.id.illustrate_quicksort);
        tvResult = findViewById(R.id.result_quicksort);
    }
    /**
     * 由于使用了下面的split方法
     * 所以输入要限定分隔符号
     * */
    public Integer[] addressIntInput(String needToAddress,char r){
        String[] splittedInput=split(needToAddress,r);
        Integer[] res=new Integer[splittedInput.length];
        for (int i=0;i<splittedInput.length;++i){
            res[i]=Integer.valueOf(splittedInput[i]);
        }
        return res;
    }
    public Character[] addressCharacterInput(String needToAddress,char r){//这里方便处理但是限定了单字母字符的输入
        String[] splittedInput=split(needToAddress,r);
        Character[] res=new Character[splittedInput.length];
        for (int i=0;i<splittedInput.length;++i){
            if (splittedInput[i].charAt(0)>='a' && splittedInput[i].charAt(0)<='z'){
                res[i]=(char)(splittedInput[i].charAt(0)-32);
            }
            else {
                res[i]=splittedInput[i].charAt(0);
            }
        }
        return res;
    }



    public String[] split(String needToSplit,char regex){
        int count=0;//符号的个数
        for (int i=0;i<needToSplit.length();++i){
            if (needToSplit.charAt(i)==regex){
                count++;
            }
        }
        String[] res=new String[count+1];//被分成的串应该是符号的个数加1
        int i=0,k=0;
        StringBuilder each=new StringBuilder();
        while (k<count+1 && i<needToSplit.length()){
            char c=needToSplit.charAt(i++);
            if (c!=regex){
                each.append(c);
            }
            else {
                res[k++]=each.toString();
                each=new StringBuilder();
            }
        }
        res[k++]=each.toString();
        return res;

    }
}

