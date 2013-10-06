package com.editor;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import android.widget.TextView;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

public class EditorActivity extends RoboActivity {
	private MySurfaceView mGLSurfaceView;

    LinearLayout imageButtonLinearLayout;
    @InjectView(R.id.textView2)  TextView sUp;




    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        //����Ϊȫ��
        requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN ,
		              WindowManager.LayoutParams.FLAG_FULLSCREEN);
		//����Ϊ����ģʽ
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        setContentView(R.layout.main);


    /* -------------------- Start add ImageButtons------------------------------------- */
        Context context = this.getApplicationContext();
        imageButtonLinearLayout = new LinearLayout(this);
        imageButtonLinearLayout.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.FILL_PARENT));
        imageButtonLinearLayout.setOrientation(LinearLayout.VERTICAL);
        // add imagebuttons
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout imagebuttonLinearLayout = (LinearLayout) inflater.inflate(R.layout.imagebutton, imageButtonLinearLayout, false);
        imageButtonLinearLayout.addView(imagebuttonLinearLayout);
    /* -------------------- End add ImageButtons------------------------------------- */



        //��ʼ��GLSurfaceView
        mGLSurfaceView = new MySurfaceView(this);

        mGLSurfaceView.requestFocus();//��ȡ����
        mGLSurfaceView.setFocusableInTouchMode(true);//����Ϊ�ɴ���

//        mGLSurfaceView.setZOrderOnTop(true);
        mGLSurfaceView.getHolder().setFormat(PixelFormat.TRANSPARENT);
        setContentView(mGLSurfaceView);


        // ����imageButtonLinearLayout (SurfaceView)
        addContentView(imageButtonLinearLayout, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT,
                TableLayout.LayoutParams.FILL_PARENT));

//         sUp.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View view) {
//                 //To change body of implemented methods use File | Settings | File Templates.
//
//                  mGLSurfaceView.setUp();
//             }
//         });

    }

    @Override
    protected void onResume() {
        super.onResume();
        mGLSurfaceView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mGLSurfaceView.onPause();
    }    
}


