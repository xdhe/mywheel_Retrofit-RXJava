package com.wheel.xiaodong.mywheel.retrofithelp;

import java.util.List;

/**
 * 修改历史：
 */
public class TheatersMoive extends ErrorBean{
    public static final String URL1 = "v2/movie/in_theaters";
    public static final String METHOD1 = "getTheatersMoive";
    private int count;
    private int start;
    private int total;
    private String title;
    /**
     * rating : {"max":10,"average":8,"stars":"40","min":0}
     * genres : ["动作","奇幻","冒险"]
     * title : 魔兽
     * casts : [{"alt":"https://movie.douban.com/celebrity/1009451/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/1465353958.78.jpg","large":"http://img3.doubanio.com/img/celebrity/large/1465353958.78.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/1465353958.78.jpg"},"name":"崔维斯·费米尔","id":"1009451"},{"alt":"https://movie.douban.com/celebrity/1010533/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/1920.jpg","large":"http://img3.douban.com/img/celebrity/large/1920.jpg","medium":"http://img3.douban.com/img/celebrity/medium/1920.jpg"},"name":"托比·凯贝尔","id":"1010533"},{"alt":"https://movie.douban.com/celebrity/1036350/","avatars":{"small":"http://img3.doubanio.com/img/celebrity/small/45198.jpg","large":"http://img3.doubanio.com/img/celebrity/large/45198.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/45198.jpg"},"name":"宝拉·巴顿","id":"1036350"}]
     * collect_count : 116594
     * original_title : Warcraft
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1018030/","avatars":{"small":"http://img3.douban.com/img/celebrity/small/33020.jpg","large":"http://img3.douban.com/img/celebrity/large/33020.jpg","medium":"http://img3.douban.com/img/celebrity/medium/33020.jpg"},"name":"邓肯·琼斯","id":"1018030"}]
     * year : 2016
     * images : {"small":"http://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2345947329.jpg","large":"http://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2345947329.jpg","medium":"http://img3.doubanio.com/view/movie_poster_cover/spst/public/p2345947329.jpg"}
     * alt : https://movie.douban.com/subject/2131940/
     * id : 2131940
     */

    private List<SubjectsEntity> subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SubjectsEntity> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectsEntity> subjects) {
        this.subjects = subjects;
    }

    public static class SubjectsEntity {
        /**
         * max : 10
         * average : 8.0
         * stars : 40
         * min : 0
         */

        private RatingEntity rating;
        private String title;
        private int collect_count;
        private String original_title;
        private String subtype;
        private String year;
        /**
         * small : http://img3.doubanio.com/view/movie_poster_cover/ipst/public/p2345947329.jpg
         * large : http://img3.doubanio.com/view/movie_poster_cover/lpst/public/p2345947329.jpg
         * medium : http://img3.doubanio.com/view/movie_poster_cover/spst/public/p2345947329.jpg
         */

        private ImagesEntity images;
        private String alt;
        private String id;
        private List<String> genres;
        /**
         * alt : https://movie.douban.com/celebrity/1009451/
         * avatars : {"small":"http://img3.doubanio.com/img/celebrity/small/1465353958.78.jpg","large":"http://img3.doubanio.com/img/celebrity/large/1465353958.78.jpg","medium":"http://img3.doubanio.com/img/celebrity/medium/1465353958.78.jpg"}
         * name : 崔维斯·费米尔
         * id : 1009451
         */

        private List<CastsEntity> casts;
        /**
         * alt : https://movie.douban.com/celebrity/1018030/
         * avatars : {"small":"http://img3.douban.com/img/celebrity/small/33020.jpg","large":"http://img3.douban.com/img/celebrity/large/33020.jpg","medium":"http://img3.douban.com/img/celebrity/medium/33020.jpg"}
         * name : 邓肯·琼斯
         * id : 1018030
         */

        private List<DirectorsEntity> directors;

        public RatingEntity getRating() {
            return rating;
        }

        public void setRating(RatingEntity rating) {
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getCollect_count() {
            return collect_count;
        }

        public void setCollect_count(int collect_count) {
            this.collect_count = collect_count;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getSubtype() {
            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public ImagesEntity getImages() {
            return images;
        }

        public void setImages(ImagesEntity images) {
            this.images = images;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<String> getGenres() {
            return genres;
        }

        public void setGenres(List<String> genres) {
            this.genres = genres;
        }

        public List<CastsEntity> getCasts() {
            return casts;
        }

        public void setCasts(List<CastsEntity> casts) {
            this.casts = casts;
        }

        public List<DirectorsEntity> getDirectors() {
            return directors;
        }

        public void setDirectors(List<DirectorsEntity> directors) {
            this.directors = directors;
        }

        public static class RatingEntity {
            private int max;
            private double average;
            private String stars;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public double getAverage() {
                return average;
            }

            public void setAverage(double average) {
                this.average = average;
            }

            public String getStars() {
                return stars;
            }

            public void setStars(String stars) {
                this.stars = stars;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class ImagesEntity {
            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }

        public static class CastsEntity {
            private String alt;
            /**
             * small : http://img3.doubanio.com/img/celebrity/small/1465353958.78.jpg
             * large : http://img3.doubanio.com/img/celebrity/large/1465353958.78.jpg
             * medium : http://img3.doubanio.com/img/celebrity/medium/1465353958.78.jpg
             */

            private AvatarsEntity avatars;
            private String name;
            private String id;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsEntity getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsEntity avatars) {
                this.avatars = avatars;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public static class AvatarsEntity {
                private String small;
                private String large;
                private String medium;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }
            }
        }

        public static class DirectorsEntity {
            private String alt;
            /**
             * small : http://img3.douban.com/img/celebrity/small/33020.jpg
             * large : http://img3.douban.com/img/celebrity/large/33020.jpg
             * medium : http://img3.douban.com/img/celebrity/medium/33020.jpg
             */

            private AvatarsEntity avatars;
            private String name;
            private String id;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsEntity getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsEntity avatars) {
                this.avatars = avatars;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public static class AvatarsEntity {
                private String small;
                private String large;
                private String medium;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }
            }
        }
    }
}