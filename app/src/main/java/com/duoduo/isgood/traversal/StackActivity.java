package com.duoduo.isgood.traversal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

public class StackActivity extends BaseActivity{


    private EditText edpush;
    private EditText edpop;
    private Button btn;
    private TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stack_layout);
        FVBid();
        InitToolbar(R.id.tool_bar_stack,R.id.drawer_layout_stack,R.id.navigation_stack,"验证栈序列");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String a=edpush.getText().toString();//测试用
//                String p=edpop.getText().toString();//测试用
                int[] stackSequence= convertToArray(edpush.getText().toString());
                int[] needToCheck= convertToArray(edpop.getText().toString());
                boolean valid=validateStackSequences(stackSequence,needToCheck);
                if (stackSequence.length!=needToCheck.length){
                    tv.setText("输入错误，进出栈序列长度不相等！");
                }
                else if (valid==true){
                    tv.setText("该出栈序列可由输入栈弹出");
                }
                else if (valid==false){
                    tv.setText("该出栈序列不可由输入栈弹出！");
                }
                //延时8秒清空结果
                Timer timer=new Timer();
                TimerTask timertask=new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tv.setText("");
                            }
                        });
                    }
                };
                timer.schedule(timertask,8000);
            }
        });

    }
    public void FVBid(){
        edpush = findViewById(R.id.ed_push_stack);
        edpop = findViewById(R.id.ed_pop_stack);
        btn = findViewById(R.id.btn_stack);
        tv = findViewById(R.id.result_stack);
    }

    public int[] convertToArray(String string){
        int count=0;
        for (int i=0;i<string.length();++i){
            if (string.charAt(i)>='0' && string.charAt(i)<='9'){
                count++;
            }
        }
        int[] needToReturn=new int[count];
        count=0;
        for (int i=0;i<string.length();++i){
            if (string.charAt(i)>='0' && string.charAt(i)<='9'){
                needToReturn[count]=(string.charAt(i)-'0');
                count++;
                if (count==needToReturn.length){
                    break;
                }
            }
        }
        return needToReturn;
    }


    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length!=popped.length){
            return false;
        }
        int N = pushed.length;
        Stack<Integer> stack = new Stack();

        int j = 0;
        for (int x: pushed) {
            stack.push(x);
            while (!stack.isEmpty() && j < N && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return j == N;
    }



}
