// Generated by Dagger (https://dagger.dev).
package com.example.torangrepository;

import com.example.torang_core.data.dao.LoggedInUserDao;
import com.example.torangrepository.services.RestaurantService;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AlarmRepositoryImpl_Factory implements Factory<AlarmRepositoryImpl> {
  private final Provider<LoggedInUserDao> loggedInUserDaoProvider;

  private final Provider<RestaurantService> restaurantServiceProvider;

  public AlarmRepositoryImpl_Factory(Provider<LoggedInUserDao> loggedInUserDaoProvider,
      Provider<RestaurantService> restaurantServiceProvider) {
    this.loggedInUserDaoProvider = loggedInUserDaoProvider;
    this.restaurantServiceProvider = restaurantServiceProvider;
  }

  @Override
  public AlarmRepositoryImpl get() {
    return newInstance(loggedInUserDaoProvider.get(), restaurantServiceProvider.get());
  }

  public static AlarmRepositoryImpl_Factory create(
      Provider<LoggedInUserDao> loggedInUserDaoProvider,
      Provider<RestaurantService> restaurantServiceProvider) {
    return new AlarmRepositoryImpl_Factory(loggedInUserDaoProvider, restaurantServiceProvider);
  }

  public static AlarmRepositoryImpl newInstance(LoggedInUserDao loggedInUserDao,
      RestaurantService restaurantService) {
    return new AlarmRepositoryImpl(loggedInUserDao, restaurantService);
  }
}
