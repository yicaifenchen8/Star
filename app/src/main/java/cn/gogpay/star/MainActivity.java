package cn.gogpay.star;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.hw).setOnClickListener(v -> star("com.huawei.appmarket"));
        findViewById(R.id.yyb).setOnClickListener(v -> star("com.tencent.android.qqdownloader"));
        findViewById(R.id.oppo).setOnClickListener(v -> star("com.oppo.market"));
        findViewById(R.id.vivo).setOnClickListener(v -> star("com.bbk.appstore"));
        findViewById(R.id.meizu).setOnClickListener(v -> star("com.meizu.mstore"));
        findViewById(R.id.xiaomi).setOnClickListener(v -> star("com.xiaomi.market"));
        findViewById(R.id.sx).setOnClickListener(v -> star("com.sec.android.app.samsungapps"));

//        star(null);
    }

    public void star(String packageName) {
        Uri uri = Uri.parse("market://details?id=cn.gogpay.dcb");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        if(packageName!=null && !packageName.isEmpty()) {
            intent.setPackage(packageName);
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if(packageName.equals("com.sec.android.app.samsungapps"))
            intent.setClassName(packageName, "com.sec.android.app.samsungapps.SamsungAppsMainActivity");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "无法启动应用市场 !", Toast.LENGTH_SHORT).show();
        }
    }

}
