package com.wheel.xiaodong.mywheel.retrofithelp;

import java.util.List;

/**
 * Created by xiaodong on 17/3/28.
 */

public class User extends ErrorBean {
    public static final String URL = "api/other/indexApiForApp.php";
    public static final String METHOD = "loadRepo";

    /**
     /**
     * list : [{"lvid":"19215","uid":"160","nick":"安卓1","head":"http://dev-img.huanpeng.com/7/7/77e5efddcb3b613076f4252d87d25c6b.png","gameID":"190","poster":"","title":"夜空中最亮的星～","stime":"1479174791","orientation":"1","vtype":"1","gameName":"王者荣耀","userCount":"0"},{"lvid":"19220","uid":"100","nick":"King,
     * OK??","head":"http://dev-img.huanpeng.com/5/c/5cafcc38b8850d73765bdad9afb10dd0.gif","gameID":"401","poster":"","title":"King,
     * OK??的直播间","stime":"1479176415","orientation":"0","vtype":"1","gameName":"手机直播","userCount":"0"},{"lvid":"19225","uid":"365","nick":"美啦美啦","head":"http://dev-img.huanpeng.com/defaultPic/09430c53187f9cf809cbcca965aba90e.png","gameID":"401","poster":"","title":"美啦美啦的直播间","stime":"1479192410","orientation":"0","vtype":"1","gameName":"手机直播","userCount":"0"},{"lvid":"580","uid":"140","nick":"JM1307","head":"http://dev-img.huanpeng.com/3/2/32226c246205a12d1e013ca6d445b59a.jpeg","gameID":"62","poster":"http://dev-img.huanpeng.com//6/0/60e2eff9aeacd2e1a9b700086a15aa41.jpg","title":"JM1307","stime":"2016-08-02
     * 15:54:57","gameName":"天天酷跑","userCount":"71","orientation":"1","vtype":"2","videoUtl":"http://dev-img.huanpeng.com/v/2/1/212a8d9b1be706537489eef879a1aa7e.mp4"},{"lvid":"645","uid":"165","nick":"安卓2","head":"http://dev-img.huanpeng.com/c/1/c1af66f39825d23d12ab8079aa6c0c2c.png","gameID":"98","poster":"http://dev-img.huanpeng.com//c/e/ce3008db2526963906935ae6eedb9a1f.jpg","title":"嘿吧咋嘿的直播间","stime":"2016-08-02
     * 17:04:08","gameName":"部落冲突","userCount":"415","orientation":"0","vtype":"2","videoUtl":"http://dev-img.huanpeng.com/v/3/9/39a78e266a93a9bf6f09dfe647b998b1.mp4"},{"lvid":"905","uid":"275","nick":"其实我是个演员","head":"http://dev-img.huanpeng.com/3/2/3295e4f327d7b737278040b50dea69e1.png","gameID":"160","poster":"http://dev-img.huanpeng.com//9/6/9656274caa62a9bb24724e6750a57110.jpg","title":"大王叫我来巡山的直播间","stime":"2016-08-03
     * 14:34:22","gameName":"全民枪战","userCount":"1","orientation":"1","vtype":"2","videoUtl":"http://dev-img.huanpeng.com/v/c/e/ce537060b0ce83e88a78ab442c40d12b.mp4"},{"lvid":"1955","uid":"135","nick":"Htong","head":"http://dev-img.huanpeng.com//userPic/135/9ff2bb9d91f8a6f0d69008f435763e03.jpg","gameID":"215","poster":"http://dev-img.huanpeng.com//4/4/44b806d77057a1b1d42f61822e22f98f.jpg","title":"隔壁的王哥哥的直播间","stime":"2016-08-05
     * 14:03:14","gameName":"穿越火线","userCount":"24","orientation":"4","vtype":"2","videoUtl":"http://dev-img.huanpeng.com/v/e/3/e3e4208dbcfb7fb916d4d2aede678e1a.mp4"},{"lvid":"2290","uid":"90","nick":"你猜你猜","head":"http://dev-img.huanpeng.com/defaultPic/09430c53187f9cf809cbcca965aba90e.png","gameID":"215","poster":"http://dev-img.huanpeng.com//4/0/40e6a8bd5de3171c1da188e5f49d84be.jpg","title":"这也是逆天了！","stime":"2016-08-08
     * 15:10:34","gameName":"穿越火线","userCount":"49","orientation":"1","vtype":"2","videoUtl":"http://dev-img.huanpeng.com/v/6/9/6945e5f2becb8065f8dca065020e4f72.mp4"},{"lvid":"2355","uid":"185","nick":"安卓66","head":"http://dev-img.huanpeng.com//userPic/185/8a65d0bc86ccc8131a7aba05091ce754.png","gameID":"190","poster":"http://dev-img.huanpeng.com//5/d/5dddcdd92b83223d1239f5952fb3afda.jpg","title":"还有谁？","stime":"2016-08-08
     * 15:55:29","gameName":"王者荣耀","userCount":"45","orientation":"1","vtype":"2","videoUtl":"http://dev-img.huanpeng.com/v/1/b/1bbb5e9b75a8056e921610beddf2b3b1.mp4"},{"lvid":"2800","uid":"60","nick":"诺言～","head":"http://dev-img.huanpeng.com//userPic/60/c0ba5e8c5f358b04936e5453616171bf.png","gameID":"215","poster":"http://dev-img.huanpeng.com//c/1/c1ab3927ca75f4d4aaad02a82e7814a4.jpg","title":"cf枪战王者～","stime":"2016-08-09
     * 16:23:10","gameName":"穿越火线","userCount":"5","orientation":"1","vtype":"2","videoUtl":"http://dev-img.huanpeng.com/v/a/f/aff8124f384096a04e922ee532d43a8d.mp4"}]
     * total : 20
     */

    private String total;
    private List<ListBean> list;

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotal() {
        return total;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public class ListBean {
        /**
         * lvid : 19215 uid : 160 nick : 安卓1 head : http://dev-img.huanpeng.com/7/7/77e5efddcb3b613076f4252d87d25c6b.png
         * gameID : 190 poster : title : 夜空中最亮的星～ stime : 1479174791 orientation : 1 vtype : 1
         * gameName : 王者荣耀 userCount : 0 videoUtl : http://dev-img.huanpeng.com/v/2/1/212a8d9b1be706537489eef879a1aa7e.mp4
         */

        private String lvid;
        private String uid;
        private String nick;
        private String head;
        private String gameID;
        private String poster;
        private String title;
        private String stime;
        private String orientation;
        private String vtype;
        private String gameName;
        private String userCount;
        private String videoUtl;

        public String getLvid() {
            return lvid;
        }

        public void setLvid(String lvid) {
            this.lvid = lvid;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public String getGameID() {
            return gameID;
        }

        public void setGameID(String gameID) {
            this.gameID = gameID;
        }

        public String getPoster() {
            return poster;
        }

        public void setPoster(String poster) {
            this.poster = poster;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getStime() {
            return stime;
        }

        public void setStime(String stime) {
            this.stime = stime;
        }

        public String getOrientation() {
            return orientation;
        }

        public void setOrientation(String orientation) {
            this.orientation = orientation;
        }

        public String getVtype() {
            return vtype;
        }

        public void setVtype(String vtype) {
            this.vtype = vtype;
        }

        public String getGameName() {
            return gameName;
        }

        public void setGameName(String gameName) {
            this.gameName = gameName;
        }

        public String getUserCount() {
            return userCount;
        }

        public void setUserCount(String userCount) {
            this.userCount = userCount;
        }

        public String getVideoUtl() {
            return videoUtl;
        }

        public void setVideoUtl(String videoUtl) {
            this.videoUtl = videoUtl;
        }
    }
}
