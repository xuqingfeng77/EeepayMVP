/*
 * Copyright (C) 2015 Drakeet <drakeet.me@gmail.com>
 *
 * This file is part of Meizhi
 *
 * Meizhi is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Meizhi is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Meizhi.  If not, see <http://www.gnu.org/licenses/>.
 */

package cn.eeepay.app.entity;

import java.util.List;

public class LoginBean {


    /**
     * date : 20170302
     * stories : [{"images":["http://pic4.zhimg.com/ad6053e6f6a875ee0770626d6bb41f8b.jpg"],"type":0,"id":9259607,"ga_prefix":"030210","title":"「速读都是套路，多读才是王道」"},{"images":["http://pic4.zhimg.com/c8bc9388eb35dffb5c57fd3d2ef303eb.jpg"],"type":0,"id":9258357,"ga_prefix":"030209","title":"如何用经济学知识讨价还价？"},{"images":["http://pic2.zhimg.com/4a7bce8524a62d9b7cea5529e2ba2429.jpg"],"type":0,"id":9258313,"ga_prefix":"030208","title":"就这样，上海（闸北上海马戏城附近）成了中国电竞的中心"},{"images":["http://pic4.zhimg.com/a8617008787e54b9115160a1af418ddf.jpg"],"type":0,"id":9197885,"ga_prefix":"030207","title":"需要补充咖啡因来「提神」，喝什么最有效？"},{"title":"春天到了，这是一份靠谱的国内追花指南，从三月看到七月","ga_prefix":"030207","images":["http://pic2.zhimg.com/0c6c0712f8e6963620fbeae072cb2979.jpg"],"multipic":true,"type":0,"id":9258411},{"images":["http://pic2.zhimg.com/19696c9236c1fb829af718a7991fd025.jpg"],"type":0,"id":9258514,"ga_prefix":"030207","title":"从法律上讲，我能不能让出轨的爱人「净身出户」？"},{"images":["http://pic2.zhimg.com/6aa51dc2747319c459b7053406e4ee2d.jpg"],"type":0,"id":9251988,"ga_prefix":"030206","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic1.zhimg.com/ffd5d684115b3c59fc9b755112d78bd0.jpg","type":0,"id":9258313,"ga_prefix":"030208","title":"就这样，上海（闸北上海马戏城附近）成了中国电竞的中心"},{"image":"http://pic4.zhimg.com/1ca7555d4bb5f8a365791cffa48000a7.jpg","type":0,"id":9258514,"ga_prefix":"030207","title":"从法律上讲，我能不能让出轨的爱人「净身出户」？"},{"image":"http://pic3.zhimg.com/aa2a1f96e322389b39b128b6285525da.jpg","type":0,"id":9257684,"ga_prefix":"030114","title":"龚琳娜明明可以「好好唱歌」，为什么不「好好唱」？"},{"image":"http://pic4.zhimg.com/c9e794556aa5ad5d4d4590f7898071a7.jpg","type":0,"id":9253911,"ga_prefix":"030111","title":"现在觉得没有必要花几千块买洗碗机，以后你就懂了"},{"image":"http://pic1.zhimg.com/a47882e02db2fee883152d73f41dc170.jpg","type":0,"id":9256023,"ga_prefix":"030107","title":"你不一定会买的安踏现在市值超了 600 亿，全球第五"}]
     */

    private String date;
    private List<StoriesEntity> stories;
    private List<TopStoriesEntity> top_stories;

    public void setDate(String date) {
        this.date = date;
    }

    public void setStories(List<StoriesEntity> stories) {
        this.stories = stories;
    }

    public void setTop_stories(List<TopStoriesEntity> top_stories) {
        this.top_stories = top_stories;
    }

    public String getDate() {
        return date;
    }

    public List<StoriesEntity> getStories() {
        return stories;
    }

    public List<TopStoriesEntity> getTop_stories() {
        return top_stories;
    }

    public static class StoriesEntity {
        /**
         * images : ["http://pic4.zhimg.com/ad6053e6f6a875ee0770626d6bb41f8b.jpg"]
         * type : 0
         * id : 9259607
         * ga_prefix : 030210
         * title : 「速读都是套路，多读才是王道」
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public void setType(int type) {
            this.type = type;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public int getType() {
            return type;
        }

        public int getId() {
            return id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public List<String> getImages() {
            return images;
        }
    }

    public static class TopStoriesEntity {
        /**
         * image : http://pic1.zhimg.com/ffd5d684115b3c59fc9b755112d78bd0.jpg
         * type : 0
         * id : 9258313
         * ga_prefix : 030208
         * title : 就这样，上海（闸北上海马戏城附近）成了中国电竞的中心
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public void setImage(String image) {
            this.image = image;
        }

        public void setType(int type) {
            this.type = type;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public int getType() {
            return type;
        }

        public int getId() {
            return id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public String getTitle() {
            return title;
        }
    }
}
