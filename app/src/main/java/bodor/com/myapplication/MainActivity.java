package bodor.com.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView= (ImageView) findViewById(R.id.iv_top);
        button = (Button) findViewById(R.id.btn_processed);
        textView = (TextView) findViewById(R.id.tv_item);
        final Bitmap bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.pic);
        imageView.setImageBitmap(bitmap);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextRecognizer textRecognizer = new TextRecognizer.Builder(getApplicationContext()).build();
                if (!textRecognizer.isOperational()){
                    Toast.makeText(getApplicationContext(),"ERRO",Toast.LENGTH_SHORT).show();
                }else{
                    Frame frame = new Frame.Builder().setBitmap(bitmap).build();
                    SparseArray<TextBlock> items = textRecognizer.detect(frame);
                   StringBuilder stringBuilder =  new StringBuilder();
                    for (int i = 0;i< items.size();++i){
                        TextBlock item = items.valueAt(i);
                        stringBuilder.append(item.getValue());
                        stringBuilder.append("\n");
                    }
                    textView.setText(stringBuilder.toString());
                }
            }
        });
    }
}
