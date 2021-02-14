package com.mia.ysc.ui.spotthedifference.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.DrawableRes
import coil.load
import coil.request.CachePolicy
import coil.transform.RoundedCornersTransformation
import com.mia.ysc.R
import com.mia.ysc.databinding.FragmentFindthedifferenceBinding
import com.mia.ysc.ui.common.controllers.BaseFragment

class SpotTheDifferenceFragment : BaseFragment() {

    companion object {

        private const val KEY_POSITION = "position"

        fun newInstance(position: Int): SpotTheDifferenceFragment {
            val fragment = SpotTheDifferenceFragment()
            val argument = Bundle()
            argument.putInt(KEY_POSITION, position)
            fragment.arguments = argument;
            return fragment
        }
    }

    private var position: Int = 0
    private lateinit var binding: FragmentFindthedifferenceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let { position = it.getInt(KEY_POSITION) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFindthedifferenceBinding.inflate(inflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        when(position){
            0 -> setDataForExercise1()
            1 -> setDataForExercise2()
            2 -> setDataForExercise3()
        }
    }

    private fun setDataForExercise1() {
        loadProfilePic(binding.imageView, R.drawable.std_one)
    }

    private fun setDataForExercise2() {
        loadProfilePic(binding.imageView, R.drawable.std_two)
    }

    private fun setDataForExercise3() {
        loadProfilePic(binding.imageView, R.drawable.std_three)
    }

    fun loadProfilePic(imageView: ImageView, @DrawableRes drawableResId: Int) {
        imageView.load(drawableResId) {
            crossfade(true)
            memoryCachePolicy(CachePolicy.ENABLED)
            transformations(RoundedCornersTransformation())
        }
    }
}