package com.app.base.common;

/**
 * 异步任务回调
 *
 * @author Haojie.Dai
 */
public interface AsyncTaskCallback<T> {

    /**
     * 结果回调
     *
     * @param result
     */
    void onResult(T result);
}
