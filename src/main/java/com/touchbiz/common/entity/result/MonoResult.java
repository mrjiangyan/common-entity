package com.touchbiz.common.entity.result;

import reactor.core.CoreSubscriber;
import reactor.core.Fuseable;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Operators;

import java.time.Duration;
import java.util.Objects;

public class MonoResult<T> extends Mono<Result<T>> implements Fuseable.ScalarCallable<Result<T>>, Fuseable  {

    final Result<T> value;

    MonoResult(Result<T> value) {
        this.value = Objects.requireNonNull(value, "value");
    }

    @Override
    public Result<T> call() throws Exception {
        return this.value;
    }

    @Override
    public Result<T> block(Duration m) {
        return this.value;
    }

    @Override
    public Result<T> block() {
        return this.value;
    }

    @Override
    public void subscribe(CoreSubscriber<? super Result<T>> actual) {
        actual.onSubscribe(Operators.scalarSubscription(actual, this.value));
    }

    public static<T> MonoResult<T> OK(T data){
        return (MonoResult<T>) Mono.onAssembly(new MonoResult(Result.OK(data)));
    }

    public static<T> MonoResult<T> ok() {
        return (MonoResult<T>) Mono.onAssembly(new MonoResult(Result.OK()));
    }

    public static<T> MonoResult<T> ok(String msg) {
        return (MonoResult<T>) Mono.onAssembly(new MonoResult(Result.ok(msg)));
    }

    public static<T> MonoResult<T> ok(T data) {
        return (MonoResult<T>) Mono.onAssembly(new MonoResult(Result.ok(data)));
    }

    public static<T> MonoResult<T> OK() {
        return (MonoResult<T>) Mono.onAssembly(new MonoResult(Result.OK()));
    }

    /**
     * 此方法是为了兼容升级所创建
     *
     */
    public static<T> MonoResult<T> OK(String msg) {
        return (MonoResult<T>) Mono.onAssembly(new MonoResult(Result.OK(msg)));
    }


    public static<T> MonoResult<T> OK(String msg, T data) {
        return (MonoResult<T>) Mono.onAssembly(new MonoResult(Result.OK(msg, data)));
    }

    public static<T> Mono<Result<T>> error(String msg, T data) {
        return (MonoResult<T>) Mono.onAssembly(new MonoResult(Result.error(msg, data)));
    }

    public static<T> MonoResult<T> error(String msg) {
        return error(500, msg);
    }

    public static<T> MonoResult<T> error(int code, String msg) {
        return (MonoResult<T>) Mono.onAssembly(new MonoResult(Result.error(code, msg)));
    }

    public static<T> MonoResult<T> error500(String msg) {
        return (MonoResult<T>) Mono.onAssembly(new MonoResult(Result.OK().error500(msg)));
    }

    /**
     * 无权限访问返回结果
     */
    public static<T> MonoResult<T> noauth(String msg) {
        return error(510, msg);
    }

}
