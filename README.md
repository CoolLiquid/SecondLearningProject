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