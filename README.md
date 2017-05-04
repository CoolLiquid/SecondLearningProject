practicallibrary使用
===
okhttp使用
-------
如下：
```Java
        CommonOkhttpClient.sendRequest(CommonRequest.
                createPostRequest("http://www.baidu.com", null),
                new CommonJsonCallBack(new DisposeDataHandle(new DisposeDataListener() {
                    @Override
                    public void onSucess(Object responseObj) {

                    }

                    @Override
                    public void onFailure(Object responseObj) {

                    }
                },null)));
```
`好处`：封装的结果`完全脱离Okhttp`，如果Okhttp官方更改了类名的话，我们就不再使用`全局修改`我们的代码。<br>
        只需要在`practicallibraly`上需改我们的代码<br>


封装类ImageLoaderManager：
    使用单例模式封装ImageLoader
    <br>使用如下：<br>
```java
        ImageLoaderManager.getmInstance(this).displayImage("url",imageView );
```

当然ImageLoaderManager类下包含如下重要的API:

```java
        /**
             * 根据Url显示，图片在ImageView中，同时设置显示的配置和设置图片的监听
             *
             * @param imageview
             * @param url
             * @param options
             * @param listener
             */
            public  void displayImage(ImageView imageview, String url
                    , DisplayImageOptions options
                    , ImageLoadingListener listener) {}
```

`好处`：我们应用层是使用我们自己封装的一套API，当我们不适用UniversialImageLoader ,我们使用Glide的时候，我们只在
    封装里面改，不影响我们应用层代码的使用。