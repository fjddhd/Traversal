package com.duoduo.isgood.traversal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Init();
                Xianxu(alNode.get(0));
                TextView tv_result=findViewById(R.id.result);
                tv_result.setText("");
                tv_result.setText(sb1);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Init();
                Zhongxu(alNode.get(0));
                TextView tv_result=findViewById(R.id.result);
                tv_result.setText("");
                tv_result.setText(sb2);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Init();
                Houxu(alNode.get(0));
                TextView tv_result=findViewById(R.id.result);
                tv_result.setText("");
                tv_result.setText(sb3);
            }
        });

    }

    public void Init(){
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
            alNode.add(new Node(al.get(i)));
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
