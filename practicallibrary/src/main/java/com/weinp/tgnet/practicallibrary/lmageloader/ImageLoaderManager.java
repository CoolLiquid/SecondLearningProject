package com.weinp.tgnet.practicallibrary.lmageloader;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * @author wienp
 * @function 提供方便使用的ImageLoader
 */
public class ImageLoaderManager {
    private static final int THREAD_COUNT = 4;
    private static final int PRIORITY = 2;
    private static final int DISK_CACHE_SIZE = 50 * 1024;
    private static final int CONNECTION_TIME_OUT = 5 * 1000;
    private static final int READ_TIME_OUT = 30 * 1000;

    private static ImageLoaderManager mInstance = null;
    private static ImageLoader imageLoader = null;

    private ImageLoaderManager(Context context) {
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration
                .Builder(context)
                .threadPoolSize(THREAD_COUNT)//线程池数量
                .threadPriority(Thread.NORM_PRIORITY - PRIORITY)//降级
                .denyCacheImageMultipleSizesInMemory()//防止缓存多套图片
                .memoryCache(new WeakMemoryCache())//使用弱引用内存缓存
                .diskCacheSize(DISK_CACHE_SIZE)//本地缓存大小
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())//内存缓存文件的名字
                .tasksProcessingOrder(QueueProcessingType.LIFO)//线程执行的顺序，先进先出的方式
                .defaultDisplayImageOptions(getDefaultDispalyImageOption())//设置显示时的配置
                .imageDownloader(new BaseImageDownloader(context, CONNECTION_TIME_OUT, READ_TIME_OUT))//
                .writeDebugLogs()//debug环境下输出日志
                .build();
        ImageLoader.getInstance().init(configuration);
        imageLoader = ImageLoader.getInstance();
    }

    /**
     * 使用单例模式创建ImageLoaderManger
     *
     * @param context
     * @return
     */
    public static ImageLoaderManager getmInstance(Context context) {
        if (mInstance == null) {
            synchronized (ImageLoaderManager.class) {
                if (mInstance == null) {
                    mInstance = new ImageLoaderManager(context);
                }
            }
        }
        return mInstance;
    }

    /**
     * 显示图片时候的配置
     *
     * @return
     */
    public DisplayImageOptions getDefaultDispalyImageOption() {
        DisplayImageOptions option = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(android.R.mipmap.sym_def_app_icon)//图片地址为空时显示的图片
                .showImageOnFail(android.R.mipmap.sym_def_app_icon)//图片加载失败，显示的图片
                .cacheInMemory(true)//设置图片可以缓存到内存中
                .cacheOnDisk(true)//设置图片可以存放到硬盘中
                .bitmapConfig(Bitmap.Config.RGB_565)//使用图片的类型
                .decodingOptions(new BitmapFactory.Options())//图片解码的配置
                .build();
        return option;
    }

    /**
     * 根据Url显示图片
     *
     * @param imageView
     * @param url
     */
    public  void displayImage(ImageView imageView, String url) {
        displayImage(imageView, url, null);
    }

    /**
     * 根据Url显示图片，同时设置监听
     *
     * @param imageView
     * @param url
     * @param listener
     */
    public  void displayImage(ImageView imageView, String url
            , ImageLoadingListener listener) {
        displayImage(imageView, url, null, listener);
    }

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
            , ImageLoadingListener listener) {
        if (imageLoader != null) {
            imageLoader.displayImage(url, imageview, options, listener);
        }
    }
}
