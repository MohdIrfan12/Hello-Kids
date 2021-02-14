package com.mia.ysc.ui.english.alphabets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.lifecycle.ViewModelProvider
import coil.load
import coil.request.CachePolicy
import coil.transform.RoundedCornersTransformation
import com.mia.ysc.databinding.FragmentEnglishAlphabetBinding
import com.mia.ysc.ui.common.controllers.BaseFragment
import com.mia.ysc.ui.questionlist.AlphabetViewModel


class EnglishAlphabetFragment : BaseFragment(), AlphabetViewModelObserver {

    companion object {
        private const val KEY_POSITION = "position"
        fun newInstance(position: Int): EnglishAlphabetFragment {
            val fragment = EnglishAlphabetFragment()
            val argument = Bundle()
            argument.putInt(KEY_POSITION, position)
            fragment.arguments = argument;
            return fragment
        }
    }

    private var position: Int = 0
    private lateinit var binding: FragmentEnglishAlphabetBinding
    private lateinit var mAlphabetViewModel: AlphabetViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { position = it.getInt(KEY_POSITION) }
        mAlphabetViewModel = ViewModelProvider(
            this, getControllerCompositionRoot()
                .getViewModelProviderFactory()
        ).get(AlphabetViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEnglishAlphabetBinding.inflate(inflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        mAlphabetViewModel.attachObserver(this)
    }

    override fun onStop() {
        super.onStop()
        mAlphabetViewModel.removeObserver()
    }

    fun loadProfilePic(imageView: ImageView, @DrawableRes drawableResId: Int) {
        imageView.load(drawableResId) {
            crossfade(true)
            memoryCachePolicy(CachePolicy.ENABLED)
            transformations(RoundedCornersTransformation())
        }
    }

    override fun setAlphabet(mAlphabetsArray: Array<String>) {
        binding.tvAlphabbet.setText(mAlphabetsArray[position])
    }

    override fun setIcon(mIconsArray: Array<Int>) {
        loadProfilePic(binding.ivAlphabet, mIconsArray[position])
    }
}