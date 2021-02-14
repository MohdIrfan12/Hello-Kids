package com.mia.ysc.ui.english.alphabets


/**
 * Created by Mohd Irfan
 * on 03/01/21.
 */
interface AlphabetViewModelObserver {
    fun setAlphabet(mAlphabetsArray: Array<String>)
    fun setIcon(mIconsArray: Array<Int>)
}