# TextRecognition
从图片读取文字的demo，用到了Google Vision，但是不能读取汉字，有兴趣的朋友可以push，大家一起研究一下哦！
Step1 . Add library
        compile"compile com.google.android.gms:play-services-version:9.8.0"
        
Step2 .Change Theme
        <style name = "AppTheme" parent="Theme.AppComPact.Light.NoActionBar"

step3. Add Meta-data
        <Meta-data
            android:name = "come.google.android.version.DEPENDENCIES"
            android:value= "orc"
            
step4. Declar View by XML
        android:scaleType = "CenterInside"
        
step5.Find items by id

step6.Creat TextRecognizer
      TextRecognizer textRecognizer = new TextRecognizer.Builder(getApplicationContext()).build;
      use  IF to make suer that textRecognizer has been created.I hava a BUG here .
      
step7.Creat Frame
      Frame frame = new Frame.Builder().setBitmap(bitmap).build();

step8.
      SparsArray<TextBlock> items = textRecognizer.detect(frame);
      
step9. StringBuilder stringBuilder = new StringBuilder();

step10.TextBlock item = items.valueAt(i)

        
        
