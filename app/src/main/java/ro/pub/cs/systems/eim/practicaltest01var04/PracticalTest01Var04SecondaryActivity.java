package ro.pub.cs.systems.eim.practicaltest01var04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var04SecondaryActivity extends AppCompatActivity {

    TextView receivedText;
    Button verify;
    Button cancel;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.verify:
                    setResult(1, null);
                    break;
                case R.id.cancel:
                    setResult(0, null);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_secondary);

        receivedText = (TextView)findViewById(R.id.received_text);
        verify = (Button)findViewById(R.id.verify);
        cancel = (Button)findViewById(R.id.cancel);

        verify.setOnClickListener(buttonClickListener);
        cancel.setOnClickListener(buttonClickListener);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("text")) {
            String currentText = intent.getStringExtra("text");
            receivedText.setText(currentText);
        }
    }
}
