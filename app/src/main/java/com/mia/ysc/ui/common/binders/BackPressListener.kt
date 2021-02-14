package com.mia.ysc.ui.common.controllers

/**
 * Created by Mohd Irfan
 * on 01/01/21.
 */
interface BackPressListener {
    /**
     * return true if fragment handles backpress, else otherwise
     */
    fun onBackPressed(): Boolean
}