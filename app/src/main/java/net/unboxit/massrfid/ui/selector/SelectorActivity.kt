package net.unboxit.massrfid.ui.selector

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import net.unboxit.massrfid.R

@AndroidEntryPoint
class SelectorActivity : AppCompatActivity() {
    private val viewModel by viewModels<SelectorViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selector)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SelectorFragment.newInstance())
                .commitNow()
        }
    }
}