// Generated by Dagger (https://dagger.dev).
package com.example.torangrepository.test;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class TestFeedRepositoryImpl_Factory implements Factory<TestFeedRepositoryImpl> {
  @Override
  public TestFeedRepositoryImpl get() {
    return newInstance();
  }

  public static TestFeedRepositoryImpl_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static TestFeedRepositoryImpl newInstance() {
    return new TestFeedRepositoryImpl();
  }

  private static final class InstanceHolder {
    private static final TestFeedRepositoryImpl_Factory INSTANCE = new TestFeedRepositoryImpl_Factory();
  }
}
