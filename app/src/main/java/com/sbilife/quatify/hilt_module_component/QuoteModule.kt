package com.sbilife.quatify.hilt_module_component

import com.sbilife.quatify.FirebaseRepo
import com.sbilife.quatify.QuoteRepo
import com.sbilife.quatify.SQLRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
class QuoteModule {

    @Provides
    fun provideSQLQuoterepo(): QuoteRepo {
        return SQLRepo()
    }
}