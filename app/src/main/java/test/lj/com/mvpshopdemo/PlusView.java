package test.lj.com.mvpshopdemo;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by lj on 2017/11/21.
 */

public class PlusView extends LinearLayout {
   private  Button revserse,add;
   private EditText editText;
    private  int mCount=1;

    public PlusView(Context context) {
        super(context);
    }

    public PlusView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view= LayoutInflater.from(context).inflate(R.layout.plus_layout,null,false);

           revserse= view.findViewById(R.id.revserse);
           add= view.findViewById(R.id.add);
           editText=  view.findViewById(R.id.content);

        revserse.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

               String content= editText.getText().toString().trim();
                int count=  Integer.valueOf(content);
                if (count>1){
                    mCount=count-1;
                    editText.setText(mCount+"");
                       if (listener!=null){
                           listener.click(mCount);
                       }

                }

            }
        });

    add.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
          String content=    editText.getText().toString().trim();
            int count=Integer.valueOf(content)+1;
            mCount=count;
              editText.setText(count+"");
            if(listener != null){
                listener.click(count);
            }
        }
    });

   editText.addTextChangedListener(new TextWatcher() {
       @Override
       public void beforeTextChanged(CharSequence s, int start, int count, int after) {

       }

       @Override
       public void onTextChanged(CharSequence s, int start, int before, int count) {

       }

       @Override
       public void afterTextChanged(Editable s) {

       }
   });
        //展示
        addView(view);

    }

    public PlusView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setEditText(int num){
        if(editText != null){
            editText.setText(num+"");
        }
    }



    public  ClickListener listener;
    public  void  setListener(ClickListener listener){
        this.listener=listener;

    }
    /**
     * 加减号 点击事件
     */
   public interface  ClickListener{

       public void click(int count);
   }



}
