// Generated by Dagger (https://dagger.dev).
package com.example.torangrepository.services;

import com.example.torangrepository.modules.RetrofitModule;
import com.example.torangrepository.modules.TorangOkhttpClient;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ProductFeedService_Factory implements Factory<ProductFeedService> {
  private final Provider<TorangOkhttpClient> torangOkHttpClientImplProvider;

  private final Provider<RetrofitModule> retrofitModuleProvider;

  public ProductFeedService_Factory(Provider<TorangOkhttpClient> torangOkHttpClientImplProvider,
      Provider<RetrofitModule> retrofitModuleProvider) {
    this.torangOkHttpClientImplProvider = torangOkHttpClientImplProvider;
    this.retrofitModuleProvider = retrofitModuleProvider;
  }

  @Override
  public ProductFeedService get() {
    return newInstance(torangOkHttpClientImplProvider.get(), retrofitModuleProvider.get());
  }

  public static ProductFeedService_Factory create(
      Provider<TorangOkhttpClient> torangOkHttpClientImplProvider,
      Provider<RetrofitModule> retrofitModuleProvider) {
    return new ProductFeedService_Factory(torangOkHttpClientImplProvider, retrofitModuleProvider);
  }

  public static ProductFeedService newInstance(TorangOkhttpClient torangOkHttpClientImpl,
      RetrofitModule retrofitModule) {
    return new ProductFeedService(torangOkHttpClientImpl, retrofitModule);
  }
}
