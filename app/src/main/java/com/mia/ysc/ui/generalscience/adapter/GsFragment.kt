package com.mia.ysc.ui.generalscience.adapter

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
import com.mia.ysc.R
import com.mia.ysc.databinding.FragmentGsBinding
import com.mia.ysc.ui.common.controllers.BaseFragment
import com.mia.ysc.ui.questionlist.GsViewModel

class GsFragment : BaseFragment(), GsViewModelObserver {

    companion object {

        private const val KEY_POSITION = "position"

        fun newInstance(position: Int): GsFragment {
            val fragment = GsFragment()
            val argument = Bundle()
            argument.putInt(KEY_POSITION, position)
            fragment.arguments = argument;
            return fragment
        }
    }

    private lateinit var mGsViewModel: GsViewModel
    private lateinit var binding: FragmentGsBinding
    private var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let { position = it.getInt(KEY_POSITION) }
        mGsViewModel = ViewModelProvider(
            this,
            getControllerCompositionRoot().getViewModelProviderFactory()
        ).get(GsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGsBinding.inflate(inflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        mGsViewModel.attachObserver(this, position)
    }

    override fun onStop() {
        super.onStop()
        mGsViewModel.removeObserver()
    }

    override fun setDataForPlants() {
        binding.tvFollowing.setText(getString(R.string.text_some_important_points_about_plants))
        binding.tv1.setText(getString(R.string.text_important_points_plant_1))
        binding.tv2.setText(getString(R.string.text_important_points_plant_2))
        binding.tv3.setText(getString(R.string.text_important_points_plant_3))
        binding.tv4.setText(getString(R.string.text_important_points_plant_4))
        binding.tv5.setText(getString(R.string.text_important_points_plant_5))
        binding.tv6.setText(getString(R.string.text_important_points_plant_6))
        loadProfilePic(binding.imageView, R.drawable.plants)
    }

    override fun setDataForAnimals() {
        binding.tvFollowing.setText(getString(R.string.text_some_important_points_about_animals))
        binding.tv1.setText(getString(R.string.text_important_points_animals_1))
        binding.tv2.setText(getString(R.string.text_important_points_animals_2))
        binding.tv3.setText(getString(R.string.text_important_points_animals_3))
        binding.tv4.setText(getString(R.string.text_important_points_animals_4))
        binding.tv5.setText(getString(R.string.text_important_points_animals_5))
        binding.tv6.setText(getString(R.string.text_important_points_animals_6))
        loadProfilePic(binding.imageView, R.drawable.animal)
    }

    override fun setDataForHumanBody() {
        binding.tvFollowing.setText(getString(R.string.text_some_important_points_about_human_body))
        binding.tv1.setText(getString(R.string.text_important_points_humanbody_1))
        binding.tv2.setText(getString(R.string.text_important_points_humanbody_2))
        binding.tv3.setText(getString(R.string.text_important_points_humanbody_3))
        binding.tv4.setText(getString(R.string.text_important_points_humanbody_4))
        binding.tv5.setText(getString(R.string.text_important_points_humanbody_5))
        binding.tv6.setText(getString(R.string.text_important_points_humanbody_6))
        loadProfilePic(binding.imageView, R.drawable.human_body)
    }

    override fun setDataForEnvirnment() {
        binding.tvFollowing.setText(getString(R.string.text_some_important_points_about_envirnment))
        binding.tv1.setText(getString(R.string.text_important_points_envirnment_1))
        binding.tv2.setText(getString(R.string.text_important_points_envirnment_2))
        binding.tv3.setText(getString(R.string.text_important_points_envirnment_3))
        binding.tv4.setText(getString(R.string.text_important_points_envirnment_4))
        binding.tv5.setText(getString(R.string.text_important_points_envirnment_5))
        binding.tv6.setText(getString(R.string.text_important_points_envirnment_6))
        loadProfilePic(binding.imageView, R.drawable.envirnment)
    }

    fun loadProfilePic(imageView: ImageView, @DrawableRes drawableResId: Int) {
        imageView.load(drawableResId) {
            crossfade(true)
            memoryCachePolicy(CachePolicy.ENABLED)
            transformations(RoundedCornersTransformation())
        }
    }

}