package com.mia.ysc.ui.common.views

import androidx.viewbinding.ViewBinding

/**
 * Created by Mohd Irfan on 29/12/20.
 *
 */
interface MvvmView<ViewBindingClassName : ViewBinding> {
    fun getViewBinding(): ViewBindingClassName
}