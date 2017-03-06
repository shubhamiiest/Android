package in.ac.iiests.iiest_shibpur;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.UiLifecycleHelper;
import com.facebook.widget.FacebookDialog;

import java.util.Arrays;
import java.util.List;



public class Enquiry extends AppCompatActivity {
    EditText e3,e4,e5;
    private UiLifecycleHelper uiHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiry);
        e3= (EditText) findViewById(R.id.editText3);
        e4= (EditText) findViewById(R.id.editText4);
        e5= (EditText) findViewById(R.id.editText5);
       uiHelper = new UiLifecycleHelper(this, null);
        uiHelper.onCreate(savedInstanceState);

    }
    public  void submit(View v)
    {
        String s3=e3.getText().toString();
        String s4=e4.getText().toString();
        String s5=e5.getText().toString();
        List<String> list= Arrays.asList(s3.split("\\s*,\\s*"));
        new SendMailTask(Enquiry.this).execute("shubhambitpatna28.2010@gmail.com","aeiou9661089984",list,s4,s5);
        e4.setText("");
        e5.setText("");
        Toast.makeText(Enquiry.this,"Mail Sent",Toast.LENGTH_SHORT).show();
        Toast.makeText(Enquiry.this,"We will revert back Shortly",Toast.LENGTH_LONG).show();
    }
    public void share(View v)
    {

        FacebookDialog shareDialog = new FacebookDialog.ShareDialogBuilder(Enquiry.this).setLink("https://www.facebook.com/internshalaiiest").build();
        uiHelper.trackPendingDialogCall(shareDialog.present());

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        uiHelper.onActivityResult(requestCode, resultCode, data, new FacebookDialog.Callback() {
            @Override
            public void onComplete(FacebookDialog.PendingCall pendingCall, Bundle data) {


            }

            @Override
            public void onError(FacebookDialog.PendingCall pendingCall, Exception error, Bundle data) {
                Toast.makeText(getApplicationContext(), "Device not connected to Internet", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        uiHelper.onResume();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        uiHelper.onSaveInstanceState(outState);
    }

    @Override
    protected void onPause() {
        super.onPause();
        uiHelper.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        uiHelper.onDestroy();
    }


}
