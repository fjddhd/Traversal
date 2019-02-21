package com.duoduo.isgood.traversal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.util.ArrayList;

public class MainActivity extends BaseActivity{

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private EditText root;
    private EditText et11;
    private EditText et12;
    private EditText et21;
    private EditText et22;
    private EditText et23;
    private EditText et24;
    private EditText et31;
    private EditText et32;
    private EditText et33;
    private EditText et34;
    private EditText et35;
    private EditText et36;
    private EditText et37;
    private EditText et38;
    private ArrayList<String> al;
    private ArrayList<Node> alNode;
    StringBuffer sb1=new StringBuffer();
    StringBuffer sb2=new StringBuffer();
    StringBuffer sb3=new StringBuffer();
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tree_layout);
        FVBid();
        InitToolbar(R.id.tool_bar_tree,R.id.drawer_layout_tree,R.id.navigation_tree,"二叉树遍历");
        
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb1=new StringBuffer();
                Init();
                Xianxu(alNode.get(0));
                tv_result.clearComposingText();
                tv_result.setText("前序排序是 "+sb1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb2=new StringBuffer();
                Init();
                Zhongxu(alNode.get(0));
                tv_result.setText("中序排序是 "+sb2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb3=new StringBuffer();
                Init();
                Houxu(alNode.get(0));
                tv_result.clearComposingText();
                tv_result.setText("后序排序是 "+sb3);
            }
        });

    }

    public void FVBid(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        root = findViewById(R.id.root);
        et11 = findViewById(R.id.ed11);
        et12 = findViewById(R.id.ed12);
        et21 = findViewById(R.id.ed21);
        et22 = findViewById(R.id.ed22);
        et23 = findViewById(R.id.ed23);
        et24 = findViewById(R.id.ed24);
        et31 = findViewById(R.id.ed31);
        et32 = findViewById(R.id.ed32);
        et33 = findViewById(R.id.ed33);
        et34 = findViewById(R.id.ed34);
        et35 = findViewById(R.id.ed35);
        et36 = findViewById(R.id.ed36);
        et37 = findViewById(R.id.ed37);
        et38 = findViewById(R.id.ed38);
        tv_result = findViewById(R.id.result);
    }

    public void Init(){//获取节点框内信息组合成Node节点的树结构
//        count++;
        al = new ArrayList<>();
        alNode = new ArrayList<>();
        al.add(root.getText().toString());
        al.add(et11.getText().toString());
        al.add(et12.getText().toString());
        al.add(et21.getText().toString());
        al.add(et22.getText().toString());
        al.add(et23.getText().toString());
        al.add(et24.getText().toString());
        al.add(et31.getText().toString());
        al.add(et32.getText().toString());
        al.add(et33.getText().toString());
        al.add(et34.getText().toString());
        al.add(et35.getText().toString());
        al.add(et36.getText().toString());
        al.add(et37.getText().toString());
        al.add(et38.getText().toString());
        for (int i=0;i<al.size();++i){
            if (al.get(i).equals("")){//注意字符串比较
                alNode.add(null);
            }else{
                alNode.add(new Node(al.get(i)));
            }
        }
        if (alNode.get(0)!=null){
            alNode.get(0).left=alNode.get(1);
            alNode.get(0).right=alNode.get(2);
        }
        if (alNode.get(1)!=null){
            alNode.get(1).left=alNode.get(3);
            alNode.get(1).right=alNode.get(4);
        }
        if (alNode.get(2)!=null){
            alNode.get(2).left=alNode.get(5);
            alNode.get(2).right=alNode.get(6);
        }
        if (alNode.get(3)!=null){
            alNode.get(3).left=alNode.get(7);
            alNode.get(3).right=alNode.get(8);
        }
        if (alNode.get(4)!=null){
            alNode.get(4).left=alNode.get(9);
            alNode.get(4).right=alNode.get(10);
        }
        if (alNode.get(5)!=null){
            alNode.get(5).left=alNode.get(11);
            alNode.get(5).right=alNode.get(12);
        }
        if (alNode.get(6)!=null){
            alNode.get(6).left=alNode.get(13);
            alNode.get(6).right=alNode.get(14);
        }
    }
    public void Xianxu(Node n){
          if (n!=null){
              sb1.append(n.val);
              Xianxu(n.left);
              Xianxu(n.right);
          }
    }
    public void Zhongxu(Node n){
        if (n!=null){
            Zhongxu(n.left);
            sb2.append(n.val);
            Zhongxu(n.right);
        }
    }
    public void Houxu(Node n){
        if (n!=null){
            Houxu(n.left);
            Houxu(n.right);
            sb3.append(n.val);
        }
    }

}
