package com.example.krishe;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {
    private ViewPager msLideViewPager;
    private LinearLayout mDoLayout;
    private SlideAdapter sliderAdapter;
    private TextView[] mdots;

    private Button mNextButton;
    private Button mBackButton;
    private int mcurrentpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        msLideViewPager=(ViewPager) findViewById(R.id.slideview);
        mDoLayout=(LinearLayout)findViewById(R.id.dots);
        mNextButton=(Button)findViewById(R.id.nextBtn);
        mBackButton=(Button)findViewById(R.id.prevbtn);
        sliderAdapter=new SlideAdapter( this);
        msLideViewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        msLideViewPager.addOnPageChangeListener(viewListener);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msLideViewPager.setCurrentItem(mcurrentpage+1);
            }
        });
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msLideViewPager.setCurrentItem(mcurrentpage-1);
            }
        });
    }

    public void addDotsIndicator(int position)
    {
        mdots=new TextView[4];
        mDoLayout.removeAllViews();
        for(int i=0;i<mdots.length;i++)
        {
            mdots[i]=new TextView(this);
            mdots[i].setText(Html.fromHtml("&#8226;"));
            mdots[i].setTextSize(35);
            mdots[i].setTextColor(getResources().getColor(R.color.white));

            mDoLayout.addView(mdots[i]);


        }
        if(mdots.length>0)
        {
            mdots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }


    ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);

            mcurrentpage=i;
            if(i==0)
            {
                mNextButton.setEnabled(true);
                mBackButton.setEnabled(false);
                mBackButton.setVisibility(View.INVISIBLE);
                mNextButton.setText("Next");
                mBackButton.setText("");
            } else if(i==mdots.length-1)
            {
                mNextButton.setEnabled(true);
                mBackButton.setEnabled(true);
                mBackButton.setVisibility(View.VISIBLE);
                mNextButton.setText("Finish");
                mBackButton.setText("Back");
                mNextButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent =new Intent(Welcome.this,Login.class);
                        startActivity(intent);
                    }
                });

            }
            else
            {
                mNextButton.setEnabled(true);
                mBackButton.setEnabled(true);
                mBackButton.setVisibility(View.VISIBLE);
                mNextButton.setText("Next");
                mBackButton.setText("Back");
            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}

