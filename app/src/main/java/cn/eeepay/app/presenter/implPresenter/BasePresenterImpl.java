package cn.eeepay.app.presenter.implPresenter;



import android.content.Context;

import cn.eeepay.app.presenter.IPresenter;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 *
 */
public class BasePresenterImpl implements IPresenter {
    Context mContext;

    private CompositeSubscription mCompositeSubscription;

    protected void addSubscription(Subscription s) {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeSubscription();
        }
        this.mCompositeSubscription.add(s);
    }

    @Override
    public void unsubcrible() {

        // TODO: 16/8/17 find when unsubcrible
        if (this.mCompositeSubscription != null) {
            this.mCompositeSubscription.unsubscribe();
        }
    }
}
