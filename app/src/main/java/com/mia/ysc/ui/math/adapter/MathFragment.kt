package com.mia.ysc.ui.math.adapter

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.mia.ysc.R
import com.mia.ysc.databinding.FragmentMathBinding
import com.mia.ysc.ui.common.controllers.BaseFragment
import com.mia.ysc.ui.questionlist.MathViewModel

class MathFragment : BaseFragment(), MathViewModelObserver {

    companion object {

        private const val KEY_POSITION = "position"

        fun newInstance(position: Int): MathFragment {
            val fragment = MathFragment()
            val argument = Bundle()
            argument.putInt(KEY_POSITION, position)
            fragment.arguments = argument;
            return fragment
        }
    }

    private lateinit var mMathViewModel: MathViewModel
    private var position: Int = 0
    private lateinit var binding: FragmentMathBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let { position = it.getInt(KEY_POSITION) }
        mMathViewModel = ViewModelProvider(
            this, getControllerCompositionRoot()
                .getViewModelProviderFactory()
        ).get(MathViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMathBinding.inflate(inflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        mMathViewModel.attachObserver(this, position)
    }

    override fun onStop() {
        super.onStop()
        mMathViewModel.removeObserver()
    }

    override fun setDataForAddition() {
        binding.tv1.setText(getString(R.string.text_tv1_addition))
        binding.tv2.setText(getString(R.string.text_tv2_addition))
        binding.tvTotal.setText(getString(R.string.text_tv3_addition))
        binding.tvOperation.setText("1    +   1    =  2")
    }

    override fun setDataForSubstraction() {
        binding.tv1.setText(getString(R.string.text_tv1_subtraction))
        binding.tv2.setText(getString(R.string.text_tv2_subtraction))
        binding.tvTotal.setText(getString(R.string.text_tvtotal_subtraction))
        binding.tvOperation.setText("2    -   1    =  1")
    }

    override fun setDataForMultiplication() {
        binding.tv1.setText(getString(R.string.text_tv1_multiplication))
        binding.tv2.setText(getString(R.string.text_tv2_multiplication))
        binding.tvTotal.setText(getString(R.string.text_tvtotal_multiplication))
        binding.tvOperation.setText("2    X   2    = 4")
    }
}