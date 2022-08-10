// Generated by Dagger (https://dagger.dev).
package com.example.torangrepository;

import com.example.torangrepository.di.modules.RetrofitModule;
import com.example.torangrepository.di.modules.TorangOkhttpClient;
import com.example.torangrepository.services.ProductRestaurantService;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ProductRestaurantService_Factory implements Factory<ProductRestaurantService> {
  private final Provider<TorangOkhttpClient> torangOkHttpClientImplProvider;

  private final Provider<RetrofitModule> retrofitModuleProvider;

  public ProductRestaurantService_Factory(
      Provider<TorangOkhttpClient> torangOkHttpClientImplProvider,
      Provider<RetrofitModule> retrofitModuleProvider) {
    this.torangOkHttpClientImplProvider = torangOkHttpClientImplProvider;
    this.retrofitModuleProvider = retrofitModuleProvider;
  }

  @Override
  public ProductRestaurantService get() {
    return newInstance(torangOkHttpClientImplProvider.get(), retrofitModuleProvider.get());
  }

  public static ProductRestaurantService_Factory create(
      Provider<TorangOkhttpClient> torangOkHttpClientImplProvider,
      Provider<RetrofitModule> retrofitModuleProvider) {
    return new ProductRestaurantService_Factory(torangOkHttpClientImplProvider, retrofitModuleProvider);
  }

  public static ProductRestaurantService newInstance(TorangOkhttpClient torangOkHttpClientImpl,
      RetrofitModule retrofitModule) {
    return new ProductRestaurantService(torangOkHttpClientImpl, retrofitModule);
  }
}
