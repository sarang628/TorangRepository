// Generated by Dagger (https://dagger.dev).
package com.example.torangrepository;

import com.example.torang_core.data.dao.RestaurantDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MapSharedRepositoryImpl_Factory implements Factory<MapSharedRepositoryImpl> {
  private final Provider<RestaurantDao> restaurantDaoProvider;

  private final Provider<RestaurantService> restaurantServiceProvider;

  public MapSharedRepositoryImpl_Factory(Provider<RestaurantDao> restaurantDaoProvider,
      Provider<RestaurantService> restaurantServiceProvider) {
    this.restaurantDaoProvider = restaurantDaoProvider;
    this.restaurantServiceProvider = restaurantServiceProvider;
  }

  @Override
  public MapSharedRepositoryImpl get() {
    return newInstance(restaurantDaoProvider.get(), restaurantServiceProvider.get());
  }

  public static MapSharedRepositoryImpl_Factory create(
      Provider<RestaurantDao> restaurantDaoProvider,
      Provider<RestaurantService> restaurantServiceProvider) {
    return new MapSharedRepositoryImpl_Factory(restaurantDaoProvider, restaurantServiceProvider);
  }

  public static MapSharedRepositoryImpl newInstance(RestaurantDao restaurantDao,
      RestaurantService restaurantService) {
    return new MapSharedRepositoryImpl(restaurantDao, restaurantService);
  }
}
