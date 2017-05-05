package com.weinp.tgnet.secondlearningproject.module.recommoand;

import com.weinp.tgnet.secondlearningproject.module.BaseModule;
import com.weinp.tgnet.secondlearningproject.module.monitor.Monitor;
import com.weinp.tgnet.secondlearningproject.module.monitor.emevent.EMEvent;

import java.util.ArrayList;

/**
 * Created by tgnet on 2017/5/5.
 */
public class RecommandBody extends BaseModule{
    public int type;
    public String logo;
    public String title;
    public String info;
    public String price;
    public String text;
    public String site;
    public String from;
    public String zan;
    public ArrayList<String> url;

    //视频专用
    public String thumb;
    public String resource;
    public String resourceID;
    public String adid;
    public ArrayList<Monitor> startMonitor;
    public ArrayList<Monitor> middleMonitor;
    public ArrayList<Monitor> endMonitor;
    public String clickUrl;
    public ArrayList<Monitor> clickMonitor;
    public EMEvent event;
}
