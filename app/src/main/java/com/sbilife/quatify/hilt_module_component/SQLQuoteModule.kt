package com.sbilife.quatify.hilt_module_component

import com.sbilife.quatify.QuoteRepo
import com.sbilife.quatify.SQLRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
abstract class SQLQuoteModule {

    @Binds
    abstract fun provideSQLQuoterepo(mSQLRepo: SQLRepo): QuoteRepo
}