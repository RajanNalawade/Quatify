package com.sbilife.quatify.hilt_module_component

import com.sbilife.quatify.FirebaseRepo
import com.sbilife.quatify.QuoteRepo
import com.sbilife.quatify.SQLRepo
import com.sbilife.quatify.custom_qualifiers.FirebaseQualifier
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Named

@InstallIn(ActivityComponent::class)
@Module
class SQLQuoteModule {

    @Provides
    @Named("sql")
    fun provideSQLQuoterepo(mSQLRepo: SQLRepo): QuoteRepo {
        return mSQLRepo
    }

    @Provides
    //to avoid typo in @Named() annotation use custom qualifiers
    @FirebaseQualifier
    fun provideFirebaseQuoterepo(): QuoteRepo {
        return FirebaseRepo()
    }
}