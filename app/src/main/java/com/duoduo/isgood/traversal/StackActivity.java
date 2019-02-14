package com.duoduo.isgood.traversal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Stack;

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
        InitToolbar(R.id.tool_bar_stack,R.id.drawer_layout_stack,R.id.navigation_stack);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] stackSequence=convert(edpush.getText().toString());
                int[] needToCheck=convert(edpop.getText().toString());
                boolean valid=validateStackSequences(stackSequence,needToCheck);
                if (stackSequence.length!=needToCheck.length){
                    tv.setText("输入错误，进出栈序列长度不相等！");
                }
                else {

                }
            }
        });

    }
    public void FVBid(){
        edpush = findViewById(R.id.ed_push_stack);
        edpop = findViewById(R.id.ed_pop_stack);
        btn = findViewById(R.id.btn_stack);
        tv = findViewById(R.id.result_stack);
    }

    public int[] convert(String string){
        String pushText=edpush.getText().toString();
        int count=0;
        for (int i=0;i<pushText.length();++i){
            if (pushText.charAt(i)>=0 && pushText.charAt(i)<=9){
                count++;
            }
        }
        int[] needToReturn=new int[count];
        count=0;
        for (int i=0;i<pushText.length();++i){
            if (pushText.charAt(i)>=0 && pushText.charAt(i)<=9){
                needToReturn[count]=pushText.charAt(i)-'0';
                count++;
            }
        }
        return needToReturn;
    }


    public boolean validateStackSequences(int[] pushed, int[] popped) {
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
