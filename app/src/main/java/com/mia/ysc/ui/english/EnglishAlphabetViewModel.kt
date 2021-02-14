package com.mia.ysc.ui.questionlist

import androidx.lifecycle.ViewModel
import com.mia.ysc.ui.english.EnglishAlphabetViewModelObserver
/**
 * Created by Mohd Irfan on 31/12/20.
 *
 */
class EnglishAlphabetViewModel() : ViewModel() {

    private var mObserver: EnglishAlphabetViewModelObserver? = null
    var mAlphabetsArray = arrayOf(
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

    fun attachObserver(observer: EnglishAlphabetViewModelObserver?) {
        this.mObserver = observer;
    }

    fun removeObserver() {
        this.mObserver = null;
    }

    fun checkForSound(position: Int) {
        when (position) {
            0 -> mObserver?.playSoundForAalphabet()
            1 -> mObserver?.playSoundForBalphabet()
            2 -> mObserver?.playSoundForCalphabet()
            3 -> mObserver?.playSoundForDalphabet()
            4 -> mObserver?.playSoundForEalphabet()
            5 -> mObserver?.playSoundForFalphabet()
            6 -> mObserver?.playSoundForGalphabet()
            7 -> mObserver?.playSoundForHalphabet()
            8 -> mObserver?.playSoundForIalphabet()
            9 -> mObserver?.playSoundForJalphabet()
            10 -> mObserver?.playSoundForKalphabet()
            11 -> mObserver?.playSoundForLalphabet()
            12 -> mObserver?.playSoundForMalphabet()
            13 -> mObserver?.playSoundForNalphabet()
            14 -> mObserver?.playSoundForOalphabet()
            15 -> mObserver?.playSoundForPalphabet()
            16 -> mObserver?.playSoundForQalphabet()
            17 -> mObserver?.playSoundForRalphabet()
            18 -> mObserver?.playSoundForSalphabet()
            19 -> mObserver?.playSoundForTalphabet()
            20 -> mObserver?.playSoundForUalphabet()
            21 -> mObserver?.playSoundForValphabet()
            22 -> mObserver?.playSoundForWalphabet()
            23 -> mObserver?.playSoundForXalphabet()
            24 -> mObserver?.playSoundForYalphabet()
            25 -> mObserver?.playSoundForZalphabet()
        }
    }
}