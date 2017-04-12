package com.wheel.xiaodong.mywheel.retrofithelp;

import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by sh on 2016/10/25 11:16.
 */

public class RxUtil {
	/**
	 * 简化RX线程处理
	 *
	 * @param <T>
	 * @return
	 */
	public static <T> FlowableTransformer<T, T> fixScheduler() {
//		return new FlowableTransformer<T, T>() {
//			@Override
//			public Publisher<T> apply(Flowable<T> flowable) {
//				return flowable.subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());
//			}
//		};

		return upstream -> upstream.subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());
	}


}
