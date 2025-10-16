package com.cognitus.courseandroid

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cognitus.courseandroid.databinding.ToolbarBinding


abstract class Utility: AppCompatActivity() {

    protected fun initializeToolbar(toolbarBinding: ToolbarBinding,
                                    titleTb: String = "", back:Boolean=false, isMain:Boolean=false){
        setSupportActionBar(toolbarBinding.toolbar)
        toolbarBinding.title = titleTb
        if(isMain){
            toolbarBinding.tvTitleBar.visibility= View.INVISIBLE
            toolbarBinding.ivExit.visibility= View.VISIBLE
            toolbarBinding.toolbar.navigationIcon=null

        }else{
            toolbarBinding.tvTitleBar.visibility= View.VISIBLE
            toolbarBinding.ivExit.visibility= View.INVISIBLE
        }

        if(back) {
            toolbarBinding.toolbar.setNavigationOnClickListener {
                finish()
            }
        }
    }
}