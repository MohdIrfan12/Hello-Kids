package com.mia.ysc.ui.questionlist


import androidx.lifecycle.ViewModel
import com.mia.ysc.R
import com.mia.ysc.ui.english.alphabets.AlphabetViewModelObserver

/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */
class AlphabetViewModel() : ViewModel() {

    private var mAlphabetsArray = arrayOf(
        "A",
        "B",
        "C",
        "D",
        "E",
        "F",
        "G",
        "H",
        "I",
        "J",
        "K",
        "L",
        "M",
        "N",
        "O",
        "P",
        "Q",
        "R",
        "S",
        "T",
        "U",
        "V",
        "W",
        "X",
        "Y",
        "Z"
    )

    private var mIconsArray = arrayOf(
        R.drawable.apple,
        R.drawable.boy,
        R.drawable.cat,
        R.drawable.dog,
        R.drawable.elephent,
        R.drawable.factory,
        R.drawable.girl,
        R.drawable.hat,
        R.drawable.ice_cube,
        R.drawable.jet,
        R.drawable.kite,
        R.drawable.lemon,
        R.drawable.magazine,
        R.drawable.napkin,
        R.drawable.owl,
        R.drawable.piano,
        R.drawable.queen,
        R.drawable.remote,
        R.drawable.shirt,
        R.drawable.teddy_wear,
        R.drawable.umbrella,
        R.drawable.van,
        R.drawable.window,
        R.drawable.x_ray_machine,
        R.drawable.yatch,
        R.drawable.zero,
    )
    private var mObserver: AlphabetViewModelObserver? = null

    fun attachObserver(observer: AlphabetViewModelObserver?) {
        this.mObserver = observer;
        mObserver?.setAlphabet(mAlphabetsArray)
        mObserver?.setIcon(mIconsArray)
    }

    fun removeObserver() {
        this.mObserver = null;
    }
}