package zqx.rj.com.playandroid.account.view

import android.arch.lifecycle.Observer
import android.view.View
import com.kingja.loadsir.callback.SuccessCallback
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import zqx.rj.com.mvvm.base.LifecycleActivity
import zqx.rj.com.mvvm.common.str
import zqx.rj.com.playandroid.MainActivity
import zqx.rj.com.playandroid.R
import zqx.rj.com.playandroid.account.vm.AccountViewModel

class LoginActivity : LifecycleActivity<AccountViewModel>(), View.OnClickListener {

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }


    override fun initView() {
        super.initView()
        mBtnLogin.setOnClickListener(this)
        mTvRegister.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.mBtnLogin -> {
                mViewModel.requestLogin(mTieAccount.str(), mTiePassword.str())
            }
            R.id.mTvRegister -> {
                toast(getString(R.string.register))
            }
        }
    }

    override fun dataObserver() {
        mViewModel.requestLogin().observe(this, Observer {
            it?.data?.let {
                loadService.showCallback(SuccessCallback::class.java)
                startActivity<MainActivity>()
                finish()
            }
        })
    }

    override fun reLoad() {
        toast("重新加载啦~")
    }

}