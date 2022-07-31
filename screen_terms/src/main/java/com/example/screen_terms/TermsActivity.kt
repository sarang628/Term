package com.example.screen_terms

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.torang_core.navigation.MainNavigation
import com.example.torang_core.navigation.TermsNavigation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Inject

@AndroidEntryPoint
class TermsActivity : AppCompatActivity(), BlankFragment.BlankFragmentInterAction {

    @Inject
    lateinit var mainNavigation: MainNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_container, BlankFragment())
            .commit()
    }

    override fun agree() {
        mainNavigation.goMain(this)
        finish()
    }

    override fun disAgree() {
        finish()
    }
}

@Module
@InstallIn(ActivityComponent::class)
abstract class TermsModule {
    @Binds
    abstract fun provideTermsNavigation(termNavigationImpl : TermsNavigationNavigationImpl) : TermsNavigation
}

class TermsNavigationNavigationImpl @Inject constructor() : TermsNavigation{
    override fun go(context: Context) {
        context.startActivity(Intent(context, TermsActivity::class.java))
    }

}
