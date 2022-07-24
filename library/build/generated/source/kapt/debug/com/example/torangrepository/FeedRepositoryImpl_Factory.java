// Generated by Dagger (https://dagger.dev).
package com.example.torangrepository;

import android.content.Context;
import com.example.torang_core.data.dao.LoggedInUserDao;
import com.example.torang_core.data.dao.UserDao;
import com.example.torangrepository.services.FeedServices;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class FeedRepositoryImpl_Factory implements Factory<FeedRepositoryImpl> {
  private final Provider<Context> contextProvider;

  private final Provider<FeedServices> feedServicesProvider;

  private final Provider<UserDao> userDaoProvider;

  private final Provider<LoggedInUserDao> userProvider;

  public FeedRepositoryImpl_Factory(Provider<Context> contextProvider,
      Provider<FeedServices> feedServicesProvider, Provider<UserDao> userDaoProvider,
      Provider<LoggedInUserDao> userProvider) {
    this.contextProvider = contextProvider;
    this.feedServicesProvider = feedServicesProvider;
    this.userDaoProvider = userDaoProvider;
    this.userProvider = userProvider;
  }

  @Override
  public FeedRepositoryImpl get() {
    return newInstance(contextProvider.get(), feedServicesProvider.get(), userDaoProvider.get(), userProvider.get());
  }

  public static FeedRepositoryImpl_Factory create(Provider<Context> contextProvider,
      Provider<FeedServices> feedServicesProvider, Provider<UserDao> userDaoProvider,
      Provider<LoggedInUserDao> userProvider) {
    return new FeedRepositoryImpl_Factory(contextProvider, feedServicesProvider, userDaoProvider, userProvider);
  }

  public static FeedRepositoryImpl newInstance(Context context, FeedServices feedServices,
      UserDao userDao, LoggedInUserDao user) {
    return new FeedRepositoryImpl(context, feedServices, userDao, user);
  }
}
