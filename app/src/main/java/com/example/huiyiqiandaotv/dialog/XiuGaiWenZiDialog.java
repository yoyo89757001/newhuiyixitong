package com.example.huiyiqiandaotv.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.huiyiqiandaotv.R;


/**
 * @Function: 自定义对话框
 * @Date: 2013-10-28
 * @Time: 下午12:37:43
 * @author Tom.Cai
 */
public class XiuGaiWenZiDialog extends Dialog implements View.OnFocusChangeListener {
  //  private TextView title2;
    private Button l1,l2;
    private EditText shanchu,daxiao,shanchu1,daxiao1;
    public XiuGaiWenZiDialog(Context context) {
        super(context, R.style.dialog_style2);
        Window window =  this.getWindow();
        if ( window != null) {
            WindowManager.LayoutParams attr = window.getAttributes();
            if (attr != null) {
                attr.height = LayoutParams.WRAP_CONTENT;
                attr.width = LayoutParams.WRAP_CONTENT;
                attr.gravity = Gravity.CENTER;//设置dialog 在布局中的位置
            }
        }
        setCustomDialog();
    }

    private void setCustomDialog() {
        View mView = LayoutInflater.from(getContext()).inflate(R.layout.xiugaidialog_wenzi, null);

        shanchu= (EditText) mView.findViewById(R.id.xiangce);
        daxiao= (EditText) mView.findViewById(R.id.daxiao);
        shanchu1= (EditText) mView.findViewById(R.id.xiangce1);//1是左边
        daxiao1= (EditText) mView.findViewById(R.id.daxiao1);

        l1= (Button)mView. findViewById(R.id.queren);
        l2= (Button) mView.findViewById(R.id.quxiao);
        l1.setOnFocusChangeListener(this);
        l2.setOnFocusChangeListener(this);
        super.setContentView(mView);
    }

    public void setContents(String ss, String s3,String ss2,String ss4){
        if (ss!=null)
            shanchu.setText(ss);
        if (s3!=null){
            daxiao.setText(s3);
        }
        if (ss2!=null)
            shanchu1.setText(ss2);
        if (ss4!=null){
            daxiao1.setText(ss4);
        }

    }

    public String getContents(){

        return shanchu.getText().toString().trim();

    }
    public String getSize(){

        return daxiao.getText().toString().trim();

    }

    public String getContents2(){

        return shanchu1.getText().toString().trim();

    }
    public String getSize2(){

        return daxiao1.getText().toString().trim();

    }

    @Override
    public void setContentView(int layoutResID) {
    }

    @Override
    public void setContentView(View view, LayoutParams params) {
    }

    @Override
    public void setContentView(View view) {
    }

    /**
     * 确定键监听器
     * @param listener
     */
    public void setOnQueRenListener(View.OnClickListener listener){
        l1.setOnClickListener(listener);
    }
    /**
     * 取消键监听器
     * @param listener
     */
    public void setQuXiaoListener(View.OnClickListener listener){
        l2.setOnClickListener(listener);
    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        switch (v.getId()){
            case R.id.queren:
                l1.setBackgroundResource(R.drawable.jiaohu_tc);
                l1.setTextColor(Color.WHITE);
                l2.setBackgroundColor(Color.TRANSPARENT);
                l2.setTextColor(Color.parseColor("#FF1c97fe"));

                break;
            case R.id.quxiao:
                l2.setBackgroundResource(R.drawable.jiaohu_tc);
                l2.setTextColor(Color.WHITE);
                l1.setBackgroundColor(Color.TRANSPARENT);
                l1.setTextColor(Color.parseColor("#FF1c97fe"));
                break;
        }
    }
}
