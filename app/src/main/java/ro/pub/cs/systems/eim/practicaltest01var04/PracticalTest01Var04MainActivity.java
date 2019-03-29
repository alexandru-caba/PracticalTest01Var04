package ro.pub.cs.systems.eim.practicaltest01var04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {

    Button navigate;

    TextView myText;
    Button topLeft;
    Button topright;
    Button center;
    Button bottomLeft;
    Button bottomRight;

    public int number_of_clicks;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            String currentText = myText.getText().toString();

            switch(view.getId()) {
                case R.id.navigate_button:
                    // navigate
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var04SecondaryActivity.class);
                    intent.putExtra("text", myText.getText().toString());
                    startActivityForResult(intent, 1);
                    break;
                case R.id.top_left:
                    currentText = currentText + topLeft.getText().toString() + ", ";
                    number_of_clicks++;
                    break;
                case R.id.top_right:
                    currentText = currentText + topright.getText().toString()+ ", ";
                    number_of_clicks++;
                    break;
                case R.id.center:
                    currentText = currentText + center.getText().toString()+ ", ";
                    number_of_clicks++;
                    break;
                case R.id.bottom_left:
                    currentText = currentText + bottomLeft.getText().toString()+ ", ";
                    number_of_clicks++;
                    break;
                case R.id.bottom_right:
                    currentText = currentText + bottomRight.getText().toString()+ ", ";
                    number_of_clicks++;
                    break;
            }

            myText.setText(currentText);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);

        navigate = (Button)findViewById(R.id.navigate_button);
        topLeft = (Button)findViewById(R.id.top_left);
        topright = (Button)findViewById(R.id.top_right);
        center = (Button)findViewById(R.id.center);
        bottomLeft = (Button)findViewById(R.id.bottom_left);
        bottomRight = (Button)findViewById(R.id.bottom_right);

        navigate.setOnClickListener(buttonClickListener);
        topLeft.setOnClickListener(buttonClickListener);
        topright.setOnClickListener(buttonClickListener);
        center.setOnClickListener(buttonClickListener);
        bottomLeft.setOnClickListener(buttonClickListener);
        bottomRight.setOnClickListener(buttonClickListener);

        myText = (TextView)findViewById(R.id.text);
        myText.setText("");

        if (savedInstanceState == null)
            number_of_clicks = 0;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 1) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
            number_of_clicks = 0;
            myText.setText("");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("no_clicks", number_of_clicks);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Count is " + number_of_clicks, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            number_of_clicks = savedInstanceState.getInt("no_clicks");
        }
    }
}
