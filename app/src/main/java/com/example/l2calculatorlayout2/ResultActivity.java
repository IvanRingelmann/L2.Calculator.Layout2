package com.example.l2calculatorlayout2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    public static final String RESULT_EXTRA_KEY = "RESULT_EXTRA_KEY";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultTextView = findViewById(R.id.result_number_view);

        final Intent intent = getIntent();
        if (intent != null && intent.hasExtra(RESULT_EXTRA_KEY)) {
            TransferObject value = (TransferObject) intent.getParcelableExtra(RESULT_EXTRA_KEY);
            resultTextView.setText(value.input);
        }
    }

    static class TransferObject implements Parcelable {
        public final Creator<TransferObject> CREATOR = new Creator<TransferObject>() {
            @Override
            public TransferObject createFromParcel(Parcel in) {
                return new TransferObject(in);
            }

            @Override
            public TransferObject[] newArray(int size) {
                return new TransferObject[size];
            }
        };
        String input;

        public TransferObject(String input) {
            this.input = input;
        }

        protected TransferObject(Parcel in) {
            input = in.readString();
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(input);
        }
    }

}
