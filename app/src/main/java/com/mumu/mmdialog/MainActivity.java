package com.mumu.mmdialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mumu.dialog.MMAlertDialog;
import com.mumu.dialog.MMPopupWindow;
import com.mumu.dialog.PickBaseEntity;
import com.mumu.dialog.PickEntity;
import com.mumu.mmdialog.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;

    private String webUrl = "https://www.jianshu.com/u/281e9668a5a6";
    private MMPopupWindow mmPopupWindow;
    private List<PickEntity.RestbodyBean.Higher1LevelBean> list1 = new ArrayList<>();
    private List<PickEntity.RestbodyBean.Higher2LevelBean> list2 = new ArrayList<>();
    private List<PickEntity.RestbodyBean.Higher3LevelBean> list3 = new ArrayList<>();
    private List arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        list1.add(new PickEntity.RestbodyBean.Higher1LevelBean(111, "aaaaaa"));
        list1.add(new PickEntity.RestbodyBean.Higher1LevelBean(111, "22222"));
        list1.add(new PickEntity.RestbodyBean.Higher1LevelBean(111, "333333"));
        list1.add(new PickEntity.RestbodyBean.Higher1LevelBean(111, "44444"));
        list2.add(new PickEntity.RestbodyBean.Higher2LevelBean(111, "bbbbb"));
        list3.add(new PickEntity.RestbodyBean.Higher3LevelBean(111, "vvvvvvvvv"));

    }

    private void showDialog1() {
        MMAlertDialog.showDialog(MainActivity.this,
                "标题",
                "我是中国人，我爱我的祖国",
                null,
                "确定",
                false,
                null,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
    }

    private void showDialog2() {
        MMAlertDialog.showDialog(this,
                "标题",
                "我是中国人，我爱我的祖国。祝祖国繁荣富强",
                "取消",
                "确定",
                false,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                },
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
    }

    private void showDialogXieYi() {
        final boolean[] misChecked = {false};
        MMAlertDialog.showDialogXieYi(this,
                "个人协议",
                webUrl,
                "我知道了",
                "我已阅读并同意以上条款，下次不再提示",
                false,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                },
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (misChecked[0]) {
                            Toast.makeText(MainActivity.this, "checkbox选中了--我知道了", Toast.LENGTH_SHORT).show();
                        }
                        dialog.dismiss();
                    }
                }, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            misChecked[0] = true;
                        } else {
                            misChecked[0] = false;
                        }
                    }
                });
    }

    private void showImageDialog() {
        MMAlertDialog.showDialogImage(MainActivity.this,
                "https://wx1.sinaimg.cn/mw690/007ukfVdly1g5s67ygzs4j32j03si7wi.jpg",
                false,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                },
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
    }

    private void showPickDialogTwo() {
        for (int i = 0; i < list1.size(); i++) {
            list1.get(i).setChecked(false);
        }
        for (int i = 0; i < list2.size(); i++) {
            list2.get(i).setChecked(false);
        }
        MMAlertDialog.showDialogPickTwo(this,
                "选择",
                "aa", "bb",
                2, 1,
                list1, list2,
                "完成", true,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
                        arrayList = new ArrayList();
                        for (int i = 0; i < list1.size(); i++) {
                            if (list1.get(i).isChecked()) {
                                arrayList.add(list1.get(i).getName());
                            }
                        }
                        for (int i = 0; i < list2.size(); i++) {
                            if (list2.get(i).isChecked()) {
                                arrayList.add(list2.get(i).getName());
                            }
                        }
                        String aaa = "";
                        for (int i = 0; i < arrayList.size(); i++) {
                            String bbb = arrayList.get(i).toString();
                            aaa += " " + bbb;
                        }
                        Log.d("mmm", aaa);
                        Toast.makeText(MainActivity.this, aaa, Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (list1.get(which).isChecked()) {
                            list1.get(which).setChecked(false);
                        } else {
                            list1.get(which).setChecked(true);
                        }
                        Toast.makeText(MainActivity.this, list1.get(which).getId() + list1.get(which).getName(), Toast.LENGTH_SHORT).show();
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (list2.get(which).isChecked()) {
                            list2.get(which).setChecked(false);
                        } else {
                            list2.get(which).setChecked(true);
                        }
                        Toast.makeText(MainActivity.this, list2.get(which).getId() + list2.get(which).getName(), Toast.LENGTH_SHORT).show();
                    }
                }, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int checkedId, boolean isChecked) {
//                        if (checkedId == com.mumu.dialog.R.id.rb_first) {
//
//                        } else if (checkedId == com.mumu.dialog.R.id.rb_second) {
//                            list.clear();
//                            list.addAll(list2);
//                        } else if (checkedId == com.mumu.dialog.R.id.rb_third) {
//                            list.clear();
//                            list.addAll(list3);
//                        }
                        Toast.makeText(MainActivity.this, "nnn", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void showPickDialogThree() {
        for (int i = 0; i < list1.size(); i++) {
            list1.get(i).setChecked(false);
        }
        for (int i = 0; i < list2.size(); i++) {
            list2.get(i).setChecked(false);
        }
        for (int i = 0; i < list3.size(); i++) {
            list3.get(i).setChecked(false);
        }
        MMAlertDialog.showDialogPickThree(this,
                "选择",
                "aa", "bb", "cc",
                2, 1, 3,
                list1, list2, list3,
                "完成", true,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_SHORT).show();
                        arrayList = new ArrayList();
                        for (int i = 0; i < list1.size(); i++) {
                            if (list1.get(i).isChecked()) {
                                arrayList.add(list1.get(i).getName());
                            }
                        }
                        for (int i = 0; i < list2.size(); i++) {
                            if (list2.get(i).isChecked()) {
                                arrayList.add(list2.get(i).getName());
                            }
                        }
                        for (int i = 0; i < list3.size(); i++) {
                            if (list3.get(i).isChecked()) {
                                arrayList.add(list3.get(i).getName());
                            }
                        }
                        String aaa = "";
                        for (int i = 0; i < arrayList.size(); i++) {
                            String bbb = arrayList.get(i).toString();
                            aaa += " " + bbb;
                        }
                        Log.d("mmm", aaa);
                        Toast.makeText(MainActivity.this, aaa, Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (list1.get(which).isChecked()) {
                            list1.get(which).setChecked(false);
                        } else {
                            list1.get(which).setChecked(true);
                        }
                        Toast.makeText(MainActivity.this, list1.get(which).getId() + list1.get(which).getName(), Toast.LENGTH_SHORT).show();
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (list2.get(which).isChecked()) {
                            list2.get(which).setChecked(false);
                        } else {
                            list2.get(which).setChecked(true);
                        }
                        Toast.makeText(MainActivity.this, list2.get(which).getId() + list2.get(which).getName(), Toast.LENGTH_SHORT).show();
                    }
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (list3.get(which).isChecked()) {
                            list3.get(which).setChecked(false);
                        } else {
                            list3.get(which).setChecked(true);
                        }
                        Toast.makeText(MainActivity.this, list3.get(which).getId() + list3.get(which).getName(), Toast.LENGTH_SHORT).show();
                    }
                }, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int checkedId, boolean isChecked) {
//                        if (checkedId == com.mumu.dialog.R.id.rb_first) {
//
//                        } else if (checkedId == com.mumu.dialog.R.id.rb_second) {
//                            list.clear();
//                            list.addAll(list2);
//                        } else if (checkedId == com.mumu.dialog.R.id.rb_third) {
//                            list.clear();
//                            list.addAll(list3);
//                        }
                        Toast.makeText(MainActivity.this, "nnn", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4,
            R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9, R.id.button10, R.id.button11, R.id.button12})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
                showLoading();
                //延迟3秒关闭
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        hideLoading();
                    }
                }, 3000);
                break;
            case R.id.button2:
                showLoading("正在校验信息");
                //延迟3秒关闭
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        hideLoading();
                    }
                }, 5000);
                break;
            case R.id.button3:
                showToastSuccess("加载成功");
                break;
            case R.id.button4:
                showToastFailure("加载失败");
                break;
            case R.id.button5:
                showDialog1();
                break;
            case R.id.button6:
                showDialog2();
                break;
            case R.id.button7:
                showDialogXieYi();
                break;
            case R.id.button8:
                showImageDialog();
                break;
            case R.id.button9:
                Button button9 = findViewById(R.id.button9);
                if (mmPopupWindow == null) {
                    mmPopupWindow = new MMPopupWindow();
                }
                mmPopupWindow.showDownPop(
                        this,
                        button9,
                        "我是中国人",
                        "我是中国人，我爱我的祖国，祝祖国繁荣昌盛",
                        40,
                        0);
                break;
            case R.id.button10:
                showPickDialogTwo();
                break;
            case R.id.button11:
                showPickDialogThree();
                break;
            case R.id.button12:
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
                break;
        }
    }
}
