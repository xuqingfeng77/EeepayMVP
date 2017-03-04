package cn.eeepay.app.presenter.view;

/**
 * Created by xqf on 2017/3/1.
 */

public interface IView {
   //待添加
   void showProgressDialog();//显示对话框

    void hidProgressDialog();//隐藏对话框

    void showError(String error);
}
