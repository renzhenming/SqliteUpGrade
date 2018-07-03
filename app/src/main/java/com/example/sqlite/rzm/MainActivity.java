package com.example.sqlite.rzm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.sqlite.rzm.db.BaseDaoFactory;
import com.example.sqlite.rzm.update.UpdateManager;
import com.example.sqlite.rzm.versionV001.UserDao;
import com.example.sqlite.rzm.versionV001.User;
import com.example.sqlite.rzm.versionV001.PhotoDao;
import com.example.sqlite.rzm.versionV001.Photo;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    public static final String url = "http://v.juhe.cn/toutiao/index?type=top&key=29da5e8be9ba88b932394b7261092f71";
    TextView textView;
    UpdateManager updateManager;

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.content);
        updateManager = new UpdateManager();

    }

    public void createV001(View view) {
        UserDao userDaoV001 = BaseDaoFactory.getInstance().getDataHelper
                (UserDao.class, User.class);

        for (int i1 = 0; i1 < 10; i1++) {
            User user = new User();
            user.setName("张三-----V001" + (i++));
            user.setPassword("123456");
            userDaoV001.insert(user);
        }


        PhotoDao photoDaoV001 = BaseDaoFactory.getInstance().getDataHelper
                (PhotoDao.class,Photo.class);

        for (int i1 = 0; i1 < 10; i1++) {
            Photo photo = new Photo();
            photo.setPath("data/data/my.jpg-----V001");
            photoDaoV001.insert(photo);
        }
    }


    public void createV002(View view) {
        com.example.sqlite.rzm.versionV002.UserDao userDaoV002 = BaseDaoFactory.getInstance().getDataHelper
                (com.example.sqlite.rzm.versionV002.UserDao.class, com.example.sqlite.rzm.versionV002.User.class);

        for (int i1 = 0; i1 < 10; i1++) {
            com.example.sqlite.rzm.versionV002.User user = new com.example.sqlite.rzm.versionV002.User();
            user.setName("李四-----V002" + (i++));
            user.setPassword("123456");
            userDaoV002.insert(user);
        }


        com.example.sqlite.rzm.versionV002.PhotoDao photoDaoV002 = BaseDaoFactory.getInstance().getDataHelper
                (com.example.sqlite.rzm.versionV002.PhotoDao.class, com.example.sqlite.rzm.versionV002.Photo.class);

        for (int i1 = 0; i1 < 10; i1++) {
            com.example.sqlite.rzm.versionV002.Photo photo = new com.example.sqlite.rzm.versionV002.Photo();
            photo.setPath("data/data/my.jpg-----V002");
            photoDaoV002.insert(photo);
        }
    }

    public void update1to2(View view) {
        updateManager.saveVersionInfo("V001", "V002");
        updateManager.startUpdateDb(this);
    }

    public void update1to3(View view) {
        updateManager.saveVersionInfo("V001", "V003");
        updateManager.startUpdateDb(this);
    }

    public void update2to3(View view) {
        updateManager.saveVersionInfo("V002", "V003");
        updateManager.startUpdateDb(this);
    }

    /**
     * 1
     * 2
     *
     * @param view
     */
    public void login(View view) {

        /*User user = new User();
        user.setName("V00" + (i++));
        user.setPassword("123456");
        user.setName("张三" + i);
        user.setUser_id("N000" + i);
        baseDao.insert(user);
        updateManager.checkThisVersionTable(this);*/
//        Volley.sendRequest(null, url,NewsPager.class, new IDataListener<NewsPager>() {
//            @Override
//            public void onSuccess(NewsPager loginRespense) {
//                Log.i(TAG,loginRespense.toString());
//            }
//
//            @Override
//            public void onFail() {
//                Log.i(TAG,"获取失败");
//            }
//        });


//        DownFileManager downFileService=new DownFileManager();
//        downFileService.download("http://gdown.baidu.com/data/wisegame/8be18d2c0dc8a9c9/WPSOffice_177.apk");
    }


    public void insert(View view) {
        Photo photo = new Photo();
        photo.setPath("data/data/my.jpg");
        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        photo.setTime(dateFormat.format(new Date()));
        PhotoDao photoDao = BaseDaoFactory.getInstance().getUserHelper(PhotoDao.class, Photo.class);
        photoDao.insert(photo);
    }


    public void update(View view) {
        /**
         * 这个方法是模拟一个情景，当前有一个新版本发布，此时运行于市场上的app通过版本更新
         * 接口请求到了新版本信息，新版本版本号为V003,当前版本版本号为V002,通过这个方法将新旧版本
         * 号写入到一个文件中做记录，这个信息可以传递出此次升级是从哪个版本升级到哪个版本
         * 保存成功返回true，否则返回false
         */
        updateManager.saveVersionInfo("V003", "V002");
        updateManager.checkThisVersionTable(this);
        updateManager.startUpdateDb(this);
    }

}
