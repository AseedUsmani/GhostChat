package com.ghostriley.sgt.ghostchat.UI;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.ghostriley.sgt.ghostchat.R;
import com.ghostriley.sgt.ghostchat.utils.ParseConstants;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParsePush;
import com.parse.ParseQuery;
import com.parse.ParseRelation;
import com.parse.ParseUser;

import java.util.Collection;
import java.util.List;

public class SendTextActivity extends AppCompatActivity {

    public static final String TAG=ChooseRecipientsActivity.class.getSimpleName();

    protected EditText mMessageText;
    protected Button mSendButton;

    protected List<ParseUser> mFriends;
    protected ParseRelation<ParseUser> mFriendsRelation;
    protected ParseUser mCurrentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_text);

        mMessageText=(EditText)findViewById(R.id.messageText);
        mSendButton=(Button)findViewById(R.id.button);

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMessageText.getText().toString().equals(null)) {
                    Toast.makeText(SendTextActivity.this, "Please type a message", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(SendTextActivity.this, SendMessageActivity.class);
                    intent.putExtra(ParseConstants.TYPE_TEXT, mMessageText.getText().toString());
                    startActivity(intent);

                }
            }
        });
    }
}