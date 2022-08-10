// Generated by Dagger (https://dagger.dev).
package com.example.torangrepository;

import com.example.torangrepository.di.modules.RetrofitModule;
import com.example.torangrepository.di.modules.TorangOkhttpClient;
import com.example.torangrepository.services.ProductReportService;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ProductReportService_Factory implements Factory<ProductReportService> {
  private final Provider<TorangOkhttpClient> torangOkHttpClientImplProvider;

  private final Provider<RetrofitModule> retrofitModuleProvider;

  public ProductReportService_Factory(Provider<TorangOkhttpClient> torangOkHttpClientImplProvider,
      Provider<RetrofitModule> retrofitModuleProvider) {
    this.torangOkHttpClientImplProvider = torangOkHttpClientImplProvider;
    this.retrofitModuleProvider = retrofitModuleProvider;
  }

  @Override
  public ProductReportService get() {
    return newInstance(torangOkHttpClientImplProvider.get(), retrofitModuleProvider.get());
  }

  public static ProductReportService_Factory create(
      Provider<TorangOkhttpClient> torangOkHttpClientImplProvider,
      Provider<RetrofitModule> retrofitModuleProvider) {
    return new ProductReportService_Factory(torangOkHttpClientImplProvider, retrofitModuleProvider);
  }

  public static ProductReportService newInstance(TorangOkhttpClient torangOkHttpClientImpl,
      RetrofitModule retrofitModule) {
    return new ProductReportService(torangOkHttpClientImpl, retrofitModule);
  }
}
