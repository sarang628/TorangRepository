// Generated by Dagger (https://dagger.dev).
package com.example.torangrepository.modules;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RetrofitModule_Factory implements Factory<RetrofitModule> {
  @Override
  public RetrofitModule get() {
    return newInstance();
  }

  public static RetrofitModule_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static RetrofitModule newInstance() {
    return new RetrofitModule();
  }

  private static final class InstanceHolder {
    private static final RetrofitModule_Factory INSTANCE = new RetrofitModule_Factory();
  }
}
