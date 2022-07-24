// Generated by Dagger (https://dagger.dev).
package com.example.torangrepository;

import com.example.torang_core.data.dao.FeedDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ReportRepositoryImpl_Factory implements Factory<ReportRepositoryImpl> {
  private final Provider<ReportService> reportServiceProvider;

  private final Provider<FeedDao> feedDaoProvider;

  public ReportRepositoryImpl_Factory(Provider<ReportService> reportServiceProvider,
      Provider<FeedDao> feedDaoProvider) {
    this.reportServiceProvider = reportServiceProvider;
    this.feedDaoProvider = feedDaoProvider;
  }

  @Override
  public ReportRepositoryImpl get() {
    return newInstance(reportServiceProvider.get(), feedDaoProvider.get());
  }

  public static ReportRepositoryImpl_Factory create(Provider<ReportService> reportServiceProvider,
      Provider<FeedDao> feedDaoProvider) {
    return new ReportRepositoryImpl_Factory(reportServiceProvider, feedDaoProvider);
  }

  public static ReportRepositoryImpl newInstance(ReportService reportService, FeedDao feedDao) {
    return new ReportRepositoryImpl(reportService, feedDao);
  }
}
