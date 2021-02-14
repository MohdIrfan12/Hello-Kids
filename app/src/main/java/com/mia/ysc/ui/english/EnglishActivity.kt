package com.mia.ysc.ui.english

import android.os.Bundle
import android.widget.FrameLayout
import androidx.lifecycle.ViewModelProvider
import com.mia.ysc.R
import com.mia.ysc.ui.common.controllers.BaseActivity
import com.mia.ysc.ui.common.tts.TTSFactory
import com.mia.ysc.ui.questionlist.EnglishAlphabetViewModel

class EnglishActivity : BaseActivity(), EnglishAlphabetViewModelObserver,
    EnglishAlphabetView.Listener, TTSFactory.Listener {

    private lateinit var mEnglishAlphabetView: EnglishAlphabetView
    private lateinit var mEnglishAlphabetViewModel: EnglishAlphabetViewModel
    private lateinit var mTTSFactory: TTSFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mTTSFactory = getControllerCompositionRoot().getTTSFactory()
        mEnglishAlphabetView =
            getControllerCompositionRoot().getViewFactory().getEnglishAlphabetView(null, this)
        mEnglishAlphabetViewModel = ViewModelProvider(
            this, getControllerCompositionRoot()
                .getViewModelProviderFactory()
        ).get(EnglishAlphabetViewModel::class.java)

        setContentView(mEnglishAlphabetView.getViewBinding().root)
    }

    override fun onStart() {
        super.onStart()
        mEnglishAlphabetView.registerLister(this)
        mEnglishAlphabetViewModel.attachObserver(this)
    }

    override fun onStop() {
        super.onStop()
        mEnglishAlphabetView.unregisterListener(this)
        mEnglishAlphabetViewModel.removeObserver()
        mTTSFactory.unregister()
    }

    override fun getFragmentFrame(): FrameLayout {
        TODO("Not yet implemented")
    }

    override fun onPageSelected(position: Int) {
        mEnglishAlphabetViewModel.checkForSound(position)
    }

    override fun onNavigationUpClicked() {
        finish()
    }

    override fun navigateToExerciseScreen() {
        getControllerCompositionRoot().getScreenNavigatior().navigateToEnglishExerciseScreen()
    }

    override fun navigateToPrizeScreen() {
        getControllerCompositionRoot().getScreenNavigatior().navigateToMathPrizeScreen()
    }

    override fun onTTSinitialized() {
        mEnglishAlphabetView.initViewPagerAndTabs()
        mEnglishAlphabetView.bindAlphabetArray(mEnglishAlphabetViewModel.mAlphabetsArray)
    }

    override fun playSoundForAalphabet() {
        mTTSFactory.play(getString(R.string.text_play_apple))
    }

    override fun playSoundForBalphabet() {
        mTTSFactory.play(getString(R.string.text_b_for))
    }

    override fun playSoundForCalphabet() {
        mTTSFactory.play(getString(R.string.text_c_for))
    }

    override fun playSoundForDalphabet() {
        mTTSFactory.play(getString(R.string.text_d_for))
    }

    override fun playSoundForEalphabet() {
        mTTSFactory.play(getString(R.string.text_e_for))
    }

    override fun playSoundForFalphabet() {
        mTTSFactory.play(getString(R.string.text_f_for))
    }

    override fun playSoundForGalphabet() {
        mTTSFactory.play(getString(R.string.text_g_for))
    }

    override fun playSoundForHalphabet() {
        mTTSFactory.play(getString(R.string.text_h_for))
    }

    override fun playSoundForIalphabet() {
        mTTSFactory.play(getString(R.string.text_i_for))
    }

    override fun playSoundForJalphabet() {
        mTTSFactory.play(getString(R.string.text_j_for))
    }

    override fun playSoundForKalphabet() {
        mTTSFactory.play(getString(R.string.text_k_for))
    }

    override fun playSoundForLalphabet() {
        mTTSFactory.play(getString(R.string.text_l_for))
    }

    override fun playSoundForMalphabet() {
        mTTSFactory.play(getString(R.string.text_m_for))
    }

    override fun playSoundForNalphabet() {
        mTTSFactory.play(getString(R.string.text_n_for))
    }

    override fun playSoundForOalphabet() {
        mTTSFactory.play(getString(R.string.text_o_for))
    }

    override fun playSoundForPalphabet() {
        mTTSFactory.play(getString(R.string.text_p_for))
    }

    override fun playSoundForQalphabet() {
        mTTSFactory.play(getString(R.string.text_q_for))
    }

    override fun playSoundForRalphabet() {
        mTTSFactory.play(getString(R.string.text_r_for))
    }

    override fun playSoundForSalphabet() {
        mTTSFactory.play(getString(R.string.text_s_for))
    }

    override fun playSoundForTalphabet() {
        mTTSFactory.play(getString(R.string.text_t_for))
    }

    override fun playSoundForUalphabet() {
        mTTSFactory.play(getString(R.string.text_u_for))
    }

    override fun playSoundForValphabet() {
        mTTSFactory.play(getString(R.string.text_v_for))
    }

    override fun playSoundForWalphabet() {
        mTTSFactory.play(getString(R.string.text_w_for))
    }

    override fun playSoundForXalphabet() {
        mTTSFactory.play(getString(R.string.text_x_for))
    }

    override fun playSoundForYalphabet() {
        mTTSFactory.play(getString(R.string.text_y_for))
    }

    override fun playSoundForZalphabet() {
        mTTSFactory.play(getString(R.string.text_z_for))
    }
}