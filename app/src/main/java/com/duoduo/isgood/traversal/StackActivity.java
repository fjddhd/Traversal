package com.duoduo.isgood.traversal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
                String stackSequenceString=edpush.getText().toString();//测试用
                String needToCheckString=edpop.getText().toString();//测试用
                int[] stackSequence= convertToArray(edpush.getText().toString());
                int[] needToCheck= convertToArray(edpop.getText().toString());
                char inputRegex='.';//默认分隔符为英文句号
                int countInt=0;//给每位int计数（防溢出操作）
                boolean findRegex=false;
                for (int i=0;i<stackSequenceString.length();++i){//寻找最后一个非字母数字字符为分隔符,保存到inputRegex变量中去
                    char temp=stackSequenceString.charAt(i);
                    if (!(temp>='0' && temp<='9') &&
                            !(temp>='a' && temp<='z') &&
                            !(temp>='A' && temp<='Z')){
                        if (findRegex==true){
                            if (inputRegex!=temp){
                                Toast.makeText(StackActivity.this,"请输入统一的分隔符",Toast.LENGTH_LONG).show();//分隔符不一致提示
                                return;//结束本次点击事件
                            }
                        }
                        inputRegex=temp;
                        findRegex=true;
                        countInt=0;
                    }else {
                        countInt++;
                        if (countInt>=10){
                            Toast.makeText(StackActivity.this,"请不要输入过大的数字",Toast.LENGTH_LONG).show();//数字溢出提示
                            return;//结束本次点击事件
                        }
                    }
                }
                inputRegex='.';countInt=0;findRegex=false;
                for (int i=0;i<needToCheckString.length();++i){//寻找最后一个非字母数字字符为分隔符,保存到inputRegex变量中去
                    char temp=needToCheckString.charAt(i);
                    if (!(temp>='0' && temp<='9') &&
                            !(temp>='a' && temp<='z') &&
                            !(temp>='A' && temp<='Z')){
                        if (findRegex==true){
                            if (inputRegex!=temp){
                                Toast.makeText(StackActivity.this,"请输入统一的分隔符",Toast.LENGTH_LONG).show();//分隔符不一致提示
                                return;//结束本次点击事件
                            }
                        }
                        inputRegex=temp;
                        findRegex=true;
                        countInt=0;
                    }else {
                        countInt++;
                        if (countInt>=10){
                            Toast.makeText(StackActivity.this,"请不要输入过大的数字",Toast.LENGTH_LONG).show();//数字溢出提示
                            return;//结束本次点击事件
                        }
                    }
                }


                boolean valid=validateStackSequences2(stackSequence,needToCheck);
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

    public boolean validateStackSequences2(int[] pushed, int[] popped) {//去重版
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = pushed.length - 1; i >= 0; --i) {
            List<Integer> indexs = map.getOrDefault(pushed[i], new ArrayList<Integer>());
            indexs.add(i);
            map.put(pushed[i], indexs);
        }
        boolean[] visit = new boolean[pushed.length];
        int topIndex = -1;
        for (Integer num : popped) {
            List<Integer> indexs = map.get(num);
            for (Integer index : indexs) {
                if (visit[index] == true) continue;
                if (index < topIndex) return false;
                else {
                    int newTop = index - 1;
                    while (newTop > - 1 && visit[newTop] == true) newTop--;
                    topIndex = newTop;
                }
                visit[index] = true;
                break;
            }
        }
        return true;
    }



}
