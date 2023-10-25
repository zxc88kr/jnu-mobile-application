package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView ivObjHead;
    ImageView ivObjDress;
    ImageView ivObjLeg;

    ImageView ivObjHead1;
    ImageView ivObjHead2;
    ImageView ivObjDress1;
    ImageView ivObjDress2;
    ImageView ivObjLeg1;
    ImageView ivObjLeg2;

    ImageView ivObjBand;
    ImageView ivObjPin;
    ImageView ivObjCrown;
    ImageView ivObjNeck;

    ImageView ivObjBand1;
    ImageView ivObjBand2;
    ImageView ivObjPin1;
    ImageView ivObjPin2;
    ImageView ivObjCrown1;
    ImageView ivObjCrown2;
    ImageView ivObjNecklace1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivObjHead = findViewById(R.id.imageViewHead);
        ivObjDress = findViewById(R.id.imageViewDress);
        ivObjLeg = findViewById(R.id.imageViewLeg);

        ivObjHead1 = findViewById(R.id.imageViewHead1);
        ivObjHead2 = findViewById(R.id.imageViewHead2);

        ivObjDress1 = findViewById(R.id.imageViewDress1);
        ivObjDress2 = findViewById(R.id.imageViewDress2);

        ivObjLeg1 = findViewById(R.id.imageViewLeg1);
        ivObjLeg2 = findViewById(R.id.imageViewLeg2);

        ivObjBand = findViewById(R.id.imageViewBand1);
        ivObjPin = findViewById(R.id.imageViewPin1);
        ivObjCrown = findViewById(R.id.imageViewCrown1);
        ivObjNeck = findViewById(R.id.imageViewNecklace1);

        ivObjBand1 = findViewById(R.id.imageViewBand1);
        ivObjBand2 = findViewById(R.id.imageViewBand2);

        ivObjPin1 = findViewById(R.id.imageViewPin1);
        ivObjPin2 = findViewById(R.id.imageViewPin2);

        ivObjCrown1 = findViewById(R.id.imageViewCrown1);
        ivObjCrown2 = findViewById(R.id.imageViewCrown2);

        ivObjNecklace1 = findViewById(R.id.imageViewNecklace1);

        ivObjBand.setVisibility(View.INVISIBLE);
        ivObjPin.setVisibility(View.INVISIBLE);
        ivObjCrown.setVisibility(View.INVISIBLE);
        ivObjNeck.setVisibility(View.INVISIBLE);
    }
    public void onClickChoice(View view ) {
        if(view.getId()==R.id.imageViewHead1) ivObjHead.setImageResource(R.drawable.head1);
        else if(view.getId()==R.id.imageViewHead2 )  ivObjHead.setImageResource(R.drawable.head2);
        else if(view.getId()==R.id.imageViewDress1)  ivObjDress.setImageResource(R.drawable.dress1);
        else if(view.getId()==R.id.imageViewDress2 )  ivObjDress.setImageResource(R.drawable.dress2);
        else if(view.getId()==R.id.imageViewLeg1)  ivObjLeg.setImageResource(R.drawable.leg1);
        else if(view.getId()==R.id.imageViewLeg2 )  ivObjLeg.setImageResource(R.drawable.leg2);
        else if(view.getId()==R.id.imageViewBand1 )  {
            ivObjBand.setVisibility(View.VISIBLE);
            ivObjBand.setImageResource(R.drawable.headband1);
        }
        else if(view.getId()==R.id.imageViewBand2 )  {
            ivObjBand.setVisibility(View.VISIBLE);
            ivObjBand.setImageResource(R.drawable.headband2);
        }
        else if(view.getId()==R.id.imageViewPin1 )  {
            ivObjPin.setVisibility(View.VISIBLE);
            ivObjPin.setImageResource(R.drawable.pin1);
        }
        else if(view.getId()==R.id.imageViewPin2 )  {
            ivObjPin.setVisibility(View.VISIBLE);
            ivObjPin.setImageResource(R.drawable.pin2);
        }
        else if(view.getId()== R.id.imageViewCrown1 )  {
            ivObjCrown.setVisibility(View.VISIBLE);
            ivObjCrown.setImageResource(R.drawable.crown1);
        }
        else if(view.getId()==R.id.imageViewCrown2)  {
            ivObjCrown.setVisibility(View.VISIBLE);
            ivObjCrown.setImageResource(R.drawable.crown2);
        }
        else if(view.getId()==R.id.imageViewNecklace1 )  {
            ivObjNeck.setVisibility(View.VISIBLE);
            ivObjNeck.setImageResource(R.drawable.necklace1);
        }
    }
    public void  onClickReset(View view) {
        ivObjBand.setVisibility(View.INVISIBLE);
        ivObjPin.setVisibility(View.INVISIBLE);
        ivObjCrown.setVisibility(View.INVISIBLE);
        ivObjNeck.setVisibility(View.INVISIBLE);

        ivObjHead.setImageResource(R.drawable.head1);
        ivObjDress.setImageResource(R.drawable.dress1);
        ivObjLeg.setImageResource(R.drawable.leg1);
    }
}
